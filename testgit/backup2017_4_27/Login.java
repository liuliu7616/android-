import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.*;
public class Login extends JFrame implements ActionListener{
	//protected JApplet applet;
	protected Panel panel; 
	TextField tf1=new TextField(10);
	JPasswordField pw=new JPasswordField();
	public Login(){
		super("��ӭ����������ԤԼϵͳ");
		this.setBounds(400, 200, 400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setBackground(java.awt.Color.white);
		this.setLayout(new java.awt.FlowLayout());
		Panel panel=new Panel();
		//panel.setBounds(200 ,500 , 200, 500);
		this.add(panel);
		panel.setLayout(new java.awt.GridLayout(3,2));
		panel.add(new Label("		�û�����"));
		//TextField tf1=new TextField(10);
		//tf1.setBounds(getMaximizedBounds());
		panel.add(tf1);
		panel.add(new Label("		���룺"));
		
		//pw.setBounds(getMaximizedBounds());
		panel.add(pw);
		Button bre = new Button("ע��");
		bre.addActionListener(this);
		panel.add(bre);
		Button blo = new Button("��½");
		blo.addActionListener(this);
		panel.add(blo);
		this.setVisible(true);
	}
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
		this.dispose();
		}
	}
	public static void main(String args[]){
		Login login = new Login();
	}
}
