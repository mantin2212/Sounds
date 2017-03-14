package classes;

import java.util.List;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;

import help.GeneralHelp;
import help.NotesHelp;

public class NoteGroup extends Playable {
	private List<Integer> notes;

	public NoteGroup() {
	}

	public NoteGroup(int[] notes) {
		this(GeneralHelp.toArrayList(notes));
	}

	public NoteGroup(List<Integer> notes) {
		this.notes = notes;
		defaultInstrument = NotesHelp.defaultInstrument;
	}

	public NoteGroup(List<Integer> notes, MidiChannel channel) {
		this.notes = notes;
		this.channel = channel;
		defaultInstrument = NotesHelp.defaultInstrument;
	}

	public void setChannel(MidiChannel newChannel) {
		this.channel = newChannel;
	}

	public void play(long millis) {
		channel.programChange(defaultInstrument.getPatch().getProgram());
		for (int i : notes)
			channel.noteOn(i, 90);

		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i : notes)
			channel.noteOff(i);

	}

	@Override
	public void setDefaultInstrument(Instrument instrument) {
		this.defaultInstrument = instrument;
	}
}
