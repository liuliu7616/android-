import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class RegistSucceed extends JFrame implements ActionListener {
	protected Label label = new Label("ע��ɹ�	");
	protected Button button = new Button("������ص�½");
	public RegistSucceed(){
		super("������Ԥ��ϵͳ");
		this.setBounds(400, 200, 400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(java.awt.Color.white);
		this.setLayout(new java.awt.FlowLayout());
		Panel panel = new Panel();
		this.add(panel);
		panel.setLayout(new java.awt.GridLayout(2,1));
		panel.add(label);
		panel.add(button);
		button.addActionListener(this);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getActionCommand()=="������ص�½"){
			new Login();
			this.dispose();
		}
	}

}
