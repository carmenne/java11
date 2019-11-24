import java.util.Properties;

public class Application {
	public static void main(String... arg) {
		double timeSec = 10.0;
		int horsePower = 246;
		int payload = Truck.convertKgToPounds(1500);
		int vehicleWeight = Truck.convertKgToPounds(1800);
		Truck truck = FactoryVehicle.buildTruck(payload, vehicleWeight, horsePower);
		System.out.println("Payload in pounds: " + truck.getPayloadPounds());
		int kg = truck.getPayloadKg();
		System.out.println("Payload converted to kg: " + kg);
		System.out.println("Payload converted back to pounds: " + Truck.convertKgToPounds(kg));
		
	}
}
