import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class Show extends JFrame implements ActionListener {
	public Show(){
		super("会议室预约系统");
		this.setBackground(java.awt.Color.white);
		this.setBounds(400,200,800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new java.awt.FlowLayout());
		Panel panel=new Panel();
		panel.setLayout(new java.awt.GridLayout(1,3));
		this.add(panel);
		Panel panel1=new Panel();
		Panel panel2=new Panel();
		Panel panel3=new Panel();
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		this.setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Show();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
