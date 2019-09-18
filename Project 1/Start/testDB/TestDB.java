import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
   Tests a database installation by creating and querying
   a sample table. Call this program as
   java -classpath driver_class_path;. TestDB database.properties
*/
public class TestDB 
{
	private static Vehicle Vehicle = new Vehicle();

	private static void PrintVehicle() {
		System.out.println("Make: " + Vehicle.VehicleMake[0]);
		System.out.println("Size: " + Vehicle.VehicleSize[0]);
		System.out.println("Weight: " + Vehicle.VehicleWeight);
		System.out.println("Engine Size: " + Vehicle.VehicleEngineSize);
		System.out.println("Imported?: " + Vehicle.isVehicleImport);
	}
	
	public static void main(String[] args) throws Exception
   {   
	   PrintVehicle();
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
