package programs;

import javax.sound.midi.*;

import classes.*;
import help.GeneralHelp;
import help.NotesHelp;

public class soundTest {
	public static NoteGroup[] chords = new NoteGroup[] {
			new NoteGroup(GeneralHelp.toArrayList(new int[] { 60, 64, 67 })),
			new NoteGroup(GeneralHelp.toArrayList(new int[] { 55, 59, 62 })),
			new NoteGroup(GeneralHelp.toArrayList(new int[] { 57, 60, 64 })),
			new NoteGroup(GeneralHelp.toArrayList(new int[] { 53, 57, 60 })) };

	public static void main(String[] args) throws InterruptedException {
		Synthesizer synth = null;
		try {
			synth = MidiSystem.getSynthesizer();
			synth.open();

		} catch (

		MidiUnavailableException e) {
			e.printStackTrace();
		}
		NotesHelp.initInstruments(synth);
		for (NoteGroup g : chords)
			g.updateDefaultInstrument();
		Instrument[] inst = synth.getDefaultSoundbank().getInstruments();
		MidiChannel[] ch = synth.getChannels();
		synth.unloadAllInstruments(synth.getDefaultSoundbank());
		if (synth.loadInstrument(inst[0])) {
			for (int i = 0; i < chords.length; i++) {
				chords[i].setChannel(ch[0]);
				chords[i].play(1000);
			}
			Thread.sleep(1000);
		} else
			System.out.println("instrument not loaded");
	}

}
