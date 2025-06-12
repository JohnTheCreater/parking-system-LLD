public class Vehicle{

    private VehicleType type;
    private String color;
    private String registerNumber;

    public Vehicle(VehicleType type, String color, String registerNumber) {
        this.type = type;
        this.color = color;
        this.registerNumber = registerNumber;

    }

    public VehicleType getType() {
        return this.type;
    }

    public String getColor() {
        return this.color;
    }

    public String getRegisterNumber() {
        return this.registerNumber;
    }
}
