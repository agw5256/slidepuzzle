package slidePuzzle;

// ȭ�� �������, ArrayList ����� ���� Ŭ����
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class RankingPanel extends JPanel {

	private JButton btnGoBack/*�ڷΰ��� ��ư*/, btnEasy/*Easy������ ��ŷȭ�麸�� ��ư*/, btnNormal/*Normal������ ��ŷȭ�麸�� ��ư*/, btnHard/*Hard������ ��ŷȭ�麸�� ��ư*/;
	private JLabel lblBgEasy, lblBgNormal, lblBgHard; //�� ���̵��� ��ŷȭ�� �̹����� �ҷ��� JLabel���� ����
	//�� ���̵��� ��ŷ �����͸� ������ ArrayList����
	public static ArrayList<RankingData> easydataList = new ArrayList<RankingData>();
	public static ArrayList<RankingData> normaldataList = new ArrayList<RankingData>();
	public static ArrayList<RankingData> harddataList = new ArrayList<RankingData>();
	//1��~5�� ��ŷ�� ����ϱ� ���� JLabel ����
	private JLabel lblFirst, lblSecond, lblThird, lblFourth, lblFifth;
	
	private ViewChange window; //ȭ����ȯ�� ���� ViewChangeŬ������ ��ü ����
	private GameListener gameL; //Listener ��ü ����
	
	public static String sUserName; //�ʱ�ȭ�鿡�� ����ڷκ��� �̸��� �޾ƿ� ��ŷ �����Ϳ� �����ϱ� ���� ���ڿ�����
	
	public RankingPanel(ViewChange window) {
		// ȭ�� �ʱ�ȭ
		setPreferredSize(new Dimension(900,600));
		setBackground(Color.PINK);
		setLayout(null);
		
		this.window = window;
		gameL = new GameListener();
		
		// ���̵��� ��ŷȭ�� �ʱ�ȭ
		lblBgEasy = new JLabel(new ImageIcon("rankingeasy.jpg"));
		lblBgEasy.setBounds(10,10,880,500);
		lblBgEasy.setVisible(false);
		add(lblBgEasy);
		
		lblBgNormal = new JLabel(new ImageIcon("rankingnormal.jpg"));
		lblBgNormal.setBounds(10,10,880,500);
		lblBgNormal.setVisible(false);
		add(lblBgNormal);
		
		lblBgHard = new JLabel(new ImageIcon("rankinghard.jpg"));
		lblBgHard.setBounds(10,10,880,500);
		lblBgHard.setVisible(false);
		add(lblBgHard);
		
		// ���̵��� ��ŷ ��ư �ʱ�ȭ
		btnEasy = new JButton("EASY");
		btnEasy.setBounds(50,530,120,50);
		btnEasy.setBackground(new Color(250,70,140));
		btnEasy.setFont(new Font("Consolas",Font.BOLD,30));
		btnEasy.setHorizontalAlignment(SwingConstants.CENTER);
		btnEasy.addActionListener(gameL);
		add(btnEasy);
		
		btnNormal = new JButton("NORMAL");
		btnNormal.setBounds(200,530,120,50);
		btnNormal.setBackground(new Color(250,70,140));
		btnNormal.setFont(new Font("Consolas",Font.BOLD,25));
		btnNormal.setHorizontalAlignment(SwingConstants.CENTER);
		btnNormal.addActionListener(gameL);
		add(btnNormal);
		
		btnHard = new JButton("HARD");
		btnHard.setBounds(350,530,120,50);
		btnHard.setBackground(new Color(250,70,140));
		btnHard.setFont(new Font("Consolas",Font.BOLD,30));
		btnHard.setHorizontalAlignment(SwingConstants.CENTER);
		btnHard.addActionListener(gameL);
		add(btnHard);
		
		//1������ 5�������� ��ŷ�� ����� JLabel �ʱ�ȭ
		lblFirst = new JLabel();
		lblFirst.setBounds(200,110,400,50);
		lblFirst.setFont(new Font("Consolas",Font.BOLD,50));
		lblFirst.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblSecond = new JLabel();
		lblSecond.setBounds(200,190,400,50);
		lblSecond.setFont(new Font("Consolas",Font.BOLD,50));
		lblSecond.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblThird = new JLabel();
		lblThird.setBounds(200,275,400,50);
		lblThird.setFont(new Font("Consolas",Font.BOLD,50));
		lblThird.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblFourth = new JLabel();
		lblFourth.setBounds(200,355,400,50);
		lblFourth.setFont(new Font("Consolas",Font.BOLD,50));
		lblFourth.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblFifth = new JLabel();
		lblFifth.setBounds(200,440,400,50);
		lblFifth.setFont(new Font("Consolas",Font.BOLD,50));
		lblFifth.setHorizontalAlignment(SwingConstants.LEFT);
		
		// �ڷΰ��� ��ư �ʱ�ȭ
		btnGoBack = new JButton("Back");
		btnGoBack.setBounds(790,530,70,50);
		btnGoBack.setFont(new Font("Consolas",Font.BOLD,15));
		btnGoBack.setHorizontalAlignment(SwingConstants.CENTER);
		// 3. add the listener object to the component
		btnGoBack.addActionListener(gameL);
		add(btnGoBack);
		
	} //RankingPanel ������

	private class GameListener implements ActionListener	{
		public void actionPerformed(ActionEvent event) {
		// 4. event handling...			
			Object obj = event.getSource(); // �̺�Ʈ �߻��� ��ġ(��ư �̸�) �Ѱܹ���.
			// �ڷΰ��� ��ư�� Ŭ���� ��� InitialPanel�� ȭ����ȯ
			if(obj == btnGoBack) {
				lblBgEasy.setVisible(false);
				lblBgNormal.setVisible(false);
				lblBgHard.setVisible(false);
				window.changeWindow("InitialPanel");
			} // if
			// Easy��ư�� Ŭ���� ��� EasyRanking�� �����ִ� ȭ������ ��ȯ
			if(obj == btnEasy) {
				lblBgEasy.setVisible(true);
				lblBgNormal.setVisible(false);
				lblBgHard.setVisible(false);
				sortRank(easydataList); // easy���̵��� �����Ͱ� ����Ǿ��ִ� ArrayList�� ��ŷ������ ����
				// �� ������ JLabel�� ��ŷ���� �Է� �� ȭ�鿡 ���
				if (easydataList.size()>0) {
					lblFirst.setText(easydataList.get(0).getName()+"  "+easydataList.get(0).getMove()+"MOVES");
					lblBgEasy.add(lblFirst);
					if (easydataList.size()>1) {
						lblSecond.setText(easydataList.get(1).getName()+"  "+easydataList.get(1).getMove()+"MOVES");
						lblBgEasy.add(lblSecond);
						if(easydataList.size()>2) {
							lblThird.setText(easydataList.get(2).getName()+"  "+easydataList.get(2).getMove()+"MOVES");
							lblBgEasy.add(lblThird);
							if(easydataList.size()>3) {
								lblFourth.setText(easydataList.get(3).getName()+"  "+easydataList.get(3).getMove()+"MOVES");
								lblBgEasy.add(lblFourth);
								if(easydataList.size()>4) {
									lblFifth.setText(easydataList.get(4).getName()+"  "+easydataList.get(4).getMove()+"MOVES");
									lblBgEasy.add(lblFifth);
								}
							}
						}
					}
				}
			}
			// Normal��ư�� Ŭ���� ��� EasyRanking�� �����ִ� ȭ������ ��ȯ
			if(obj == btnNormal) {
				lblBgEasy.setVisible(false);
				lblBgNormal.setVisible(true);
				lblBgHard.setVisible(false);
				sortRank(normaldataList); // normal���̵��� �����Ͱ� ����Ǿ��ִ� ArrayList�� ��ŷ������ ����
				// �� ������ JLabel�� ��ŷ���� �Է� �� ȭ�鿡 ���
				if (normaldataList.size()>0) {
					lblFirst.setText(normaldataList.get(0).getName()+"  "+normaldataList.get(0).getMove()+"MOVES");
					lblBgNormal.add(lblFirst);
					if (normaldataList.size()>1) {
						lblSecond.setText(normaldataList.get(1).getName()+"  "+normaldataList.get(1).getMove()+"MOVES");
						lblBgNormal.add(lblSecond);
						if(normaldataList.size()>2) {
							lblThird.setText(normaldataList.get(2).getName()+"  "+normaldataList.get(2).getMove()+"MOVES");
							lblBgNormal.add(lblThird);
							if(normaldataList.size()>3) {
								lblFourth.setText(normaldataList.get(3).getName()+"  "+normaldataList.get(3).getMove()+"MOVES");
								lblBgNormal.add(lblFourth);
								if(normaldataList.size()>4) {
									lblFifth.setText(normaldataList.get(4).getName()+"  "+normaldataList.get(4).getMove()+"MOVES");
									lblBgNormal.add(lblFifth);
								}
							}
						}
					}
				}
			}
			// Hard��ư�� Ŭ���� ��� EasyRanking�� �����ִ� ȭ������ ��ȯ
			if(obj == btnHard) {
				lblBgEasy.setVisible(false);
				lblBgNormal.setVisible(false);
				lblBgHard.setVisible(true);
				sortRank(harddataList); // hard���̵��� �����Ͱ� ����Ǿ��ִ� ArrayList�� ��ŷ������ ����
				// �� ������ JLabel�� ��ŷ���� �Է� �� ȭ�鿡 ���
				if (harddataList.size()>0) {
					lblFirst.setText(harddataList.get(0).getName()+"  "+harddataList.get(0).getMove()+"MOVES");
					lblBgHard.add(lblFirst);
					if (harddataList.size()>1) {
						lblSecond.setText(harddataList.get(1).getName()+"  "+harddataList.get(1).getMove()+"MOVES");
						lblBgHard.add(lblSecond);
						if(harddataList.size()>2) {
							lblThird.setText(harddataList.get(2).getName()+"  "+harddataList.get(2).getMove()+"MOVES");
							lblBgHard.add(lblThird);
							if(harddataList.size()>3) {
								lblFourth.setText(harddataList.get(3).getName()+"  "+harddataList.get(3).getMove()+"MOVES");
								lblBgHard.add(lblFourth);
								if(harddataList.size()>4) {
									lblFifth.setText(harddataList.get(4).getName()+"  "+harddataList.get(4).getMove()+"MOVES");
									lblBgHard.add(lblFifth);
								}
							}
						}
					}
				}
			}
		} // actionPerformed		
	} // GameListener class
	
	//��ŷ�� ������� �������ִ� �޼ҵ�
	//��������
	public void sortRank(ArrayList<RankingData> data) {
		RankingData tmpdata = new RankingData();
		for (int i=0;i<data.size()-1;i++) {
			for (int j=0;j<data.size()-1;j++) {
				if (data.get(j).getMove() > data.get(j+1).getMove()) {
					tmpdata = data.get(j);
					data.set(j,data.get(j+1));
					data.set(j+1,tmpdata);
				}
			}
		}
	} //sortRank()
	
} // Ranking Panel class