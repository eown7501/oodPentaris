package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ranking.RankingManager;

/**
 * �� ViewSoloRankingResetPanel Ŭ������ SoloRanking�� �ʱ�ȭ�ϴ� ȭ���� Panel�� �����ϰ� �����ִ� Ŭ�����Դϴ�.
 * 
 * @author ������
 */
public class ViewSoloRankingResetPanel extends JPanel {
	
	/** ViewTotalFrame Type �� �����Դϴ�. */
	private ViewTotalFrame totalFrame;
	/** RankingManager Type �� �����Դϴ�. */
	private RankingManager rankingManager;
	/** JLabel Type �� ���� �Դϴ�. */
	private JLabel nameLabel;
	/** JButton Type �� ���� �Դϴ�. */
	private JButton resetbtn, cancelbtn;
	
	/**
	 * ViewSoloRankingResetPanel�� �����մϴ�.
	 * 
	 * @param totalFrame ����� ���޹��� totalFrame �Դϴ�.
	 */
	ViewSoloRankingResetPanel(ViewTotalFrame totalFrame) {
		this.totalFrame = totalFrame;
		init();
	}
	
	/** �ʱⰪ ������ �մϴ�. */
	public void init() {
		rankingManager = new RankingManager();
		setLayout(null);
		setBackground(Color.BLACK);
		addContents();
		addListener();
	}
	
	/** Contents�� �⺻ ������ �����մϴ�. */
	public void addContents() {
		nameLabel = new JLabel("Are you serious ?");
		resetbtn = new JButton("reset");
		cancelbtn = new JButton("cancel");
		
		nameLabel.setFont(new Font("Forte", Font.PLAIN, 45));
		nameLabel.setBounds(360, 175, 450, 80);
		nameLabel.setForeground(Color.RED);
		
		resetbtn.setFont(new Font("Forte", Font.PLAIN, 45));
		resetbtn.setBounds(260, 315, 250, 60);
		resetbtn.setBorderPainted(false);
		resetbtn.setForeground(Color.WHITE);
		resetbtn.setFocusable(false);
		resetbtn.setContentAreaFilled(false);

		cancelbtn.setFont(new Font("Forte", Font.PLAIN, 45));
		cancelbtn.setBounds(510, 315, 250, 60);
		cancelbtn.setBorderPainted(false);
		cancelbtn.setForeground(Color.WHITE);
		cancelbtn.setFocusable(false);
		cancelbtn.setContentAreaFilled(false);

		this.add(nameLabel);
		this.add(resetbtn);
		this.add(cancelbtn);
	}
	
	/** Button�� Listener�� �����մϴ�. */
	public void addListener() {
		resetbtn.addActionListener(makeListener());
		cancelbtn.addActionListener(makeListener());
		resetbtn.addMouseListener(makeListener2());
		cancelbtn.addMouseListener(makeListener2());
	}
	
	/** ActionLister�� �����մϴ�. 
	 * 
	 * @return ActionListener �� ��ȯ�մϴ�. 
	 */
	public ActionListener makeListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == resetbtn) {
					
					try {
						rankingManager.resetSoloData();
						showSoloRankingPanel();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (e.getSource() == cancelbtn) {
					showSoloRankingPanel();
				}
			}
		};

	}
	
	/** MouseAdapter�� �����մϴ�. 
	 * 
	 * @return MouseAdapter �� ��ȯ�մϴ�. 
	 */
	public MouseAdapter makeListener2() {
		return new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if (e.getSource() == resetbtn)
					resetbtn.setFont(new Font("Forte", Font.PLAIN, 55));
				if (e.getSource() == cancelbtn)
					cancelbtn.setFont(new Font("Forte", Font.PLAIN, 55));
			}
			public void mouseExited(MouseEvent e) {
				if (e.getSource() == resetbtn)
					resetbtn.setFont(new Font("Forte", Font.PLAIN, 45));
				if (e.getSource() == cancelbtn)
					cancelbtn.setFont(new Font("Forte", Font.PLAIN, 45));
			}
		};
	}
	
	/** SoloRankingPanel�� �����ݴϴ�. */
	public void showSoloRankingPanel() {
		totalFrame.showSoloRankingPanel();
	}
	
}