package controller;

import java.awt.Graphics;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import model.GameBoard1P;
import model.GameBoard2P;
import model.GameBoardSolo;
import view.ViewTotalFrame;
import AI.GameBoardAI;

/**
 * 이 Controller 클래스는 GameBoard Class 와 ViewTotalFrame Class 의 연결을 담당합니다.
 * ViewTotalFrame 객체와 GameBoard 객체는 각자 명령을 Controller 객체에게 전달하거나 전달받습니다.
 * 
 * @author 신승현
 */
public class Controller {

	/** 명령을 받을 TotalFrame Type 의 변수입니다. */
	private ViewTotalFrame totalFrame;
	/** 명령을 전달할 GameBoardSolo Type 의 변수입니다. */
	private GameBoard1P GameBoard1P;
	/** GameMode 를 나타낼 Int Type 변수입니다. */
	private GameBoard2P GameBoard2P;
	/** GameMode 를 나타낼 Int Type 변수입니다. */
	private GameBoardSolo GameBoardSolo;
	/** 명령을 전달할 GameBoardAI 타입의 변수 입니다. */
	private GameBoardAI gameBoardAI;
	/** 명령을 전달할 GameBoardAI 타입의 변수 입니다. */
	private GameBoardAI gameBoardAIP;
	/** GameMode 를 나타낼 Int Type 변수입니다. */
	public int gameMode;
	/** Game 이 시작할때 쓰이는 intro clip 입니다. */
	private Clip clipIntro;
	/** Game 이 시작할때 쓰이는 Origin clip 입니다. */
	private Clip clipOrigin;
	/** Game 이 시작할때 쓰이는 Metal clip 입니다. */
	private Clip clipMetal;
	/** Game 이 시작할때 쓰이는 Landing clip 입니다. */
	private Clip clipLanding;

	/** ViewTotalFrame이 생성되는 Controller 를 생성합니다. */
	public Controller() {
		gameMode = 0;
		totalFrame = new ViewTotalFrame(this);
		makeMusic();
		playMusic(0);
	}

	public void playMusic(int index) {
		if (index == 0) {
			clipIntro.start();
			clipIntro.loop(-1);
		}

		if (index == 1) {
			clipOrigin.start();
			clipOrigin.loop(-1);
		}

		if (index == 2) {
			clipMetal.start();
			clipMetal.loop(-1);
		}
		if (index == 3) {
			clipLanding.start();
			clipLanding.loop(1);
		}

	}

	/** Music 을 정지합니다. */
	public void stopMusic(int index) {
		if (index == 0)
			clipIntro.stop();
		if (index == 1)
			clipOrigin.stop();
		if (index == 2)
			clipMetal.stop();
		if (index == 3)
			clipLanding.stop();
	}

	public void makeMusic() {
		makeIntroMusic();
		makeOriginMusic();
		makeMetalMusic();
		makeLandingMusic();
	}

	/** Intro Music 을 만듭니다. */
	public void makeIntroMusic() {
		URL intro = getClass().getClassLoader().getResource("musics/intro.wav");
		try {
			AudioInputStream aisIntro = AudioSystem.getAudioInputStream(intro);
			clipIntro = AudioSystem.getClip();
			clipIntro.open(aisIntro);
		} catch (Exception e) {
		}

	}

	/** Original Music 을 만듭니다. */
	public void makeOriginMusic() {
		URL origin = getClass().getClassLoader().getResource("musics/BradinskyOrignal.wav");
		try {
			AudioInputStream aisOrigin = AudioSystem.getAudioInputStream(origin);
			clipOrigin = AudioSystem.getClip();
			clipOrigin.open(aisOrigin);
		} catch (Exception e) {
		}
	}

	/** Metal Music 을 만듭니다. */
	public void makeMetalMusic() {
		URL metal = getClass().getClassLoader().getResource("musics/BradinskyMetal.wav");
		try {
			AudioInputStream aisMetal = AudioSystem.getAudioInputStream(metal);
			clipMetal = AudioSystem.getClip();
			clipMetal.open(aisMetal);
		} catch (Exception e) {
		}
	}

	public void makeLandingMusic() {
		URL landing = getClass().getClassLoader().getResource("musics/Landing.wav");
		try {
			AudioInputStream aisLanding = AudioSystem.getAudioInputStream(landing);
			clipLanding = AudioSystem.getClip();
			clipLanding.open(aisLanding);
		} catch (Exception e) {
		}
	}

	/**
	 * 1P Controller 의 멤버변수들을 초기화 합니다.
	 * 
	 * @author 송민석
	 */
	public void init() {
		GameBoard1P = new GameBoard1P(this);

	}

	/**
	 * 2P Controller 의 멤버변수들을 초기화 합니다.
	 * 
	 * @author 송민석
	 */
	public void init2() {
		GameBoard2P = new GameBoard2P(this);
	}

	/** Controller 의 멤버변수들을 초기화 합니다. */
	public void initSolo() {
		GameBoardSolo = new GameBoardSolo(this);

	}

	public void initAI() {
		gameBoardAI = new GameBoardAI(this);
		gameBoardAIP = new GameBoardAI(this);
	}

	/** Solo Game을 시작합니다. */
	public void startSoloGame() {
		initSolo();
		gameMode = 1;
		stopMusic(0);
		makeOriginMusic();
		playMusic(1);
		GameBoardSolo.startSoloGame();
		totalFrame.showSoloGamePanel();
	}

	/**
	 * 2P Game을 시작합니다.
	 * 
	 * @author 송민석
	 */
	public void start2PGame() {
		init();
		init2();
		gameMode = 2;
		stopMusic(0);
		makeOriginMusic();
		playMusic(1);
		GameBoard1P.startGame();
		GameBoard2P.startGame();
		totalFrame.show2PGamePanel();

	}

	/** AI Game 을 시작합니다. */
	public void startAIGame() {
		initAI();
		gameMode = 3;
		totalFrame.gameMode = 3;
		stopMusic(0);
		playMusic(2);
		gameBoardAI.startAIGame();
		gameBoardAIP.startPlayerGame();
		totalFrame.showAIGamePanel();
	}

	/**
	 * GameBoard1P 의 draw 메소드를 실행합니다.
	 * 
	 * @author 송민석
	 * @param g
	 *            - totalFrame에서 받은 매개변수 입니다. 이 Graphics g를 GameBoard의 draw 메소드에
	 *            전달합니다.
	 */
	public void draw(Graphics g) {
		GameBoard1P.draw(g);
	}

	/**
	 * GameBoard2P 의 draw 메소드를 실행합니다.
	 * 
	 * @author 송민석
	 * @param g
	 *            - totalFrame에서 받은 매개변수 입니다. 이 Graphics g를 GameBoard의 draw 메소드에
	 *            전달합니다.
	 */
	public void draw2P(Graphics g) {
		GameBoard2P.draw(g);
	}

	/**
	 * soloGameBoard 의 draw 메소드를 실행합니다.
	 * 
	 * @param g
	 *            - totalFrame에서 받은 매개변수 입니다. 이 Graphics g를 GameBoard의 draw 메소드에
	 *            전달합니다.
	 */
	public void drawSolo(Graphics g) {
		GameBoardSolo.drawSolo(g);
	}

	/**
	 * gameBoardAI, gameBoardAIP 의 draw 메소드를 실행합니다.
	 * 
	 * @param g
	 *            - totalFrame에서 받은 매개변수 입니다. 이 Graphics g를 GameBoard의 draw 메소드에
	 *            전달합니다.
	 */
	public void drawAI(Graphics g) {
		gameBoardAI.draw(g);
		gameBoardAIP.draw(g);
	}

	/** totalFrame 의 update 메소드를 실행합니다. */
	public void update() {
		totalFrame.update();
	}

	/**
	 * 1P의 회전 명령을 전달합니다.
	 * 
	 * @author 송민석
	 */
	public void spin1P() {
		GameBoard1P.spin();
		update();
	}

	/**
	 * 2P의 회전 명령을 전달합니다.
	 * 
	 * @author 송민석
	 */
	public void spin2P() {
		GameBoard2P.spin();
		update();
	}

	/** 회전 명령을 전달합니다. */
	public void spinSolo() {
		GameBoardSolo.spin();
		update();
	}

	/**
	 * 1P의 왼쪽이동 명령을 전달합니다.
	 * 
	 * @author 송민석
	 */
	public void moveLeft1P() {
		GameBoard1P.moveLeft();
		update();
	}

	/**
	 * 2P의 왼쪽이동 명령을 전달합니다.
	 * 
	 * @author 송민석
	 */
	public void moveLeft2P() {
		GameBoard2P.moveLeft();
		update();
	}

	/** 왼쪽이동 명령을 전달합니다. */
	public void moveLeftSolo() {
		GameBoardSolo.moveLeft();
		update();
	}

	/**
	 * 1P의 오른쪽 이동 명령을 전달합니다.
	 * 
	 * @author 송민석
	 */
	public void moveRight1P() {
		GameBoard1P.moveRight();
		update();
	}

	/**
	 * 2P의 오른쪽 이동 명령을 전달합니다.
	 * 
	 * @author 송민석
	 */
	public void moveRight2P() {
		GameBoard2P.moveRight();
		update();
	}

	/** 오른쪽 이동 명령을 전달합니다. */
	public void moveRightSolo() {
		GameBoardSolo.moveRight();
		update();
	}

	/**
	 * 1P의 아래이동 명령을 전달합니다.
	 * 
	 * @author 송민석
	 */
	public void moveDown1P() {
		GameBoard1P.moveDown();
		update();
	}

	/**
	 * 2P의 아래이동 명령을 전달합니다.
	 * 
	 * @author 송민석
	 */
	public void moveDown2P() {
		GameBoard2P.moveDown();
		update();
	}

	/** 아래이동 명령을 전달합니다. */
	public void moveDownSolo() {
		GameBoardSolo.moveDown();
		update();
	}

	/**
	 * 1P의 바로내림 명령을 전달합니다.
	 * 
	 * @author 송민석
	 */
	public void fastDown1P() {
		GameBoard1P.fastDown();
		// playMusic(3);
		update();
	}

	/**
	 * 2P의 바로내림 명령을 전달합니다.
	 * 
	 * @author 송민석
	 */
	public void fastDown2P() {
		GameBoard2P.fastDown();
		// playMusic(3);
		update();
	}

	/** 바로내림 명령을 전달합니다. */
	public void fastDownSolo() {
		//
		GameBoardSolo.fastDown();
		update();
	}

	/**
	 * 2P Game 을 일시정지 합니다.
	 * 
	 * @author 송민석
	 */
	public void pause() {
		stopMusic(1);
		GameBoard1P.pause();
		GameBoard2P.pause();
		totalFrame.showPausePanel();
	}

	/** Game 을 일시정지 합니다. */
	public void pauseSolo() {
		stopMusic(1);
		GameBoardSolo.pause();
		totalFrame.showPausePanelSolo();
	}

	/** Game 을 일시정지 합니다. */
	public void pauseAI() {
		stopMusic(2);
		gameBoardAIP.pause();
		gameBoardAI.pause();
		totalFrame.showPausePanelAI();
		update();
	}

	/**
	 * 2P Game 을 재개 합니다.
	 * 
	 * @author 송민석
	 */
	public void resume() {
		playMusic(1);
		GameBoard1P.resume();
		GameBoard2P.resume();
		totalFrame.show2PGamePanel();
		update();
	}

	/** Game 을 재개 합니다. */
	public void resumeSolo() {
		playMusic(1);
		GameBoardSolo.resume();
		totalFrame.showSoloGamePanel();
		update();
	}

	/** Game 을 재개 합니다. */
	public void resumeAI() {
		playMusic(2);
		gameBoardAI.resume();
		gameBoardAIP.resume();
		totalFrame.showAIGamePanel();
		update();
	}

	/**
	 * 2P Game 을 재시작 합니다.
	 * 
	 * @author 송민석
	 */
	public void restart() {
		playMusic(1);
		GameBoard1P.restart();
		GameBoard2P.restart();
		totalFrame.show2PGamePanel();
		update();
	}

	/** Game 을 재시작 합니다. */
	public void restartSolo() {
		playMusic(1);
		GameBoardSolo.restart();
		totalFrame.showSoloGamePanel();
		update();
	}

	/** Game 을 재시작 합니다. */
	public void restartAI() {
		playMusic(2);
		gameBoardAI.restart();
		gameBoardAIP.restart();
		totalFrame.showAIGamePanel();
		update();
	}

	/** 메인으로 돌아갑니다. */
	public void goMain() {
		makeIntroMusic();
		playMusic(0);
		totalFrame.showMainPanel();
	}

	/**
	 * 사용자의 점수를 얻습니다.
	 * 
	 * @author 이은경
	 * @return GameBoardSolo.getScore() int Type의 score를 반환합니다.
	 */
	public int getScore() {
		return GameBoardSolo.getScore();
	}

	/**
	 * AI GAME 에서 Player의 점수를 얻습니다.
	 * 
	 * @return int Type의 score를 반환합니다.
	 */
	public int getAIScore() {
		return gameBoardAIP.getScore();
	}

	/** SoloGame Over하면 호출됩니다. */
	public void soloGameOver() {
		stopMusic(1);
		totalFrame.soloGameOver();
	}

	/**
	 * * 2P Game이 game over하면 호출됩니다.
	 * 
	 * @author 송민석
	 * @param player
	 *            1P 와 2P 를 나타내며 Win Lose를 구분합니다.
	 * 
	 */

	public void GameOver2P(int player) {
		stopMusic(1);
		GameBoard1P.start = false;
		GameBoard2P.start = false;
		totalFrame.ZPGameLose(player);
	}

	/**
	 * AI Game이 game over 하면 호출됩니다.
	 * 
	 * @param gameMode
	 *            - 어떤 객체가 호출했는지를 알아낼 값입니다.
	 */
	public void GameOverAI(int gameMode) {
		stopMusic(2);
		gameBoardAI.start = false;
		gameBoardAIP.start = false;
		totalFrame.AIGameLose(gameMode);
	}

	/** 회전명령을 전달합니다 . */
	public void spinAI() {
		gameBoardAIP.spin();
		update();
	}

	/** 오른쪽 이동명령을 전달합니다. */
	public void moveRightAI() {
		gameBoardAIP.moveRight();
		update();
	}

	/** 왼쪽 이동명령을 전달합니다. */
	public void moveLeftAI() {
		gameBoardAIP.moveLeft();
		update();
	}

	/** 아래 이동명령을 전달합니다. */
	public void moveDownAI() {
		gameBoardAIP.moveDown();
		update();
	}

	/** 바로내림 명령을 전달합니다. */
	public void fastDownAI() {
		// playMusic(3);
		gameBoardAIP.fastDown();
		update();
	}

	/** AI 에게 바로내림명령을 전달합니다. AI의 블럭을 강제로 내릴때 사용됩니다. */
	public void AIFastDown() {
		// playMusic(3);
		gameBoardAI.fastDown();
		update();
	}

	/**
	 * 이 메소드는 라인추가명령을 전달합니다.
	 * 
	 * @param index
	 *            - 어떤 플레이어가 라인을 추가하는지를 확인할 값입니다.
	 */
	public void addLineAI(int index) {
		if (index == 3)
			gameBoardAIP.addLine();
		else
			gameBoardAI.addLine();
	}

	/**
	 * 이 메소드는 라인추가명령을 전달합니다.
	 * 
	 * @param index
	 *            - 어떤 플레이어가 라인을 추가하는지를 확인할 값입니다.
	 */
	public void addLine2P(int index) {
		if (index == 1)
			GameBoard2P.addLine();
		else
			GameBoard1P.addLine();
	}

}
