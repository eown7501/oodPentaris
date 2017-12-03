package view;

import controller.Controller;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 이 ViewTotalFrame 클래스는 모든 GUI를 총괄담당하는 클래스 입니다.
 * 
 * @author 송민석
 */
public class ViewTotalFrame extends JFrame {

	/** Controller Type 의 변수 입니다. */
	private Controller controller;
	/** ViewMainPanel Type 의 변수 입니다. */
	private ViewMainPanel mainPanel;
	/** ViewGameModePanel Type 의 변수 입니다. */
	private ViewGameModePanel gameModePanel;
	/** ViewSoloGamePanel Type 의 변수 입니다. */
	private ViewSoloGamePanel soloGamePanel;
	/** View2PAndAIGamePanel Type 의 변수 입니다. */
	private View2PAndAIGamePanel ZPAndAIGamePanel;
	/** ViewRankingPanel Type 의 변수 입니다. */
	private ViewRankingPanel rankingPanel;
	/** ViewSoloRankingPanel Type 의 변수 입니다. */
	private ViewSoloRankingPanel soloRankingPanel;
	/** ViewAIRankingPanel Type 의 변수 입니다. */
	private ViewAIRankingPanel AIRankingPanel;
	/** ViewSoloRankingRegisterPanel Type 의 변수입니다. */
	private ViewSoloRankingRegisterPanel registerSoloPanel;
	/** ViewAIRankingRegisterPanel Type 의 변수입니다. */
	private ViewAIRankingRegisterPanel registerAIPanel;
	/** ViewSoloRankingResetPanel Type 의 변수입니다. */
	private ViewSoloRankingResetPanel resetSoloPanel;
	/** ViewAIRankingResetPanel Type 의 변수입니다. */
	private ViewAIRankingResetPanel resetAIPanel;
	/** ViewHelpPanel Type 의 변수 입니다. */
	private ViewHelpPanel helpPanel;
	/** ViewKeyGuidePanel Type 의 변수 입니다. */
	private ViewKeyGuidePanel controlMethodPanel;
	/** ViewProfilePanel Type 의 변수 입니다. */
	private ViewProfilePanel profilePanel;
	/** ViewPausePanel Type 의 변수 입니다. */
	private ViewPausePanel2P pausePanel;
	/** ViewPausePanelSolo Type 의 변수 입니다. */
	private ViewPausePanelSolo pausePanelSolo;
	/** ViewPausePanelAI Type 의 변수 입니다. */
	private ViewPausePanelAI pausePanelAI;
	/** ViewAIGamePanel Type 의 변수입니다. */
	private ViewAIGamePanel AIGamePanel;
	/** CardLayout Type 의 변수 입니다. */
	private CardLayout card;
	/** 2P PlayMode나 AI 게임 내의 1P의 조작에 관련된 KeyListener Type 의 변수 입니다. */
	private KeyListener keyListener1p;
	/** 2P PlayMode나 AI 게임 내의 2P의 조작에 관련된 KeyListener Type 의 변수 입니다. */
	private KeyListener keyListener2p;
	/** 2P PlayMode나 AI 게임 내의 AI의 조작에 관련된 KeyListener Type 의 변수 입니다. */
	private KeyListener keyListenerAI;
	/** SoloPlay 게임 내의 조작에 관련된 KeyListener Type 의 변수 입니다. */
	private KeyListener keyListenerSolo;
	/** Container Type 의 변수 입니다. */
	private Container contentPane;
	/**GameMode 를 나타내는 정수 입니다. */
	public int gameMode;

	/**
	 * ViewTotalFrame을 생성합니다.
	 * 
	 * @param controller
	 *            - 명령을 하거나 명령을 전달받을 controller 입니다.
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

	/** ViewTotalFrame 을 초기화 합니다. */
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

	/** 1P의 KeyListener를 추가합니다. */
	public void addKeyListener1P() {
		addKeyListener(keyListener1p);

	}

	/** 2P의 KeyListener를 추가합니다. */
	public void addKeyListener2P() {
		addKeyListener(keyListener2p);

	}

	/** SoloPlay의 KeyListener를 추가합니다. */
	public void addKeyListenerSolo() {
		addKeyListener(keyListenerSolo);

	}
	
	/** AIPlay의 KeyListener를 추가합니다. */
	public void addKeyListenerAI() {
		addKeyListener(keyListenerAI);
	}
	
	/** AI의 KeyListener를 제거합니다. */
	public void removeKeyListenerAI() {
		removeKeyListener(keyListenerAI);
	}

	/** 1P의 KeyListener를 제거합니다. */
	public void removeKeyListener() {
		removeKeyListener(keyListener1p);

	}

	/** 2P의 KeyListener를 제거합니다. */
	public void removeKeyListener2P() {
		removeKeyListener(keyListener2p);

	}

	/** Soloplay의 KeyListener를 제거합니다. */
	public void removeKeyListenerSolo() {
		removeKeyListener(keyListenerSolo);

	}

	/**
	 * 1P의 KeyListener를 구현합니다.
	 * 
	 * @return 이 KeyListener을 반환합니다.
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
	 * 2P의 KeyListener를 구현합니다.
	 * 
	 * @return 이 KeyListener을 반환합니다.
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
	 * Soloplay의 KeyListener를 구현합니다.
	 * 
	 * @return 이 KeyListener을 반환합니다.
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

	/** Container에 Panel을 삽입합니다. */
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

	/** SoloGame을 시작합니다. */
	public void soloGameStart() {
		addKeyListenerSolo();
		controller.startSoloGame();
	}

	/** 2PGame을 시작합니다. */
	public void ZPGameStart() {
		addKeyListener1P();
		addKeyListener2P();
		controller.start2PGame();
	}

	/** AIGame을 시작합니다. */
	public void AIGameStart() {
		addKeyListenerAI();
		controller.startAIGame();
	}

	/** 화면을 repaint 합니다. */
	public void update() {
		repaint();
	}

	/**
	 * Controller의 draw 메소드를 실행합니다.
	 * 
	 * @param g
	 *            - controller에 draw 메소드를 전달합니다.
	 */
	public void draw(Graphics g) {
		controller.draw(g);

	}

	/**
	 * Controller의 draw2P 메소드를 실행합니다.
	 * 
	 * @param g
	 *            - controller에 draw2P 메소드를 전달합니다.
	 */
	public void draw2P(Graphics g) {
		controller.draw2P(g);

	}

	/**
	 * Controller의 drawSolo 메소드를 실행합니다.
	 * 
	 * @param g
	 *            - controller에 drawSolo 메소드를 전달합니다.
	 */
	public void drawSolo(Graphics g) {
		controller.drawSolo(g);

	}
	
	public void drawAI(Graphics g) {
		controller.drawAI(g);
	}

	/** SoloGame을 종료합니다. */
	public void soloGameOver() {
		removeKeyListenerSolo();
		soloGamePanel.gameOver();

	}

	/** 2PGame을 종료합니다. */
	public void ZPGameLose() {
		removeKeyListener();
		removeKeyListener2P();
		ZPAndAIGamePanel.lose();

	}

	/** 2PGame을 종료합니다. */
	public void ZPGameWin() {
		removeKeyListener();
		removeKeyListener2P();
		ZPAndAIGamePanel.lose();
	}

	/** AIGame을 종료합니다. */
	public void AIGameLose() {
		removeKeyListenerAI();
		AIGamePanel.gameOver();
	}

	/** MainPanel을 보여줍니다. */
	public void showMainPanel() {
		card.show(contentPane, "Main");
	}

	/** GameMode를 선택하는 Panel을 보여줍니다. */
	public void showGameModePanel() {
		card.show(contentPane, "Game Mode");
	}

	/** SoloGamePanel을 보여줍니다. */
	public void showSoloGamePanel() {
		card.show(contentPane, "Solo Game");
	}
	
	/** 2PGamePanel을 보여줍니다. */
	public void show2PGamePanel() {
		card.show(contentPane, "2P And AI Game");
	}

	/** AIGamePanel을 보여줍니다. */
	public void showAIGamePanel() {
		card.show(contentPane, "AI Game");
	}

	/** RankingPanel을 보여줍니다. */
	public void showRankingPanel() {
		card.show(contentPane, "Ranking");
	}

	/** SoloRankingPanel을 보여줍니다. */
	public void showSoloRankingPanel() {
		card.show(contentPane, "Solo Ranking");
	}

	/** SoloAIRankingPanel을 보여줍니다. */
	public void showAIRankingPanel() {
		card.show(contentPane, "AI Ranking");
	}
	
	/** SoloRankingRegisterPanel을 보여줍니다. 
	 * @author 이은경
	 */
	public void showSoloRankingRegisterPanel() {
		card.show(contentPane, "Register SoloRanking");
	}
	
	/** AIRankingRegisterPanel을 보여줍니다. 
	 * @author 이은경
	 */
	public void showAIRankingRegisterPanel() {
		card.show(contentPane, "Register AIRanking");
	}
	
	/** SoloRankingResetPanel을 보여줍니다.
	 * @author 이은경
	 */
	public void showSoloRankingResetPanel() {
		card.show(contentPane, "Reset SoloRanking");
	}
	
	/** AIRankingResetPanel을 보여줍니다. 
	 * @author 이은경
	 */
	public void showAIRankingResetPanel() {
		card.show(contentPane, "Reset AIRanking");
	}
	/** HelpPanel을 보여줍니다. */
	public void showHelpPanel() {
		card.show(contentPane, "Help");
	}

	/** ControlMethodPanel을 보여줍니다. */
	public void showControlMethodPanel() {
		card.show(contentPane, "Control Method");
	}

	/** ProfilePanel을 보여줍니다. */
	public void showProfile() {
		card.show(contentPane, "Profile");
	}

	/** PausePanel을 보여줍니다. */
	public void showPausePanel() {
		card.show(contentPane, "Pause");
	}

	/** PausePanelSolo을 보여줍니다. */
	public void showPausePanelSolo() {
		card.show(contentPane, "PauseSolo");
	}

	/** 1P 조작에 대헤 회전 명령을 전달합니다. */
	public void spin1P() {
		controller.spin1P();
	}

	/** 2P 조작에 대헤 회전 명령을 전달합니다. */
	public void spin2P() {
		controller.spin2P();
	}

	/** SoloPlay 조작에 대헤 회전 명령을 전달합니다. */
	public void spinSolo() {
		controller.spinSolo();
	}

	/** 1P 조작에 대해 왼쪽이동 명령을 전달합니다. */
	public void moveLeft1P() {
		controller.moveLeft1P();
	}

	/** 2P 조작에 대해 왼쪽이동 명령을 전달합니다. */
	public void moveLeft2P() {
		controller.moveLeft2P();
	}

	/** SoloPlay 조작에 대해 왼쪽이동 명령을 전달합니다. */
	public void moveLeftSolo() {
		controller.moveLeftSolo();
	}

	/** 1P 조작에 대해 오른쪽이동 명령을 전달합니다. */
	public void moveRight1P() {
		controller.moveRight1P();
	}

	/** 2P 조작에 대해 오른쪽이동 명령을 전달합니다. */
	public void moveRight2P() {
		controller.moveRight2P();
	}

	/** SoloPlay 조작에 대해 오른쪽이동 명령을 전달합니다. */
	public void moveRightSolo() {
		controller.moveRightSolo();
	}

	/** 1P 조작에 대해 아래로이동 명령을 전달합니다. */
	public void moveDown1P() {
		controller.moveDown1P();
	}

	/** 2P 조작에 대해 아래로이동 명령을 전달합니다. */
	public void moveDown2P() {
		controller.moveDown2P();
	}

	/** SoloPlay 조작에 대해 아래로이동 명령을 전달합니다. */
	public void moveDownSolo() {
		controller.moveDownSolo();
	}

	/** 1P 조작에 대해 아래로 빠르게 이동 명령을 전달합니다. */
	public void fastDown1P() {
		controller.fastDown1P();
	}

	/** 2P 조작에 대해 아래로 빠르게 이동 명령을 전달합니다. */
	public void fastDown2P() {
		controller.fastDown2P();
	}

	/** SoloPlay 조작에 대해 아래로 빠르게 이동 명령을 전달합니다. */
	public void fastDownSolo() {
		controller.fastDownSolo();
	}

	/** 2P 또는 AI Play 중에 일시정지 명령을 전달합니다. */
	public void pause() {
		removeKeyListener(keyListener1p);
		removeKeyListener(keyListener2p);
		controller.pause();

	}

	/** SoloPlay 중에 일시정지 명령을 전달합니다. */
	public void pauseSolo() {
		removeKeyListener(keyListenerSolo);
		controller.pauseSolo();
	}
	
	public void pauseAI() {
		removeKeyListener(keyListenerAI);
		controller.pauseAI();
	}

	/** 2P 또는 AI Play 중에 일시정지를 했을 때, 계속하기 명령을 전달합니다. */
	public void resume() {
		addKeyListener(keyListener1p);
		addKeyListener(keyListener2p);
		controller.resume();

	}

	/** SoloPlay 중에 일시정지를 했을 때, 계속하기 명령을 전달합니다. */
	public void resumeSolo() {
		addKeyListener(keyListenerSolo);
		controller.resumeSolo();
	}
	
	public void resumeAI() {
		addKeyListener(keyListenerAI);
		controller.resumeAI();
	}

	/** 2P 또는 AI Play 중에 일시정지를 했을 때, 재시작 명령을 전달합니다. */
	public void restart() {
		addKeyListener(keyListener1p);
		addKeyListener(keyListener2p);
		controller.restart();

	}

	/** SoloPlay 중에 일시정지를 했을 때, 재시작 명령을 전달합니다. */
	public void restartSolo() {
		addKeyListener(keyListenerSolo);
		controller.restartSolo();
	}
	
	public void restartAI() {
		addKeyListener(keyListenerAI);
		controller.restartAI();
	}

	/** 일시정지를 했을 때, Main화면으로 이동 명령을 전달합니다. */
	public void goMain() {
		controller.goMain();
	}
	
	/** 사용자의 점수를 얻습니다. 
	 * @author 이은경
	 * @return int Type의 score를 반환합니다. */
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