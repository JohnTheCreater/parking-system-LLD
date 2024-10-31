import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ParkingLot parkingLot = null;
        do {
            System.out.println("PARKING SYSTEM !");
            System.out.println(
                    "---------------------------------------------------------------------------------------------");
            System.out.println("Commands:::: \n");
            System.out.println("create_parking_lot <PARKING_NAME> <FLOORS_COUNT> <SLOTS_COUNT>");
            System.out.println("register_vehicle <VEHICLE_TYPE> <REG_NUMBER> <COLOR>");
            System.out.println("park_vehicle <REG_NUMBER>");
            System.out.println("unpark_vehicle <TICKET_ID>");
            System.out.println(
                    "display <DISPLAY_TYPE> <VEHICLE_TYPE> (display type possible values 1.free_count 2.free_slots 3.occupied_slots )");
            System.out.println("exit");
            System.out.println(
                    "---------------------------------------------------------------------------------------------");
            System.out.print("command: ");

            String input = scan.nextLine();
            String[] commands = input.split(" ");

            switch (commands[0]) {
                case "create_parking_lot":
                    if (commands.length == 4)
                        parkingLot = new ParkingLot(commands[1], Integer.parseInt(commands[2]),
                                Integer.parseInt(commands[3]), scan);
                    break;
                case "register_vehicle":
                    if (commands.length == 4 && parkingLot != null)
                        parkingLot.registerVehicle(commands[1], commands[2], commands[3]);
                    break;
                case "park_vehicle":
                    if (commands.length == 2 && parkingLot != null)
                        parkingLot.parkVehicle(commands[1]);
                    break;
                case "unpark_vehicle":
                    if (commands.length == 2 && parkingLot != null)
                        parkingLot.unParkVehicle(Integer.parseInt(commands[1]));
                    break;
                case "display":
                    switch (commands[1]) {
                        case "free_count":
                            parkingLot.printFreeCount(commands[2]);
                            break;
                        case "free_slots":
                            parkingLot.printFreeSlots(commands[2]);
                            break;
                        case "occupied_slots":
                            parkingLot.printOccupiedSlots(commands[2]);
                            break;
                    }
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("invalid input!");
                    break;
            }

        } while (true);
    }

}
