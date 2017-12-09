package slidePuzzle;

import javax.swing.JFrame;

public class ViewChange extends JFrame { // 화면 전환을 해주는 클래스
	
	public InitialPanel initPanel =null; // 각각 패널들 선언 / public으로 하여 main에서 변경 가능하게
	public GamingPanelEasy gamePaneleasy = null;
	public ProgrammerPanel madeByPanel = null;
	public GamingPanelNormal gamePanelNormal = null;
	public GamingPanelHard gamePanelHard = null;
	public RankingPanel rankingPanel = null;
	
	public void changeWindow(String panelName) { // 문자열을 값으로 받아 구분쉽게, 원하는 패널로 변경하는 메소드
		
		if(panelName.equals("InitialPanel")) { // 문자열 값이 초기 화면패널인경우
			getContentPane().removeAll(); // 프레임의 모든 내용지우고
			getContentPane().add(initPanel); // 프레임에 초기화면 패널 넣고
			initPanel.initializePanel(); // ??
			revalidate(); // 무슨용도인지 모름. 웹서핑해서 찾은것
			repaint(); // 화면 경직 막기위해?
		} else if(panelName.equals("GamingPanelEasy")) { // 이하 동
			getContentPane().removeAll();
			getContentPane().add(gamePaneleasy);
			revalidate();
			repaint();
		} else if(panelName.equals("GamingPanelNormal")) {
			getContentPane().removeAll();
			getContentPane().add(gamePanelNormal);
			revalidate();
			repaint();	
		} else if(panelName.equals("GamingPanelHard")) {
			getContentPane().removeAll();
			getContentPane().add(gamePanelHard);
			revalidate();
			repaint();	
		} else if(panelName.equals("ProgrammerPanel")) {
			getContentPane().removeAll();
			getContentPane().add(madeByPanel);
			revalidate();
			repaint();			
		} else if(panelName.equals("RankingPanel")) {
			getContentPane().removeAll();
			getContentPane().add(rankingPanel);
			revalidate();
			repaint();
		}
	} //changeWindow()

} // ViewChange class
