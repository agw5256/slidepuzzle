package slidePuzzle;
import javax.swing.*;
public class MovingButton {
	private int black;
	private int temp;
	//MovingButton Ŭ������ ��ü��  SortImage Ŭ������ ��ü�� ���ڷ� �޾� �ش� ��ü(SortImage ��ü)�� ������ �ִ� ������ �����Ѵ�.
	public boolean moving(SortImage btnArray,int widthSize,int i)
	{
		black=widthSize*widthSize-1;//�� ��ư�� ������ �ִ� ���� black ������ �����Ѵ�.(�ε����� �ƴ϶� ��)
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
