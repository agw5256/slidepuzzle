package slidePuzzle;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
////////////////////////////////////GamingPanelEasy클래스와 형식같음
public class GamingPanelNormal extends JPanel {	
	private ViewChange window;
	private JLabel lblTitle;
	private JPanel pzlPanel;
	private JLabel lblCntMove, lblMove, lbl, lblAnswer;
	private JLabel lblMode;
	private int count = 0,c=0;
	
	private JButton btnGoBack;
	
	private SortImage sort;
	private JButton[] btnMenuArray;
	private GameListener gameL;
	private BtnMenuListener btnMenuL;
	private MovingButton move;
	
	public GamingPanelNormal(ViewChange window) {
		setPreferredSize(new Dimension(900,600));
		setBackground(Color.pink);
		setLayout(null);
		
		
		sort = new SortImage(25);
		sort.Sorting(5);
		
		btnMenuL = new BtnMenuListener();
		gameL = new GameListener();			
		this.window = window;
		
		lblTitle = new JLabel("SLIDE PUZZLE");
		lblTitle.setBounds(100, 30, 300, 70);
		lblTitle.setFont(new Font("Consolas",Font.BOLD,45));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitle);
		
		pzlPanel = new JPanel();
		pzlPanel.setBounds(70, 120, 360, 420);
		pzlPanel.setLayout(new GridLayout(5,5));
		pzlPanel.setBackground(Color.white);
		pzlPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		add(pzlPanel);
		
		lblAnswer = new JLabel(new ImageIcon("normalImage/normalAns.png"));
		lblAnswer.setBounds(600, 70, 200, 200);
		lblAnswer.setBorder(BorderFactory.createLineBorder(Color.black));
		add(lblAnswer);
		
		lblCntMove = new JLabel(""+count);
		lblCntMove.setBounds(600,320,200,90);
		lblCntMove.setFont(new Font("Consolas",Font.BOLD,100));
		lblCntMove.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCntMove);
		
		//더미라벨
		lbl = new JLabel(""+c);
		lbl.setBounds(600,320,200,90);
		lbl.setFont(new Font("Consolas",Font.BOLD,1));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl);
		
		
		lblMove = new JLabel("MOVE");
		lblMove.setBounds(600,420,200,65);
		lblMove.setFont(new Font("Consolas",Font.BOLD,80));
		lblMove.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblMove);
		
		lblMode = new JLabel("Normal Mode");
		lblMode.setBounds(600,530,200,50);
		lblMode.setFont(new Font("Consolas",Font.BOLD,30));
		lblMode.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblMode); 
		
		btnGoBack = new JButton("Back");
		btnGoBack.setBounds(790,530,70,50);
		btnGoBack.setFont(new Font("Consolas",Font.BOLD,15));
		btnGoBack.setHorizontalAlignment(SwingConstants.CENTER);
		// 3. add the listener object to the component
		btnGoBack.addActionListener(gameL);
		add(btnGoBack);	
		
		btnMenuArray = new JButton[25];
		for (int i=0; i<25; i++) {
        	btnMenuArray[i] = new JButton(new ImageIcon("normalImage/normal"+sort.Getarray(i) +".png"));
			btnMenuArray[i].addMouseListener(btnMenuL);
			pzlPanel.add(btnMenuArray[i]);
		} //for	
		move=new MovingButton();
	} // GamingPanel() 생성자
	public void gameContinue()
	{
		int result;
		result=JOptionPane.showConfirmDialog(pzlPanel,"CONTINUE?");

		if(result==JOptionPane.YES_OPTION)
		{
			count=0;
			sort = new SortImage(25);
			sort.Sorting(5);
			c++;
			lbl.setText(""+c);
			lblCntMove.setText(""+count);
		
			for (int i=0; i<25; i++) {
				pzlPanel.removeAll();
	        } //for   
	        
			for (int i=0; i<25; i++) {
            	btnMenuArray[i] = new JButton(new ImageIcon("normalImage/normal"+sort.Getarray(i) +".png"));
				btnMenuArray[i].addMouseListener(btnMenuL);
				pzlPanel.add(btnMenuArray[i]);
			} //for  
			System.out.println("YES");
		}
		else if(result==JOptionPane.NO_OPTION)
		{	
			count=0;
			window.changeWindow("InitialPanel");
			sort = new SortImage(25);
			sort.Sorting(5);
			c++;
			lbl.setText(""+c);
			lblCntMove.setText(""+count);
		
			for (int i=0; i<25; i++) {
				pzlPanel.removeAll();
	        } //for   
	        
			for (int i=0; i<25; i++) {
            	btnMenuArray[i] = new JButton(new ImageIcon("normalImage/normal"+sort.Getarray(i) +".png"));
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
	private class BtnMenuListener implements MouseListener
	{
		int i;
		public void mouseClicked(MouseEvent event){}
		public void mousePressed(MouseEvent event){}
		public void mouseReleased(MouseEvent event){
			JButton btnMenu = (JButton)event.getSource();
			
			for(i=0;i<25;i++)
			{
				if(btnMenu==btnMenuArray[i]) break;
			}
			//System.out.println("i:"+i);
			if(move.moving(sort, 5, i)==true) {
				count++;
			}
			for (i=0; i<25; i++) {
				pzlPanel.removeAll();
			} //for	
			
			for (i=0; i<25; i++) {
            	btnMenuArray[i] = new JButton(new ImageIcon("normalImage/normal"+sort.Getarray(i) +".png"));
				btnMenuArray[i].addMouseListener(btnMenuL);
				pzlPanel.add(btnMenuArray[i]);
			} //for	
			i=0;
			c++;
			lblCntMove.setText(""+count);
			lbl.setText(""+c);
			 if(sort.Check() == true) {
				 RankingPanel.normaldataList.add(new RankingData(RankingPanel.sUserName,count));
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
	
	
	private class GameListener implements ActionListener	{
		public void actionPerformed(ActionEvent event) {
			// 4. event handling...			
			Object obj = event.getSource(); // 이벤트 발생한 위치(버튼 이름) 넘겨받음.
			if(obj == btnGoBack) {
				count=0;
				window.changeWindow("InitialPanel");
				sort = new SortImage(25);
				sort.Sorting(5);
				c++;
				lbl.setText(""+c);
				lblCntMove.setText(""+count);
				
	            for (int i=0; i<25; i++) {
	               pzlPanel.removeAll();
	            } //for   
	            
	            for (int i=0; i<25; i++) {
	            	btnMenuArray[i] = new JButton(new ImageIcon("normalImage/normal"+sort.Getarray(i) +".png"));
	               btnMenuArray[i].addMouseListener(btnMenuL);
	               pzlPanel.add(btnMenuArray[i]);
	            } //for   
			} // if			
		} // actionPerformed		
	} // GameListener class

} // GamingPanel class