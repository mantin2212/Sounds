package classes;

import javax.sound.midi.MidiChannel;
import help.*;

public class ChordType {
	private int[] ranks;
	private String name;

	public ChordType(int[] ranks, String name) {
		this.ranks = ranks;
		this.name = name;
	}

	public void playChord(int first, MidiChannel channel, long millis, String type) {
		NoteGroup chord = this.getAsGroup(first, type);
		chord.setChannel(channel);
		chord.play(millis);
	}

	public String getName() {
		return name;
	}

	private NoteGroup getAsGroup(int first, String type) {
		boolean isMajor = type.equalsIgnoreCase("major");
		int[] chord = new int[ranks.length];
		for (int i = 0; i < ranks.length; i++) {
			chord[i] = NotesHelp.getPlace(first, ranks[i], isMajor);
		}
		return new NoteGroup(chord);
	}
}
