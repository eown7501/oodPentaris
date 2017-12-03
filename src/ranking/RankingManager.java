package ranking;

import java.io.*;
import java.util.StringTokenizer;

/**
 * �� Class�� ��ŷ�� ����°� ����� ����ϴ� Class �Դϴ�.
 * 
 * @author ������
 *
 */
public class RankingManager{

	/** InputStream Type �� �����Դϴ�. */
	private InputStream fis;
	/** BufferedReader Type �� �����Դϴ�. */
	private BufferedReader in;
	/** OutputStream Type �� �����Դϴ�. */
	private OutputStream fos;
	/** PrintWriter Type �� �����Դϴ�. */
	private PrintWriter out;
	/** File Type �� �����Դϴ�. */
	private File soloFile, AIFile;
	/** FileReader Type �� �����Դϴ�. */
	private FileReader fr;
	/** StringTokenizer Type �� �����Դϴ�. */
	private StringTokenizer token;
	/** String Type �� �����Դϴ�. */
	private String line, str;
	/** �ؽ�Ʈ ���Ϸκ��� ���� �о�� �� �̿��� int Type �� �����Դϴ�. */
	private int soloIndex, AIIndex;
	/** RankingData[] Type �� �����Դϴ�. */
	private RankingData[] soloRankingData, AIRankingData;
	
	/** RankingManager �� �����մϴ�. */
	public RankingManager() {
		soloRankingData = new RankingData[10];
		AIRankingData =  new RankingData[10];
		soloFile = new File("SoloRanking.txt");
		AIFile = new File("AIRanking.txt");
		createFile();
	}

	/** Ranking�� ������ �ؽ�Ʈ ������ �ִ��� �˻��ϰ� ���� ��� �����մϴ�.*/
	public void createFile() {
		try {
			soloFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			AIFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** �ؽ�Ʈ ���Ϸκ��� ���� �о� SoloRankingData�� �����մϴ�. */
	public void getSoloData() {
		try {
			fr = new FileReader(soloFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		in = new BufferedReader(fr);
		token = null;
		int i = 0;
		try {
			while((line = in.readLine()) != null) {
				if(!line.equals("")) {
					token = new StringTokenizer(line, "\n");
					while(token.hasMoreTokens()) {
						str = token.nextToken();
						soloRankingData[i++] = new RankingData(str);
					}
				}
			}
			soloIndex = i;
			if( soloIndex < 10 ) {
				for(int j = soloIndex + 1 ; j < 10 ; j++) {
					soloRankingData[j] = new RankingData();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** �ؽ�Ʈ ���Ϸκ��� ���� �о� AIRankingData�� �����մϴ�. */
	public void getAIData() {
		try {
			fr = new FileReader(AIFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		in = new BufferedReader(fr);
		token = null;
		int i = 0;
		try {
			while((line = in.readLine()) != null) {
				if(!line.equals("")) {
					token = new StringTokenizer(line, "\n");
					while(token.hasMoreTokens()) {
						str = token.nextToken();
						AIRankingData[i++] = new RankingData(str);
					}
				}
			}
			AIIndex = i;
			if( AIIndex < 10 ) {
				for(int j = AIIndex ; j < 10 ; j++) {
					AIRankingData[j] = new RankingData();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * SoloRankingData�� ������ �����մϴ�.
	 * 
	 * @param name - ViewSoloRankingRegisterPanel���Լ� ���� �Ű������Դϴ�. ������� �̸��� ��Ÿ���ϴ�.  
	 * @param score - ViewSoloRankingRegisterPanel���Լ� ���� ���� �Ű������Դϴ�. ������� ������ ��Ÿ���ϴ�. 
	 * @throws IOException
	 */
	public void registerSolo (String name, int score) throws IOException {
		createFile();
		getSoloData();
		if (soloIndex == 0) {
			soloRankingData[soloIndex] = new RankingData(name, score);
			saveTXTinSoloRankingData(soloRankingData);
		} else if (soloIndex > 0 && soloIndex < 10) {
			soloRankingData[soloIndex] = new RankingData(name, score);
			sortSoloRanking(soloRankingData);
		} else if (soloIndex == 10) {
			if (soloRankingData[9].score < score) {
				soloRankingData[9] = new RankingData(name, score);
				soloIndex = 9;
				sortSoloRanking(soloRankingData);
			}
		}
	}

	/**
	 * AIRankingData�� ������ �����մϴ�.
	 * 
	 * @param name - ViewAIRankingRegisterPanel���Լ� ���� �Ű������Դϴ�. ������� �̸��� ��Ÿ���ϴ�.  
	 * @param score - ViewAIRankingRegisterPanel���Լ� ���� �Ű������Դϴ�. ������� ������ ��Ÿ���ϴ�.  
	 * @throws IOException
	 */
	public void registerAI (String name, int score) throws IOException {
		createFile();
		getAIData();
		if (AIIndex == 0) {
			AIRankingData[AIIndex] = new RankingData(name, score);
			saveTXTinAIRankingData(AIRankingData);
		} else if (AIIndex > 0 && AIIndex < 10) {
			AIRankingData[AIIndex] = new RankingData(name, score);
			sortAIRanking(AIRankingData);
		} else if (AIIndex == 10) {
			if (AIRankingData[9].score < score) {
				AIRankingData[9] = new RankingData(name, score);
				AIIndex = 9;
				sortAIRanking(AIRankingData);
			}
		}
	}
	
	/**
	 * SoloRankingData�� �����մϴ�.
	 * 
	 * @param data - soloRankingData�� �Ű������� �޽��ϴ�.
	 * @throws IOException
	 */
	public void sortSoloRanking(RankingData[] data) throws IOException {
		for(int i = 0 ; i < 9 ; i++)
		{
			for(int j = 1 ; j < 10-i ; j++)
			{
				if(data[j-1].score < data[j].score)
				{
					RankingData temp = soloRankingData[j-1];
					soloRankingData[j-1] = soloRankingData[j];
					soloRankingData[j] = temp;
				}
			}
		}
		saveTXTinSoloRankingData(soloRankingData);
	}
	
	/**
	 * AIRankingData�� �����մϴ�.
	 * 
	 * @param data - AIRankingData�� �Ű������� �޽��ϴ�.
	 * @throws IOException
	 */
	public void sortAIRanking(RankingData[] data) throws IOException {
		for(int i = 0 ; i < 9 ; i++)
		{
			for(int j = 1 ; j < 10-i ; j++)
			{
				if(data[j-1].score < data[j].score)
				{
					RankingData temp = AIRankingData[j-1];
					AIRankingData[j-1] = AIRankingData[j];
					AIRankingData[j] = temp;
				}
			}
		}
		saveTXTinAIRankingData(AIRankingData);
	}

	/** 
	 * SoloRankingData�� �ʱ�ȭ�մϴ�.
	 * 
	 * @throws IOException
	 */
	public void resetSoloData () throws IOException {
		createFile();
		soloFile = new File("SoloRanking.txt");
		fos = new FileOutputStream(soloFile);
		fos.close();
	}
	
	/**
	 * AIRankingData�� �ʱ�ȭ�մϴ�.
	 * 
	 * @throws IOException
	 */
	public void resetAIData () throws IOException {
		createFile();
		AIFile = new File("AIRanking.txt");
		fos = new FileOutputStream(AIFile);
		fos.close();
	}
	
	/** 
	 * SoloRankingData�� �ؽ�Ʈ ���Ͽ� �����մϴ�.
	 * @param data - ������ RankingData�Դϴ�.
	 * @throws IOException
	 */
	public void saveTXTinSoloRankingData(RankingData[] data) throws IOException{
		createFile();
		File inFile = new File("tempFile.txt");
		inFile.createNewFile();
		fis = new FileInputStream(inFile);
		in = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
		fos = new FileOutputStream(soloFile);
		out = new PrintWriter(fos);
		try {
			if(soloIndex < 10) {
			for(int i = 0 ; i < soloIndex+1 ; i++) {
				out.println(data[i].str);
			}
			out.flush();
			out.close();
			in.close();
			inFile.delete();
			soloFile.renameTo(inFile);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * AIRankingData�� �ؽ�Ʈ ���Ͽ� �����մϴ�.
	 * 
	 * @param data - ������ RankingData�Դϴ�.
	 * @throws IOException
	 */
	public void saveTXTinAIRankingData(RankingData[] data) throws IOException {
		createFile();
		File inFile = new File("tempFile.txt");
		inFile.createNewFile();
		fis = new FileInputStream(inFile);
		in = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
		fos = new FileOutputStream(AIFile);
		out = new PrintWriter(fos);
		try {
			if(AIIndex < 10) {
			for(int i = 0 ; i < AIIndex+1 ; i++) {
				out.println(data[i].str);
			}
			out.flush();
			out.close();
			in.close();
			inFile.delete();
			AIFile.renameTo(inFile);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}