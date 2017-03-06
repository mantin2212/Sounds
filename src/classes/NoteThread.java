package classes;


public class NoteThread extends Thread {
	private Note note;
	private long millis;

	public NoteThread(Note note, long millis) {
		this.note = note;
		this.millis = millis;
	}

	@Override
	public void run() {
		note.play(millis);
	}
}
