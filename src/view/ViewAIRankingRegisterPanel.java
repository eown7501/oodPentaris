package view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ranking.RankingManager;

/**
 * �� ViewAIRankingRegisterPanel Ŭ������ AIRanking�� ����ϴ� ȭ���� Panel�� �����ϰ� �����ִ� Ŭ�����Դϴ�.
 * 
 * @author ������
 */
public class ViewAIRankingRegisterPanel extends JPanel {

	/** ViewTotalFrame Type �� �����Դϴ�. */
	private ViewTotalFrame totalFrame;
	/** RankingManager Type �� �����Դϴ�. */
	RankingManager rankingManager;
	/** JTextField Type �� ���� �Դϴ�. */
	private JTextField nameSpace;
	/** JLabel Type �� �����Դϴ�. */
	private JLabel nameLabel;
	/** JButton Type �� �����Դϴ�. */
	private JButton registerbtn, cancelbtn;

	/**
	 * ViewAIRankingRegisterPanel�� �����մϴ�.
	 * 
	 * @param totalFrame ����� ���޹��� totalFrame �Դϴ�.
	 */
	public ViewAIRankingRegisterPanel(ViewTotalFrame totalFrame) {
		rankingManager = new RankingManager();
		this.totalFrame = totalFrame;
		init();
	}

	/** �ʱⰪ ������ �մϴ�. */
	public void init() {
		setLayout(null);
		setBackground(new Color(90, 90, 90, 255));
		addContents();
		addListener();
	}
	
	/** ���� ������Ʈ�� �ڽ��� ����� �׸��ϴ�. */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		int xx = 200;
		int yy = 175;
		int w = 600;
		int h = 300;
		int arc = 30;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .7f));
		Shape vButtonShape = new RoundRectangle2D.Double((double)xx,(double)yy,(double)w,(double)h,(double)arc,(double)arc);
		Shape vOldClip = g.getClip();
		java.awt.Paint p = new GradientPaint(200f, 175f, new Color(90, 90, 90, 255), 200f, 325f, Color.decode("#3c3c3c"));
		g2.setPaint(p);
		g2.setClip(vButtonShape);
		g2.fillRect(xx,yy,w,h/2);
		java.awt.Paint p1 = new GradientPaint(200f, 380f, Color.decode("#3c3c3c"), 200f, 475f, new Color(90, 90, 90, 255));
		g2.setPaint(p1);
		g2.fillRect(xx,yy+h/2,w,h/2);
		g2.setClip(vOldClip);
		totalFrame.drawAI(g);
	}

	/** Contents�� �⺻ ������ �����մϴ�. */
	public void addContents() {
		nameLabel = new JLabel("nickname ( English / Number / no blank ) :");
		nameSpace = new JTextField(10);
		registerbtn = new JButton("register");
		cancelbtn = new JButton("cancel");
		
		nameLabel.setBackground(new Color(90, 90, 90, 255));
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Forte", Font.PLAIN, 30));
		nameLabel.setBounds(225, 195, 600, 80);
		
		nameSpace.setBounds(320, 275, 400, 50);
		nameSpace.setFont(new Font("Forte", Font.PLAIN, 20));
		
		registerbtn.setFont(new Font("Forte", Font.PLAIN, 45));
		registerbtn.setBounds(280, 335, 250, 60);
		registerbtn.setBorderPainted(false);
		registerbtn.setForeground(Color.WHITE);
		registerbtn.setFocusable(false);
		registerbtn.setContentAreaFilled(false);
		
		cancelbtn.setFont(new Font("Forte", Font.PLAIN, 45));
		cancelbtn.setBounds(520, 335, 250, 60);
		cancelbtn.setBorderPainted(false);
		cancelbtn.setForeground(Color.WHITE);
		cancelbtn.setFocusable(false);
		cancelbtn.setContentAreaFilled(false);
		
		this.add(nameLabel);
		this.add(nameSpace);
		this.add(registerbtn);
		this.add(cancelbtn);
	}
	
	/** Button�� MouseListener�� �����մϴ�. */
	public void addListener() {
		registerbtn.addMouseListener(makeListener());
		cancelbtn.addMouseListener(makeListener());
	}

	/** MouseLister�� �����մϴ�. 
	 * 
	 * @return MouseAdapter �� ��ȯ�մϴ�. 
	 */
	public MouseListener makeListener() {
		return new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if(e.getSource() == registerbtn){
					registerbtn.setFont(new Font("Forte", Font.PLAIN, 55));
					registerbtn.setForeground(Color.CYAN);
				}
				if(e.getSource() == cancelbtn){
					cancelbtn.setFont(new Font("Forte", Font.PLAIN, 55));
					cancelbtn.setForeground(Color.CYAN);
				}
			}
			public void mouseExited(MouseEvent e) {
				if(e.getSource() == registerbtn){
					registerbtn.setFont(new Font("Forte", Font.PLAIN, 45));
					registerbtn.setForeground(Color.WHITE);
				}
				if(e.getSource() == cancelbtn){
					cancelbtn.setFont(new Font("Forte", Font.PLAIN, 45));
					cancelbtn.setForeground(Color.WHITE);
				}
			}
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == registerbtn) {
					int score = totalFrame.getAIScore();
					registerbtn.setForeground(Color.CYAN);
					register(nameSpace.getText(), score);
					nameSpace.setText("");
					showAIRankingPanel();
				}
				if (e.getSource() == cancelbtn) {
					cancelbtn.setForeground(Color.CYAN);
					showMainPanel();
				}
			}
		};
	}
	

	/**
	 * Ranking�� ������ ����մϴ�.
	 * 
	 * @param name ����ڰ� ����� name �Դϴ�.
	 * @param score ������� �����Դϴ�.
	 */
	public void register(String name, int score) {
		try {
			rankingManager.registerAI(name, score);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** AIRankingPanel�� �����ݴϴ�. */
	public void showAIRankingPanel() {
		totalFrame.showAIRankingPanel();
	}
	
	/** MainPanel�� �����ݴϴ�. */
	public void showMainPanel() {
		totalFrame.showMainPanel();
	}
	
}
