import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.net.*;
public class appointmentofmeetingroomserver {
	public static void main(String []args){
		try{
			appointmentmeetingImpl rmiam=new appointmentmeetingImpl();
			LocateRegistry.createRegistry(2048);
			Naming.bind("rmi://localhost:2048/Ram",rmiam);
			System.out.println("Զ�̶���Ram�󶨳ɹ�");
		}catch(RemoteException e)
		{
			System.out.println("����Զ�̶����쳣��");
			e.printStackTrace();
		}catch(AlreadyBoundException e)
		{
			System.out.println("�ظ��󶨶����쳣��");
			e.printStackTrace();
		}catch(MalformedURLException e)
		{
			System.out.println("URL�����쳣��");
			e.printStackTrace();
		}
		catch(Exception e){e.printStackTrace();}
	}
}
