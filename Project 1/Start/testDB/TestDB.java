import java.io.File;
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
		
	   for(int i = 1; i<11; i++) {
		Vehicle Vehicle = new Vehicle();
	   
	   int randmake = (int) (Math.random()*5);
	   String input1 = new String[] { "Ford", "Chevy", "Toyota", "Nissan", "Hyundai" }[randmake];
	   int randsize = (int) (Math.random()*3);
	   String input2 = "0";// = new String[] { "compact", "intermediate", "fullSized" }[randsize];
	   double input3 = (Math.random() * (+4000 - +1500)) + +1500;
	   double input4 = (Math.random() * ((1000 - 100) + 100)) + 100;
	   boolean input5 = true;

	   if(input3 < 2001) {input2 ="compact";}
	   if(input3 > 2001 && input3 < 2500) {input2 ="intermediate";}
	   if(input3 > 2501) {input2 ="fullSized";}
	   if(input1 == "Ford" || input1 == "Chevy") {
		   input5 = false;
	   } else {
		   input5 = true;
	   }
	   
	   Vehicle.setVehicleMake(input1);
	   Vehicle.setVehicleSize(input2);
	   Vehicle.setVehicleWeight(input3);
	   Vehicle.setVehicleEngineSize(input4);
	   Vehicle.setIsVehicleImport(input5);
	   
	   	System.out.println("Car " + (i));
	    System.out.println("Make: " + Vehicle.VehicleMake);
		System.out.println("Size: " + Vehicle.VehicleSize);
		System.out.println("Weight: " + df.format(Vehicle.VehicleWeight));
		System.out.println("Engine Size: " + df.format(Vehicle.VehicleEngineSize));
		System.out.println("Imported?: " + Vehicle.isVehicleImport + "\n");
	   }
		
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
