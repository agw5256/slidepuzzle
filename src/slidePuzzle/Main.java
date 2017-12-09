package slidePuzzle;

import javax.swing.JFrame;

public class Main { // 실행하는 메인클래스

	public static void main(String[] args) { // 메인 프레임가진  클래스
		// TODO Auto-generated method stub
		ViewChange frame = new ViewChange(); //Jframe class인 viewchange클래스 생성하여 프레임 사용
		frame.setTitle("SLIDE PUZZLE");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.initPanel = new InitialPanel(frame); // viewchange클래스의 데이터인 패널클래스들 생성 및 상위객체(프레임) 인자로 넣어놓기
		frame.madeByPanel = new ProgrammerPanel(frame);
		frame.gamePaneleasy = new GamingPanelEasy(frame);
		frame.gamePanelNormal = new GamingPanelNormal(frame);
		frame.gamePanelHard = new GamingPanelHard(frame);
		frame.rankingPanel = new RankingPanel(frame);
		
		// GamingPanel gamingPanel = new GamingPanel(frame);
		
		frame.getContentPane().add(frame.initPanel); // 초기화면부터 출력
		frame.setSize(900,600);
		frame.pack();
		frame.setVisible(true);
	}

}
