package slidePuzzle;
import java.util.Random;

public class SortImage {
	private int array[]; //이미지파일 정보를 담는 배열
	private int num; //최대 이미지수
	Random generator = new Random(); //랜덤값
	
	//생성자
	public SortImage(int n) {
		num = n;
		array = new int[n];
		for(int i=0;i<n;i++) {
			array[i] = i;			
		}
	}
	
	//인덱스 n의 배열값을 반환
	public int Getarray(int n) {
		return array[n];
	}
	//인덱스 n의 배열값을 지정
	public void Setarray(int n,int i)
	{
		array[n]=i;
	}
	
	//정답확인 메소드
	public boolean Check() {
		for(int i=0;i<num;i++) {
			if(array[i] != i) {
				return false; //검사중 틀린것이 있을경우 false 반환			
			}		
		}
		return true;
	}
	//이미자를 정답에서 역으로 섞는 메소드
	public void Sorting(int widthSize) {
		int k,temp,black; //black은 현재 검은화면의 배열인덱스, k는 상하좌우값을 지정함
		black = num-1; //초기 black값 지정
		for(int i=0;i<100;i++) { //반복문의 섞는 수를 조절가능
			k = generator.nextInt(4) + 1; //
			System.out.println(" "+k);
			if(k==1) {//상
				if(black-widthSize >=0 && black-widthSize <= num-1 ) { //교체 가능한지 검사
					temp = array[black];
					array[black] = array[black-widthSize];
					array[black-widthSize] = temp;
					black = black -widthSize;
				}
				
			}
			else if(k==2) {//하
				if(black + widthSize >=0 && black + widthSize <= num-1) {//교체 가능한지 검사
					temp = array[black];
					array[black] = array[black+widthSize];
					array[black+widthSize] = temp;
					black = black +widthSize;
					i++; //섞을때 확률적으론 전부 25퍼센트가 나올수 있으므로 일부 경우엔 i를 하나더더함
				}
				
			}
			else if(k==3) {//좌
				if(black -1 >=0 && black -1 <= num-1&&(black-1)%widthSize!= 0&&(black-1)%widthSize!=widthSize-1) {//교체 가능한지 검사
					temp = array[black];
					array[black] = array[black-1];
					array[black-1] = temp;
					black = black -1;
				}
				
			}
			else {//우
				if(black +1 >=0 && black +1 <= num-1&&(black+1)%widthSize!=widthSize-1&&(black+1)%widthSize!= 0) {//교체 가능한지 검사
					temp = array[black];
					array[black] = array[black+1];
					array[black+1] = temp;
					black = black +1;
					i++; //섞을때 확률적으론 전부 25퍼센트가 나올수 있으므로 일부 경우엔 i를 하나더더함
				}
			}
		}	
	}
}
