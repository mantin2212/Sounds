package classes;

import javax.sound.midi.MidiChannel;

import help.NotesHelp;

public class Note extends Playable {
	private int place;

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

}
