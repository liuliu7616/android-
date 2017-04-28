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
	public boolean add(int roomnum, int remain, String starttime,//这里还要判断时间冲突  ？?
			String endtime, String uname, String describe,String members[])//怎么添加不同数量的成员
			throws RemoteException {
		// TODO Auto-generated method stub
		boolean result =true;
		if(roomnum>0&remain>0&starttime!=null&endtime!=null&uname!=null& describe!=null)//保证数据有意义
		{	System.out.println(1);
			try{
				Connection conn=jdbcconnect.connnect();
				Statement stmt;
				ResultSet rs;
				stmt=conn.createStatement();
				System.out.println(2);
				String sqlroom="select number from roominformations where roomnumber = "+roomnum;
				rs=stmt.executeQuery(sqlroom);
				rs.next();
				if(rs.getInt("number")>=remain){//房间冲突
				
						
						
					//SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm-ss");
					//java.util.Date dst=sdf.parse(starttime);
					 //java.sql.Timestamp dst2= new java.sql.Timestamp(dst.getTime());
					String sqlrecords="insert into records(remain,starttime,endtime,roomnumber,uname,describetion) values" +
							"("+remain+",'"+starttime+"','"+endtime+"',"+roomnum+",'"+uname+"','"+describe+"')";
					String sqlrecords2="select rid from records where starttime= '"+starttime+"' and endtime= '"+endtime+"'and roomnumber= "+roomnum;
					System.out.println(3);
					System.out.println(sqlrecords);
					System.out.println(sqlrecords2);
						//check uname exist or not in table users 
						
						stmt.executeUpdate(sqlrecords);System.out.println(4);
						rs=stmt.executeQuery(sqlrecords2);System.out.println(5);
						rs.next();
						int rid=rs.getInt("rid");
						System.out.print(rid);
						System.out.println("remain= "+remain);
						String sqlmembers[]=new String[remain];
						for(int i=0;i<remain;i++){
							sqlmembers[i] = "insert into members values("+rid+","+members[i]+")";
							stmt.execute(sqlmembers[i]);
							System.out.println(i);
							System.out.println(sqlmembers[i]);
						}
						String sqlmembersown = "insert into members values("+rid+","+uname+")";
						stmt.execute(sqlmembersown);
				}else {System.out.println("the number is over the remain"); result = false;}
				rs.close();
				stmt.close();
				jdbcconnect.jdbcclose();
			}catch(Exception e){System.out.println(e);e.printStackTrace();result=false;}
		}
		return result;
	}
	@Override
	public boolean delete( String uname,String upasswords,int rid) throws RemoteException{
		// TODO Auto-generated method stub
		boolean result=false;
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
				String sqlmember="delete from members where rid="+rid;
					Connection conn=jdbcconnect.connnect();
				Statement stmt;
				System.out.println(sql);
				System.out.println(sqlmember);
				stmt=conn.createStatement();
				if(stmt.executeUpdate(sqlmember)>0) {
					if(stmt.executeUpdate(sql)>0){System.out.println("delete succeed!");result= true;}
				}
				else System.out.println("fail to delete!");
				stmt.close();
				jdbcconnect.jdbcclose();
				}
			}catch(Exception e){System.out.println(e);}
		}
		return result;
	}
	
	@Override
	public String[] query(String uname,String starttime,//查找成员需要完善
			String endtime) throws RemoteException {		//还没有控制时间
		//boolean result= true;
		int define =100;int i=1;
		String data[]=new String[define];
		for(int j=0;j<define;j++){    
			
				data[j]="                     ";
			
		}data[0]="    ";
		// TODO Auto-generated method stub
		if(uname!=null&starttime!=null&endtime!=null){
			try{
				
			Connection con1=jdbcconnect.connnect();
			String sql1="select distinct members.rid from members,records where members.uname='"+uname+"'"+" and starttime>= '"+starttime+"' and endtime<= '"+endtime+"'";
			System.out.println(sql1);
			Statement st1=con1.createStatement();
			ResultSet res= st1.executeQuery(sql1);//
			//System.out.println("there is not exe");
			while(res.next()){
				int rid=res.getInt("rid");
				System.out.println("rid ="+rid);
				//System.out.println(upws);
				String sql="select * from records where rid="+rid;
				Statement stmt;
				System.out.println(sql);
				stmt=con1.createStatement();//starttime end describe member
				ResultSet rs= stmt.executeQuery(sql);//rs ->records
				String sqlmember="select uname from members where rid="+rid;
				System.out.println(sqlmember);
				Statement stmtmember= con1.createStatement();
				ResultSet rsmember=stmtmember.executeQuery(sqlmember);
				System.out.println(i);
				
				
				while(rs.next()){ 
					data[i]=String.valueOf((rs.getInt("rid")));i++;
					data[i]=rs.getString("starttime");i++;
					data[i]=rs.getString("endtime");i++;
					data[i]=rs.getString("describetion");i++;
					System.out.println(rs.getInt("rid")+"	"+rs.getString("starttime")+"	"+rs.getString("endtime")+"	"+rs.getString("describetion"));
					while(rsmember.next()){
						System.out.println(rsmember.getString("uname"));
						data[i]=rsmember.getString("uname");i++;
					}
					data[i]="\n";i++;
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
		for(int p=0;p<define;p++){
				System.out.println(data[p]+" "+p);
			}
		return data;
	}
	/*public static void main(String args[])throws Exception{
		appointmentmeetingImpl test=new appointmentmeetingImpl();
		//test.regist("47", "789s");
		//test.login("123","123");
		//test.delete("123","123",4);
	//	String mem[]={"1","2","3"};
		// test.add(302, 3, "2014-1-1 12:12:12", "2017-12-12 02:02:02", "123","just a test" ,mem );
		
	}*/

}
