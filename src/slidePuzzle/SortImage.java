package slidePuzzle;
import java.util.Random;

public class SortImage {
	private int array[]; //�̹������� ������ ��� �迭
	private int num; //�ִ� �̹�����
	Random generator = new Random(); //������
	
	//������
	public SortImage(int n) {
		num = n;
		array = new int[n];
		for(int i=0;i<n;i++) {
			array[i] = i;			
		}
	}
	
	//�ε��� n�� �迭���� ��ȯ
	public int Getarray(int n) {
		return array[n];
	}
	//�ε��� n�� �迭���� ����
	public void Setarray(int n,int i)
	{
		array[n]=i;
	}
	
	//����Ȯ�� �޼ҵ�
	public boolean Check() {
		for(int i=0;i<num;i++) {
			if(array[i] != i) {
				return false; //�˻��� Ʋ������ ������� false ��ȯ			
			}		
		}
		return true;
	}
	//�̹��ڸ� ���信�� ������ ���� �޼ҵ�
	public void Sorting(int widthSize) {
		int k,temp,black; //black�� ���� ����ȭ���� �迭�ε���, k�� �����¿찪�� ������
		black = num-1; //�ʱ� black�� ����
		for(int i=0;i<100;i++) { //�ݺ����� ���� ���� ��������
			k = generator.nextInt(4) + 1; //
			System.out.println(" "+k);
			if(k==1) {//��
				if(black-widthSize >=0 && black-widthSize <= num-1 ) { //��ü �������� �˻�
					temp = array[black];
					array[black] = array[black-widthSize];
					array[black-widthSize] = temp;
					black = black -widthSize;
				}
				
			}
			else if(k==2) {//��
				if(black + widthSize >=0 && black + widthSize <= num-1) {//��ü �������� �˻�
					temp = array[black];
					array[black] = array[black+widthSize];
					array[black+widthSize] = temp;
					black = black +widthSize;
					i++; //������ Ȯ�������� ���� 25�ۼ�Ʈ�� ���ü� �����Ƿ� �Ϻ� ��쿣 i�� �ϳ�������
				}
				
			}
			else if(k==3) {//��
				if(black -1 >=0 && black -1 <= num-1&&(black-1)%widthSize!= 0&&(black-1)%widthSize!=widthSize-1) {//��ü �������� �˻�
					temp = array[black];
					array[black] = array[black-1];
					array[black-1] = temp;
					black = black -1;
				}
				
			}
			else {//��
				if(black +1 >=0 && black +1 <= num-1&&(black+1)%widthSize!=widthSize-1&&(black+1)%widthSize!= 0) {//��ü �������� �˻�
					temp = array[black];
					array[black] = array[black+1];
					array[black+1] = temp;
					black = black +1;
					i++; //������ Ȯ�������� ���� 25�ۼ�Ʈ�� ���ü� �����Ƿ� �Ϻ� ��쿣 i�� �ϳ�������
				}
			}
		}	
	}
}
