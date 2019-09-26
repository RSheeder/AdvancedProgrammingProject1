import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.DecimalFormat;

/**
   Tests a database installation by creating and querying
   a sample table. Call this program as
   java -classpath driver_class_path;. TestDB database.properties
*/
public class TestDB 
{	
	public static void main(String[] args) throws Exception
   {   
	   DecimalFormat df = new DecimalFormat("####.##");
	   FileWriter fileWriter = new FileWriter("Vehicles.dat");
		
	   SimpleDataSource.init("./database.properties");
	   Connection conn = SimpleDataSource.getConnection();
	   Statement stat = conn.createStatement();
	   try {  
			  stat.execute("DROP TABLE VehicleTable"); 
	      }
		   catch (Exception e)
			{ System.out.println(""); }      

	   try
	      {
		   stat.execute("CREATE TABLE VehicleTable (CarID int, Make CHAR(20), Size CHAR(20), Weight FLOAT, EngineSize FLOAT, Import CHAR(5))");
		   
		   for(int i = 1; i<11; i++) {
			   Vehicle Vehicle = new Vehicle();
			   
			   int randmake = (int) (Math.random()*5);
			   String make = new String[] { "Ford", "Chevy", "Toyota", "Nissan", "Hyundai" }[randmake];
			   String size = "0";
			   double weight = (Math.random() * (+4000 - +1500)) + +1500;
			   double enginesize = (Math.random() * ((1000 - 100) + 100)) + 100;
			   boolean imported = true;

			   if(weight < 2001) {size ="compact";}
			   if(weight > 2001 && weight < 2500) {size ="intermediate";}
			   if(weight > 2501) {size ="fullSized";}
			   if(make == "Ford" || make == "Chevy") {
				   imported = false;
			   } else {
				   imported = true;
			   }
			   
			   
			   Vehicle.setVehicleMake(make);
			   Vehicle.setVehicleSize(size);
			   Vehicle.setVehicleWeight(weight);
			   Vehicle.setVehicleEngineSize(enginesize);
			   Vehicle.setIsVehicleImport(imported);   
			   
			   	System.out.println("Car " + (i));
			   	fileWriter.write("Car " + i +": " + "\n");
			    
			   	System.out.println("Make: " + Vehicle.VehicleMake);
			    fileWriter.write("Make: " + make + "\n");
				
			    System.out.println("Size: " + Vehicle.VehicleSize);
				fileWriter.write("Size: " + size + "\n");
				
				System.out.println("Weight: " + df.format(Vehicle.VehicleWeight));
				fileWriter.write("Weight: " + df.format(weight) + "\n");
				
				System.out.println("Engine Size: " + df.format(Vehicle.VehicleEngineSize));
				fileWriter.write("Engine Size: " + df.format(enginesize) + "\n");
				
				System.out.println("Imported?: " + Vehicle.isVehicleImport + "\n");
				fileWriter.write("Imported?: " + imported + "\n\n");
				
				stat.execute("INSERT INTO VehicleTable VALUES ("+i+",'"+make+"','"+size+"',"+df.format(weight)+","+df.format(enginesize)+","+imported+")");
			   }
	   
		   	 ResultSet result = stat.executeQuery("SELECT * FROM VehicleTable");
				  
				System.out.println("Querying: SELECT * FROM VehicleTable");
				ResultSetMetaData rsm = result.getMetaData();
				int cols = rsm.getColumnCount();
				  while(result.next())
				  {
				    for(int i = 1; i <= cols; i++)
	               System.out.print(result.getString(i)+" ");
	             System.out.println("");      
				  }
				  System.out.println("\n"+"Querying: SELECT * FROM VehicleTable WHERE Make = 'Ford' OR Make = 'Chevy'");
				  result = stat.executeQuery("SELECT * FROM VehicleTable WHERE Make ='Ford' OR Make = 'Chevy'");
				  while(result.next())
				  {
				    for(int i = 1; i <= cols; i++)
	               System.out.print(result.getString(i)+" ");
	             System.out.println("");      
				  }
				  System.out.println("\n"+"Querying: SELECT * FROM VehicleTable WHERE Weight > 2500");
				  result = stat.executeQuery("SELECT * FROM VehicleTable WHERE Weight > 2500");
				  while(result.next())
				  {
				    for(int i = 1; i <= cols; i++)
	               System.out.print(result.getString(i)+" ");
	             System.out.println("");      
				  }
				try { 
			     stat.execute("DROP TABLE VehicleTable"); 
	         }
				catch (Exception e)
				{ System.out.println("drop failed"); }    
	      } finally {
		         conn.close();
					System.out.println("dropped Table VehicleTable, closed connection and ending program");  
		    }
		fileWriter.close();
	    Vehicle.setIsVehicleImport(Vehicle.isVehicleImport);
   }
}
