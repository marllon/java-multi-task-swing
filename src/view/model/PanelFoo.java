package view.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class PanelFoo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1400188281877395934L;
	private JLabel label;
	private JTextPane textArea;
	private JScrollPane scrollPanel;
	private JProgressBar progressBar;

	public PanelFoo(final List<String> listOfStates) {
		setLayout(new FlowLayout());
		setSize(180, 400);
		final ImageIcon iconStatus = createImageIcon("waiting-list.png", "waiting start");
		this.label = new JLabel(listOfStates.get(0), iconStatus, SwingConstants.HORIZONTAL);
		add(this.label);

		this.textArea = new JTextPane();
		this.textArea.setEditable(false);
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
			ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/" + path));
			final Image image = imageIcon.getImage(); 
			final Image newimg = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(newimg, description);
			return imageIcon;

		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	
	public void write(String msg)
	{
		StyledDocument doc = textArea.getStyledDocument();

		//  Define a keyword attribute

		//  Add some text

		try
		{
		    doc.insertString(textArea.getStyledDocument().getLength(), msg+ "\n", null );
		    textArea.setCaretPosition(textArea.getStyledDocument().getLength());
		}
		catch(Exception e) { System.out.println(e); }
	}

	public final JLabel getLabel() {
		return this.label;
	}

	public final void setLabel(final JLabel label) {
		this.label = label;
	}

	public JTextPane getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextPane textArea) {
		this.textArea = textArea;
	}

	public final JProgressBar getProgressBar() {
		return this.progressBar;
	}

	public final void setProgressBar(final JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

}
