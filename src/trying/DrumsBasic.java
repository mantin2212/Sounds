package trying;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		playRockBeat(4, ch, Arrays.asList(2, 6, 10, 14), Arrays.asList(0, 4, 5, 8, 9, 11, 13), 300);

	}

	public void playRockBeat(int bars, MidiChannel ch, List<Integer> snares, List<Integer> kicks, int beatTime) {
		ArrayList<Integer> toPlay = new ArrayList<Integer>();
		for (int b = 0; b < bars; b++) {
			for (int i = 0; i < 16; i++) {
				if (i == 0)
					toPlay.add(49);
				else
					toPlay.add(42);
				if (snares.contains(i))
					toPlay.add(38);
				if (snares.contains(i))
					toPlay.add(35);
				playDrums(ch, toPlay, beatTime);
				toPlay.clear();
			}
		}

	}

	

	public static void main(String[] args) {
		new DrumsBasic();
	}
}
