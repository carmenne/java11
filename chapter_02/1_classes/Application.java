public class Application {
	
	public static void main(String... arg) {
		double timeSec = 10.0;
		int horsePower = 246;
		int vehicleWeight = 4000;
		Engine engine = new Engine();
		engine.setHorsePower(horsePower);
		Vehicle vehicle = new Car(4, vehicleWeight, engine);
		System.out.println("Car speed (" + timeSec + " sec)="
		+ vehicle.getSpeedMph(timeSec) + " mph");
	}

}

