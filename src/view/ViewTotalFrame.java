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
	/** ViewSoloRankingRegisterPanel Type �� �����Դϴ�. */
	private ViewSoloRankingRegisterPanel registerSoloPanel;
	/** ViewAIRankingRegisterPanel Type �� �����Դϴ�. */
	private ViewAIRankingRegisterPanel registerAIPanel;
	/** ViewSoloRankingResetPanel Type �� �����Դϴ�. */
	private ViewSoloRankingResetPanel resetSoloPanel;
	/** ViewAIRankingResetPanel Type �� �����Դϴ�. */
	private ViewAIRankingResetPanel resetAIPanel;
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
	/** ViewPausePanelAI Type �� ���� �Դϴ�. */
	private ViewPausePanelAI pausePanelAI;
	/** ViewAIGamePanel Type �� �����Դϴ�. */
	private ViewAIGamePanel AIGamePanel;
	/** CardLayout Type �� ���� �Դϴ�. */
	private CardLayout card;
	/** 2P PlayMode�� AI ���� ���� 1P�� ���ۿ� ���õ� KeyListener Type �� ���� �Դϴ�. */
	private KeyListener keyListener1p;
	/** 2P PlayMode�� AI ���� ���� 2P�� ���ۿ� ���õ� KeyListener Type �� ���� �Դϴ�. */
	private KeyListener keyListener2p;
	/** 2P PlayMode�� AI ���� ���� AI�� ���ۿ� ���õ� KeyListener Type �� ���� �Դϴ�. */
	private KeyListener keyListenerAI;
	/** SoloPlay ���� ���� ���ۿ� ���õ� KeyListener Type �� ���� �Դϴ�. */
	private KeyListener keyListenerSolo;
	/** Container Type �� ���� �Դϴ�. */
	private Container contentPane;
	/**GameMode �� ��Ÿ���� ���� �Դϴ�. */
	public int gameMode;

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
		registerSoloPanel = new ViewSoloRankingRegisterPanel(this);
		registerAIPanel = new ViewAIRankingRegisterPanel(this);
		resetSoloPanel = new ViewSoloRankingResetPanel(this);
		resetAIPanel = new ViewAIRankingResetPanel(this);
		helpPanel = new ViewHelpPanel(this);
		controlMethodPanel = new ViewKeyGuidePanel(this);
		profilePanel = new ViewProfilePanel(this);
		pausePanel = new ViewPausePanel2P(this);
		pausePanelSolo = new ViewPausePanelSolo(this);
		pausePanelAI = new ViewPausePanelAI(this);
		AIGamePanel = new ViewAIGamePanel(this);
		card = new CardLayout();
		keyListener1p = makeKeyListener1p();
		keyListener2p = makeKeyListener2p();
		keyListenerSolo = makeKeyListenerSolo();
		keyListenerAI = makeKeyListenerAI();
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
		addKeyListener(keyListener1p);

	}

	/** 2P�� KeyListener�� �߰��մϴ�. */
	public void addKeyListener2P() {
		addKeyListener(keyListener2p);

	}

	/** SoloPlay�� KeyListener�� �߰��մϴ�. */
	public void addKeyListenerSolo() {
		addKeyListener(keyListenerSolo);

	}
	
	/** AIPlay�� KeyListener�� �߰��մϴ�. */
	public void addKeyListenerAI() {
		addKeyListener(keyListenerAI);
	}
	
	/** AI�� KeyListener�� �����մϴ�. */
	public void removeKeyListenerAI() {
		removeKeyListener(keyListenerAI);
	}

	/** 1P�� KeyListener�� �����մϴ�. */
	public void removeKeyListener() {
		removeKeyListener(keyListener1p);

	}

	/** 2P�� KeyListener�� �����մϴ�. */
	public void removeKeyListener2P() {
		removeKeyListener(keyListener2p);

	}

	/** Soloplay�� KeyListener�� �����մϴ�. */
	public void removeKeyListenerSolo() {
		removeKeyListener(keyListenerSolo);

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
	
	public KeyListener makeKeyListenerAI() {
		return new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					spinAI();
				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					fastDownAI();
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					moveLeftAI();
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					moveRightAI();
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					moveDownAI();
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					pauseAI();
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
		contentPane.add("Register SoloRanking", registerSoloPanel);
		contentPane.add("Register AIRanking", registerAIPanel);
		contentPane.add("Reset SoloRanking", resetSoloPanel);
		contentPane.add("Reset AIRanking", resetAIPanel);
		contentPane.add("Help", helpPanel);
		contentPane.add("Control Method", controlMethodPanel);
		contentPane.add("Profile", profilePanel);
		contentPane.add("Pause", pausePanel);
		contentPane.add("PauseSolo", pausePanelSolo);
		contentPane.add("AI Game",AIGamePanel);
		contentPane.add("AI Pause",pausePanelAI);
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
		addKeyListenerAI();
		controller.startAIGame();
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
	
	public void drawAI(Graphics g) {
		controller.drawAI(g);
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
		removeKeyListenerAI();
		AIGamePanel.gameOver();
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
		card.show(contentPane, "AI Game");
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
	
	/** SoloRankingRegisterPanel�� �����ݴϴ�. 
	 * @author ������
	 */
	public void showSoloRankingRegisterPanel() {
		card.show(contentPane, "Register SoloRanking");
	}
	
	/** AIRankingRegisterPanel�� �����ݴϴ�. 
	 * @author ������
	 */
	public void showAIRankingRegisterPanel() {
		card.show(contentPane, "Register AIRanking");
	}
	
	/** SoloRankingResetPanel�� �����ݴϴ�.
	 * @author ������
	 */
	public void showSoloRankingResetPanel() {
		card.show(contentPane, "Reset SoloRanking");
	}
	
	/** AIRankingResetPanel�� �����ݴϴ�. 
	 * @author ������
	 */
	public void showAIRankingResetPanel() {
		card.show(contentPane, "Reset AIRanking");
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
	
	public void pauseAI() {
		removeKeyListener(keyListenerAI);
		controller.pauseAI();
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
	
	public void resumeAI() {
		addKeyListener(keyListenerAI);
		controller.resumeAI();
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
	
	public void restartAI() {
		addKeyListener(keyListenerAI);
		controller.restartAI();
	}

	/** �Ͻ������� ���� ��, Mainȭ������ �̵� ����� �����մϴ�. */
	public void goMain() {
		controller.goMain();
	}
	
	/** ������� ������ ����ϴ�. 
	 * @author ������
	 * @return int Type�� score�� ��ȯ�մϴ�. */
	public int getScore() {
		return controller.getScore();
	}
	
	public void spinAI() {
		controller.spinAI();
	}
	
	public void moveLeftAI() {
		controller.moveLeftAI();
	}
	
	public void moveRightAI() {
		controller.moveRightAI();
	}
	
	public void moveDownAI() {
		controller.moveDownAI();
	}
	

	
	public void fastDownAI() {
		controller.fastDownAI();
	}
	
	public void showPausePanelAI() {
		card.show(contentPane,"AI Pause");
	}
}