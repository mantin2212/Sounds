package classes;

import javax.sound.midi.Instrument;

public interface Playable {

	public abstract void play(long millis) throws InterruptedException;

	public abstract void play(long millis, Instrument inst) throws InterruptedException;

	public abstract void setDefaultInstrument(Instrument instrument);
}
