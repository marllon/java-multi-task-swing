package control;

import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingWorker;

import view.model.PanelFoo;

public class WorkerDoSomething extends SwingWorker<Void, Void> {

	private Random r = new Random();
	private PanelFoo _panel;

	WorkerDoSomething() {
	}

	public WorkerDoSomething(final PanelFoo panelFooInstance) {
		_panel = panelFooInstance;
	}

	private Integer randomInt(final int min, final int max) {
		final Integer randomNumber = this.r.nextInt((max - min) + 1) + min;

		return randomNumber;
	}

	@Override
	protected Void doInBackground() throws Exception {
		final Integer randomNumber = randomInt(10000000, 1000000000);
		for (int i = 0; i <= randomNumber; i++) {
			setProgress((i * 100) / randomNumber);
			_panel.write("Handling " + i);
			Thread.sleep(randomInt(1000, 5000));
		}

		return null;
	}


}