package slidePuzzle;

import javax.swing.JFrame;

public class Main { // �����ϴ� ����Ŭ����

	public static void main(String[] args) { // ���� �����Ӱ���  Ŭ����
		// TODO Auto-generated method stub
		ViewChange frame = new ViewChange(); //Jframe class�� viewchangeŬ���� �����Ͽ� ������ ���
		frame.setTitle("SLIDE PUZZLE");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.initPanel = new InitialPanel(frame); // viewchangeŬ������ �������� �г�Ŭ������ ���� �� ������ü(������) ���ڷ� �־����
		frame.madeByPanel = new ProgrammerPanel(frame);
		frame.gamePaneleasy = new GamingPanelEasy(frame);
		frame.gamePanelNormal = new GamingPanelNormal(frame);
		frame.gamePanelHard = new GamingPanelHard(frame);
		frame.rankingPanel = new RankingPanel(frame);
		
		// GamingPanel gamingPanel = new GamingPanel(frame);
		
		frame.getContentPane().add(frame.initPanel); // �ʱ�ȭ����� ���
		frame.setSize(900,600);
		frame.pack();
		frame.setVisible(true);
	}

}
