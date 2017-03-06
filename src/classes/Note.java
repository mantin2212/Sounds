package classes;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;

import help.*;

public class Note implements Playable {
	private int place;
	private MidiChannel channel;
	private Instrument defaultInstrument;

	public Note(int place, MidiChannel channel) {
		this.place = place;
		this.channel = channel;
		defaultInstrument = NotesHelp.defaultInstrument;
	}

	public Note(int place) {
		this.place = place;
		this.defaultInstrument = NotesHelp.defaultInstrument;
	}

	public Note() {
	}

	public void setChannel(MidiChannel newChannel) {
		this.channel = newChannel;
	}

	public int getPlace() {
		return place;
	}

	// plays the note on the default instrument
	public void play(long millis) {
		channel.programChange(defaultInstrument.getPatch().getProgram());
		channel.noteOn(place, NotesHelp.velocity);
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		channel.noteOff(place);
	}

	// plays the note on a chosen instrument
	public void play(long millis, Instrument inst) {
		channel.programChange(inst.getPatch().getProgram());
		this.play(millis);
		channel.programChange(defaultInstrument.getPatch().getProgram());
	}

	@Override
	public void setDefaultInstrument(Instrument instrument) {
		this.defaultInstrument = instrument;

	}
}
