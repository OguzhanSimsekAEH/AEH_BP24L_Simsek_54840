package pl.pp;

public class Person {

    public String forename;
    public String surname;
    public int age;
    public String address;
    public int yearOfBirth;


    public Person() {
        this.forename = "";
        this.surname = "";
        this.age = 0;
        this.address = "";
        this.yearOfBirth = 0;
    }


    public Person(String initForename, String initSurname, int initAge, String initAddress, int initYearOfBirth) {
        this.forename = initForename;
        this.surname = initSurname;
        this.age = initAge;
        this.address = initAddress;
        this.yearOfBirth = initYearOfBirth;
    }


    public void hiToAll() {
        System.out.println("Name: " + forename + " " + surname
                + ", Age: " + age
                + ", Address: " + address
                + ", Year of Birth: " + yearOfBirth);
    }


    public int growOld(int years) {
        this.age += years;
        return this.age;
    }


    public void beYounger() {
        this.age -= 1;
    }


    public String getName() {
        return forename;
    }

    public void setName(String nameToSet) {
        this.forename = nameToSet;
    }
}
