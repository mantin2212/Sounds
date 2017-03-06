package classes;

import java.util.ArrayList;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class DrumBeat {
	private int cymbalPlace;
	private int length;
	private ArrayList<Integer> snares;
	private ArrayList<Integer> kicks;
	private final MidiChannel channel;

	public DrumBeat(ArrayList<Integer> snares, ArrayList<Integer> kicks, int length, int cymbalPlace) {
		this.snares = snares;
		this.kicks = kicks;
		this.length = length;
		this.cymbalPlace = cymbalPlace;
		Synthesizer synth = null;
		try {
			synth = MidiSystem.getSynthesizer();
			synth.open();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
		channel = synth.getChannels()[9];
	}

	public void playBeat() {
	}

	public void playRockBeat(int bars, int beatTime) {
		ArrayList<Integer> toPlay = new ArrayList<Integer>();
		NoteGroup drums = new NoteGroup();
		int snaresCount = 0, kicksCount = 0;
		for (int b = 0; b < bars; b++) {
			snaresCount = 0;
			kicksCount = 0;
			for (int i = 0; i < 16; i++) {
				if (i == 0)
					toPlay.add(49);
				else
					toPlay.add(42);
				if (snares.size() != snaresCount) {
					if (snares.get(snaresCount) == i) {
						toPlay.add(38);
						snaresCount++;
					}
				}
				if (kicks.size() != kicksCount) {
					if (kicks.get(kicksCount) == i) {
						toPlay.add(35);
						kicksCount++;
					}
				}

				playDrums(channel, toPlay, beatTime);
				toPlay.clear();
			}
		}
	}
}
