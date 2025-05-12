package pl.pp;

public class Warehouse {


    private int warehouseNumber;
    private int totalSpace;      // total capacity
    private int occupiedSpace;   // amount of space currently taken

    private String ownerName;
    private String ownerEmail;
    private String ownerPhone;


    public Warehouse() {
        this(1,
                5000,
                "Default Owner",
                "owner@warehouse.com",
                "+00 000 000 000");
    }


    public Warehouse(int warehouseNumber,
                     int totalSpace,
                     String ownerName,
                     String ownerEmail,
                     String ownerPhone) {

        if (totalSpace < 0) {
            throw new IllegalArgumentException("Total space cannot be negative.");
        }

        this.warehouseNumber = warehouseNumber;
        this.totalSpace      = totalSpace;
        this.occupiedSpace   = 0;          // starts empty
        this.ownerName       = ownerName;
        this.ownerEmail      = ownerEmail;
        this.ownerPhone      = ownerPhone;
    }


    public int    getWarehouseNumber() { return warehouseNumber; }
    public int    getTotalSpace()      { return totalSpace; }
    public int    getOccupiedSpace()   { return occupiedSpace; }
    public int    getAvailableSpace()  { return totalSpace - occupiedSpace; }

    public String getOwnerName()       { return ownerName; }
    public String getOwnerEmail()      { return ownerEmail; }
    public String getOwnerPhone()      { return ownerPhone; }



    public void setWarehouseNumber(int warehouseNumber) {
        this.warehouseNumber = warehouseNumber;
    }


    public void setTotalSpace(int totalSpace) {
        if (totalSpace < occupiedSpace) {
            throw new IllegalArgumentException(
                    "New total space cannot be smaller than currently occupied space.");
        }
        this.totalSpace = totalSpace;
    }

    public void setOwnerName(String ownerName)   { this.ownerName  = ownerName;  }
    public void setOwnerEmail(String ownerEmail) { this.ownerEmail = ownerEmail; }
    public void setOwnerPhone(String ownerPhone) { this.ownerPhone = ownerPhone; }


    public void addGoods(int amount) {
        if (amount <= 0) {
            System.out.println("Amount to add must be positive.");
            return;
        }
        if (occupiedSpace + amount > totalSpace) {
            System.out.printf(
                    "Not enough space in the warehouse. Remaining warehouse space: %d units.%n",
                    getAvailableSpace());
            return;
        }
        occupiedSpace += amount;
        System.out.printf(
                "Added %d units of goods. Remaining warehouse space: %d units.%n",
                amount, getAvailableSpace());
    }

    public void removeGoods(int amount) {
        if (amount <= 0) {
            System.out.println("Amount to remove must be positive.");
            return;
        }
        if (amount > occupiedSpace) {
            System.out.printf(
                    "Cannot remove %d units. Only %d units are in the warehouse.%n",
                    amount, occupiedSpace);
            return;
        }
        occupiedSpace -= amount;
        System.out.printf(
                "Removed %d units of goods. Remaining warehouse space: %d units.%n",
                amount, getAvailableSpace());
    }

    public void checkOccupancy() {
        System.out.printf(
                "Occupied warehouse space: %d units.%nAvailable warehouse space: %d units.%n",
                occupiedSpace, getAvailableSpace());
    }

    public void updateContact(String newEmail, String newPhone) {
        this.ownerEmail = newEmail;
        this.ownerPhone = newPhone;

        System.out.println("Owner's contact details updated.");
        System.out.printf("New email: %s%n", ownerEmail);
        System.out.printf("New phone number: %s%n", ownerPhone);
    }
}
