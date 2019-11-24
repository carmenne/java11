import java.util.Properties;

public class FactorySpeedModel {
  public static SpeedModel generateSpeedModel(
  Properties drivingConditions){
    String road = drivingConditions.getProperty("roadCondition");
    String tire = drivingConditions.getProperty("tireCondition");
    if (road.equals("Wet")) {
		return new SpeedModelWet(tire);
	} else if (road.equals("Dry")) {
		return new SpeedModelDry(tire);
	}
	
	return null;
  }
  private static class SpeedModelWet implements SpeedModel{
	  
	private String tireCondition;
	private  SpeedModelWet(String tireCondition) {
		this.tireCondition = tireCondition;
	}
	
    public double getSpeedMph(double timeSec, int weightPounds, 
                                                     int horsePower){
		double v = 2.0*horsePower*746;
		v = v*timeSec*32.174/weightPounds;
		return Math.round(Math.sqrt(v)*0.68) - 5 - (tireCondition.equals("New")?0:5);
    }
  }
  private static class SpeedModelDry implements SpeedModel{
	  
	private String tireCondition;
	private  SpeedModelDry(String tireCondition) {
		this.tireCondition = tireCondition;
	}
    public double getSpeedMph(double timeSec, int weightPounds, 
                                                     int horsePower){
		double v = 2.0*horsePower*746;
		v = v*timeSec*32.174/weightPounds;
		return Math.round(Math.sqrt(v)*0.68) - 2 - (tireCondition.equals("New")?0:5);
    }
  }
}
