package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class VehicleCounter {
    private HashMap<String, Integer> vehicleCount = new HashMap<>();
    
    public void countVehicle(String licensePlate) {
        vehicleCount.put(licensePlate, vehicleCount.getOrDefault(licensePlate, 0) + 1);
    }
    
    public void displayCounts() {
        for (String plate : vehicleCount.keySet()) {
            System.out.println("License Plate: " + plate + " - Count: " + vehicleCount.get(plate));
        }
    }

    public static void main(String[] args) {
        VehicleCounter counter = new VehicleCounter();
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter vehicle license plates (type 'exit' to stop):");
        while (true) {
            String plate = scn.nextLine();
            if (plate.equalsIgnoreCase("exit")) {
                break;
            }
            counter.countVehicle(plate);
        }
        
        System.out.println("\nVehicle Count Summary:");
        counter.displayCounts();
        scn.close();
    }
}
