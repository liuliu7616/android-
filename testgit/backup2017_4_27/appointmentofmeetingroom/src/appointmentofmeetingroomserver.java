import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.net.*;
public class appointmentofmeetingroomserver {
	public static void main(String []args){
		try{
			appointmentmeetingImpl rmiam=new appointmentmeetingImpl();
			LocateRegistry.createRegistry(2048);
			Naming.bind("rmi://localhost:2048/Ram",rmiam);
			System.out.println("远程对象Ram绑定成功");
		}catch(RemoteException e)
		{
			System.out.println("创建远程对象异常！");
			e.printStackTrace();
		}catch(AlreadyBoundException e)
		{
			System.out.println("重复绑定对象异常！");
			e.printStackTrace();
		}catch(MalformedURLException e)
		{
			System.out.println("URL畸形异常！");
			e.printStackTrace();
		}
		catch(Exception e){e.printStackTrace();}
	}
}
