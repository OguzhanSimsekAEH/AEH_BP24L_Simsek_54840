package pl.pp;

public class mySeventhApp {
    public static void main(String[] args) {

        Person person1 = new Person("John", "Doe", 24, "123 Main St", 2000);
        Person person2 = new Person("Alice", "Hart", 42, "456 Elm St", 1982);


        System.out.println("-- Initial State --");
        person1.hiToAll();
        person2.hiToAll();


        int years1 = 1;
        int years2 = 1;
        if (args.length >= 1) {
            try {
                years1 = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid first argument, using default 1 year for person1.");
            }
        }
        if (args.length >= 2) {
            try {
                years2 = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid second argument, using default 1 year for person2.");
            }
        }


        person1.growOld(years1);
        person2.growOld(years2);


        person1.beYounger();
        person2.beYounger();


        System.out.println("\n-- After Aging and Becoming Younger --");
        person1.hiToAll();
        person2.hiToAll();
    }
}
