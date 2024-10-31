public class Slot {

    private String type;
    private boolean avail;
    private Vehicle vehicle;

    public Slot(String type) {
        this.type = type;
        this.avail = true;
        this.vehicle = null;
    }

    public String getType() {
        return this.type;
    }

    public boolean isAvail() {
        return this.avail;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void bookSlot(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.avail = false;
    }

    public void checkoutSlot() {
        this.vehicle = null;
        this.avail = true;
    }

}
