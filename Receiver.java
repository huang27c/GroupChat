import javax.swing.JTextArea;

/**
 * Receiver follows a sender. When a sender sends a text, the text area shows
 * the message.
 * 
 * @author Ching Ching Huang
 *
 */
public class Receiver {

	public Sender sender;
	private JTextArea display;

	/**
	 * Creates a new receiver. Follows the passed in sender.
	 * 
	 * @param group
	 * @param sender
	 * @param the
	 *            text area to display message
	 */
	public Receiver(int group, Sender sender, JTextArea display) {
		this.sender = sender;
		this.display = display;
		this.sender.register(group, this);
	}

	/**
	 * Updates the text area to show the message to the receiver
	 * 
	 * @param messge
	 *            from sender
	 */
	public void update(String msg) {
		display.append(sender.toString() + ": " + msg + "\n\r");
	}
}
