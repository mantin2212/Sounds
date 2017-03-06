package programs;

import classes.*;
import help.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.*;

public class Chords extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	public static long chordLength = 1000;
	private JPanel main;
	private JComboBox<String> notes;
	private JComboBox<String> basicChordsGroup;
	private JComboBox<String> chordTypes;
	private Synthesizer synth;
	private MidiChannel channel;

	public void actionPerformed(ActionEvent e) {
		ChordsCollection.playChord((String) chordTypes.getSelectedItem(),
				StringHelp.toNote((String) notes.getSelectedItem()), channel,
				(String) basicChordsGroup.getSelectedItem(), Chords.chordLength);
	}

	public void startSounds() throws MidiUnavailableException {
		synth = GeneralHelp.startSynthesizer();
		synth.loadInstrument(synth.getAvailableInstruments()[0]);
		channel = synth.getChannels()[0];
		NotesHelp.startCollection();
	}

	public void startPanel() {
		main = new JPanel();
		main.setVisible(true);
		main.setLayout(new GridLayout(1, 4));
		notes = new JComboBox<String>(StringHelp.notes);
		basicChordsGroup = new JComboBox<String>(NotesHelp.basicChordGroups);
		chordTypes = new JComboBox<String>(classes.ChordsCollection.getNames());
		JButton play = new JButton("play");
		play.addActionListener(this);
		notes.setVisible(true);
		main.add(notes);
		main.add(chordTypes);
		main.add(basicChordsGroup);
		main.add(play);
	}

	public Chords() throws MidiUnavailableException {
		super();
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 0, 1000, 1000);
		startSounds();
		startPanel();
		this.add(main, BorderLayout.CENTER);
	}

	public static void main(String[] args) throws MidiUnavailableException {
		new Chords();
	}

	public static void cMajChord() throws MidiUnavailableException {
		Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open();
		final MidiChannel[] ch = synth.getChannels();
		(new Thread(new Runnable() {
			@Override
			public void run() {
				(new Note(60, ch[0])).play(1000);
			}
		})).start();
		(new Thread(new Runnable() {
			@Override
			public void run() {
				(new Note(64, ch[0])).play(1000);
			}
		})).start();
		(new Thread(new Runnable() {
			@Override
			public void run() {
				(new Note(67, ch[0])).play(1000);
			}
		})).start();
	}
}
