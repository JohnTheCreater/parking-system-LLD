public class Ticket {

    private static int idGenerater;
    private int id;

    private Slot slot;

    public Ticket(Slot slot) {
        id = ++idGenerater;
        this.slot = slot;
    }

    public int getId() {
        return this.id;
    }

    public Slot getSlot() {
        return this.slot;
    }

}
