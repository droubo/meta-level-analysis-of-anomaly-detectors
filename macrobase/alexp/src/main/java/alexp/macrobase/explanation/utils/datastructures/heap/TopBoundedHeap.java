package alexp.macrobase.explanation.utils.datastructures.heap;

/*
 This file is part of ELKI:
 Environment for Developing KDD-Applications Supported by Index-Structures

 Copyright (C) 2013
 Ludwig-Maximilians-Universität München
 Lehr- und Forschungseinheit für Datenbanksysteme
 ELKI Development Team

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU Affero General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Affero General Public License for more details.

 You should have received a copy of the GNU Affero General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * heap class that is bounded in size from the top. It will keep the bottom
 * {@code k} Elements only.
 * 
 * @author Erich Schubert
 * 
 * @param <E> Element type. Should be {@link Comparable} or a {@link Comparator}
 *        needs to be given.
 */
public class TopBoundedHeap<E> extends Heap<E> {
  /**
   * Maximum size.
   */
  protected int maxsize;

  /**
   * Constructor with maximum size only.
   * 
   * @param maxsize Maximum size
   */
  public TopBoundedHeap(int maxsize) {
    this(maxsize, null);
  }

  /**
   * Constructor with maximum size and {@link Comparator}.
   * 
   * @param maxsize Maximum size
   * @param comparator Comparator
   */
  public TopBoundedHeap(int maxsize, Comparator<? super E> comparator) {
    super(maxsize + 1, comparator);
    this.maxsize = maxsize;
    assert (maxsize > 0);
  }

  /**
   * Copy constructor.
   *
   * @param topBoundedHeap An existing top bounded heap
   */
  public TopBoundedHeap(TopBoundedHeap<E> topBoundedHeap){
    super(topBoundedHeap.maxsize + 1, topBoundedHeap.comparator);
    this.maxsize = topBoundedHeap.maxsize;
    assert (maxsize > 0);
    for(Heap<E>.UnorderedIter it = topBoundedHeap.unorderedIter(); it.valid(); it.advance()){
      add(it.get());
    }
  }

  /**
   * Take the topK elements as list of an existing topBoundedHeap
   *
   * @param k The starting point of the TopBoundedHeap
   * @param comparator The comparator that will help choose the preferred topK
   */
  public List<E> topK(int k, Comparator<E> comparator){
    List<E> topKList = new ArrayList<>();
    for(Heap<E>.UnorderedIter it = this.unorderedIter(); it.valid(); it.advance()){
      topKList.add(it.get());
    }
    topKList.sort(comparator);
    return topKList.subList(0, Math.min(topKList.size(),k));
  }

  /**
   * Converts the TopBoundedHeap to a list
   */
  public List<E> toList() {
    List<E> list = new ArrayList<>();
    for(Heap<E>.UnorderedIter it = this.unorderedIter(); it.valid(); it.advance()){
      list.add(it.get());
    }
    return list;
  }

  @Override
  public void add(E e) {
    if (super.size() < maxsize) {
      // Just offer.
      super.add(e);
      return;
    }
    // Peek at the top element, return if we are worse.
    final int comp;
    if (comparator == null) {
      @SuppressWarnings("unchecked")
      Comparable<Object> c = (Comparable<Object>) e;
      comp = c.compareTo(queue[0]);
    } else {
      comp = comparator.compare(e, queue[0]);
    }
    if (comp < 0) {
      return;
    }
    if (comp == 0) {
      handleOverflow(e);
    } else {
      // Otherwise, replace and repair:
      E prev = super.replaceTopElement(e);
      handleOverflow(prev);
    }
  }

  /**
   * Handle an overflow in the structure. This function can be overridden to get
   * overflow treatment.
   * 
   * @param e Overflowing element.
   */
  protected void handleOverflow(E e) {
    // discard extra element
  }

  /**
   * Get the maximum size.
   * 
   * @return the maximum size
   */
  public int getMaxSize() {
    return maxsize;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{ ");
    for(Heap<E>.UnorderedIter it = unorderedIter(); it.valid(); it.advance())
      sb.append(it.get() + " ");
    sb.append("}");
    return sb.toString();
  }
}
