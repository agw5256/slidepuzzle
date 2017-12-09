package slidePuzzle;

import javax.swing.JFrame;

public class ViewChange extends JFrame { // ȭ�� ��ȯ�� ���ִ� Ŭ����
	
	public InitialPanel initPanel =null; // ���� �гε� ���� / public���� �Ͽ� main���� ���� �����ϰ�
	public GamingPanelEasy gamePaneleasy = null;
	public ProgrammerPanel madeByPanel = null;
	public GamingPanelNormal gamePanelNormal = null;
	public GamingPanelHard gamePanelHard = null;
	public RankingPanel rankingPanel = null;
	
	public void changeWindow(String panelName) { // ���ڿ��� ������ �޾� ���н���, ���ϴ� �гη� �����ϴ� �޼ҵ�
		
		if(panelName.equals("InitialPanel")) { // ���ڿ� ���� �ʱ� ȭ���г��ΰ��
			getContentPane().removeAll(); // �������� ��� ���������
			getContentPane().add(initPanel); // �����ӿ� �ʱ�ȭ�� �г� �ְ�
			initPanel.initializePanel(); // ??
			revalidate(); // �����뵵���� ��. �������ؼ� ã����
			repaint(); // ȭ�� ���� ��������?
		} else if(panelName.equals("GamingPanelEasy")) { // ���� ��
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
