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
 * �� ViewSoloRankingPanel Ŭ������ SoloRankingȭ���� Panel�� �����ϰ� �����ִ� Ŭ�����Դϴ�.
 * 
 * @author ������
 */
public class ViewSoloRankingPanel extends JPanel {

	/** ViewTotalFrame Type �� ���� �Դϴ�. */
	private ViewTotalFrame totalFrame;
	/** RankingManager Type �� ���� �Դϴ�. */
	private RankingManager rankingManager;
	/** JPanel Type �� ���� �Դϴ�. */
	private JPanel panel1, panel2, panel3;
	/** JLabel Type �� ���� �Դϴ�. */
	private JLabel nameLabel;
	/** JButton Type �� ���� �Դϴ�. */
	private JButton resetbt, backbt;
	/** FileReader Type �� �����Դϴ�. */
	private FileReader fr;
	/** BufferedReader Type �� �����Դϴ�. */
	private BufferedReader br;
	/** String Type �� �����Դϴ�. */
	private String line, subStr, subStr2, content;
	/** JLabel[] Type �� �����Դϴ�. */
	private JLabel[] listLabel;
	/** StringTokenizer Type �� �����Դϴ�. */
	private StringTokenizer token, token2;

	/**
	 *  ViewSoloRankingpanel�� �����մϴ�. 
	 *  
	 * @param totalFrame ����� ���� ���� totalFrame �Դϴ�.
	 */
	public ViewSoloRankingPanel(ViewTotalFrame totalFrame) {
		this.totalFrame = totalFrame;
		init();
	}
	
	/** �ʱⰪ ������ �մϴ�. */
	public void init() {
		rankingManager = new RankingManager();
		setBackground(Color.BLACK);
		setLayout(null);
		addContents();
		addListener();
		setVisible(true);
	}

	/** Contents�� �⺻ ������ �����մϴ�. */
	public void addContents(){
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		resetbt = new JButton("reset");
		backbt = new JButton("back");
		nameLabel = new JLabel("SoloGame Ranking");
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
	
	/** ���� ������Ʈ�� �ڽ��� ����� �׸��ϴ�. */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		resetListLabel();
		printRanking();
	}
	
	/** SoloRanking�� ��Ÿ���� Label�� �ʱ�ȭ�մϴ�. */
	public void resetListLabel() {
		for (int i = 0; i < 10 ; i++) {
			listLabel[i].setText("");
		}
	}
	
	/** SoloRanking�� ����մϴ�. */ 
	public void printRanking(){
		try {
			getSoloTXT();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** �ؽ�Ʈ ���Ϸκ��� ���� �о�ɴϴ�. */
	public void getSoloTXT() throws FileNotFoundException{
		fr = new FileReader("SoloRanking.txt");
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

	

	/** Button�� MouseListener�� �����մϴ�. */
	public void addListener() {
		backbt.addMouseListener(makeListener());
		resetbt.addMouseListener(makeListener());
		
	}

	/** MouseLister�� �����մϴ�. 
	 * 
	 * @return MouseAdapter �� ��ȯ�մϴ�. 
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
						rankingManager.resetSoloData();
						showSoloRankingResetPanel();
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

	/** RankingPanel�� �����ݴϴ�. */
	public void showRankingPanel() {
		totalFrame.showRankingPanel();
	}
	
	/** SoloRankingResetPanel�� �����ݴϴ�. */
	public void showSoloRankingResetPanel() {
		totalFrame.showSoloRankingResetPanel();
	}
}
