package trying;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

import classes.NoteGroup;
import help.NotesHelp;

public class TryingChords {

	public TryingChords() {

	}

	public static void main(String[] args) throws MidiUnavailableException {
		Synthesizer synth = MidiSystem.getSynthesizer();
		NotesHelp.initInstruments(synth);
		synth.open();
		synth.loadInstrument(synth.getAvailableInstruments()[0]);
		MidiChannel ch = synth.getChannels()[0];
		NoteGroup c = new NoteGroup(new int[] { 48, 52, 55 });
		NoteGroup c4 = new NoteGroup(new int[] { 48, 53, 55 });
		c.setChannel(ch);
		c4.setChannel(ch);
		int a = 150;
		c.play(8 * a);
		c.play(8 * a);
		c.play(7 * a);
		c4.play(4 * a);
		c.play(5 * a);
	}

}
