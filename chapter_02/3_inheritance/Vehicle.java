public abstract class Vehicle {
	protected int weightPounds, horsePower;
	public Vehicle(int weightPounds, int horsePower) {
		this.weightPounds = weightPounds;
		this.horsePower = horsePower;
	}
	
	protected abstract double getSpeedMph(double timeSec);
	
	public double getSpeedMph(double timeSec, int weight){
		double v = 2.0 * this.horsePower * 746 * 
				 timeSec * 32.17 / weight;
		return Math.round(Math.sqrt(v) * 0.68);
	}
}
