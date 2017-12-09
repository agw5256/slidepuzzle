package slidePuzzle;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class InitialPanel extends JPanel  { // �⺻ ����ȭ�鿡 ��µ� ����г�

	private JLabel lblTitle; // �� ���� ��µǴ� ���� Ÿ��Ʋ
	private JButton btnEasy,btnNormal,btnHard; // ���� ���̵� ���� ��ư
	private JButton btnRanking, btnProgrammer; // ������� ��ŷ, ������ ��� �����ִ� ��ư
	private JButton btnEnter; // �̸� �Է¹ް� Ȯ�� ������ �뵵�� ��ư
	private JTextField txtName; // �̸� �Է¹��� �ؽ�Ʈ�ʵ�
	
	private ViewChange window; // ������ü ��������
	
	// 2. declaration listener object
	private GameListener gameL; // ���ӿ��� �����ϴ� �̺�Ʈ ���õ� ������ -> ��ư���θ� �����ϱ⶧���� �ϳ��� ���
	
	public InitialPanel(ViewChange window) { // �ʱ�ȭ�� ������
		setPreferredSize(new Dimension(900,600));
		setBackground(Color.pink);
		setLayout(null);
		
		this.window = window; //���� ��ü �������
		// 2. creating listener object
		gameL = new GameListener();		
		
		//������ ������ ���� �гο� ���ԵǴ� ����� ����
		lblTitle = new JLabel("SLIDE PUZZLE"); 
		lblTitle.setBounds(100, 100, 700, 100);
		lblTitle.setFont(new Font("Consolas",Font.BOLD,100));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitle);
		
		txtName = new JTextField("put your name"); 
		txtName.setBounds(350,250,200,30);
		txtName.setFont(new Font("Consolas",Font.BOLD,18));
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.addActionListener(gameL);
		add(txtName);
		
		btnEnter = new JButton("Enter");
		btnEnter.setBounds(552,250,80,30);
		btnEnter.setFont(new Font("Consolas",Font.BOLD,17));
		btnEnter.setHorizontalAlignment(SwingConstants.CENTER);
		btnEnter.addActionListener(gameL);
		add(btnEnter);
		
		btnEasy = new JButton("Easy");
		btnEasy.setBounds(100,300,200,100);
		btnEasy.setFont(new Font("Consolas",Font.BOLD,50));
		btnEasy.setHorizontalAlignment(SwingConstants.CENTER);
		btnEasy.setEnabled(false);
		// 3. add the listener object to the component
		btnEasy.addActionListener(gameL);
		add(btnEasy);
		
		btnNormal = new JButton("Normal");
		btnNormal.setBounds(350,300,200,100);
		btnNormal.setFont(new Font("Consolas",Font.BOLD,50));
		btnNormal.setHorizontalAlignment(SwingConstants.CENTER);
		btnNormal.setEnabled(false);
		// 3. add the listener object to the component
		btnNormal.addActionListener(gameL);
		add(btnNormal);
		
		btnHard = new JButton("Hard");
		btnHard.setBounds(600,300,200,100);
		btnHard.setFont(new Font("Consolas",Font.BOLD,50));
		btnHard.setHorizontalAlignment(SwingConstants.CENTER);
		btnHard.setEnabled(false);
		// 3. add the listener object to the component
		btnHard.addActionListener(gameL);
		add(btnHard);
		
		btnRanking = new JButton("Ranking");
		btnRanking.setBounds(450,520,150,50);
		btnRanking.setBackground(new Color(250,70,140));
		btnRanking.setFont(new Font("Consolas",Font.BOLD,20));
		btnRanking.setHorizontalAlignment(SwingConstants.CENTER);
		// 3. add the listener object to the component
		btnRanking.addActionListener(gameL);
		add(btnRanking);
		
		btnProgrammer = new JButton("Programmed by");
		btnProgrammer.setBounds(625,520,200,50);
		btnProgrammer.setBackground(new Color(250,70,140));
		btnProgrammer.setFont(new Font("Consolas",Font.BOLD,20));
		btnProgrammer.setHorizontalAlignment(SwingConstants.CENTER);
		// 3. add the listener object to the component
		btnProgrammer.addActionListener(gameL);
		add(btnProgrammer);			
				
	} // InitialPanel() // ������	
	
	// 1. listener class
	private class GameListener implements ActionListener	{
		public void actionPerformed(ActionEvent event) {
			// 4. event handling...			
			Object obj = event.getSource(); // �̺�Ʈ �߻��� ��ġ(��ư �̸�) �Ѱܹ���.
			if(obj == txtName || obj == btnEnter) { // �̸��Է��ϰ� ���� �����ų� Ȯ�� ��ư ��������
				if (txtName.getText().length()==0) RankingPanel.sUserName = "NONE"; // �ؽ�Ʈ�ʵ忡 �ƹ��͵� ������ �⺻�� NONE���� �̸� �Էµ�
				else RankingPanel.sUserName = txtName.getText(); // �׿��� ���� �ؽ�Ʈ�ʵ��� �̸��� ������
				txtName.setEnabled(false); // �ؽ�Ʈ�ʵ� ���� ��ư ���Ұ�, ���Ӱ��� ��ư ��밡��
				btnEnter.setEnabled(false);
				btnEasy.setEnabled(true);
				btnNormal.setEnabled(true);
				btnHard.setEnabled(true);
			}
			if(obj == btnEasy) { // ���� ��ư�� �ش��ϴ� �г� �ҷ����� else if
				window.changeWindow("GamingPanelEasy");
				
			} else if( obj == btnNormal) {
				window.changeWindow("GamingPanelNormal");
				
			} else if( obj == btnHard) {
				window.changeWindow("GamingPanelHard");
				
			} else if( obj == btnRanking) {
				window.changeWindow("RankingPanel");
				
			} else if( obj == btnProgrammer) {
				window.changeWindow("ProgrammerPanel");
				
			} // if-else if	//��ư ����
			
		} // actionPerformed
		
	} // GameListener class
	
	public void initializePanel() { // ??
		txtName.setText("put your name");
		txtName.setEnabled(true);
		btnEnter.setEnabled(true);
		btnEasy.setEnabled(false);
		btnNormal.setEnabled(false);
		btnHard.setEnabled(false);
	}
} // InitialPanel class
