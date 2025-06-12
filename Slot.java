public class Slot {

    private VehicleType type;
    private Vehicle vehicle;
    private  int floorId;
    private boolean isActive;

    private int id;

  
    public Slot(VehicleType type,int floorId,int id) {
        this.type = type;
        this.vehicle = null;
        this.floorId = floorId;
        this.id = id;
        this.isActive = true;
    }

    public int getFloorId() {
        return floorId;
    }

    public int getId() {
        return id;
    }


    public VehicleType getType() {
        return this.type;
    }

    public boolean isAvailable() {
        return this.vehicle == null;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void checkout() {
        this.vehicle = null;
    }

    public void deactivate()
    {
        if(isAvailable())
            this.isActive = false;
        else 
            System.out.println(" A Vehicle is Parked! ");

    }

    public void activate()
    {
        if(isActive)
            System.out.println(" Already Active! ");
        else
            this.isActive = true;
    }

    public boolean isActive()
    {
        return this.isActive;
    }

}
