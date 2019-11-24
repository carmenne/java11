public class Truck extends Vehicle {
	private int payload;
	public Truck(int payloadPounds, int weightPounds, 
						  int horsePower){
		super(weightPounds, horsePower);
		this.payload = payloadPounds;
	}
	public int getPayload() { 
		return this.payload; 
	}
	
	public double getSpeedMph(double timeSec) {
		return getSpeedMph(timeSec, this.weightPounds + this.payload);
	}
}
