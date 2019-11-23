public class VehicleInnerClass {
	
	private int weightPounds;
	private Engine engine;
	
	public VehicleInnerClass(int weightPounds, int horsePower) {
		this.weightPounds = weightPounds;
		this.engine = new Engine(horsePower);
	}
	public double getSpeedMph(double timeSec){
		return this.engine.getSpeedMph(timeSec);
	}
	private int getWeightPounds() {
		return this.weightPounds;
	}
	private class Engine {
	
	private int horsePower;
	
	private Engine(int horsePower) {
              this.horsePower = horsePower;
    }
	
	public double getSpeedMph(double timeSec){
		double v = 2.0 * this.horsePower * 746 * timeSec *
		32.17 / getWeightPounds();
		return Math.round(Math.sqrt(v) * 0.68);
	}
	}
}
