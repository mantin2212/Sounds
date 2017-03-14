package classes;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;

public abstract class Playable {
	protected MidiChannel channel;
	protected Instrument defaultInstrument;

	public abstract void play(long millis) throws InterruptedException;

	public void play(long millis, Instrument inst) throws InterruptedException {
		channel.programChange(inst.getPatch().getProgram());
		play(millis);
		channel.programChange(defaultInstrument.getPatch().getProgram());
	}

	public void setDefaultInstrument(Instrument instrument) {
		this.defaultInstrument = instrument;
	}
}
