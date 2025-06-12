public class Ticket {

    private static int idGenerator;
    private int id;


    private boolean isActive;
    private Vehicle vehicle;
    private  Slot slot;

    public Ticket(Slot slot,Vehicle vehicle) {
        id = ++idGenerator;
        this.isActive = true;
        this.vehicle = vehicle;
        this.slot = slot;
    }

    public boolean isActive()
    {
        return this.isActive;
    }

    public int getId() {
        return this.id;
    }

    public Slot getSlot() {
        return this.slot;
    }
    public Vehicle getVehicle()
    {
        return this.vehicle;
    }


    public void expire()
    {
        this.isActive = false;
        slot.checkout();
    }




}
