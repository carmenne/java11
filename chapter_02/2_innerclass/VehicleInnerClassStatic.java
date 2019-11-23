public class VehicleInnerClassStatic {
	
	private Engine engine;
	
	public VehicleInnerClassStatic(int weightPounds, int horsePower) {
		this.engine = new Engine(horsePower, weightPounds);
	}
	public double getSpeedMph(double timeSec){
		return this.engine.getSpeedMph(timeSec);
	}

	private static class Engine {
	
		private int horsePower;
		private int weightPounds;
		
		private Engine(int horsePower, int weightPounds) {
			this.horsePower = horsePower;
			this.weightPounds = weightPounds;
		}
		
		public double getSpeedMph(double timeSec){
			double v = 2.0 * this.horsePower * 746 * timeSec *
			32.17 / this.weightPounds;
			return Math.round(Math.sqrt(v) * 0.68);
		}
	}
}
