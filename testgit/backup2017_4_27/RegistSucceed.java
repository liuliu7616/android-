import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class RegistSucceed extends JFrame implements ActionListener {
	protected Label label = new Label("注册成功	");
	protected Button button = new Button("点击返回登陆");
	public RegistSucceed(){
		super("会议室预订系统");
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
		if(event.getActionCommand()=="点击返回登陆"){
			new Login();
			this.dispose();
		}
	}

}
