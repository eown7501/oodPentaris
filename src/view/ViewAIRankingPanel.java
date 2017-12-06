package view;

import ranking.RankingManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.*;

/**
 * 이 ViewAIRankingPanel 클래스는 AIRanking화면의 Panel을 구성하고 보여주는 클래스입니다.
 * 
 * @author 이은경
 */
public class ViewAIRankingPanel extends JPanel {

	/** ViewTotalFrame Type 의 변수 입니다. */
	private ViewTotalFrame totalFrame;
	/** RankingManager Type 의 변수 입니다. */
	private RankingManager rankingManager;
	/** JPanel Type 의 변수 입니다. */
	private JPanel panel1, panel2, panel3;
	/** JLabel Type 의 변수 입니다. */
	private JLabel nameLabel;
	/** JButton Type 의 변수 입니다. */
	private JButton resetbt, backbt;
	/** FileReader Type 의 변수입니다. */
	private FileReader fr;
	/** BufferedReader Type 의 변수입니다. */
	private BufferedReader br;
	/** String Type 의 변수입니다. */
	private String line, subStr, subStr2, content;
	/** JLabel[] Type 의 변수입니다. */
	private JLabel[] listLabel;
	/** StringTokenizer Type 의 변수입니다. */
	private StringTokenizer token, token2;

	/**
	 *  ViewAIRankingpanel을 생성합니다. 
	 *  
	 * @param totalFrame 명령을 전달 받을 totalFrame 입니다.
	 */
	public ViewAIRankingPanel(ViewTotalFrame totalFrame) {
		this.totalFrame = totalFrame;
		init();
	}
	
	/** 초기값 설정을 합니다. */
	public void init() {
		rankingManager = new RankingManager();
		setBackground(Color.BLACK);
		setLayout(null);
		addContents();
		addListener();
		setVisible(true);
	}

	/** Contents의 기본 설정을 세팅합니다. */
	public void addContents(){
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		resetbt = new JButton("reset");
		backbt = new JButton("back");
		nameLabel = new JLabel("AIGame Ranking");
		listLabel = new JLabel[10];
		
		for(int i = 0 ; i < 10 ; i++) {
			listLabel[i] = new JLabel();
			listLabel[i].setFont(new Font("Forte", Font.PLAIN, 30));
			listLabel[i].setBackground(Color.BLACK);
			listLabel[i].setForeground(Color.WHITE);
			panel2.add(listLabel[i]);
		}
		
		nameLabel.setFont(new Font("Forte", Font.PLAIN, 45));
		nameLabel.setForeground(Color.WHITE);
		resetbt.setFont(new Font("Forte", Font.PLAIN, 45));
		backbt.setFont(new Font("Forte", Font.PLAIN, 45));
		
		resetbt.setBounds(297, 380, 450, 60);
		resetbt.setBorderPainted(false);
		resetbt.setForeground(Color.WHITE);
		resetbt.setFocusable(false);
		resetbt.setContentAreaFilled(false);
		
		backbt.setBounds(800, 380, 450, 60);
		backbt.setBorderPainted(false);
		backbt.setForeground(Color.WHITE);
		backbt.setFocusable(false);
		backbt.setContentAreaFilled(false);
		
		printRanking();
		
		panel2.setLayout(new GridLayout(10, 1, 5, 5));

		panel1.setBounds(0, 0, 1050, 100);
		panel2.setBounds(200, 110, 650, 450);
		panel3.setBounds(0, 550, 1050, 100);
		
		panel1.setBackground(Color.BLACK);
		panel2.setBackground(Color.BLACK);
		panel3.setBackground(Color.BLACK);

		panel1.add(nameLabel, JLabel.CENTER);
		panel3.add(resetbt);
		panel3.add(Box.createHorizontalStrut(50));
		panel3.add(backbt);
		
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
	}
	
	/** 스윙 컴포넌트가 자신의 모양을 그립니다. 
	 * 
	 * @param g 그래픽 변수를 받습니다.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		resetListLabel();
		printRanking();
	}
	
	/** AIRanking을 나타내는 Label을 초기화합니다. */
	public void resetListLabel() {
		for (int i = 0; i < 10 ; i++) {
			listLabel[i].setText("");
		}
	}
	
	/** AIRanking을 출력합니다. */ 
	public void printRanking(){
		try {
			getAITXT();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** 텍스트 파일로부터 값을 읽어옵니다. 
	 * 
	 * @throws FileNotFoundException 예외를 던집니다.
	 */
	public void getAITXT() throws FileNotFoundException{
		fr = new FileReader("AIRanking.txt");
		br = new BufferedReader(fr);
		token = null;
		int num = 0;
		try {
			while((line = br.readLine()) != null) {
				if(!line.equals("")) {
					token = new StringTokenizer(line, "\n");
					
					while(token.hasMoreTokens()) {
						subStr = token.nextToken();
						token2 = new StringTokenizer(subStr, " ");
						content = "";
						
						while(token2.hasMoreTokens()){
							subStr2 = token2.nextToken();	
							content += subStr2 + " ";
						}
						listLabel[num++].setText(content);
					}
				}
			}
			panel2.repaint();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	/** Button에 MouseListener를 삽입합니다. */
	public void addListener() {
		backbt.addMouseListener(makeListener());
		resetbt.addMouseListener(makeListener());
		
	}

	/** MouseLister를 구현합니다. 
	 * 
	 * @return MouseAdapter MouseAdapter를 반환합니다. 
	 */
	public MouseListener makeListener() {
		return new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if(e.getSource() == resetbt){
					resetbt.setFont(new Font("Forte", Font.PLAIN, 55));
				}
				if(e.getSource() == backbt){
					backbt.setFont(new Font("Forte", Font.PLAIN, 55));
				}
			}
			public void mouseExited(MouseEvent e) {
				if(e.getSource() == resetbt){
					resetbt.setFont(new Font("Forte", Font.PLAIN, 45));
				}
				if(e.getSource() == backbt){
					backbt.setFont(new Font("Forte", Font.PLAIN, 45));
				}
			}
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == resetbt) {
					try {
						rankingManager.resetAIData();
						showAIRankingResetPanel();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (e.getSource() == backbt) {
					showRankingPanel();
				}
			}
		};
	}

	/** RankingPanel을 보여줍니다. */
	public void showRankingPanel() {
		totalFrame.showRankingPanel();
	}
	
	/** AIRankingResetPanel을 보여줍니다. */
	public void showAIRankingResetPanel() {
		totalFrame.showAIRankingResetPanel();
	}
	
}