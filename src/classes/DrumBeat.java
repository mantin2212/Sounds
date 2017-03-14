package classes;

import java.util.ArrayList;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class DrumBeat implements Playable{
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

	public void playBeat(int bars, int beatTime) {
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
				playDrums(channel, toPlay, beatTime);
				toPlay.clear();
			}
		}
	}

	private void playDrums(MidiChannel ch, ArrayList<Integer> places, long millis) {
		for (int i : places)
			ch.noteOn(i, 90);
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i : places)
			ch.noteOff(i, 64);
	}

	@Override
	public void play(long millis) throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void play(long millis, Instrument inst) throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDefaultInstrument(Instrument instrument) {
		// TODO Auto-generated method stub
		
	}
}
