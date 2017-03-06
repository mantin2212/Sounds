package help;

import javax.sound.midi.Instrument;
import javax.sound.midi.Synthesizer;

public class NotesHelp {

	public static final int velocity = 90;
	public static final int[] notesValues = { 9, 11, 0, 2, 4, 5, 7 };
	public static final int[] majorScale = { 0, 2, 4, 5, 7, 9, 11, 12 };
	public static final int[] minorScale = { 0, 2, 3, 5, 7, 8, 10, 12 };
	public static final String[] basicChordGroups = { "minor", "major" };
	public static Instrument[] availableInstruments;
	public static Instrument defaultInstrument;

	public static int getPlace(int first, int rank, boolean isMajor) {
		int[] scale = minorScale;
		if (isMajor)
			scale = majorScale;
		return scale[rank];
	}

	public static void initInstruments(Synthesizer synth) {
		availableInstruments = synth.getAvailableInstruments();
		defaultInstrument = availableInstruments[0];
	}

}