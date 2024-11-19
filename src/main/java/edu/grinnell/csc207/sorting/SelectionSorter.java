package edu.grinnell.csc207.sorting;

import java.util.Comparator;
import edu.grinnell.csc207.util.ArrayUtils;

/**
 * Something that sorts using selection sort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 */

public class SelectionSorter<T> implements Sorter<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The way in which elements are ordered.
   */
  Comparator<? super T> order;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter using a particular comparator.
   *
   * @param comparator
   *   The order in which elements in the array should be ordered
   *   after sorting.
   */
  public SelectionSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // SelectionSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Find the index of the smallest value of a specific range from start index to the
   * end of the array.
   *
   * @param values
   *   an array to sort.
   * @param start
   *   the initial index to begin searching for the minimum.
   * @return the index of the smallest value in the array
   */
  public int findMin(T[] values, int start) {
    int index = start;
    T min = values[index];
    for(int n = index + 1; n < values.length; n++) {
      if(order.compare(values[n], min) < 0) {
        min = values[n];
        index = n;
      } //if
    } //for
    return index;
  } // findMin(T[])

  /**
   * Sort an array in place using selection sort.
   *
   * @param values
   *   an array to sort.
   *
   * @post
   *   The array has been sorted according to some order (often
   *   one given to the constructor).
   * @post
   *   For all i, 0 &lt; i &lt; values.length,
   *     order.compare(values[i-1], values[i]) &lt;= 0
   */
  @Override
  public void sort(T[] values) {
    for(int n = 0; n < values.length; n++) {
      ArrayUtils.swap(values, findMin(values,n), n);
    } // for
  } // sort(T[])

} // class SelectionSorter
