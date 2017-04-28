import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;


public class appointmentmeetingImpl extends UnicastRemoteObject 
	implements appointmentmeetinginterface {
	//static int rid=0;
	public appointmentmeetingImpl()throws Exception{}
	
	
/*	protected appointmentmeetingImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}*/
	public boolean regist(String username, String upw) throws RemoteException {
		// TODO Auto-generated method stub
		boolean result = true;
		if(username!=null)//username should be unique
		{String sql="insert into users(uname,upasswords) values('"+username+"','"+upw+"')";
		try{	Connection conn=jdbcconnect.connnect();
				System.out.println(sql);
				//check uname exist or not in table users 
				Statement stmt;
				ResultSet rs;
				stmt=conn.createStatement();
				rs=stmt.executeQuery("select uname from users");
				while(rs.next()){
					String uname=rs.getString("uname");//had better confirm passwords twice
					System.out.println(uname);
					if(username==uname) {result = false;break;}
				}
				rs.close();
				if(result==true){
					System.out.println("execute the sql");
					stmt.execute(sql);
					System.out.println("regist succeed!");
				}
				stmt.close();
				jdbcconnect.jdbcclose();
			}catch(Exception e){System.out.println(e);}
		}
		return result;
	}	
	@Override
	public boolean login(String username, String upw) throws RemoteException {
		// TODO Auto-generated method stub
		boolean result = false;
		if(username!=null){
			String sql="select upasswords from users where uname='"+username+"'";
			try{	Statement stmt;
					ResultSet rs;
					Connection conn=jdbcconnect.connnect();
					stmt=conn.createStatement();
					rs=stmt.executeQuery(sql);
					rs.next();//resultset 取值默认指向结果前一个
					//System.out.println(upw);
					String upasswords=rs.getString("upasswords");
					//System.out.println(upasswords);
					if(upw.equals(upasswords))//look out   equals!!!!
					{ result = true;
					System.out.println("login succeed!");}
					else System.out.println("user name and passwords does not match");
					//System.out.println(2);
					rs.close();
					stmt.close();
					jdbcconnect.jdbcclose();
			}catch(Exception e ){System.out.println(e);}
		}
		return result;
	}
	@Override
	public void add(int roomnum, int remain, String starttime,
			String endtime, String uname, String describe)//怎么添加不同数量的成员
			throws RemoteException {
		// TODO Auto-generated method stub
		
		if(roomnum>0&remain>0&starttime!=null&endtime!=null&uname!=null& describe!=null)//保证数据有意义
		{
			//SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm-ss");
			//java.util.Date dst=sdf.parse(starttime);
			 //java.sql.Timestamp dst2= new java.sql.Timestamp(dst.getTime());
			String sql="insert into records(remain,starttime,endtime,roomnumber,uname,describetion) values" +
					"("+remain+",'"+starttime+"','"+endtime+"',"+roomnum+",'"+uname+"','"+describe+"')";
			System.out.println(sql);
			
		try{	Connection conn=jdbcconnect.connnect();
				
				//check uname exist or not in table users 
				Statement stmt;
				//ResultSet rs;
				stmt=conn.createStatement();
				stmt.executeUpdate(sql);
				
				stmt.close();
				jdbcconnect.jdbcclose();
			}catch(Exception e){System.out.println(e);}
		}

	}
	@Override
	public void delete( String uname,String upasswords,int rid) throws RemoteException{
		// TODO Auto-generated method stub
		if(uname!=null&upasswords!=null&rid>0){
			try{
			Connection con1=jdbcconnect.connnect();
			String sql1="select upasswords from users where uname='"+uname+"'";
			//System.out.println(sql1);
			Statement st1=con1.createStatement();
			ResultSet res= st1.executeQuery(sql1);//
			//System.out.println("there is not exe");
			res.next();
			String upws=res.getString("upasswords");
			//System.out.println(upws);
			res.close();
			st1.close();
			con1.close();
			jdbcconnect.jdbcclose();
			if(upasswords.equals(upws)){
				String sql="delete from records where rid="+rid;
					Connection conn=jdbcconnect.connnect();
				Statement stmt;
				System.out.println(sql);
				stmt=conn.createStatement();
				if(stmt.executeUpdate(sql)>0) System.out.println("delete succeed!");
				else System.out.println("fail to delete!");
				stmt.close();
				jdbcconnect.jdbcclose();
				}
			}catch(Exception e){System.out.println(e);}
		}
	}
	@Override
	public void query(String uname,String starttime,//查找成员需要完善
			String endtime) throws RemoteException {
		// TODO Auto-generated method stub
		if(uname!=null&starttime!=null&endtime!=null){
			try{
			Connection con1=jdbcconnect.connnect();
			String sql1="select rid from members where uname='"+uname+"'";
			//System.out.println(sql1);
			Statement st1=con1.createStatement();
			ResultSet res= st1.executeQuery(sql1);//
			//System.out.println("there is not exe");
			while(res.next()){
			int rid=res.getInt("rid");
			//System.out.println(upws);
			String sql="select * from records where rid="+rid;
			Statement stmt;
			System.out.println(sql);
			stmt=con1.createStatement();
			ResultSet rs= stmt.executeQuery(sql);//starttime end describe member
			while(rs.next()){ 
				System.out.println(rs.getString("starttime")+"	"+rs.getString("endtime")+"	"+rs.getString("describetion")	);
			}
				//System.out.println("fail to delete!");
				stmt.close();
			}
			res.close();
			st1.close();
			con1.close();
			jdbcconnect.jdbcclose();				
			}catch(Exception e){System.out.println(e);}
		}
	}
	/*public static void main(String args[])throws Exception{
		appointmentmeetingImpl test=new appointmentmeetingImpl();
		test.regist("47", "789s");
		//test.login("123","123");
		//test.delete("hello","world",1);
		//test.query("hello","2011-01-01 12:12:12","2017-12-12 12:12:12");
	}*/

}
