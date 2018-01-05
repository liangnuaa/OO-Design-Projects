package edu.neu.ccs.cs5004;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

import javax.swing.JPanel;


/**
 * Represents GuessTimeDisplay class.
 *
 * @author Liang
 */
public class GuessTimeDisplay extends JPanel implements GuessViewer, KeyWordViewer {
  private Guess remainingTimes;
  private KeyWord keyWord;
  private JLabel guessDisp;

  /**
   * Create a new GuessTimeDisplay.
   *
   * @param remainingTimes given remaining times
   * @param keyWord        given keyword
   */
  public GuessTimeDisplay(Guess remainingTimes, KeyWord keyWord) {
    this.remainingTimes = remainingTimes;
    this.keyWord = keyWord;
    setPreferredSize(new Dimension(600, 30));
    Font font = new Font("Monospaced", Font.BOLD, 20);
    guessDisp = new JLabel(remainingTimes.getRemainingTimes() + "guesses left!");
    guessDisp.setFont(font);
    add(guessDisp);
    remainingTimes.signUpViewer(this);
    keyWord.signUpViewer(this);
    setBackground(Color.white);
  }

  @Override
  public void guessChanged() {
    // got notified that state of Model has changed.
    // so update display
    if (keyWord.isWin()) {
      return;
    }

    if (remainingTimes.getRemainingTimes() <= 0) {
      StringBuilder res = new StringBuilder();
      for (char character : keyWord.getWordList()) {
        res.append(character);
      }
      guessDisp.setText("You lost!(" + res.toString() + ")");
      return;
    }

    guessDisp.setText(remainingTimes.getRemainingTimes() + " guesses left");
  }

  @Override
  public void keyWordChanged() {
    if (remainingTimes.getRemainingTimes() >= 0 && keyWord.isWin()) {
      guessDisp.setText("You won with "
          + remainingTimes.getRemainingTimes() + " guesses left");
    }
  }
}
