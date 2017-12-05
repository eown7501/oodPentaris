package view;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;

/**
 * 이 ViewPausePanelSolo는 Solo Game진행 도중 esc를 눌렀을 시 Pause화면의 Panel을 구성하고 보여주는
 * 클래스입니다.
 * 
 * @author 송민석
 * 
 */
public class ViewPausePanelSolo extends JPanel implements IViewPanel {
	/** ViewTotalFrame Type의 변수 입니다 */
	private ViewTotalFrame totalFrame;
	/** JButton Type의 변수 입니다 */
	private JButton resumebt, restartbt, goMainbt;
	/** 폰트 색상을 지정할 변수 입니다 */
	private Color setFontColor = new Color(244, 29, 0);

	/**
	 * ViewPausePanel을 생성합니다.
	 * 
	 * @param totalFrame
	 *            - 명령을 전달받을 totalFrame 입니다.
	 */
	public ViewPausePanelSolo(ViewTotalFrame totalFrame) {
		this.totalFrame = totalFrame;
		init();

	}

	/** 초기값 설정을 합니다. */
	public void init() {
		setBackground(new Color(90, 90, 90, 255)); // 투명
		addButton();
		addListener();

		setLayout(null);

	}

	/** 스윙 컴포넌트가 자신의 모양을 그립니다. */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		totalFrame.drawSolo(g);

	}

	/** Button의 기본 설정을 세팅합니다. */
	public void addButton() {

		resumebt = new JButton("Resume");
		resumebt.setFont(new Font("Forte", Font.PLAIN, 45));
		resumebt.setBounds(297, 200, 450, 60);
		resumebt.setBorderPainted(false);
		resumebt.setForeground(setFontColor);
		resumebt.setFocusable(false);
		resumebt.setContentAreaFilled(false);

		restartbt = new JButton("Restart");
		restartbt.setFont(new Font("Forte", Font.PLAIN, 45));
		restartbt.setBounds(297, 290, 450, 60);
		restartbt.setBorderPainted(false);
		restartbt.setForeground(setFontColor);
		restartbt.setFocusable(false);
		restartbt.setContentAreaFilled(false);

		goMainbt = new JButton("Go Main");
		goMainbt.setFont(new Font("Forte", Font.PLAIN, 45));
		goMainbt.setBounds(297, 380, 450, 60);
		goMainbt.setBorderPainted(false);
		goMainbt.setForeground(setFontColor);
		goMainbt.setFocusable(false);
		goMainbt.setContentAreaFilled(false);

		this.add(resumebt);
		this.add(restartbt);
		this.add(goMainbt);
	}

	/** Button에 MouseListener를 삽입합니다. */
	public void addListener() {
		resumebt.addMouseListener(makeMouseListener());
		restartbt.addMouseListener(makeMouseListener());
		goMainbt.addMouseListener(makeMouseListener());
	}

	/** MouseLister를 구현합니다. */
	public MouseListener makeMouseListener() {
		return new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if (e.getSource() == resumebt) {
					resumebt.setFont(new Font("Forte", Font.PLAIN, 55));

				}
				if (e.getSource() == restartbt) {
					restartbt.setFont(new Font("Forte", Font.PLAIN, 55));
				}
				if (e.getSource() == goMainbt) {
					goMainbt.setFont(new Font("Forte", Font.PLAIN, 55));
				}
			}

			public void mouseExited(MouseEvent e) {
				if (e.getSource() == resumebt) {
					resumebt.setFont(new Font("Forte", Font.PLAIN, 45));

				}
				if (e.getSource() == restartbt) {
					restartbt.setFont(new Font("Forte", Font.PLAIN, 45));
				}
				if (e.getSource() == goMainbt) {
					goMainbt.setFont(new Font("Forte", Font.PLAIN, 45));
				}
			}

			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == resumebt) {
					resumeSolo();
				}
				if (e.getSource() == restartbt) {
					restartSolo();
				}
				if (e.getSource() == goMainbt) {
					goMain();
				}
			}
		};

	}

	/** 계속하기 명령을 전달합니다. */
	public void resumeSolo() {
		totalFrame.resumeSolo();
	}

	/** 재시작 명령을 전달합니다. */
	public void restartSolo() {
		totalFrame.restartSolo();
	}

	/** Main화면으로 이동 명령을 전달합니다. */
	public void goMain() {
		totalFrame.goMain();
	}
}
