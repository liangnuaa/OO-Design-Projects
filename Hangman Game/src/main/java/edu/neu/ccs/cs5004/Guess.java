package edu.neu.ccs.cs5004;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents Guess class.
 *
 * @author Liang
 */
public class Guess {
  private Integer remainingTimes;
  private List<GuessViewer> viewerList;

  /**
   * Create a new Guess.
   *
   * @param remainingTimes given remaining time
   */
  public Guess(Integer remainingTimes) {
    if (remainingTimes < 0) {
      throw new IllegalArgumentException("The remaining "
          + "time should be at least 0 times giving " + remainingTimes);
    }
    this.remainingTimes = remainingTimes;
    viewerList = new ArrayList<>();
  }

  /**
   * Set the remainingTimes to given value.
   *
   * @param remainingTimes given remaining time
   */
  public void setToInitialState(Integer remainingTimes) {
    this.remainingTimes = remainingTimes;
    notifyAllViewers();
  }

  /**
   * Getter for 'remainingTimes'.
   *
   * @return the remainingTimes
   */
  public Integer getRemainingTimes() {
    return remainingTimes;
  }

  /**
   * Getter for 'viewerList'.
   *
   * @return the viewerList
   */
  public List<GuessViewer> getViewerList() {
    return viewerList;
  }

  /**
   * Sign up a guess viewer to viewer list.
   *
   * @param guessViewer given guess viewer
   */
  public void signUpViewer(GuessViewer guessViewer) {
    viewerList.add(guessViewer);
    guessViewer.guessChanged();
  }

  /**
   * Decrease the remaining time by 1.
   */
  public void decreaseTime() {
    this.remainingTimes -= 1;
    notifyAllViewers();
  }

  /**
   * Notify all viewers in viewer list.
   */
  private void notifyAllViewers() {
    Iterator<GuessViewer> iterator = viewerList.iterator();
    while (iterator.hasNext()) {
      GuessViewer next = iterator.next();
      next.guessChanged();
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

    Guess guess = (Guess) obj;

    if (!getRemainingTimes().equals(guess.getRemainingTimes())) {
      return false;
    }
    return getViewerList().equals(guess.getViewerList());
  }

  @Override
  public int hashCode() {
    int result = getRemainingTimes().hashCode();
    result = 31 * result + getViewerList().hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "Guess{"
        + "remainingTimes=" + remainingTimes
        + ", viewerList=" + viewerList
        + '}';
  }
}
