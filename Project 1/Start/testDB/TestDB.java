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
	//private static Vehicle Vehicle = new Vehicle("Ford", "compact", 5, 5, true);
	
/*	//for(int i; i<2; i++) {
	private static Vehicle Vehicle = new Vehicle();
	//}
	private static void PrintVehicle() {
		System.out.println("Make: " + Vehicle.VehicleMake);
		System.out.println("Size: " + Vehicle.VehicleSize);
		System.out.println("Weight: " + Vehicle.VehicleWeight);
		System.out.println("Engine Size: " + Vehicle.VehicleEngineSize);
		System.out.println("Imported?: " + Vehicle.isVehicleImport + "\n");
	}*/
	
	public static void main(String[] args) throws Exception
   {   
	   DecimalFormat df = new DecimalFormat("####.##");
	   FileWriter fileWriter = new FileWriter("Vehicles.dat");
		
	   for(int i = 1; i<11; i++) {
		Vehicle Vehicle = new Vehicle();
	   
	   int randmake = (int) (Math.random()*5);
	   String make = new String[] { "Ford", "Chevy", "Toyota", "Nissan", "Hyundai" }[randmake];
	   int randsize = (int) (Math.random()*3);
	   String size = "0";// = new String[] { "compact", "intermediate", "fullSized" }[randsize];
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
	   
	   
	  // FileWriter fileWriter = new FileWriter("Vehicles.dat");
	   //fileWriter.write("Make: " + Vehicle.VehicleMake);
	   
	   //fileWriter.close();
	   
	   
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
		
		//fileWriter.close();
	   }
		fileWriter.close();
		//PrintVehicle();
	   Vehicle.setIsVehicleImport(Vehicle.isVehicleImport);
	   
		if (args.length == 0)
      {   
         System.out.println(
               "Usage: java -classpath driver_class_path" 
               + File.pathSeparator 
               + ". TestDB database.properties");
         return;
      }
      else 
		{
		   System.out.println("args[0] = " + args[0]);
         SimpleDataSource.init(args[0]);
		}

      Connection conn = SimpleDataSource.getConnection();
      Statement stat = conn.createStatement();  
 	   try {  
		  stat.execute("DROP TABLE Test2"); 
      }
	   catch (Exception e)
		{ System.out.println("drop failed"); }      

      try
      {
   
         stat.execute("CREATE TABLE Test2 (Name CHAR(20),Age INTEGER)");
         stat.execute("INSERT INTO Test2 VALUES ('Romeo',27)");
         stat.execute("INSERT INTO Test2 VALUES ('Juliet',25)");
         stat.execute("INSERT INTO Test2 VALUES ('Tom',64)");
         stat.execute("INSERT INTO Test2 VALUES ('Dick',55)");
         stat.execute("INSERT INTO Test2 VALUES ('Harry',33)");
         ResultSet result = stat.executeQuery("SELECT * FROM Test2");
			  
			System.out.println("after inserts");
			ResultSetMetaData rsm = result.getMetaData();
			int cols = rsm.getColumnCount();
			  while(result.next())
			  {
			    for(int i = 1; i <= cols; i++)
               System.out.print(result.getString(i)+" ");
             System.out.println("");      
			  }
			try {  
		     stat.execute("DROP TABLE Test2"); 
         }
			catch (Exception e)
			{ System.out.println("drop failed"); }    
		}
      finally
      {
         conn.close();
			System.out.println("dropped Table Test2, closed connection and ending program");  
      }
   }
}
