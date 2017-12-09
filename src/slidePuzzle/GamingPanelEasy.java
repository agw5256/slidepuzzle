package slidePuzzle;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GamingPanelEasy extends JPanel {	
	private ViewChange window; 
	private JLabel lblTitle; //제목라벨
	private JPanel pzlPanel; //퍼즐판넬
	private JLabel lblCntMove, lblMove, lbl, lblAnswer;
	private JLabel lblMode;
	private int count = 0,c=0; //move수 세는 변수
	
	private JButton btnGoBack;
	
	private SortImage sort; //이미지 섞기 메소드 생성
	private JButton[] btnMenuArray; //퍼즐을 모두 버튼으로 생성
	private GameListener gameL;
	private BtnMenuListener btnMenuL;
	private MovingButton move;
	
	public GamingPanelEasy(ViewChange window) {
		setPreferredSize(new Dimension(900,600));
		setBackground(Color.pink);
		setLayout(null);
		
		sort = new SortImage(16);//이미지 배열생성
		sort.Sorting(4);//이미지배열을 섞음
		
		btnMenuL = new BtnMenuListener(); //버튼리스너
		gameL = new GameListener();			
		this.window = window;
		
		//제목라벨 생성
		lblTitle = new JLabel("SLIDE PUZZLE");
		lblTitle.setBounds(100, 30, 300, 70);
		lblTitle.setFont(new Font("Consolas",Font.BOLD,45));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitle);
		
		//퍼즐판넬 생성
		pzlPanel = new JPanel();
		pzlPanel.setBounds(70, 120, 360, 420);
		pzlPanel.setLayout(new GridLayout(4,4));
		pzlPanel.setBackground(Color.white);
		pzlPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		add(pzlPanel);
		
		//정답판넬 생성
		lblAnswer = new JLabel(new ImageIcon("easyImage/easyAns.png"));
		lblAnswer.setBounds(600, 70, 200, 200);
		lblAnswer.setBorder(BorderFactory.createLineBorder(Color.black));
		add(lblAnswer);
		
		//count라벨 생성
		lblCntMove = new JLabel(""+count);
		lblCntMove.setBounds(600,320,200,90);
		lblCntMove.setFont(new Font("Consolas",Font.BOLD,100));
		lblCntMove.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCntMove);
		
		//더미 라벨
		lbl = new JLabel(""+c);
		lbl.setBounds(600,320,200,90);
		lbl.setFont(new Font("Consolas",Font.BOLD,1));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl);
		
		//count개수밑에 move표시 라벨
		lblMove = new JLabel("MOVE");
		lblMove.setBounds(600,420,200,65);
		lblMove.setFont(new Font("Consolas",Font.BOLD,80));
		lblMove.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblMove);
		
		//퍼즐 판넬위의 난이도 표시 라벨생성
		lblMode = new JLabel("Easy Mode");
		lblMode.setBounds(600,530,200,50);
		lblMode.setFont(new Font("Consolas",Font.BOLD,30));
		lblMode.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblMode); 
		
		//뒤로가기 버튼 생성
		btnGoBack = new JButton("Back");
		btnGoBack.setBounds(790,530,70,50);
		btnGoBack.setFont(new Font("Consolas",Font.BOLD,15));
		btnGoBack.setHorizontalAlignment(SwingConstants.CENTER);
		// 3. add the listener object to the component
		btnGoBack.addActionListener(gameL);
		add(btnGoBack);	
		
		//초기 배열에 이미지 할당
		btnMenuArray = new JButton[16];
		for (int i=0; i<16; i++) {
			btnMenuArray[i]=new JButton(new ImageIcon("easyImage/easy"+sort.Getarray(i) +".png"));
			btnMenuArray[i].addMouseListener(btnMenuL);
			pzlPanel.add(btnMenuArray[i]);
		} //for	
		//이미지 이동 객체 생성
		move=new MovingButton();
		
	} // GamingPanel() 생성자
	private class BtnMenuListener implements MouseListener
	{
		int i;
		public void mouseClicked(MouseEvent event){}
		public void mousePressed(MouseEvent event){}
		public void mouseReleased(MouseEvent event){
			JButton btnMenu = (JButton)event.getSource();
			
			for(i=0;i<16;i++)
			{
				if(btnMenu==btnMenuArray[i]) break; //클릭된 버튼 반환
			}
			//System.out.println("i:"+i);
			if(move.moving(sort, 4, i)==true) { //이미지 이동후 count 증가
				count++;
			}
			for (i=0; i<16; i++) { //퍼즐 판넬 삭제
				pzlPanel.removeAll();
			} //for	
			
			for (i=0; i<16; i++) {//바뀐 배열로 이미지 다시할당
				btnMenuArray[i]=new JButton(new ImageIcon("easyImage/easy"+sort.Getarray(i) +".png"));
				btnMenuArray[i].addMouseListener(btnMenuL);
				pzlPanel.add(btnMenuArray[i]);
			} //for	
			i=0;
			c++;
			lblCntMove.setText(""+count);
			lbl.setText(""+c);
            if(sort.Check() == true) {//정답이 맞는지 확인
            	//맞을경우 게임을 다시할지 로비로갈지로 묻는 팝업창 생성
            	RankingPanel.easydataList.add(new RankingData(RankingPanel.sUserName,count));
            	System.out.println("game continue");
            	gameContinue();
            }
		}
		
		public void mouseEntered(MouseEvent event){
			JButton btnMenu = (JButton)event.getSource(); 
		} // mouseEntered()
		
		public void mouseExited(MouseEvent event){
			JButton btnMenu = (JButton)event.getSource();
		} // mouseExited()
	} // MouseListener class
	public void gameContinue()
	{
		int result;
		result=JOptionPane.showConfirmDialog(pzlPanel,"CONTINUE?");

		if(result==JOptionPane.YES_OPTION)
		{//yes일경우 다시하기
			//클래스 초기화
			count=0;
			sort = new SortImage(16);
			sort.Sorting(4);
			c++;
			lbl.setText(""+c);
			lblCntMove.setText(""+count);
		
			for (int i=0; i<16; i++) {
				pzlPanel.removeAll();
	        } //for   
	        
			for (int i=0; i<16; i++) {
				btnMenuArray[i]=new JButton(new ImageIcon("easyImage/easy"+sort.Getarray(i) +".png"));
				btnMenuArray[i].addMouseListener(btnMenuL);
				pzlPanel.add(btnMenuArray[i]);
			} //for  
			System.out.println("YES");
		}
		else if(result==JOptionPane.NO_OPTION)
		{	//no일경우 로비로 이동
			//클래스 초기화
			count=0;
			window.changeWindow("InitialPanel");
			sort = new SortImage(16);
			sort.Sorting(4);
			c++;
			lbl.setText(""+c);
			lblCntMove.setText(""+count);
		
			for (int i=0; i<16; i++) {
				pzlPanel.removeAll();
	        } //for   
	        
			for (int i=0; i<16; i++) {
				btnMenuArray[i]=new JButton(new ImageIcon("easyImage/easy"+sort.Getarray(i) +".png"));
				btnMenuArray[i].addMouseListener(btnMenuL);
				pzlPanel.add(btnMenuArray[i]);
			} //for  
			System.out.println("NO");
		}
		else
		{
				System.out.println("CANCEL");
		}
	}
	
	private class GameListener implements ActionListener	{
		public void actionPerformed(ActionEvent event) {
			// 4. event handling...			
			Object obj = event.getSource(); // 이벤트 발생한 위치(버튼 이름) 넘겨받음.
			if(obj == btnGoBack) { //뒤로가기 버튼클릭 일경우 클래스초기화
				count=0;
				window.changeWindow("InitialPanel");
				sort = new SortImage(16);
				sort.Sorting(4);
				c++;
				lbl.setText(""+c);
				lblCntMove.setText(""+count);
				
	            for (int i=0; i<16; i++) {
	               pzlPanel.removeAll();
	            } //for   
	            
	            for (int i=0; i<16; i++) {
					btnMenuArray[i]=new JButton(new ImageIcon("easyImage/easy"+sort.Getarray(i) +".png"));
	               btnMenuArray[i].addMouseListener(btnMenuL);
	               pzlPanel.add(btnMenuArray[i]);
	            } //for  
			}
		} // actionPerformed		
	} // GameListener class

} // GamingPanel class
