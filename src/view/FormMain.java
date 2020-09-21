package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import control.WorkerDoSomething;
import model.AuthenticationUser;
import view.model.PanelFoo;
import javax.swing.BoxLayout;

public class FormMain extends JFrame {
	private JButton btnStart, btnStop;
	private JPanel _panelTop, _panelMid, _panelBot;

	private PanelFoo panelFooA, panelFooB, panelFooC, panelFooD;

	private final List<String> ugsRj = Arrays.asList("AB");
	private final List<String> ugsMg = Arrays.asList("CD", "EF");
	private final List<String> ugsBA = Arrays.asList("GH", "IJ", "KL");
	private final List<String> ugsPE = Arrays.asList("MN", "OP", "RS", "TU");

	private void initialize() {
		this._panelTop = new JPanel();
		this._panelMid = new JPanel();
		this._panelBot = new JPanel();

		this.btnStart = new JButton("Start");
		this.btnStop = new JButton("Stop");
		this._panelBot.add(this.btnStart);

		this.panelFooA = new PanelFoo(this.ugsRj);
		this.panelFooB = new PanelFoo(this.ugsMg);
		this.panelFooC = new PanelFoo(this.ugsBA);
		this.panelFooD = new PanelFoo(this.ugsPE);
		_panelMid.setLayout(new BoxLayout(_panelMid, BoxLayout.X_AXIS));

		this._panelMid.add(this.panelFooA);
		this._panelMid.add(this.panelFooB);
		this._panelMid.add(this.panelFooC);
		this._panelMid.add(this.panelFooD);

	}

	public FormMain() {
		initialize();
		getContentPane().setLayout(new BorderLayout());
		setSize(800, 516);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(this._panelTop, BorderLayout.NORTH);
		getContentPane().add(this._panelMid, BorderLayout.CENTER);
		getContentPane().add(this._panelBot, BorderLayout.SOUTH);

		this.btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				final AuthenticationUser auth = new AuthenticationUser();
				auth.setUser("test");
				auth.setPassword("p@ss");
//
				final WorkerDoSomething w1 = new WorkerDoSomething(panelFooA);
				w1.addPropertyChangeListener(new ProgressListener(panelFooA.getProgressBar()));
				final WorkerDoSomething w2 = new WorkerDoSomething(panelFooB);
				w2.addPropertyChangeListener(new ProgressListener(panelFooB.getProgressBar()));
				final WorkerDoSomething w3 = new WorkerDoSomething(panelFooC);
				w3.addPropertyChangeListener(new ProgressListener(panelFooC.getProgressBar()));
				final WorkerDoSomething w4 = new WorkerDoSomething(panelFooD);
				w4.addPropertyChangeListener(new ProgressListener(panelFooD.getProgressBar()));

				w1.execute();
				w2.execute();
				w3.execute();
				w4.execute();

			}
		});

	}
}
