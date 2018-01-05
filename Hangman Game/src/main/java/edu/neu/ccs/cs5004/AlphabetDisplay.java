package edu.neu.ccs.cs5004;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.Box;

import javax.swing.BoxLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Represents AlphabetDisplay class.
 *
 * @author Liang
 */
public class AlphabetDisplay extends JPanel implements AlphabetViewer {
  private Alphabet alphabet;
  private JPanel alphabetPanel;
  private java.util.List<JLabel> labelList;

  /**
   * Create a new AlphabetDisplay.
   *
   * @param alphabet given alphabet
   */
  public AlphabetDisplay(Alphabet alphabet) {
    this.alphabet = alphabet;
    labelList = new ArrayList<>();
    setPreferredSize(new Dimension(600, 50));
    Font font = new Font("Monospaced", Font.BOLD, 15);
    alphabetPanel = new JPanel();
    alphabetPanel.setLayout(new BoxLayout(alphabetPanel, BoxLayout.X_AXIS));
    for (Map.Entry<Character, Boolean> entry : alphabet.getMap().entrySet()) {
      JLabel jlabel = new JLabel();
      jlabel.setFont(font);
      jlabel.setBackground(Color.white);
      jlabel.setText(entry.getKey().toString());
      jlabel.setForeground(Color.lightGray);
      labelList.add(jlabel);
      add(jlabel);
      add(Box.createGlue());
    }
    alphabet.signUpViewer(this);
    setBackground(Color.white);
  }

  @Override
  public void alphabetChanged() {
    Font font = new Font("Monospaced", Font.BOLD, 15);
    for (Map.Entry<Character, Boolean> entry : alphabet.getMap().entrySet()) {
      JLabel jlabel = labelList.get(entry.getKey() - 'a');
      jlabel.setFont(font);
      labelList.set(entry.getKey() - 'a', jlabel);
      if (entry.getValue()) {
        jlabel.setForeground(Color.BLUE);
      } else {
        jlabel.setForeground(Color.LIGHT_GRAY);
      }
    }
  }
}
