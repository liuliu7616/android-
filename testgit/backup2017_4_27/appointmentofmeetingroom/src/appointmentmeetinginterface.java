import java.rmi.Remote;
import java.rmi.*;

public interface appointmentmeetinginterface extends Remote {
	
	public boolean regist(String uname,String upw)throws RemoteException;
	public boolean login(String uname,String upw) throws RemoteException;
	public boolean add(int roomnum,int remain,String starttime,String endtime,String uname,String describe,String member[]) throws RemoteException;
	public boolean delete(String uname,String upasswords ,int rid) throws RemoteException;
	//public void change() throws RemoteException;
	public String[] query(String uname,String starttime,String endtime) throws RemoteException;
}
