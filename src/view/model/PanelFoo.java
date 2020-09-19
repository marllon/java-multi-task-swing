package view.model;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class PanelFoo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1400188281877395934L;
	private JLabel label;
	private JTextArea textArea;
	private JScrollPane scrollPanel;
	private JProgressBar progressBar;

	public PanelFoo(final List<String> listOfStates) {
		setLayout(new FlowLayout());
		setSize(180, 400);
		final ImageIcon icon = createImageIcon("/images/waiting-list.png", "waiting start");
		this.label = new JLabel(listOfStates.get(0), icon, SwingConstants.HORIZONTAL);
		add(this.label);

		this.textArea = new JTextArea("Numbers: \n");
		this.textArea.setWrapStyleWord(true);
		this.scrollPanel = new JScrollPane(this.textArea);
		this.scrollPanel.setPreferredSize(new Dimension(150, 350));

		this.progressBar = new JProgressBar(0, 100);

		add(this.scrollPanel);
		add(this.progressBar);

		setVisible(true);
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	public ImageIcon createImageIcon(final String path, final String description) {
		if (path != null) {
			ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
			final Image image = imageIcon.getImage(); 
			final Image newimg = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(newimg, description);
			return imageIcon;

		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	public final JLabel getLabel() {
		return this.label;
	}

	public final void setLabel(final JLabel label) {
		this.label = label;
	}

	public final JTextArea getTextArea() {
		return this.textArea;
	}

	public final void setTextArea(final JTextArea textArea) {
		this.textArea = textArea;
	}

	public final JProgressBar getProgressBar() {
		return this.progressBar;
	}

	public final void setProgressBar(final JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

}
