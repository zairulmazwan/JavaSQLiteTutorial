import java.sql.Statement;
import java.util.ArrayList;
import java.awt.datatransfer.SystemFlavorMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLiteQuery {
	
	public static void main (String [] args)
	{
		
		Connection conn = connect ();
		ArrayList<ArrayList<Object>> data;
		
		try {
	          
            //System.out.println("Connection to SQLite has been established.");
            String sql = "SELECT ProductCode,ProductCategory,ProductName FROM Products";
	   		
             Statement stmt  = conn.createStatement();
             data = new ArrayList<ArrayList<Object>>();
	   		 ResultSet res = stmt.executeQuery(sql);
			{
	             // loop through the result set
	             while (res.next()) {
	            	 
	            	 String prodCode = res.getString("ProductCode");
	            	 String prodCat = res.getString("ProductCategory");
	            	 String prodName = res.getString("ProductName");
	            	 
	            	 ArrayList<Object> rec = new ArrayList<Object>();
	            	 rec.add(prodCode);
	            	 rec.add(prodCat);
	            	 rec.add(prodName);
	            	 
	            	 data.add(rec);
	            	
	             }
	   		 }
			
			printData(data);
	         
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
	}
	
	public static void printData (ArrayList<ArrayList<Object>> data)
	{
		for (int i=0; i<data.size(); i++)
		{
			for (int j=0; j<data.get(i).size(); j++)
			{
				System.out.print(data.get(i).get(j));
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	
	private static Connection connect ()
	{
		String fileName = "C:/Users/zairu/eclipse-workspace/SQLite Tutorial/InventorySystem.db";
		String url = "jdbc:sqlite:" + fileName;
		// SQLite connection string
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Db connection successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
	}
	
	

}
