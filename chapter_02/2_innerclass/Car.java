public class Car extends Vehicle {
	private int passengersCount;
	public Car(int passengersCount, int weightPounds){
		super(weightPounds);
		this.passengersCount = passengersCount;
	}
	public int getPassengersCount() {
		return this.passengersCount;
	}
}
