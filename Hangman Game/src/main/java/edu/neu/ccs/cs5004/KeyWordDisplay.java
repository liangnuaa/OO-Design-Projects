package edu.neu.ccs.cs5004;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Represents KeyWordDisplay class.
 *
 * @author Liang
 */
public class KeyWordDisplay extends JPanel implements KeyWordViewer {
  private KeyWord keyWord;
  private JLabel keyWordLabel;

  /**
   * Create a new KeyWordDisplay.
   *
   * @param keyWord given keyword
   */
  public KeyWordDisplay(KeyWord keyWord) {
    this.keyWord = keyWord;
    setPreferredSize(new Dimension(600, 30));
    Font font = new Font("Monospaced", Font.BOLD, 20);
    int wordLength = keyWord.getWordList().size();
    StringBuilder initialString = new StringBuilder();
    for (int i = 0; i < wordLength; i++) {
      initialString.append("?");
    }
    keyWordLabel = new JLabel(initialString.toString());
    keyWordLabel.setFont(font);
    add(keyWordLabel);
    keyWord.signUpViewer(this);
    setBackground(Color.white);
  }

  @Override
  public void keyWordChanged() {
    int wordLength = keyWord.getWordList().size();
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < wordLength; i++) {
      if (keyWord.getBooleanList().get(i)) {
        res.append(keyWord.getWordList().get(i));
      } else {
        res.append("?");
      }
    }
    keyWordLabel.setText(res.toString());
  }
}
