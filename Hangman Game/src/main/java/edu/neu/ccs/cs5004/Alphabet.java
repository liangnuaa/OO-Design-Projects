package edu.neu.ccs.cs5004;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Represents Alphabet class.
 *
 * @author Liang
 */
public class Alphabet {
  private Map<Character, Boolean> map;
  private List<AlphabetViewer> alphabetViewerList;

  /**
   * Create a new Alphabet.
   */
  public Alphabet() {
    map = new TreeMap<Character, Boolean>();
    map.put('a', false);
    map.put('b', false);
    map.put('c', false);
    map.put('d', false);
    map.put('e', false);
    map.put('f', false);
    map.put('g', false);
    map.put('h', false);
    map.put('i', false);
    map.put('j', false);
    map.put('k', false);
    map.put('l', false);
    map.put('m', false);
    map.put('n', false);
    map.put('o', false);
    map.put('p', false);
    map.put('q', false);
    map.put('r', false);
    map.put('s', false);
    map.put('t', false);
    map.put('u', false);
    map.put('v', false);
    map.put('w', false);
    map.put('x', false);
    map.put('y', false);
    map.put('z', false);

    alphabetViewerList = new ArrayList<>();
  }

  /**
   * Getter for 'map'.
   *
   * @return the map
   */
  public Map<Character, Boolean> getMap() {
    return map;
  }

  /**
   * Getter for 'alphabetViewerList'.
   *
   * @return the alphabetViewerList
   */
  public List<AlphabetViewer> getAlphabetViewerList() {
    return alphabetViewerList;
  }

  /**
   * Set map to original state when created.
   */
  public void setToInitialState() {
    map = new TreeMap<Character, Boolean>();
    map.put('a', false);
    map.put('b', false);
    map.put('c', false);
    map.put('d', false);
    map.put('e', false);
    map.put('f', false);
    map.put('g', false);
    map.put('h', false);
    map.put('i', false);
    map.put('j', false);
    map.put('k', false);
    map.put('l', false);
    map.put('m', false);
    map.put('n', false);
    map.put('o', false);
    map.put('p', false);
    map.put('q', false);
    map.put('r', false);
    map.put('s', false);
    map.put('t', false);
    map.put('u', false);
    map.put('v', false);
    map.put('w', false);
    map.put('x', false);
    map.put('y', false);
    map.put('z', false);
    notifyAllViewers();
  }

  /**
   * Set value of the given character to true.
   *
   * @param character given character
   */
  public void setLetter(Character character) {
    if (!map.get(character)) {
      map.put(character, true);
    }
    notifyAllViewers();
  }


  /**
   * Sign up a alphabet viewer to viewer list.
   *
   * @param alphabetViewer given alphabet viewer
   */
  public void signUpViewer(AlphabetViewer alphabetViewer) {
    alphabetViewerList.add(alphabetViewer);
    alphabetViewer.alphabetChanged();
  }

  /**
   * Notify all viewers in viewer list.
   */
  private void notifyAllViewers() {
    Iterator<AlphabetViewer> iterator = alphabetViewerList.iterator();
    while (iterator.hasNext()) {
      AlphabetViewer next = iterator.next();
      next.alphabetChanged();
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

    Alphabet alphabet = (Alphabet) obj;

    if (!getMap().equals(alphabet.getMap())) {
      return false;
    }
    return getAlphabetViewerList().equals(alphabet.getAlphabetViewerList());
  }

  @Override
  public int hashCode() {
    int result = getMap().hashCode();
    result = 31 * result + getAlphabetViewerList().hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "Alphabet{"
        + "map=" + map
        + ", alphabetViewerList=" + alphabetViewerList
        + '}';
  }
}
