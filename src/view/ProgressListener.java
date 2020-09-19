package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JProgressBar;

public class ProgressListener implements PropertyChangeListener {
	private JProgressBar bar;

	ProgressListener() {
	}

	ProgressListener(final JProgressBar b) {
		this.bar = b;
		this.bar.setValue(0);
	}

	@Override
	public void propertyChange(final PropertyChangeEvent evt) {
		// Determine whether the property is progress type
		if ("progress".equals(evt.getPropertyName())) {
			this.bar.setValue((int) evt.getNewValue());
		}
	}
}
