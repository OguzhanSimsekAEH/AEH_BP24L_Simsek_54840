package pl.pp;


public class myNinthApp {

    public static void main(String[] args) {


        Warehouse wh = new Warehouse();


        wh.addGoods(3000);     // success
        wh.removeGoods(1000);  // success
        wh.addGoods(2500);     // leaves 500 free units

        wh.checkOccupancy();   // print summary


        wh.updateContact("owner@magazyn.pl", "+48 123 456 789");


        wh.addGoods(1000);
    }
}
