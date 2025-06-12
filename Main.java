import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Initializing the Parking Lot!");
        System.out.print("How many floors in the parking lot ? ");
        int floorsCount = scan.nextInt();
        int i = 0;
        List<List<VehicleType>> slotTypes = new ArrayList<>();
        while(i < floorsCount)
        {
            System.out.println(" Slot types for floor "+i);
            List<VehicleType> floorSlot = new ArrayList<>();
            boolean flag = true; 
            do{
                System.out.println(VehicleType.BIKE.ordinal()+". BIKE");
                System.out.println(VehicleType.CAR.ordinal()+". CAR");
                System.out.println(VehicleType.TRUCK.ordinal()+". TRUCK");
                System.out.println(VehicleType.ELECTRIC.ordinal()+". ELECTRIC");
                System.out.println(VehicleType.SUV.ordinal()+". SUV");
                System.out.println(VehicleType.values().length+". back");
                int option = scan.nextInt();

                switch(option)
                {
                    case 0:
                        floorSlot.add(VehicleType.BIKE);
                        break;
                    case 1:
                        floorSlot.add(VehicleType.CAR);
                        break;
                    case 2:
                        floorSlot.add(VehicleType.TRUCK);
                        break;
                    case 3:
                        floorSlot.add(VehicleType.ELECTRIC);
                        break;
                    case 4:
                        floorSlot.add(VehicleType.SUV);
                        break;
                    case 5:
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid option");

                }


            }while(flag);
            slotTypes.add(floorSlot);
            i++;
        }
        ParkingLot parkingLot = ParkingLot.getInstance(floorsCount, slotTypes);
       StringBuilder vehicleTypesString = new StringBuilder("(");
for (VehicleType type : VehicleType.values()) {
    vehicleTypesString.append(type.ordinal()).append(".").append(type.name()).append(" ");
}
vehicleTypesString.append(")");
        do
        {
            System.out.println("Main Menu !");
            System.out.println("1.register");
            System.out.println("2.park");
            System.out.println("3.unpark");
            System.out.println("4.print free slots count");
            System.out.println("5.print free slots ");
            System.out.println("6.print occupied slots");
            System.out.println("7.print all slots");
            System.out.println("8.exit");
            int option = scan.nextInt();
            scan.nextLine();
            String registerNumber;
            int type;

            switch(option)
            {
                case 1:
                    System.out.println("Enter Vehicle Type "+vehicleTypesString+" :");
                    int vehicleType = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter register Number : ");
                    registerNumber = scan.nextLine();
                    System.out.print("Enter Color : ");
                    String color = scan.nextLine();
                    parkingLot.registerVehicle(VehicleType.values()[vehicleType], registerNumber, color);
                    break;
                case 2:
                    System.out.print("Enter register Number: ");
                    registerNumber = scan.nextLine();
                    parkingLot.parkVehicle(registerNumber);
                    break;
                case 3:
                    System.out.print("Enter ticket id: ");
                    int ticketId = scan.nextInt();
                    scan.nextLine();
                    parkingLot.unParkVehicle(ticketId);
                    break;
                case 4:
                    System.out.println("Enter Vehicle type "+vehicleTypesString+": ");
                    type = scan.nextInt();
                    scan.nextLine();
                    parkingLot.printFreeSlotCount(VehicleType.values()[type]);
                    break;
                case 5:
                    System.out.println("Enter Vehicle type "+vehicleTypesString+": ");
                    type = scan.nextInt();
                    scan.nextLine();
                    parkingLot.printFreeSlots(VehicleType.values()[type]);
                    break;
                case 6:
                System.out.println("Enter Vehicle type "+vehicleTypesString+": ");
                    type = scan.nextInt();
                    scan.nextLine();
                    parkingLot.printOccupiedSlots(VehicleType.values()[type]);
                    break;
                case 7:
                    parkingLot.printAllSlots();
                    break;
                case 8:
                    System.exit(0);

            }

        }while(true);

      
        
    }

}
