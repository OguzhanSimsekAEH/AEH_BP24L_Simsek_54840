/* package pl.pp;
import pl.pp.Person;

public class mySeventhApp {
    public static void main(String[] args) {
        Person person1 = new Person(); // create object person1 of class Person with default parameters/attributes
        person1.hiToAll(); // by default, fields are empty or zero so this should be displayed

        person1.forename = "John";
        person1.surname = "Doe";
        person1.age = 24;
        person1.hiToAll(); // now it should display the values that we just entered as attributes of the object

        // knowing that we have a constructor for the object that is not empty but accepts certain characteristics, you can
        // initialize an object in one line instead of entering values in each field as above

        Person person2 = new Person("Alice", "Hart", 42);
        person2.hiToAll();

        // you can now use the method growOld() e.g., once for object person1 and three times for object person2
        person1.growOld();
        for(int i=0; i<3; i++) {
            person2.growOld();
        }
        // and display the final age, does everything match up?
        person1.hiToAll();
        person2.hiToAll();

        // instead of referring to specific fields of the object, you can write methods that set, for example, the variable
        // forename or read it and use these methods
        System.out.println(person1.getName()); // read forename from the object using a method (see - Person class code)
        person1.setName("Lolo"); // change the forename field in the object person1
        System.out.println(person1.getName()); // check if the forename in the object person1 has changed
        person1.hiToAll();
    }
}

 */
package pl.pp;
import pl.pp.Account;

public class myEightApp {
    public static void main(String[] args) {
        // Create a new account
        Account myAccount = new Account("12345678", 1000.0, "John Doe", "john.doe@example.com", "123-456-7890");

        // Perform transactions
        myAccount.withdraw(900.0);
        myAccount.deposit(250.0);
        myAccount.withdraw(50.0);
        myAccount.withdraw(500.0); // Should trigger insufficient funds message
    }
}

