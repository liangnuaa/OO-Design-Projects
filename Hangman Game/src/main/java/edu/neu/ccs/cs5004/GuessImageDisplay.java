package edu.neu.ccs.cs5004;

import java.awt.Dimension;

import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Represents GuessImageDisplay class.
 *
 * @author Liang
 */
public class GuessImageDisplay extends JPanel implements GuessViewer {
  private Guess remainingTimes;
  private JLabel imageLable;

  /**
   * Create a new GuessImageDisplay.
   *
   * @param remainingTimes given remaining time
   */
  public GuessImageDisplay(Guess remainingTimes) {
    this.remainingTimes = remainingTimes;
    ImageIcon image = new ImageIcon("images/Hangman"
        + remainingTimes.getRemainingTimes() + ".png");
    setPreferredSize(new Dimension(600, 700));
    imageLable = new JLabel("", image, JLabel.CENTER);
    add(imageLable);
    remainingTimes.signUpViewer(this);
  }

  @Override
  public void guessChanged() {
    imageLable.setIcon(new ImageIcon("images/Hangman"
        + remainingTimes.getRemainingTimes() + ".png"));
  }
}
