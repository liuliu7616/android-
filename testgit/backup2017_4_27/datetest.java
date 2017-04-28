import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class datetest {
	public static void main(String aegs[]) throws ParseException, SQLException{
		int y=2014;
		int m=01;
		int d=01;
		int h=11;
		int min=02;
		int s=11;
		String str=y+"-"+m+"-"+d+" "+h+":"+min+":"+s;
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date d1=sdf.parse(str);
		 java.sql.Timestamp d2= new java.sql.Timestamp(d1.getTime());
		 Connection conn=jdbcconnect.connnect();
		 String sql="insert into records(rid,remain,starttime,endtime,roomnumber,uname,describetion) " +
		 		"values(24,12,'"+str+"','"+str+"',"+301+",'hello','text')";
		 Statement stmt;
			ResultSet rs;
			stmt=conn.createStatement();
			System.out.println(str);
			System.out.println(d1);
			System.out.println(d2);
			System.out.println(sql);
			stmt.executeUpdate(sql);//rs.next();
			//rs.close();
			stmt.close();
			
			jdbcconnect.jdbcclose();
	}
}
