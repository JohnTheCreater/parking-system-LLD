public class Vehicle {

    private String type;
    private String color;
    private String registerNumber;

    public Vehicle(String type, String color, String registerNumber) {
        this.type = type;
        this.color = color;
        this.registerNumber = registerNumber;

    }

    public String getType() {
        return this.type;
    }

    public String getColor() {
        return this.color;
    }

    public String getRegisterNumber() {
        return this.registerNumber;
    }
}
