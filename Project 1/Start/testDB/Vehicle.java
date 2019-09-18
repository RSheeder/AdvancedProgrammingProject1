
public class Vehicle {
	public String VehicleMake;// = { "Ford", "Chevy", "Toyota", "Nissan", "Hyundai" };
	public String VehicleSize;// = { "compact", "intermediate", "fullSized" };
	public double VehicleWeight;
	public double VehicleEngineSize;
	public boolean isVehicleImport;
	
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
	
	public void setVehicleMake(String newVehicleMake)
	{
		VehicleMake = newVehicleMake;
	}
	
	public void setVehicleSize(String newVehicleSize)
	{
		VehicleSize = newVehicleSize;
	}
	
	public void setVehicleWeight(double newVehicleWeight)
	{
		if (newVehicleWeight < 0)
		{
			newVehicleWeight = 0;
		} else {
		
			VehicleWeight = newVehicleWeight;
		}
	}
	
	public void setVehicleEngineSize(double newVehicleEngineSize)
	{
		if (newVehicleEngineSize < 0)
		{
			newVehicleEngineSize = 0;
		} else {
		
			VehicleEngineSize = newVehicleEngineSize;
		}
	}
	
	public void setIsVehicleImport(boolean newIsVehicleImport)
	{
		isVehicleImport = newIsVehicleImport;
	}
	
	
	
	
	
}
