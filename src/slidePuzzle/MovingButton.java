package slidePuzzle;
import javax.swing.*;
public class MovingButton {
	private int black;
	private int temp;
	//MovingButton 클래스의 객체는  SortImage 클래스의 객체를 인자로 받아 해당 객체(SortImage 객체)가 가지고 있는 정보를 수정한다.
	public boolean moving(SortImage btnArray,int widthSize,int i)
	{
		black=widthSize*widthSize-1;//블랙 버튼이 가지고 있는 값을 black 변수에 저장한다.(인덱스가 아니라 값)
		//System.out.println(black);
		//System.out.println(btnArray.Getarray(i));
		if(0<=i+1&&i+1<widthSize*widthSize&&i%widthSize!=widthSize-1&&btnArray.Getarray(i+1)==black)
		{
			temp=btnArray.Getarray(i);
			btnArray.Setarray(i+1,temp);
			btnArray.Setarray(i, black);
			return true;
		}
		else if(0<=i-1&&i-1<widthSize*widthSize&&i%widthSize!=0&&btnArray.Getarray(i-1)==black)
		{
			temp=btnArray.Getarray(i);
			btnArray.Setarray(i-1,temp);
			btnArray.Setarray(i, black);
			return true;
		}
		else if(0<=i+widthSize&&i+widthSize<widthSize*widthSize&&btnArray.Getarray(i+widthSize)==black)
		{
			temp=btnArray.Getarray(i);
			btnArray.Setarray(i+widthSize,temp);
			btnArray.Setarray(i, black);
			return true;
		}
		else if(0<=i-widthSize&&i-widthSize<widthSize*widthSize&&btnArray.Getarray(i-widthSize)==black)
		{
			temp=btnArray.Getarray(i);
			btnArray.Setarray(i-widthSize,temp);
			btnArray.Setarray(i, black);
			return true;
		}
		return false;
		
	}
}
