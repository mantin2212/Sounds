package programs;

import classes.*;
import help.*;

import java.util.Scanner;
import javax.sound.midi.*;

public class lol {
	public static Scanner in = new Scanner(System.in);
	private Note C5 = new Note(60, null);
	private Note D5 = new Note(62, null);
	private Note E5 = new Note(64, null);
	private Note F5 = new Note(65, null);
	private Note G5 = new Note(67, null);
	private Note C6 = new Note(72, null);
	private Note C4 = new Note(36, null);
	private NoteGroup CmajChord = new NoteGroup(new int[] { 48, 52, 55 }, null);
	private NoteGroup G7majChord = new NoteGroup(new int[] { 43, 47, 50, 53 }, null);
	private int quarterMillis;

	public lol(int bpm, int instrument) throws MidiUnavailableException {
		quarterMillis = 60000 / bpm;
		Synthesizer synth = GeneralHelp.startSynthesizer();
		Instrument inst = synth.getAvailableInstruments()[instrument];
		MidiChannel ch = synth.getChannels()[0];

		C5.setDefaultInstrument(inst);
		D5.setDefaultInstrument(inst);
		E5.setDefaultInstrument(inst);
		F5.setDefaultInstrument(inst);
		G5.setDefaultInstrument(inst);
		C6.setDefaultInstrument(inst);
		C4.setDefaultInstrument(inst);
		CmajChord.setDefaultInstrument(inst);
		G7majChord.setDefaultInstrument(inst);
		C5.setChannel(ch);
		D5.setChannel(ch);
		E5.setChannel(ch);
		F5.setChannel(ch);
		G5.setChannel(ch);
		C6.setChannel(ch);
		C4.setChannel(ch);
		CmajChord.setChannel(ch);
		G7majChord.setChannel(ch);
		Thread melodyT = new Thread(new Runnable() {
			@Override
			public void run() {
				intro();
				part1();
				intro();
				part2();
				part3();
				intro();
				part2();
				outro();
			}
		});
		Thread chordsT = new Thread(new Runnable() {

			@Override
			public void run() {
				chords();
			}
		});
		melodyT.start();
		chordsT.start();
	}

	public void chords() {
		CmajChord.play(quarterMillis * 2);
		G7majChord.play(quarterMillis * 2);
		CmajChord.play(quarterMillis * 4);
		CmajChord.play(quarterMillis * 2);
		G7majChord.play(quarterMillis * 2);
		CmajChord.play(quarterMillis);
		G7majChord.play(quarterMillis);
		CmajChord.play(quarterMillis * 2);
		G7majChord.play(quarterMillis * 4);
		CmajChord.play(quarterMillis * 4);
		CmajChord.play(quarterMillis * 2);
		G7majChord.play(quarterMillis * 2);
		CmajChord.play(quarterMillis);
		G7majChord.play(quarterMillis);
		CmajChord.play(quarterMillis * 2);
	}

	public void intro() {
		G5.play(quarterMillis / 2);
		E5.play(quarterMillis / 2);
		E5.play(quarterMillis);
		F5.play(quarterMillis / 2);
		D5.play(quarterMillis / 2);
		D5.play(quarterMillis);

	}

	public void part1() {
		C5.play(quarterMillis / 2);
		D5.play(quarterMillis / 2);
		E5.play(quarterMillis / 2);
		F5.play(quarterMillis / 2);
		G5.play(quarterMillis / 2);
		G5.play(quarterMillis / 2);
		G5.play(quarterMillis);
	}

	public void part2() {
		C5.play(quarterMillis / 2);
		E5.play(quarterMillis / 2);
		G5.play(quarterMillis / 2);
		G5.play(quarterMillis / 2);
		C5.play(quarterMillis * 2);
	}

	public void part3() {
		D5.play(quarterMillis / 2);
		D5.play(quarterMillis / 2);
		D5.play(quarterMillis / 2);
		D5.play(quarterMillis / 2);
		D5.play(quarterMillis / 2);
		E5.play(quarterMillis / 2);
		F5.play(quarterMillis);
		E5.play(quarterMillis / 2);
		E5.play(quarterMillis / 2);
		E5.play(quarterMillis / 2);
		E5.play(quarterMillis / 2);
		E5.play(quarterMillis / 2);
		F5.play(quarterMillis / 2);
		G5.play(quarterMillis);
	}

	public void outro() {
		try {
			Thread.sleep(quarterMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		G5.play(quarterMillis);
		C6.play(quarterMillis);
		C4.play(quarterMillis);
	}

	public static void main(String[] args) throws MidiUnavailableException {
		System.out.println("enter speed(bpm), and instrument number:");

		new lol(in.nextInt(), in.nextInt());
	}

}
