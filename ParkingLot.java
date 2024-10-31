import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ParkingLot {

    List<Floor> floors;
    Map<Integer, Ticket> tickets;
    Map<String, Vehicle> vehicles;
    private String name;
    private Scanner scan;

    public String getName() {
        return this.name;
    }

    public ParkingLot(String name, int floorCount, int slotCount, Scanner scan) {
        floors = new ArrayList<>();
        tickets = new HashMap<>();
        vehicles = new HashMap<>();
        this.scan = scan;
        addFloors(floorCount, slotCount);
        this.name = name;
        System.out.println("Parking lot created!");

    }

    public void addFloors(int floorCount, int slotCount) {
        for (int i = 0; i < floorCount; i++) {
            System.out.println("Floor " + (floors.size() + 1));
            floors.add(new Floor(slotCount, this.scan));

        }
    }

    public void registerVehicle(String type, String registerNumber, String color) {

        if (vehicles.containsKey(registerNumber)) {
            System.out.println("Already have vehicle number!");
            return;
        }
        Vehicle vehicle = new Vehicle(type, color, registerNumber);
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

        Slot slot = findSlot(vehicle);
        if (slot == null) {
            System.out.println("No slots available!");
            return;
        }

        slot.bookSlot(vehicle);
        Ticket ticket = new Ticket(slot);
        tickets.put(ticket.getId(), ticket);
        System.out.println("ticket generated! id: " + ticket.getId());
    }

    private boolean isVehicleParked(Vehicle vehicle) {
        for (Ticket ticket : tickets.values()) {
            if (ticket.getSlot().getVehicle() == vehicle)
                return true;
        }
        return false;
    }

    public void unParkVehicle(int ticketId) {
        Ticket ticket = tickets.get(ticketId);
        if (ticket == null) {
            System.out.println("No ticket Found!");
            return;
        }
        Slot slot = ticket.getSlot();
        slot.checkoutSlot();
        tickets.remove(ticketId);

        System.out.println("vehicle unparked!");
    }

    private Slot findSlot(Vehicle vehicle) {
        for (Floor floor : this.floors) {
            for (Slot slot : floor.slots) {
                if (slot.getType().equalsIgnoreCase(vehicle.getType()) && slot.isAvail())
                    return slot;
            }
        }
        return null;
    }

    public void printFreeCount(String type) {
        int count = 0;
        for (Floor floor : this.floors) {
            for (Slot slot : floor.slots) {
                if (slot.getType().equalsIgnoreCase(type) && slot.isAvail())
                    count++;
            }
        }
        System.out.println("Free count for " + type + ": " + count);

    }

    public void printFreeSlots(String type) {
        for (Floor floor : this.floors) {
            String availableSlots = "";
            for (Slot slot : floor.slots) {
                if (slot.getType().equalsIgnoreCase(type) && slot.isAvail()) {
                    availableSlots += floor.slots.indexOf(slot) + 1 + ",";
                }

            }
            System.out.println(
                    "Floor " + (floors.indexOf(floor) + 1) + " free slots for " + type + ": " + availableSlots);
        }

    }

    public void printOccupiedSlots(String type) {

        for (Floor floor : this.floors) {
            String occupiedSlots = "";
            for (Slot slot : floor.slots) {
                if (slot.getType().equalsIgnoreCase(type) && !slot.isAvail()) {
                    occupiedSlots += floor.slots.indexOf(slot) + 1 + ",";
                }

            }
            System.out
                    .println("Floor " + (floors.indexOf(floor) + 1) + " free slots for " + type + ": " + occupiedSlots);
        }

    }

}
