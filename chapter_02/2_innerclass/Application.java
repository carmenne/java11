public class Application {
	
	public static void main(String... arg) {
		double timeSec = 10.0;
		int horsePower = 246;
		int vehicleWeight = 4000;

		VehicleInnerClassStatic vehicle = new VehicleInnerClassStatic(vehicleWeight, horsePower);
		System.out.println("Vehicle speed inner static(" + timeSec + " sec)="
		+ vehicle.getSpeedMph(timeSec) + " mph");
	}

}

