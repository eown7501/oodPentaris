package ranking;

import java.util.*;

/**
 * �� Class�� RankingData�� �����մϴ�.
 * 
 * @author ������
 */
public class RankingData{
	
	/** ������ ������ ���� �Դϴ�. */
	int score;
	/** �̸��� ������ ���� �Դϴ�. */
	String name;
	/** ���ڿ��� ������ �����Դϴ�. */
	String str;
	/** token�� ������ �����Դϴ�. */
	private StringTokenizer token;
	
	/** RankingData �� �����մϴ�. */
	public RankingData() {
		this.score = 0;
		this.name = "";
	}
	
	/**
	 * RankingData �� �����մϴ�.
	 * 
	 * @param name �� �̸��� �����ϴ�.
	 * @param score �� ������ �����ϴ�.
	 */
	public RankingData(String name, int score) {
		this.score = score;
		this.name = name;
		str = name + " " +score;
	}
	
	/**
	 * RankingData �� �����մϴ�.
	 * 
	 * @param str �� ���ڿ��� �����ϴ�.
	 */
	public RankingData(String str) {
		this.str = str;
		token = new StringTokenizer(this.str, " ");
		name = token.nextToken();
		if(token.hasMoreTokens())
			score = Integer.parseInt(token.nextToken());
	}
}