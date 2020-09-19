package control;

import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import view.model.PanelFoo;

public class WorkerDoSomething extends SwingWorker<Void, Void> {

	private JTextArea txtArea;
	private JLabel label;
	private Random r = new Random();

	WorkerDoSomething() {
	}

	public WorkerDoSomething(final PanelFoo panelFooInstance) {
		this.txtArea = panelFooInstance.getTextArea();
		this.label = panelFooInstance.getLabel();
	}

	private Integer randomInt(final int min, final int max) {
		final Integer randomNumber = this.r.nextInt((max - min) + 1) + min;

		return randomNumber;
	}

	@Override
	protected Void doInBackground() throws Exception {
		final Integer randomNumber = randomInt(10000000, 1000000000);
		long j;
		int progress = 0;
		final int onePerCent = randomNumber / 100;
		final int onePerMillion = onePerCent / 10;
		for (j = 0; j <= randomNumber; j++) {
			if (j % onePerCent == 0) {
				progress = (int) j / onePerCent;
				setProgress(progress);
			}
			if (j % onePerMillion == 0) {
				publish(j);
			}
			Thread.sleep(randomInt(1000, 5000));
		}
		
		return null;
	}

	private void publish(final long num) {
		this.txtArea.append(num + "\n");
		this.txtArea.setCaretPosition(this.txtArea.getDocument().getLength());
	}

}