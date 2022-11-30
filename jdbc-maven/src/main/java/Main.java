import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/aeroporto";
		String user = "root";
		String password = "root";
		 
		Connection con = null;
		try {
			
			con = DriverManager.getConnection(url, user, password);
			
			final String sql = "SELECT * FROM roles";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				final int id = rs.getInt(1);
				final String name = rs.getString(2);
				
				System.out.println(id + " - " + name);
			}
			
			ps.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		} finally{
			
			try {
				con.close();
			} catch (Exception e) { }
		}
	}

}
