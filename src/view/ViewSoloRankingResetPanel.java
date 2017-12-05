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
 * 이 ViewSoloRankingResetPanel 클래스는 SoloRanking을 초기화하는 화면의 Panel을 구성하고 보여주는 클래스입니다.
 * 
 * @author 이은경
 */
public class ViewSoloRankingResetPanel extends JPanel {
	
	/** ViewTotalFrame Type 의 변수입니다. */
	private ViewTotalFrame totalFrame;
	/** RankingManager Type 의 변수입니다. */
	private RankingManager rankingManager;
	/** JLabel Type 의 변수 입니다. */
	private JLabel nameLabel;
	/** JButton Type 의 변수 입니다. */
	private JButton resetbtn, cancelbtn;
	
	/**
	 * ViewSoloRankingResetPanel을 생성합니다.
	 * 
	 * @param totalFrame 명령을 전달받을 totalFrame 입니다.
	 */
	ViewSoloRankingResetPanel(ViewTotalFrame totalFrame) {
		this.totalFrame = totalFrame;
		init();
	}
	
	/** 초기값 설정을 합니다. */
	public void init() {
		rankingManager = new RankingManager();
		setLayout(null);
		setBackground(Color.BLACK);
		addContents();
		addListener();
	}
	
	/** Contents의 기본 설정을 세팅합니다. */
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
	
	/** Button에 Listener를 삽입합니다. */
	public void addListener() {
		resetbtn.addActionListener(makeListener());
		cancelbtn.addActionListener(makeListener());
		resetbtn.addMouseListener(makeListener2());
		cancelbtn.addMouseListener(makeListener2());
	}
	
	/** ActionLister를 구현합니다. 
	 * 
	 * @return ActionListener 를 반환합니다. 
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
	
	/** MouseAdapter를 구현합니다. 
	 * 
	 * @return MouseAdapter 를 반환합니다. 
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
	
	/** SoloRankingPanel을 보여줍니다. */
	public void showSoloRankingPanel() {
		totalFrame.showSoloRankingPanel();
	}
	
}