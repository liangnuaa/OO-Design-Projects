package edu.neu.ccs.cs5004;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents KeyWord class.
 *
 * @author Liang
 */
public class KeyWord {
  private List<Character> wordList;
  private List<KeyWordViewer> viewerList;
  private List<Boolean> booleanList;

  /**
   * Create a keyword given word.
   *
   * @param word given word
   */
  public KeyWord(String word) {
    if (word == null || word.length() == 0) {
      throw new IllegalArgumentException("Should give a valid word, length at least 1");
    }
    wordList = new ArrayList<>();
    viewerList = new ArrayList<>();
    booleanList = new ArrayList<>();
    char[] characters = word.toCharArray();
    for (char character : characters) {
      wordList.add(character);
      booleanList.add(false);
    }
  }

  /**
   * Getter for 'wordList'.
   *
   * @return the wordList
   */
  public List<Character> getWordList() {
    return wordList;
  }

  /**
   * Getter for 'booleanList'.
   *
   * @return the booleanList
   */
  public List<Boolean> getBooleanList() {
    return booleanList;
  }

  /**
   * Getter for 'viewerList'.
   *
   * @return the viewerList
   */
  public List<KeyWordViewer> getViewerList() {
    return viewerList;
  }

  /**
   * Set the state to initial state given word.
   *
   * @param word given word
   */
  public void setToInitialState(String word) {
    char[] characters = word.toCharArray();
    wordList = new ArrayList<>();
    booleanList = new ArrayList<>();
    for (char character : characters) {
      wordList.add(character);
      booleanList.add(false);
    }
    notifyAllViewers();
  }

  /**
   * Check if the word list contains the character or not.
   *
   * @param character given character
   * @return true if it contains, otherwise false
   */
  public Boolean isContain(Character character) {
    return wordList.contains(character);
  }

  /**
   * Set the state of given character in boolean list to true.
   *
   * @param character given character
   */
  public void changeCharacterState(Character character) {
    for (int i = 0; i < wordList.size(); i++) {
      if (wordList.get(i).equals(character) && !booleanList.get(i)) {
        booleanList.set(i, true);
      }
    }
    notifyAllViewers();
  }

  /**
   * Check if the game has won or not.
   *
   * @return true if win, otherwise false
   */
  public Boolean isWin() {
    return !booleanList.contains(false);
  }

  /**
   * Sign up a keyword viewer to viewer list.
   *
   * @param keyWordViewer given keyword viewer
   */
  public void signUpViewer(KeyWordViewer keyWordViewer) {
    viewerList.add(keyWordViewer);
    keyWordViewer.keyWordChanged();
  }

  /**
   * Notify all viewers in viewer list.
   */
  private void notifyAllViewers() {
    Iterator<KeyWordViewer> iterator = viewerList.iterator();
    while (iterator.hasNext()) {
      KeyWordViewer next = iterator.next();
      next.keyWordChanged();
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    KeyWord keyWord = (KeyWord) obj;

    if (!getWordList().equals(keyWord.getWordList())) {
      return false;
    }
    if (!getViewerList().equals(keyWord.getViewerList())) {
      return false;
    }
    return getBooleanList().equals(keyWord.getBooleanList());
  }

  @Override
  public int hashCode() {
    int result = getWordList().hashCode();
    result = 31 * result + getViewerList().hashCode();
    result = 31 * result + getBooleanList().hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "KeyWord{"
        + "wordList=" + wordList
        + ", viewerList=" + viewerList
        + ", booleanList=" + booleanList
        + '}';
  }
}
