import java.util.ArrayList;
import java.util.List;


public class Floor {

    private List<Slot> slots;
    private int id;

    public Floor(int id) {

        this.id = id;
        slots = new ArrayList<>();
       
       
    }

    public int getId()
    {
        return this.id;
    }

    public void addSlot(Slot slot)
    {
        this.slots.add(slot);
    }

    public List<Slot> getSlots()
    {
        return this.slots;
    }

    public void removeSlot(Slot removingSlot) {

        for(Slot slot:slots)
        {
            if(slot == removingSlot)
                {
                    slot.deactivate();
                    break;
                }
        }
    }

    public int getSlotCount() {
        return slots.size();

    }

    public int getActiveSlotCount() {
    int count = 0;
    for (Slot slot : slots) {
        if (slot.isActive()) count++;
    }
    return count;
}

public int getAvailableSlotCount(VehicleType vehicleType)
{
    int count  = 0 ;
    for(Slot slot: slots)
    {
        if(slot.isActive() && slot.getType()== vehicleType && slot.isAvailable())
        count++;
    }
    return count;
}

public List<Slot> getFreeSlots(VehicleType vehicleType)
{
    List<Slot> freeSlots = new ArrayList<>();
    for(Slot slot:slots)
    {
        if(slot.isActive() && slot.getType()== vehicleType && slot.isAvailable())
            freeSlots.add(slot);
   
    }
    return freeSlots;
}

public Slot findFirstAvailableSlot(VehicleType vehicleType)
{
    Slot firstAvailableSlot = null;
    for(Slot slot:slots)
    {
        if(slot.isActive() && slot.getType() == vehicleType && slot.isAvailable() )
        {
            firstAvailableSlot = slot;
            break;
        }
    }
    return firstAvailableSlot;
}

public List<Slot> getOccupiedSlots(VehicleType vehicleType)
{
    List<Slot> occupiedSlots = new ArrayList<>();
       for(Slot slot:slots)
    {
        if(slot.isActive() && slot.getType() == vehicleType && !slot.isAvailable() )
        {
           occupiedSlots.add(slot);
        }
    }
    return occupiedSlots;

}


}