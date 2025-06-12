import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private List<Floor> floors;
    private Map<Integer, Ticket> tickets;
    private Map<String, Vehicle> vehicles;
    private  int  floorCount;
    private static ParkingLot parkingLot;


    public static ParkingLot getInstance(int floorCount,List<List<VehicleType>> slotsTypes)
    {
        if(parkingLot == null) {
            parkingLot = new ParkingLot(floorCount,slotsTypes);
        }
        return parkingLot;
    }

    public ParkingLot setFloorCount(int count)
    {
        floorCount = count;
        return this;
    }

   




    private ParkingLot(int floorCount,List<List<VehicleType>> slotsTypes) {
        this.floorCount = floorCount;
        floors = new ArrayList<>();
        initializeFloors(slotsTypes);
        tickets = new HashMap<>();
        vehicles = new HashMap<>();
        
        System.out.println("Parking lot created!");

    }

    public void initializeFloors(List<List<VehicleType>> floorSlotTypes)
    {
        int floorId  = 0;
        for(List<VehicleType> slotTypes:floorSlotTypes)
        {
            
            Floor floor = new Floor(floorId);
            int slotId = 0 ;
            for(VehicleType slotType : slotTypes)
            {
                Slot slot = new Slot(slotType, floorId, slotId++);
                floor.addSlot(slot);
            }
            floors.add(floor);
            floorId++;
            
        }
    }

    public int getFloorCount()
    {
        return this.floorCount;
    }

    public void addFloors(Floor floor) {

        this.floors.add(floor);
       
    }

    public void registerVehicle(VehicleType vehicleType, String registerNumber, String color) {

        if (vehicles.containsKey(registerNumber)) {
            System.out.println("Already have vehicle number!");
            return;
        }
        Vehicle vehicle = new Vehicle(vehicleType, color, registerNumber);
        vehicles.put(registerNumber, vehicle);
        System.out.println("Registration successfull for " + registerNumber + " !");

    }

    public void parkVehicle(String registerNumber) {

        if (!vehicles.containsKey(registerNumber)) {
            System.out.println("Vehicle not found!");
            return;
        }
        Vehicle vehicle = vehicles.get(registerNumber);
        if (isVehicleParked(vehicle)) {
            System.out.println("already this vehicle is parked!");
            return;
        }

        Slot slot = findSlot(vehicle.getType());
        if (slot == null) {
            System.out.println("No slots available!");
            return;
        }
        ///ticket amount can be determined here
        /// 
        /// 
        slot.park(vehicle);
        Ticket ticket = new Ticket(slot,vehicle);
        tickets.put(ticket.getId(), ticket);
        System.out.println("Vehicle Parked at slot "+slot.getId()+" in floor "+slot.getFloorId()+"!");
        System.out.println("ticket id: " + ticket.getId());
    }

    private boolean isVehicleParked(Vehicle vehicle) {
        for (Ticket ticket : tickets.values()) {
            if(ticket.isActive())
            {
                if (ticket.getSlot().getVehicle() == vehicle)
                    return true;
            }
        }
        return false;
    }

    public void unParkVehicle(int ticketId) {
        Ticket ticket = tickets.get(ticketId);
        if (ticket == null) {
            System.out.println("No ticket Found!");
            return;
        }
        // payment can be made in here!
        ticket.expire();

        System.out.println("vehicle unparked!");
    }

    private Slot findSlot(VehicleType vehicleType) {

        for (Floor floor : this.floors) {
            Slot slot = floor.findFirstAvailableSlot(vehicleType);
            if(slot != null) return slot;
        }
        return null;
    }

    public void printFreeSlotCount(VehicleType vehicleType) {
        int count = 0;
        for (Floor floor : this.floors) {
          count += floor.getAvailableSlotCount(vehicleType);
        }
        System.out.println("Free count for " + vehicleType + ": " + count);

    }

    public void printFreeSlots(VehicleType vehicleType) {
        for (Floor floor : this.floors) {

            List<Slot> freeSlots = floor.getFreeSlots(vehicleType);
            printSlots(floor.getId(), freeSlots);
          
        }

    }

    public void printSlots(int floorId,List<Slot> slots)
    {   
        System.out.println("Floor : "+floorId);
        System.out.println("slot_id \t Vehicle_type");
        for(Slot slot:slots)
        {
                System.out.println("\t"+slot.getId() + "\t"+slot.getType());
        }
    }

    public void printOccupiedSlots(VehicleType vehicleType) {

        for (Floor floor : this.floors) {
           List<Slot> occupiedSlots = floor.getOccupiedSlots(vehicleType);
            System.out.println("Floor : "+floor.getId());
            System.out.println("slot_id \t Vehicle_type \t vehicle_number");
            for(Slot slot:occupiedSlots)
            {
                System.out.println("\t"+slot.getId() + "\t"+slot.getType() +"\t" + slot.getVehicle().getRegisterNumber());
            }
           
        }

    }

    public void printAllSlots()
    {
        System.out.println(floors.size());
        for(Floor floor:floors)
        {
            List<Slot> slots = floor.getSlots();
             System.out.println("Floor : "+floor.getId());
            System.out.println("slot_id \t Vehicle_type \t isAvailable");
            for(Slot slot:slots)
            {
                System.out.println("\t"+slot.getId() + "\t"+slot.getType() +"\t\t" + (slot.isActive() && slot.isAvailable()));
            }
        }
    }

}
