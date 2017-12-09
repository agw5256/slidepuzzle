package slidePuzzle;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class ProgrammerPanel extends JPanel { // ������ ȭ��
	
	private JLabel programByTitle; //���� ����� ���� JLabel
	private JLabel lblSJ, lblKJS, lblAGW, lblWSY, lblWJ; //�������� �̸��� ����� JLabel
	private JButton btnGoBack; //�ڷΰ��� ��ư
	
	private ViewChange window; //ȭ����ȯ�� ���� ViewChangeŬ������ ��ü
	private GameListener gameL; //Listener ��ü
		
	public ProgrammerPanel(ViewChange window) {
		// ȭ���ʱ�ȭ ����
		setPreferredSize(new Dimension(900,600));
		setBackground(Color.pink);
		setLayout(null);
		
		this.window = window;
		gameL = new GameListener();
		
		// ȭ����������� ���� JLabel �ʱ�ȭ
		programByTitle = new JLabel("Programmed By");
		programByTitle.setBounds(100, 70, 700, 80);
		programByTitle.setFont(new Font("Consolas",Font.BOLD,80));
		programByTitle.setHorizontalAlignment(SwingConstants.CENTER);
		add(programByTitle);
		
		lblSJ = new JLabel("Sejong University");
		lblSJ.setBounds(150,180,600,40);
		lblSJ.setFont(new Font("Consolas",Font.BOLD,30));
		lblSJ.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSJ);
		
		// ������ ���� �ʱ�ȭ
		lblKJS = new JLabel("Computer Engineering 14' Jaeseong Kim");
		lblKJS.setBounds(100,250,700,40);
		lblKJS.setFont(new Font("Consolas",Font.BOLD,30));
		lblKJS.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblKJS);
		
		lblAGW = new JLabel("Computer Engineering 16' Gunwoo An");
		lblAGW.setBounds(100,310,700,40);
		lblAGW.setFont(new Font("Consolas",Font.BOLD,30));
		lblAGW.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblAGW);
		
		lblWSY = new JLabel("Aerospace Engineering 14' Seoyeon Woo");
		lblWSY.setBounds(100,370,700,40);
		lblWSY.setFont(new Font("Consolas",Font.BOLD,30));
		lblWSY.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblWSY);
		
		lblWJ = new JLabel("Computer Engineering 16' Jin Wi");
		lblWJ.setBounds(100,430,700,40);
		lblWJ.setFont(new Font("Consolas",Font.BOLD,30));
		lblWJ.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblWJ);
		
		//�ڷΰ��� ��ư ���� �� �ʱ�ȭ
		btnGoBack = new JButton("Back");
		btnGoBack.setBounds(790,530,70,50);
		btnGoBack.setFont(new Font("Consolas",Font.BOLD,15));
		btnGoBack.setHorizontalAlignment(SwingConstants.CENTER);
		// 3. add the listener object to the component
		btnGoBack.addActionListener(gameL);
		add(btnGoBack);		
	} // ProgrammerPanel ������
	
	private class GameListener implements ActionListener	{
		public void actionPerformed(ActionEvent event) {
			// 4. event handling...			
			Object obj = event.getSource(); // �̺�Ʈ �߻��� ��ġ(��ư �̸�) �Ѱܹ���.
			if(obj == btnGoBack) { //�ڷΰ��� ��ư Ŭ�� �� InitialPanel�� ȭ����ȯ
				window.changeWindow("InitialPanel");
			} // if			
		} // actionPerformed		
	} // GameListener class
	
	

} // class
