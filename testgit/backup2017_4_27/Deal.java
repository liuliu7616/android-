import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class Deal implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getActionCommand()=="��½"){
			System.out.println(tf1.getText());
			System.out.println(pw.getPassword());
			try{
				appointmentmeetinginterface rmiai=(appointmentmeetinginterface)
						Naming.lookup("rmi://localhost:2048/Ram");
			//	String pws=String.valueOf(pw.getPassword());
				if(	rmiai.login(tf1.getText(),String.valueOf(pw.getPassword()))==true)
				System.out.println("��½�ɹ���");
			}catch(NotBoundException e){
				e.printStackTrace();
			}catch(MalformedURLException e){
				e.printStackTrace();
			}catch(RemoteException e){
				e.printStackTrace();
			}
		}
		if(event.getActionCommand()=="ע��"){
		new Regist();	
		
	}

}
