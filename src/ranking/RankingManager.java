package ranking;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 이 Class는 랭킹의 입출력과 기능을 담당하는 Class 입니다.
 * 
 * @author 이은경
 *
 */
public class RankingManager{

	/** InputStream Type 의 변수입니다. */
	private InputStream fis;
	/** BufferedReader Type 의 변수입니다. */
	private BufferedReader in;
	/** OutputStream Type 의 변수입니다. */
	private OutputStream fos;
	/** PrintWriter Type 의 변수입니다. */
	private PrintWriter out;
	/** File Type 의 변수입니다. */
	private File soloFile, AIFile;
	/** FileReader Type 의 변수입니다. */
	private FileReader fr;
	/** StringTokenizer Type 의 변수입니다. */
	private StringTokenizer token;
	/** String Type 의 변수입니다. */
	private String line, str;
	/** 텍스트 파일로부터 값을 읽어올 때 이용할 int Type 의 변수입니다. */
	private int soloIndex, AIIndex;
	/** RankingData[] Type 의 변수입니다. */
	private RankingData[] soloRankingData, AIRankingData;
	
	/** RankingManager 를 생성합니다. */
	public RankingManager() {
		soloRankingData = new RankingData[10];
		AIRankingData =  new RankingData[10];
		soloFile = new File("SoloRanking.txt");
		AIFile = new File("AIRanking.txt");
		createFile();
	}

	/** Ranking을 저장할 텍스트 파일이 있는지 검사하고 없을 경우 생성합니다.*/
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
	
	/** 텍스트 파일로부터 값을 읽어 SoloRankingData를 생성합니다. */
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
	
	/** 텍스트 파일로부터 값을 읽어 AIRankingData를 생성합니다. */
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
	 * SoloRankingData에 정보를 저장합니다.
	 * 
	 * @param name - ViewSoloRankingRegisterPanel에게서 받은 매개변수입니다. 사용자의 이름을 나타냅니다.  
	 * @param score - ViewSoloRankingRegisterPanel에게서 받은 받은 매개변수입니다. 사용자의 점수를 나타냅니다. 
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
	 * AIRankingData에 정보를 저장합니다.
	 * 
	 * @param name - ViewAIRankingRegisterPanel에게서 받은 매개변수입니다. 사용자의 이름을 나타냅니다.  
	 * @param score - ViewAIRankingRegisterPanel에게서 받은 매개변수입니다. 사용자의 점수를 나타냅니다.  
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
	 * SoloRankingData를 정렬합니다.
	 * 
	 * @param data - soloRankingData를 매개변수로 받습니다.
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
	 * AIRankingData를 정렬합니다.
	 * 
	 * @param data - AIRankingData를 매개변수로 받습니다.
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
	 * SoloRankingData를 초기화합니다.
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
	 * AIRankingData를 초기화합니다.
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
	 * SoloRankingData를 텍스트 파일에 저장합니다.
	 * @param data - 저장할 RankingData입니다.
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
	 * AIRankingData를 텍스트 파일에 저장합니다.
	 * 
	 * @param data - 저장할 RankingData입니다.
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