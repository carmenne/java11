public class Application {
public static void main(String... arg) {
	double timeSec = 10.0;
	int engineHorsePower = 246;
	int vehicleWeightPounds = 4000;
	Vehicle vehicle = new Car(4, vehicleWeightPounds, engineHorsePower);
	System.out.println("Passengers count=" + 
								 ((Car)vehicle).getPassengersCount());
	System.out.println("Car speed (" + timeSec + " sec) = " + 
							   vehicle.getSpeedMph(timeSec) + " mph");
	vehicle = new Truck(3300, vehicleWeightPounds, engineHorsePower);
	System.out.println("Payload=" + 
						   ((Truck)vehicle).getPayload() + " pounds");
	System.out.println("Truck speed (" + timeSec + " sec) = " + 
							   vehicle.getSpeedMph(timeSec) + " mph");
	}
}
