package help;

import classes.Note;

public class StringHelp {
	public static final String[] notes = { "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B" };
	public static final String[] chordTypes = { "minor", "major" };

	public static int StringToPlaceOfNote(String note) {
		if (isNote(note))
			return (36 + getIndex(note));
		else
			return -1;
	}

	public static int getIndex(String note) {
		for (int i = 0; i < notes.length; i++) {
			if (notes[i].equals(note))
				return i;
		}
		return -1;
	}

	public static boolean isNoteLegal(String note) {
		if (isNote(note.substring(0, note.length() - 2)) && note.charAt(1) < '9' && note.charAt(1) > '0')
			return true;
		return false;
	}

	public static boolean isNote(String s) {
		for (int i = 0; i < notes.length; i++)
			if (s.equals(notes[i]))
				return true;
		return false;
	}

	public static Note toNote(String note) {
		if (isNote(note))
			return new Note(StringToPlaceOfNote(note));
		else
			new IllegalAccessException("note not legal");
		return null;
	}
}
