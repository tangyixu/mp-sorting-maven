package edu.grinnell.csc207.sorting;

import java.util.Comparator;
import java.util.Arrays;

/**
 * Something that sorts using merge sort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 */

public class MergeSorter<T> implements Sorter<T> {
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
  public MergeSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // MergeSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using merge sort.
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
    T[] left = Arrays.copyOf(values, values.length/2);
    T[] right = Arrays.copyOfRange(values, values.length/2, values.length);
    int index = 0;
    for(int n = 0; n < left.length; n++) {
        if(index == right.length) {
          values[values.length - 1] = left[left.length - 1];
          return;
        } //if
        if (order.compare(left[n], right[index]) <= 0) {
          values[n] = left[n];
        } //if
        else {
          values[n] = right[index];
          index++;
        } //else 
      } //for 
      values[values.length - 1] = right[right.length - 1];      
  } // sort(T[])
} // class MergeSorter
