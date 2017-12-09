package slidePuzzle;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class InitialPanel extends JPanel  { // 기본 게임화면에 출력될 배경패널

	private JLabel lblTitle; // 맨 위에 출력되는 게임 타이틀
	private JButton btnEasy,btnNormal,btnHard; // 게임 난이도 선택 버튼
	private JButton btnRanking, btnProgrammer; // 순서대로 랭킹, 제작자 목록 보여주는 버튼
	private JButton btnEnter; // 이름 입력받고 확인 누르는 용도의 버튼
	private JTextField txtName; // 이름 입력받을 텍스트필드
	
	private ViewChange window; // 상위객체 접근위함
	
	// 2. declaration listener object
	private GameListener gameL; // 게임에서 동작하는 이벤트 관련된 리스너 -> 버튼으로만 동작하기때문에 하나로 충분
	
	public InitialPanel(ViewChange window) { // 초기화면 생성자
		setPreferredSize(new Dimension(900,600));
		setBackground(Color.pink);
		setLayout(null);
		
		this.window = window; //상위 객체 사용위함
		// 2. creating listener object
		gameL = new GameListener();		
		
		//이하의 내용은 각각 패널에 포함되는 내용들 생성
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
				
	} // InitialPanel() // 생성자	
	
	// 1. listener class
	private class GameListener implements ActionListener	{
		public void actionPerformed(ActionEvent event) {
			// 4. event handling...			
			Object obj = event.getSource(); // 이벤트 발생한 위치(버튼 이름) 넘겨받음.
			if(obj == txtName || obj == btnEnter) { // 이름입력하고 엔터 누르거나 확인 버튼 눌렀을때
				if (txtName.getText().length()==0) RankingPanel.sUserName = "NONE"; // 텍스트필드에 아무것도 없을시 기본값 NONE으로 이름 입력됨
				else RankingPanel.sUserName = txtName.getText(); // 그외의 경우는 텍스트필드의 이름값 가져옴
				txtName.setEnabled(false); // 텍스트필드 관련 버튼 사용불가, 게임관련 버튼 사용가능
				btnEnter.setEnabled(false);
				btnEasy.setEnabled(true);
				btnNormal.setEnabled(true);
				btnHard.setEnabled(true);
			}
			if(obj == btnEasy) { // 각각 버튼에 해당하는 패널 불러오는 else if
				window.changeWindow("GamingPanelEasy");
				
			} else if( obj == btnNormal) {
				window.changeWindow("GamingPanelNormal");
				
			} else if( obj == btnHard) {
				window.changeWindow("GamingPanelHard");
				
			} else if( obj == btnRanking) {
				window.changeWindow("RankingPanel");
				
			} else if( obj == btnProgrammer) {
				window.changeWindow("ProgrammerPanel");
				
			} // if-else if	//버튼 선택
			
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
