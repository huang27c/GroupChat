import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

/**
 * Sender can be part of two groups, and it can decide which group the receiver
 * goes to and which group to notify.
 * 
 * @author Ching Ching Huang
 *
 */
public class Sender {

	// two groups the sender is part of
	private List<ArrayList<Receiver>> groups = new ArrayList<ArrayList<Receiver>>();
	private List<Receiver> group1 = new ArrayList<Receiver>();
	private List<Receiver> group2 = new ArrayList<Receiver>();
	private String msg;
	private String name;

	/**
	 * Takes in a name when a sender is created
	 * 
	 * @param name
	 */
	public Sender(String name) {
		this.name = name;
	}

	/**
	 * Send message to the group and show the text on its own text area
	 * 
	 * @param group
	 * @param msg
	 * @param display
	 */
	public void sendMsg(int group, String msg, JTextArea display) {
		this.msg = msg;
		// print out the message on sender's text area
		String output = "me" + ": " + msg;
		display.append(output + "\n\r");
		// decide which group to notify
		if (group == 1) {
			notifyAllObservers(group1);
		} else {
			notifyAllObservers(group2);
		}

	}

	/**
	 * Add receivers in the list according to the group number
	 * 
	 * @param group
	 * @param receiver
	 */
	public void register(int group, Receiver receiver) {
		if (group == 1) {
			group1.add(receiver);
		} else {
			group2.add(receiver);
		}

	}

	/**
	 * Notify all the observers on the list
	 * 
	 * @param group
	 */
	public void notifyAllObservers(List<Receiver> group) {
		for (Receiver receiver : group) {
			receiver.update(msg);
		}
	}

	/**
	 * Return the name of the sender
	 */
	public String toString() {
		return name;
	}
}