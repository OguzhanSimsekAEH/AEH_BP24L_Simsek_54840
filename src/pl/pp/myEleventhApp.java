/* package pl.pp;

import java.util.*;

public class myTenthApp {
    public static void main(String[] args) {
        // Array declarations - for example
        int[] a = new int[100]; // int array named a containing 100 elements
        long b[] = new long[10]; // long array named b containing 10 elements
        String[] c = new String[5]; // String array named c containing 5 elements
        c[0] = "Test 0"; // entering the string "Test" into the first element of array c
        c[3] = "Test 3"; // entering the string "Test" into the fourth element of array c

        System.out.println(c[0]); // print to the console the previously entered string

        // Arrays can be filled in a loop
        for (var i = 0; i < 100; i++) {
            a[i] = i; // filling the array a with values from 0 to 99
        }
        for (var i = 0; i < 100; i++) {
            System.out.println(a[i]); // print to the console all elements of the array a
        }

        // You do not always have to know the length of the array - you can use the length property
        for (var i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
        // You can also perform a loop for each element in the foreach loop version
        System.out.println("==================================================");
        for (var element : c) {
            System.out.println(element);
        }

        // There are also more advanced data structures - so-called collections (lists, sets, maps - dictionaries
        // Lists
        System.out.println("LISTS");
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(0, 5);  // number 5 goes to the beginning of list number 2
        list1.addAll(2, list2); // add list 2 to list 1, from the third position (so in order: 1,2,5,4,3)

        // List elements can be displayed in a loop, e.g., foreach
        for (var element : list1) {
            System.out.println(element);
        }
        // You can refer to individual elements of the list
        System.out.println(list1.get(0));
        System.out.println(list1.get(3));

        // You can display the index of a specific value or remove it or calculate the size
        System.out.println("Position of number 3 is: " + list1.indexOf(3)); // indices are numbered from zero
        list1.remove(2); // remove the third element
        System.out.println("Position of number 3 is: " + list1.indexOf(3));

        list1.set(0, 10); // replace the first element with 10
        System.out.println("First element of the collection: " + list1.get(0));

        System.out.println("Number of elements before clearing: " + list1.size());
        list1.clear(); // clear the list
        System.out.println("Number of elements after clearing: " + list1.size());

        //Sets
        System.out.println("SETS");
        Set<Integer> set1 = new TreeSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(1);  // adding elements
        set1.add(2);
        set1.add(3);

        set2.add(5);
        set2.add(4);

        set1.addAll(set2); // merging collections

        System.out.println("Elements: ");
        for (var element : set1) {
            System.out.println(element);
        }

        System.out.println("Number of elements: " + set1.size());
        set1.remove(2); // remove number two!
        System.out.println("Number of elements: " + set1.size());

        set1.clear();
        System.out.println("Number of elements: " + set1.size());

        // Maps
        System.out.println("MAPS");
        Map<Integer, String> map1 = new TreeMap<>();
        Map<Integer, String> map2 = new HashMap<>();

        map1.put(1, "one");  // adding elements
        map1.put(2, "two");
        map1.put(3, "three");

        map2.put(5, "five");
        map2.put(4, "four");

        map1.putAll(map2); // merging collections

        System.out.println("Keys: ");
        for (var key : map1.keySet()) {
            System.out.println(key);
        }

        System.out.println("Values: ");
        for (var value : map1.values()) {
            System.out.println(value);
        }

        System.out.println("Pairs: ");
        for (var entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("Number of elements: " + map1.size());
        map1.remove(2); // remove the pair under key two!
        System.out.println("Number of elements: " + map1.size());

        map1.clear();
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
