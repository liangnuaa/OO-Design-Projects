package edu.neu.ccs.cs5004;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


import javax.swing.SwingUtilities;

import javax.swing.WindowConstants;


/**
 * Represents HangmanMvcApp class.
 *
 * @author Liang
 */
public class HangmanMvcApp implements ActionListener, KeyListener {
  private Guess remainingTimes;
  private KeyWord keyWord;
  private Alphabet alphabet;
  private JFrame win = new JFrame("Hangman");

  /**
   * Create a new HangmanMvcApp.
   */
  public HangmanMvcApp() {
    super();
    remainingTimes = new Guess(6);
    keyWord = new KeyWord("sea");
    alphabet = new Alphabet();
    win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    win.setLayout(new FlowLayout());
    win.setContentPane(Box.createVerticalBox());
    win.setTitle("FlowLayout");

    GuessTimeDisplay guessTimeDisplay = new GuessTimeDisplay(remainingTimes, keyWord);
    win.add(guessTimeDisplay);
    GuessImageDisplay guessImageDisplay = new GuessImageDisplay(remainingTimes);
    win.add(guessImageDisplay);
    KeyWordDisplay keyWordDisplay = new KeyWordDisplay(keyWord);
    win.add(keyWordDisplay);

    AlphabetDisplay alphabetDisplay = new AlphabetDisplay(alphabet);
    win.add(alphabetDisplay);

    JButton click = new JButton("NEW");
    click.addActionListener(this);
    click.setActionCommand("NEW");
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(click);
    win.add(buttonPanel);

    win.addKeyListener(this);

    win.requestFocus();
    win.setFocusable(true);
    win.requestFocusInWindow();

    win.pack();
    win.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    JButton src = (JButton) event.getSource();

    if (src.getActionCommand().equals("NEW")) {
      remainingTimes.setToInitialState(6);
      keyWord.setToInitialState("sea");
      alphabet.setToInitialState();
    }
    win.requestFocus();
    win.setFocusable(true);
    win.requestFocusInWindow();
  }

  @Override
  public void keyTyped(KeyEvent event) {
    if (remainingTimes.getRemainingTimes() <= 0) {
      return;
    }
    Character character = event.getKeyChar();

    if (event.getKeyChar() >= 'a' && event.getKeyChar() <= 'z'
        && remainingTimes.getRemainingTimes() > 0 && !keyWord.isWin()) {
      keyWord.changeCharacterState(character);
      if (!keyWord.isContain(character) && !alphabet.getMap().get(character)) {
        remainingTimes.decreaseTime();
      }
      alphabet.setLetter(character);
    }
  }

  @Override
  public void keyPressed(KeyEvent event) {

  }

  @Override
  public void keyReleased(KeyEvent event) {

  }

  /**
   * Main method for HangmanMvcApp class.
   *
   * @param args for system input command
   */
  public static void main(String[] args) {
    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        HangmanMvcApp hangmanMvcApp = new HangmanMvcApp();
      }
    });
  }
}
