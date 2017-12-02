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
	private ViewPausePanel2P pausePanel;
	/** ViewPausePanelSolo Type �� ���� �Դϴ�. */
	private ViewPausePanelSolo pausePanelSolo;
	/** CardLayout Type �� ���� �Դϴ�. */
	private CardLayout card;
	/** 2P PlayMode�� AI ���� ���� 1P�� ���ۿ� ���õ� KeyListener Type �� ���� �Դϴ�. */
	private KeyListener keyListener1p;
	/** 2P PlayMode�� AI ���� ���� 2P�� ���ۿ� ���õ� KeyListener Type �� ���� �Դϴ�. */
	private KeyListener keyListener2p;
	/** SoloPlay ���� ���� ���ۿ� ���õ� KeyListener Type �� ���� �Դϴ�. */
	private KeyListener keyListenerSolo;
	/** Container Type �� ���� �Դϴ�. */
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
		pausePanel = new ViewPausePanel2P(this);
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

	/** 1P�� KeyListener�� �߰��մϴ�. */
	public void addKeyListener1P() {
		addKeyListener(makeKeyListener1p());

	}

	/** 2P�� KeyListener�� �߰��մϴ�. */
	public void addKeyListener2P() {
		addKeyListener(makeKeyListener2p());

	}

	/** SoloPlay�� KeyListener�� �߰��մϴ�. */
	public void addKeyListenerSolo() {
		addKeyListener(makeKeyListenerSolo());

	}

	/** 1P�� KeyListener�� �����մϴ�. */
	public void removeKeyListener() {
		removeKeyListener(makeKeyListener1p());

	}

	/** 2P�� KeyListener�� �����մϴ�. */
	public void removeKeyListener2P() {
		removeKeyListener(makeKeyListener2p());

	}

	/** Soloplay�� KeyListener�� �����մϴ�. */
	public void removeKeyListenerSolo() {
		removeKeyListener(makeKeyListenerSolo());

	}

	/**
	 * 1P�� KeyListener�� �����մϴ�.
	 * 
	 * @return �� KeyListener�� ��ȯ�մϴ�.
	 */
	public KeyListener makeKeyListener1p() {
		return new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					moveLeft1P();
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					moveRight1P();
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					moveDown1P();
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					pause();
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					spin1P();
				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					fastDown1P();
				}
			}
		};

	}

	/**
	 * 2P�� KeyListener�� �����մϴ�.
	 * 
	 * @return �� KeyListener�� ��ȯ�մϴ�.
	 */
	public KeyListener makeKeyListener2p() {
		return new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_W) {
					spin2P();
				}
				if (e.getKeyCode() == KeyEvent.VK_A) {
					moveLeft2P();
				}
				if (e.getKeyCode() == KeyEvent.VK_D) {
					moveRight2P();
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					moveDown2P();
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					pause();
				}
				if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
					fastDown2P();
				}

			}
		};
	}

	/**
	 * Soloplay�� KeyListener�� �����մϴ�.
	 * 
	 * @return �� KeyListener�� ��ȯ�մϴ�.
	 */
	public KeyListener makeKeyListenerSolo() {
		return new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					spinSolo();
				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					fastDownSolo();
				}
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
		addKeyListener1P();
		addKeyListener2P();
		controller.start2PGame();
	}

	/** AIGame�� �����մϴ�. */
	public void AIGameStart() {
		addKeyListener1P();
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

	/**
	 * Controller�� draw2P �޼ҵ带 �����մϴ�.
	 * 
	 * @param g
	 *            - controller�� draw2P �޼ҵ带 �����մϴ�.
	 */
	public void draw2P(Graphics g) {
		controller.draw2P(g);

	}

	/**
	 * Controller�� drawSolo �޼ҵ带 �����մϴ�.
	 * 
	 * @param g
	 *            - controller�� drawSolo �޼ҵ带 �����մϴ�.
	 */
	public void drawSolo(Graphics g) {
		controller.drawSolo(g);

	}

	/** SoloGame�� �����մϴ�. */
	public void soloGameOver() {
		removeKeyListenerSolo();
		soloGamePanel.gameOver();

	}

	/** 2PGame�� �����մϴ�. */
	public void ZPGameLose() {
		removeKeyListener();
		removeKeyListener2P();
		ZPAndAIGamePanel.lose();

	}

	/** 2PGame�� �����մϴ�. */
	public void ZPGameWin() {
		removeKeyListener();
		removeKeyListener2P();
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

	/** PausePanelSolo�� �����ݴϴ�. */
	public void showPausePanelSolo() {
		card.show(contentPane, "PauseSolo");
	}

	/** 1P ���ۿ� ���� ȸ�� ����� �����մϴ�. */
	public void spin1P() {
		controller.spin1P();
	}

	/** 2P ���ۿ� ���� ȸ�� ����� �����մϴ�. */
	public void spin2P() {
		controller.spin2P();
	}

	/** SoloPlay ���ۿ� ���� ȸ�� ����� �����մϴ�. */
	public void spinSolo() {
		controller.spinSolo();
	}

	/** 1P ���ۿ� ���� �����̵� ����� �����մϴ�. */
	public void moveLeft1P() {
		controller.moveLeft1P();
	}

	/** 2P ���ۿ� ���� �����̵� ����� �����մϴ�. */
	public void moveLeft2P() {
		controller.moveLeft2P();
	}

	/** SoloPlay ���ۿ� ���� �����̵� ����� �����մϴ�. */
	public void moveLeftSolo() {
		controller.moveLeftSolo();
	}

	/** 1P ���ۿ� ���� �������̵� ����� �����մϴ�. */
	public void moveRight1P() {
		controller.moveRight1P();
	}

	/** 2P ���ۿ� ���� �������̵� ����� �����մϴ�. */
	public void moveRight2P() {
		controller.moveRight2P();
	}

	/** SoloPlay ���ۿ� ���� �������̵� ����� �����մϴ�. */
	public void moveRightSolo() {
		controller.moveRightSolo();
	}

	/** 1P ���ۿ� ���� �Ʒ����̵� ����� �����մϴ�. */
	public void moveDown1P() {
		controller.moveDown1P();
	}

	/** 2P ���ۿ� ���� �Ʒ����̵� ����� �����մϴ�. */
	public void moveDown2P() {
		controller.moveDown2P();
	}

	/** SoloPlay ���ۿ� ���� �Ʒ����̵� ����� �����մϴ�. */
	public void moveDownSolo() {
		controller.moveDownSolo();
	}

	/** 1P ���ۿ� ���� �Ʒ��� ������ �̵� ����� �����մϴ�. */
	public void fastDown1P() {
		controller.fastDown1P();
	}

	/** 2P ���ۿ� ���� �Ʒ��� ������ �̵� ����� �����մϴ�. */
	public void fastDown2P() {
		controller.fastDown2P();
	}

	/** SoloPlay ���ۿ� ���� �Ʒ��� ������ �̵� ����� �����մϴ�. */
	public void fastDownSolo() {
		controller.fastDownSolo();
	}

	/** 2P �Ǵ� AI Play �߿� �Ͻ����� ����� �����մϴ�. */
	public void pause() {
		removeKeyListener(keyListener1p);
		removeKeyListener(keyListener2p);
		controller.pause();

	}

	/** SoloPlay �߿� �Ͻ����� ����� �����մϴ�. */
	public void pauseSolo() {
		removeKeyListener(keyListenerSolo);
		controller.pauseSolo();
	}

	/** 2P �Ǵ� AI Play �߿� �Ͻ������� ���� ��, ����ϱ� ����� �����մϴ�. */
	public void resume() {
		addKeyListener(keyListener1p);
		addKeyListener(keyListener2p);
		controller.resume();

	}

	/** SoloPlay �߿� �Ͻ������� ���� ��, ����ϱ� ����� �����մϴ�. */
	public void resumeSolo() {
		addKeyListener(keyListenerSolo);
		controller.resumeSolo();
	}

	/** 2P �Ǵ� AI Play �߿� �Ͻ������� ���� ��, ����� ����� �����մϴ�. */
	public void restart() {
		addKeyListener(keyListener1p);
		addKeyListener(keyListener2p);
		controller.restart();

	}

	/** SoloPlay �߿� �Ͻ������� ���� ��, ����� ����� �����մϴ�. */
	public void restartSolo() {
		addKeyListener(keyListenerSolo);
		controller.restartSolo();
	}

	/** �Ͻ������� ���� ��, Mainȭ������ �̵� ����� �����մϴ�. */
	public void goMain() {
		controller.goMain();
	}

}
