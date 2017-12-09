package slidePuzzle;

// 화면 구성요소, ArrayList 사용을 위한 클래스
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class RankingPanel extends JPanel {

	private JButton btnGoBack/*뒤로가기 버튼*/, btnEasy/*Easy게임의 랭킹화면보기 버튼*/, btnNormal/*Normal게임의 랭킹화면보기 버튼*/, btnHard/*Hard게임의 랭킹화면보기 버튼*/;
	private JLabel lblBgEasy, lblBgNormal, lblBgHard; //각 난이도의 랭킹화면 이미지를 불러올 JLabel변수 선언
	//각 난이도의 랭킹 데이터를 저장할 ArrayList선언
	public static ArrayList<RankingData> easydataList = new ArrayList<RankingData>();
	public static ArrayList<RankingData> normaldataList = new ArrayList<RankingData>();
	public static ArrayList<RankingData> harddataList = new ArrayList<RankingData>();
	//1위~5위 랭킹을 출력하기 위한 JLabel 선언
	private JLabel lblFirst, lblSecond, lblThird, lblFourth, lblFifth;
	
	private ViewChange window; //화면전환을 위한 ViewChange클래스의 객체 선언
	private GameListener gameL; //Listener 객체 선언
	
	public static String sUserName; //초기화면에서 사용자로부터 이름을 받아와 랭킹 데이터에 저장하기 위한 문자열변수
	
	public RankingPanel(ViewChange window) {
		// 화면 초기화
		setPreferredSize(new Dimension(900,600));
		setBackground(Color.PINK);
		setLayout(null);
		
		this.window = window;
		gameL = new GameListener();
		
		// 난이도별 랭킹화면 초기화
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
		
		// 난이도별 랭킹 버튼 초기화
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
		
		//1위부터 5위까지의 랭킹을 출력할 JLabel 초기화
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
		
		// 뒤로가기 버튼 초기화
		btnGoBack = new JButton("Back");
		btnGoBack.setBounds(790,530,70,50);
		btnGoBack.setFont(new Font("Consolas",Font.BOLD,15));
		btnGoBack.setHorizontalAlignment(SwingConstants.CENTER);
		// 3. add the listener object to the component
		btnGoBack.addActionListener(gameL);
		add(btnGoBack);
		
	} //RankingPanel 생성자

	private class GameListener implements ActionListener	{
		public void actionPerformed(ActionEvent event) {
		// 4. event handling...			
			Object obj = event.getSource(); // 이벤트 발생한 위치(버튼 이름) 넘겨받음.
			// 뒤로가기 버튼을 클릭한 경우 InitialPanel로 화면전환
			if(obj == btnGoBack) {
				lblBgEasy.setVisible(false);
				lblBgNormal.setVisible(false);
				lblBgHard.setVisible(false);
				window.changeWindow("InitialPanel");
			} // if
			// Easy버튼을 클릭한 경우 EasyRanking을 보여주는 화면으로 전환
			if(obj == btnEasy) {
				lblBgEasy.setVisible(true);
				lblBgNormal.setVisible(false);
				lblBgHard.setVisible(false);
				sortRank(easydataList); // easy난이도의 데이터가 저장되어있는 ArrayList를 랭킹순으로 정렬
				// 각 순위의 JLabel에 랭킹정보 입력 및 화면에 출력
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
			// Normal버튼을 클릭한 경우 EasyRanking을 보여주는 화면으로 전환
			if(obj == btnNormal) {
				lblBgEasy.setVisible(false);
				lblBgNormal.setVisible(true);
				lblBgHard.setVisible(false);
				sortRank(normaldataList); // normal난이도의 데이터가 저장되어있는 ArrayList를 랭킹순으로 정렬
				// 각 순위의 JLabel에 랭킹정보 입력 및 화면에 출력
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
			// Hard버튼을 클릭한 경우 EasyRanking을 보여주는 화면으로 전환
			if(obj == btnHard) {
				lblBgEasy.setVisible(false);
				lblBgNormal.setVisible(false);
				lblBgHard.setVisible(true);
				sortRank(harddataList); // hard난이도의 데이터가 저장되어있는 ArrayList를 랭킹순으로 정렬
				// 각 순위의 JLabel에 랭킹정보 입력 및 화면에 출력
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
	
	//랭킹을 순서대로 정렬해주는 메소드
	//버블정렬
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