package slidePuzzle;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class ProgrammerPanel extends JPanel { // 개발자 화면
	
	private JLabel programByTitle; //제목 출력을 위한 JLabel
	private JLabel lblSJ, lblKJS, lblAGW, lblWSY, lblWJ; //팀원들의 이름을 출력할 JLabel
	private JButton btnGoBack; //뒤로가기 버튼
	
	private ViewChange window; //화면전환을 위한 ViewChange클래스의 객체
	private GameListener gameL; //Listener 객체
		
	public ProgrammerPanel(ViewChange window) {
		// 화면초기화 설정
		setPreferredSize(new Dimension(900,600));
		setBackground(Color.pink);
		setLayout(null);
		
		this.window = window;
		gameL = new GameListener();
		
		// 화면제목출력을 위한 JLabel 초기화
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
		
		// 개발자 정보 초기화
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
		
		//뒤로가기 버튼 생성 및 초기화
		btnGoBack = new JButton("Back");
		btnGoBack.setBounds(790,530,70,50);
		btnGoBack.setFont(new Font("Consolas",Font.BOLD,15));
		btnGoBack.setHorizontalAlignment(SwingConstants.CENTER);
		// 3. add the listener object to the component
		btnGoBack.addActionListener(gameL);
		add(btnGoBack);		
	} // ProgrammerPanel 생성자
	
	private class GameListener implements ActionListener	{
		public void actionPerformed(ActionEvent event) {
			// 4. event handling...			
			Object obj = event.getSource(); // 이벤트 발생한 위치(버튼 이름) 넘겨받음.
			if(obj == btnGoBack) { //뒤로가기 버튼 클릭 시 InitialPanel로 화면전환
				window.changeWindow("InitialPanel");
			} // if			
		} // actionPerformed		
	} // GameListener class
	
	

} // class
