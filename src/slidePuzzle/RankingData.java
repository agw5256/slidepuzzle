package slidePuzzle;

public class RankingData { //Ranking�� ������ ����ü Ŭ����
	
	private String sName;
	private int nMove, nCnt;
	
	// RankingData ������
	public RankingData() {
		sName = "";
		nMove = 0;
	} //RankingEasy()
	public RankingData(RankingData data) {
		sName = data.getName();
		nMove = data.getMove();
	} //RankingData()
	public RankingData(String name, int count) {
		sName = name;
		nMove = count;
	} //RankingData()
	
	//get method
	public String getName() { return sName; }
	public int getMove()	{ return nMove; }
	public int getContentNumber() { return nCnt; }
	
	//set method
	public void setName(String name) 	{ sName = name; }
	public void setMove(int move)		{ nMove = move; }
	public void setContentNumber(int count) { nCnt = count; }
	public void setData(String name, int move) {
		sName = name;
		nMove = move;
	}
} //RankingData class
