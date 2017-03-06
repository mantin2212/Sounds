package help;

import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.JFrame;

public class GeneralHelp {
	public static void startFrame(JFrame frame, String title, LayoutManager l) {
		frame = new JFrame(title);
		frame.setVisible(true);
		frame.setLayout(l);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static Synthesizer startSynthesizer() throws MidiUnavailableException {
		Synthesizer s = MidiSystem.getSynthesizer();
		s.open();
		return s;

	}

	public static Object[] enlargeArray(Object[] old, int toAdd) {
		Object[] newArr = new Object[old.length + toAdd];
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = old[i];
		}
		return newArr;
	}

	public static ArrayList<Integer> toArrayList(int[] arr) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int a : arr) {
			result.add(a);
		}
		return result;
	}

	public static int[] toArray(ArrayList<Integer> arr) {
		int[] result = new int[arr.size()];
		for (int i = 0; i < arr.size(); i++)
			result[i] = arr.get(i);
		return result;
	}
}
