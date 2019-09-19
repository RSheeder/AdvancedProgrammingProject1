
public class Vehicle {
	public static String VehicleMake;// = { "Ford", "Chevy", "Toyota", "Nissan", "Hyundai" };
	public static String VehicleSize;// = { "compact", "intermediate", "fullSized" };
	public static double VehicleWeight;
	public static double VehicleEngineSize;
	public static boolean isVehicleImport;
	
	/*public Vehicle(String VehicleMake, String VehicleSize, double VehicleWeight, double VehicleEngineSize, boolean isVehicleImport ) {
		this.VehicleMake = VehicleMake;
		this.VehicleSize = VehicleSize;
		this.VehicleWeight = VehicleWeight;
		this.VehicleEngineSize = VehicleEngineSize;
		this.isVehicleImport = isVehicleImport;
	}*/
	
	/*public Vehicle(String[] VehicleMake, String[] size, double weight, double enginesize, boolean import) {
		// TODO Auto-generated constructor stub
		this.VehicleMake = VehicleMake;
		
	}*/

	public String getVehicleMake() 
	{
		return VehicleMake;
	}
	
	public String getVehicleSize()
	{
		return VehicleSize;
	}
	
	public double getVehicleWeight()
	{
		return VehicleWeight;
	}
	
	public double getVehicleEngineSize()
	{
		return VehicleEngineSize;
	}
	
	public boolean getIsVehicleImport()
	{
		return isVehicleImport;
	}
	
	public static void setVehicleMake(String newVehicleMake)
	{
		VehicleMake = newVehicleMake;
	}
	
	public static void setVehicleSize(String newVehicleSize)
	{
		VehicleSize = newVehicleSize;
	}
	
	public static void setVehicleWeight(double newVehicleWeight)
	{
		if (newVehicleWeight < 0)
		{
			newVehicleWeight = 0;
		} else {
		
			VehicleWeight = newVehicleWeight;
		}
	}
	
	public static void setVehicleEngineSize(double newVehicleEngineSize)
	{
		if (newVehicleEngineSize < 0)
		{
			newVehicleEngineSize = 0;
		} else {
		
			VehicleEngineSize = newVehicleEngineSize;
		}
	}
	
	public static void setIsVehicleImport(boolean newIsVehicleImport)
	{
		isVehicleImport = newIsVehicleImport;
	}
	
	
	
	
	
}
