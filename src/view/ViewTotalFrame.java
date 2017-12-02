package view;

import controller.Controller;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * �� ViewTotalFrame Ŭ������ ��� GUI�� �Ѱ�����ϴ� Ŭ���� �Դϴ�.
 * 
 * @author �۹μ�
 */
public class ViewTotalFrame extends JFrame {

	/** Controller Type �� ���� �Դϴ�. */
	private Controller controller;
	/** ViewMainPanel Type �� ���� �Դϴ�. */
	private ViewMainPanel mainPanel;
	/** ViewGameModePanel Type �� ���� �Դϴ�. */
	private ViewGameModePanel gameModePanel;
	/** ViewSoloGamePanel Type �� ���� �Դϴ�. */
	private ViewSoloGamePanel soloGamePanel;
	/** View2PAndAIGamePanel Type �� ���� �Դϴ�. */
	private View2PAndAIGamePanel ZPAndAIGamePanel;
	/** ViewRankingPanel Type �� ���� �Դϴ�. */
	private ViewRankingPanel rankingPanel;
	/** ViewSoloRankingPanel Type �� ���� �Դϴ�. */
	private ViewSoloRankingPanel soloRankingPanel;
	/** ViewAIRankingPanel Type �� ���� �Դϴ�. */
	private ViewAIRankingPanel AIRankingPanel;
	/** ViewHelpPanel Type �� ���� �Դϴ�. */
	private ViewHelpPanel helpPanel;
	/** ViewKeyGuidePanel Type �� ���� �Դϴ�. */
	private ViewKeyGuidePanel controlMethodPanel;
	/** ViewProfilePanel Type �� ���� �Դϴ�. */
	private ViewProfilePanel profilePanel;
	/** ViewPausePanel Type �� ���� �Դϴ�. */
	private ViewPausePanel pausePanel;
	private ViewPausePanelSolo pausePanelSolo;
	/** CardLayout Type �� ���� �Դϴ�. */
	private CardLayout card;
	/** KeyListener Type �� ���� �Դϴ�. */
	private KeyListener keyListener1p;
	/** Container Type �� ���� �Դϴ�. */
	private KeyListener keyListener2p;
	private KeyListener keyListenerSolo;
	private Container contentPane;

	/**
	 * ViewTotalFrame�� �����մϴ�.
	 * 
	 * @param controller
	 *            - ����� �ϰų� ����� ���޹��� controller �Դϴ�.
	 */
	public ViewTotalFrame(Controller controller) {
		this.controller = controller;
		mainPanel = new ViewMainPanel(this);
		gameModePanel = new ViewGameModePanel(this);
		soloGamePanel = new ViewSoloGamePanel(this);
		ZPAndAIGamePanel = new View2PAndAIGamePanel(this);
		rankingPanel = new ViewRankingPanel(this);
		soloRankingPanel = new ViewSoloRankingPanel(this);
		AIRankingPanel = new ViewAIRankingPanel(this);
		helpPanel = new ViewHelpPanel(this);
		controlMethodPanel = new ViewKeyGuidePanel(this);
		profilePanel = new ViewProfilePanel(this);
		pausePanel = new ViewPausePanel(this);
		pausePanelSolo = new ViewPausePanelSolo(this);

		card = new CardLayout();
		keyListener1p = makeKeyListener1p();
		keyListener2p = makeKeyListener2p();
		keyListenerSolo = makeKeyListenerSolo();
		init();
	}

	/** ViewTotalFrame �� �ʱ�ȭ �մϴ�. */
	public void init() {
		setTitle("Pentaris");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(card);
		addPanel();
		setSize(1050, 700);
		setFocusable(true);
		requestFocus();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	/** ������ KeyListener�� �߰��մϴ�. */
	public void addKeyListener() {
		addKeyListener(makeKeyListener1p());

	}

	public void addKeyListener2() {
		addKeyListener(makeKeyListener2p());

	}

	public void addKeyListenerSolo() {
		addKeyListener(makeKeyListenerSolo());

	}

	/**
	 * KeyListener�� �����մϴ�.
	 * 
	 * @return �� KeyListener�� ��ȯ�մϴ�.
	 */
	public KeyListener makeKeyListener1p() {
		return new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					spin();
				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					fastDown();
				}
			}

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					moveLeft();
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					moveRight();
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					moveDown();
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					pause();
				}
			}
		};

	}

	public KeyListener makeKeyListener2p() {
		return new KeyAdapter() {
			public void keyReleased(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
					fastDown2();
				}
			}

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_W) {
					spin2();
				}
				if (e.getKeyCode() == KeyEvent.VK_A) {
					moveLeft2();
				}
				if (e.getKeyCode() == KeyEvent.VK_D) {
					moveRight2();
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					moveDown2();
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					pause();
				}
			}
		};
	}

	public KeyListener makeKeyListenerSolo() {
		return new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					spinSolo();
				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					fastDownSolo();
				}
			}

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					moveLeftSolo();
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					moveRightSolo();
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					moveDownSolo();
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					pauseSolo();
				}
			}
		};

	}

	/** Container�� Panel�� �����մϴ�. */
	public void addPanel() {
		contentPane.add("Main", mainPanel);
		contentPane.add("Game Mode", gameModePanel);
		contentPane.add("Solo Game", soloGamePanel);
		contentPane.add("2P And AI Game", ZPAndAIGamePanel);
		contentPane.add("Ranking", rankingPanel);
		contentPane.add("Solo Ranking", soloRankingPanel);
		contentPane.add("AI Ranking", AIRankingPanel);
		contentPane.add("Help", helpPanel);
		contentPane.add("Control Method", controlMethodPanel);
		contentPane.add("Profile", profilePanel);
		contentPane.add("Pause", pausePanel);
		contentPane.add("PauseSolo", pausePanelSolo);

	}

	/** SoloGame�� �����մϴ�. */
	public void soloGameStart() {
		addKeyListenerSolo();
		controller.startSoloGame();
	}

	/** 2PGame�� �����մϴ�. */
	public void ZPGameStart() {
		addKeyListener();
		addKeyListener2();
		controller.start2PGame();
	}

	/** AIGame�� �����մϴ�. */
	public void AIGameStart() {
		addKeyListener();
	}

	/** ȭ���� repaint �մϴ�. */
	public void update() {
		repaint();
	}

	/**
	 * Controller�� draw �޼ҵ带 �����մϴ�.
	 * 
	 * @param g
	 *            - controller�� draw �޼ҵ带 �����մϴ�.
	 */
	public void draw(Graphics g) {
		controller.draw(g);

	}

	public void drawSolo(Graphics g) {
		controller.drawSolo(g);

	}

	/** SoloGame�� �����մϴ�. */
	public void soloGameOver() {
		removeKeyListener(keyListenerSolo);
		soloGamePanel.gameOver();
	}

	/** 2PGame�� �����մϴ�. */
	public void ZPGameLose() {
		removeKeyListener(keyListener1p);
		removeKeyListener(keyListener2p);
		ZPAndAIGamePanel.lose();
	}

	public void ZPGameWin() {
		ZPAndAIGamePanel.win();
		removeKeyListener(keyListener1p);
		removeKeyListener(keyListener2p);
		ZPAndAIGamePanel.lose();
	}

	/** AIGame�� �����մϴ�. */
	public void AIGameLose() {

	}

	/** MainPanel�� �����ݴϴ�. */
	public void showMainPanel() {
		card.show(contentPane, "Main");
	}

	/** GameMode�� �����ϴ� Panel�� �����ݴϴ�. */
	public void showGameModePanel() {
		card.show(contentPane, "Game Mode");
	}

	/** SoloGamePanel�� �����ݴϴ�. */
	public void showSoloGamePanel() {
		card.show(contentPane, "Solo Game");
	}

	/** 2PGamePanel�� �����ݴϴ�. */
	public void show2PGamePanel() {
		card.show(contentPane, "2P And AI Game");
	}

	/** AIGamePanel�� �����ݴϴ�. */
	public void showAIGamePanel() {
		card.show(contentPane, "2P And AI Game");
	}

	/** RankingPanel�� �����ݴϴ�. */
	public void showRankingPanel() {
		card.show(contentPane, "Ranking");
	}

	/** SoloRankingPanel�� �����ݴϴ�. */
	public void showSoloRankingPanel() {
		card.show(contentPane, "Solo Ranking");
	}

	/** SoloAIRankingPanel�� �����ݴϴ�. */
	public void showAIRankingPanel() {
		card.show(contentPane, "AI Ranking");
	}

	/** HelpPanel�� �����ݴϴ�. */
	public void showHelpPanel() {
		card.show(contentPane, "Help");
	}

	/** ControlMethodPanel�� �����ݴϴ�. */
	public void showControlMethodPanel() {
		card.show(contentPane, "Control Method");
	}

	/** ProfilePanel�� �����ݴϴ�. */
	public void showProfile() {
		card.show(contentPane, "Profile");
	}

	/** PausePanel�� �����ݴϴ�. */
	public void showPausePanel() {
		card.show(contentPane, "Pause");
	}

	/** PausePanel�� �����ݴϴ�. */
	public void showPausePanelSolo() {
		card.show(contentPane, "PauseSolo");
	}

	/** ȸ�� ����� �����մϴ�. */
	public void spin() {
		controller.spin();
	}

	public void spin2() {
		controller.spin2();
	}

	/** ȸ�� ����� �����մϴ�. */
	public void spinSolo() {
		controller.spinSolo();
	}

	/** �����̵� ����� �����մϴ�. */
	public void moveLeft() {
		controller.moveLeft();
	}

	public void moveLeft2() {
		controller.moveLeft2();
	}

	public void moveLeftSolo() {
		controller.moveLeftSolo();
	}

	/** �������̵� ����� �����մϴ�. */
	public void moveRight() {
		controller.moveRight();
	}

	public void moveRight2() {
		controller.moveRight2();
	}

	public void moveRightSolo() {
		controller.moveRightSolo();
	}

	/** �Ʒ����̵� ����� �����մϴ�. */
	public void moveDown() {
		controller.moveDown();
	}

	public void moveDown2() {
		controller.moveDown2();
	}

	public void moveDownSolo() {
		controller.moveDownSolo();
	}

	/** �Ʒ��� ������ �̵� ����� �����մϴ�. */
	public void fastDown() {
		controller.fastDown();
	}

	/** �Ʒ��� ������ �̵� ����� �����մϴ�. */
	public void fastDown2() {
		controller.fastDown2();
	}

	public void fastDownSolo() {
		controller.fastDownSolo();
	}

	/** �Ͻ����� ����� �����մϴ�. */
	public void pause() {
		removeKeyListener(keyListener1p);
		removeKeyListener(keyListener2p);
		controller.pause();
	}

	public void pauseSolo() {
		removeKeyListener(keyListenerSolo);
		controller.pauseSolo();
	}

	/** ����ϱ� ����� �����մϴ�. */
	public void resume() {
		addKeyListener(keyListener1p);
		addKeyListener(keyListener2p);
		controller.resume();
	}

	public void resumeSolo() {
		addKeyListener(keyListenerSolo);
		controller.resumeSolo();
	}

	/** ����� ����� �����մϴ�. */
	public void restart() {
		addKeyListener(keyListener1p);
		addKeyListener(keyListener2p);
		controller.restart();
	}

	/** ����� ����� �����մϴ�. */
	public void restartSolo() {
		addKeyListener(keyListenerSolo);
		controller.restartSolo();
	}

	/** Mainȭ������ �̵� ����� �����մϴ�. */
	public void goMain() {
		controller.goMain();
	}

}
