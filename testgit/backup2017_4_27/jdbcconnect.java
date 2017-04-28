import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class jdbcconnect{
		static Connection conn;
	public static Connection connnect(){
		try{	
			String url = "jdbc:sqlserver://localhost:1433;DatabaseName=appointmentmeeting";
			String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
			try{
					Class.forName(driver);//加载驱动
			}
			catch(ClassNotFoundException event){System.out.print("无法创建驱动程式实体!");}
			conn = DriverManager.getConnection(url ,"sa","123456");
			System.out.println("database connect succeed!");
		/*	String sql;
			sql="select * from "+table;
			Statement stmt;
			ResultSet rs;
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				String uid=rs.getString("uid");
				String username=rs.getString("uname");
				System.out.println("uid	"+uid+"	uname	"+username);
			}
			if(rs!=null){
				rs.close();
				rs=null;
			}
			if(stmt!=null){
				stmt.close();
				stmt=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}*/
		}catch(SQLException e){
			System.out.println("database cannot connect");
			e.printStackTrace();
		}
		return conn;
	}
	public static void jdbcclose(){
		try{conn.close();
		System.out.println("database close succeed!");
			conn=null;
		}
		catch(Exception e){
			System.out.println("database cannot close");
			e.printStackTrace();
		}
	}
}

