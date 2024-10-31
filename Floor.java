import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Floor
 */
public class Floor {

    List<Slot> slots;
    private int slotCount;
    private Scanner scan;

    public Floor(int slotCount, Scanner scan) {
        this.scan = scan;
        slots = new ArrayList<>();
        addSlots(slotCount);
        this.slotCount = slotCount;

    }

    public void addSlots(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("enter the slot type for slot " + (slots.size() + 1) + " :");
            String type = this.scan.nextLine();
            slots.add(new Slot(type));
            this.slotCount++;
        }
    }

    public void removeSlot(int slotIndex) {

        slots.remove(slotIndex);
        this.slotCount--;
    }

    public int getSlotCount() {
        return this.slotCount;
    }

}