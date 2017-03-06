package trying;

import java.util.ArrayList;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class DrumsBasic {
	

	public DrumsBasic() {
		Synthesizer synth = null;
		try {
			synth = MidiSystem.getSynthesizer();
			synth.open();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
		MidiChannel ch = synth.getChannels()[9];
		System.out.println("starting");
		playRockBeat(4, ch, toArrayList(new int[] { 2, 6, 10, 14 }), toArrayList(new int[] { 0, 4, 5, 8, 9, 11, 13 }),
				300);

	}

	public void playRockBeat(int bars, MidiChannel ch, ArrayList<Integer> snares, ArrayList<Integer> kicks,
			int beatTime) {
		ArrayList<Integer> toPlay = new ArrayList<Integer>();
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

				playDrums(ch, toPlay, beatTime);
				toPlay.clear();
			}
		}
	}

	public void playDrums(MidiChannel ch, ArrayList<Integer> places, long millis) {
		for (int i : places)
			ch.noteOn(i, 64);
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i : places)
			ch.noteOff(i, 64);
	}

	public static void main(String[] args) {
		new DrumsBasic();
	}
}
