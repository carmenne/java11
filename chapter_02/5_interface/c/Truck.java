public interface Truck extends Vehicle {
	int getPayloadPounds();
	default int getPayloadKg(){
		return convertPoundsToKg(getPayloadPounds());
	}
	static int convertKgToPounds(int kgs){
		return (int) Math.round(2.205 * kgs);
	}
	default int getWeightKg(int pounds){
		return (int) Math.round(0.454 * pounds);
	}
	private int convertPoundsToKg(int pounds){
		return convertPoundsToKg(pounds);
	}
	
}
