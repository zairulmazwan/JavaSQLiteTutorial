import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLiteDBConnection {
	
	public static void main (String [] args)
	{
		
		Connection conn = connect();
		
		try {         
            
             //int Id = 123;
             String pCode = "PS013";
	   		 String pCat = "Drink";
	   		 String pName = "Orange";
	   		 
            System.out.println("Connection to SQLite has been established.");
            String sql = "INSERT INTO Products(ProductCode,ProductCategory,ProductName) VALUES(?,?,?)";
	   		
	   		
	   		 	PreparedStatement pstmt = conn.prepareStatement(sql);
	   		 	//pstmt.setInt(1,Id); we dont need this as we have defined this field as auto-increment and not null
	            pstmt.setString(1, pCode);
	            pstmt.setString(2, pCat);
	            pstmt.setString(3, pName);
	           
	            pstmt.executeUpdate();
	            
            
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
