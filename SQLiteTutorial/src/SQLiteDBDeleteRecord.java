import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLiteDBDeleteRecord {
	
	public static void main (String [] args)
	{
		
		SQLiteDBDeleteRecord del = new SQLiteDBDeleteRecord();
		del.deleteRecord(9);
		
	}
	
	
	public void deleteRecord (int Id) 
	{
		String sql = "DELETE FROM Products WHERE id = ?";
		Connection conn = this.connect();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);

            // set the corresponding param
            pstmt.setInt(1, Id);
            // execute the delete statement
            pstmt.executeUpdate();
            System.out.println("A record has been deleted");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	private Connection connect ()
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
