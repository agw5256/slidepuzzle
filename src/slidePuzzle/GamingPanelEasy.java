package slidePuzzle;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GamingPanelEasy extends JPanel {	
	private ViewChange window; 
	private JLabel lblTitle; //�����
	private JPanel pzlPanel; //�����ǳ�
	private JLabel lblCntMove, lblMove, lbl, lblAnswer;
	private JLabel lblMode;
	private int count = 0,c=0; //move�� ���� ����
	
	private JButton btnGoBack;
	
	private SortImage sort; //�̹��� ���� �޼ҵ� ����
	private JButton[] btnMenuArray; //������ ��� ��ư���� ����
	private GameListener gameL;
	private BtnMenuListener btnMenuL;
	private MovingButton move;
	
	public GamingPanelEasy(ViewChange window) {
		setPreferredSize(new Dimension(900,600));
		setBackground(Color.pink);
		setLayout(null);
		
		sort = new SortImage(16);//�̹��� �迭����
		sort.Sorting(4);//�̹����迭�� ����
		
		btnMenuL = new BtnMenuListener(); //��ư������
		gameL = new GameListener();			
		this.window = window;
		
		//����� ����
		lblTitle = new JLabel("SLIDE PUZZLE");
		lblTitle.setBounds(100, 30, 300, 70);
		lblTitle.setFont(new Font("Consolas",Font.BOLD,45));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitle);
		
		//�����ǳ� ����
		pzlPanel = new JPanel();
		pzlPanel.setBounds(70, 120, 360, 420);
		pzlPanel.setLayout(new GridLayout(4,4));
		pzlPanel.setBackground(Color.white);
		pzlPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		add(pzlPanel);
		
		//�����ǳ� ����
		lblAnswer = new JLabel(new ImageIcon("easyImage/easyAns.png"));
		lblAnswer.setBounds(600, 70, 200, 200);
		lblAnswer.setBorder(BorderFactory.createLineBorder(Color.black));
		add(lblAnswer);
		
		//count�� ����
		lblCntMove = new JLabel(""+count);
		lblCntMove.setBounds(600,320,200,90);
		lblCntMove.setFont(new Font("Consolas",Font.BOLD,100));
		lblCntMove.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCntMove);
		
		//���� ��
		lbl = new JLabel(""+c);
		lbl.setBounds(600,320,200,90);
		lbl.setFont(new Font("Consolas",Font.BOLD,1));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl);
		
		//count�����ؿ� moveǥ�� ��
		lblMove = new JLabel("MOVE");
		lblMove.setBounds(600,420,200,65);
		lblMove.setFont(new Font("Consolas",Font.BOLD,80));
		lblMove.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblMove);
		
		//���� �ǳ����� ���̵� ǥ�� �󺧻���
		lblMode = new JLabel("Easy Mode");
		lblMode.setBounds(600,530,200,50);
		lblMode.setFont(new Font("Consolas",Font.BOLD,30));
		lblMode.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblMode); 
		
		//�ڷΰ��� ��ư ����
		btnGoBack = new JButton("Back");
		btnGoBack.setBounds(790,530,70,50);
		btnGoBack.setFont(new Font("Consolas",Font.BOLD,15));
		btnGoBack.setHorizontalAlignment(SwingConstants.CENTER);
		// 3. add the listener object to the component
		btnGoBack.addActionListener(gameL);
		add(btnGoBack);	
		
		//�ʱ� �迭�� �̹��� �Ҵ�
		btnMenuArray = new JButton[16];
		for (int i=0; i<16; i++) {
			btnMenuArray[i]=new JButton(new ImageIcon("easyImage/easy"+sort.Getarray(i) +".png"));
			btnMenuArray[i].addMouseListener(btnMenuL);
			pzlPanel.add(btnMenuArray[i]);
		} //for	
		//�̹��� �̵� ��ü ����
		move=new MovingButton();
		
	} // GamingPanel() ������
	private class BtnMenuListener implements MouseListener
	{
		int i;
		public void mouseClicked(MouseEvent event){}
		public void mousePressed(MouseEvent event){}
		public void mouseReleased(MouseEvent event){
			JButton btnMenu = (JButton)event.getSource();
			
			for(i=0;i<16;i++)
			{
				if(btnMenu==btnMenuArray[i]) break; //Ŭ���� ��ư ��ȯ
			}
			//System.out.println("i:"+i);
			if(move.moving(sort, 4, i)==true) { //�̹��� �̵��� count ����
				count++;
			}
			for (i=0; i<16; i++) { //���� �ǳ� ����
				pzlPanel.removeAll();
			} //for	
			
			for (i=0; i<16; i++) {//�ٲ� �迭�� �̹��� �ٽ��Ҵ�
				btnMenuArray[i]=new JButton(new ImageIcon("easyImage/easy"+sort.Getarray(i) +".png"));
				btnMenuArray[i].addMouseListener(btnMenuL);
				pzlPanel.add(btnMenuArray[i]);
			} //for	
			i=0;
			c++;
			lblCntMove.setText(""+count);
			lbl.setText(""+c);
            if(sort.Check() == true) {//������ �´��� Ȯ��
            	//������� ������ �ٽ����� �κ�ΰ����� ���� �˾�â ����
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
		{//yes�ϰ�� �ٽ��ϱ�
			//Ŭ���� �ʱ�ȭ
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
		{	//no�ϰ�� �κ�� �̵�
			//Ŭ���� �ʱ�ȭ
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
			Object obj = event.getSource(); // �̺�Ʈ �߻��� ��ġ(��ư �̸�) �Ѱܹ���.
			if(obj == btnGoBack) { //�ڷΰ��� ��ưŬ�� �ϰ�� Ŭ�����ʱ�ȭ
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
