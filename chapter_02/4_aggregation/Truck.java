public class Truck extends Vehicle {
	private int payload;
	public Truck(int payloadPounds, int weightPounds, 
						  int horsePower){
		super(weightPounds + payload), horsePower);
		this.payload = payloadPounds;
	}
	public int getPayload() { 
		return this.payload; 
	}
}
