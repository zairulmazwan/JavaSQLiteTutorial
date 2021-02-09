import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLiteDBUpdateRecord {
	
	public static void main (String [] args)
	{
		
		SQLiteDBUpdateRecord update = new SQLiteDBUpdateRecord();
		update.updateRecord("PA003", "Food", "Rice", 3);
		
	}
	
	public void updateRecord (String pCode, String pCat, String pName, int Id) 
	{
		String sql = "UPDATE Products SET ProductCode = ?, ProductCategory = ?, ProductName = ? WHERE Id = ?";
		
		try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, pCode);
            pstmt.setString(2, pCat);
            pstmt.setString(3, pName);
            pstmt.setInt(4, Id);
            // update 
            pstmt.executeUpdate();
            System.out.println("Updated successful!");
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
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
	}

}
