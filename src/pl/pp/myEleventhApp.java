/* package pl.pp;Add commentMore actions





































import java.util.*;

@@ -163,5 +127,76 @@ public static void main(String[] args) {
        System.out.println("Number of elements: " + map1.size());
    }
}
*/
package pl.pp;

import java.util.*;

public class myEleventhApp {


    public static class Student {
        private final String indexNumber;
        private final String firstName;
        private final String lastName;
        private final List<Integer> grades;

        public Student(String indexNumber, String firstName, String lastName, List<Integer> grades) {
            this.indexNumber = indexNumber;
            this.firstName = firstName;
            this.lastName = lastName;
            this.grades = new ArrayList<>(grades);            // defensive copy
        }


        public String getIndexNumber() { return indexNumber; }
        public String getFirstName()  { return firstName;  }
        public String getLastName()   { return lastName;   }
        public List<Integer> getGrades() { return Collections.unmodifiableList(grades); }


        public double getAverage() {
            return grades.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0.0);
        }

        @Override
        public String toString() {
            return String.format("%s %s (%s) – Average: %.2f",
                    firstName, lastName, indexNumber, getAverage());
        }
    }

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("12345", "Jan",       "Kowalski",    Arrays.asList(4, 5, 3, 5)),
                new Student("67890", "Anna",      "Nowak",       Arrays.asList(5, 5, 4, 4)),
                new Student("54321", "Paweł",     "Wiśniewski",  Arrays.asList(2, 3, 2, 4)),
                new Student("09876", "Katarzyna", "Kowalczyk",   Arrays.asList(5, 4, 4, 5))
        );


        Student topStudent = students.stream()
                .max(Comparator.comparingDouble(Student::getAverage))
                .orElseThrow(() -> new IllegalStateException("No students found"));

        System.out.printf("Student with the highest average: %s%n%n", topStudent);


        double overallAverage = students.stream()
                .flatMap(s -> s.getGrades().stream())
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.printf("Overall average grade of all students: %.2f%n%n", overallAverage);


        System.out.println("Students sorted by last names:");
        students.stream()
                .sorted(Comparator.comparing(Student::getLastName))
                .forEach(System.out::println);
    }
}