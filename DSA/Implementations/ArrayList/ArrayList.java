/**
 * A simplified dynamic array implementation similar to Java's ArrayList.
 *
 * @param <E> the type of elements stored in this list
 */
public class ArrayList<E> {

  private static final int DEFAULT_CAPACITY = 10;

  private Object[] elementData;
  private int size;

  /**
   * Constructs an empty list with default initial capacity.
   */
  public ArrayList() {
    elementData = new Object[DEFAULT_CAPACITY];
    size = 0;
  }

  /**
   * Returns the number of elements in this list.
   */
  public int size() {
    return size;
  }

  /**
   * Returns true if this list contains no elements.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Ensures capacity by increasing array size by 50% if full.
   */
  private void ensureCapacity() {
    if (size == elementData.length) {
      int newCapacity = elementData.length + (elementData.length >> 1);
      Object[] newArray = new Object[newCapacity];
      System.arraycopy(elementData, 0, newArray, 0, size);
      elementData = newArray;
    }
  }

  /**
   * Appends the specified element to the end of this list.
   */
  public boolean add(E e) {
    ensureCapacity();
    elementData[size++] = e;
    return true;
  }

  /**
   * Returns the element at the specified position.
   */
  @SuppressWarnings("unchecked")
  public E get(int index) {
    checkIndex(index);
    return (E) elementData[index];
  }

  /**
   * Replaces the element at the specified position.
   */
  @SuppressWarnings("unchecked")
  public E set(int index, E e) {
    checkIndex(index);
    E old = (E) elementData[index];
    elementData[index] = e;
    return old;
  }

  /**
   * Removes the element at the specified position.
   */
  @SuppressWarnings("unchecked")
  public E remove(int index) {
    checkIndex(index);

    E removed = (E) elementData[index];
    int numMoved = size - index - 1;

    if (numMoved > 0) {
      System.arraycopy(
          elementData,
          index + 1,
          elementData,
          index,
          numMoved
      );
    }

    elementData[--size] = null;
    return removed;
  }

  /**
   * Removes all elements from this list.
   */
  public void clear() {
    for (int i = 0; i < size; i++) {
      elementData[i] = null;
    }
    size = 0;
  }

  /**
   * Returns true if this list contains the specified element.
   */
  public boolean contains(Object o) {
    return indexOf(o) >= 0;
  }

  /**
   * Returns the index of the first occurrence of the specified element,
   * or -1 if not found.
   */
  public int indexOf(Object o) {
    if (o == null) {
      for (int i = 0; i < size; i++) {
        if (elementData[i] == null) {
          return i;
        }
      }
    } else {
      for (int i = 0; i < size; i++) {
        if (o.equals(elementData[i])) {
          return i;
        }
      }
    }
    return -1;
  }

  /**
   * Checks whether the given index is valid.
   */
  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(
          "Index: " + index + ", Size: " + size
      );
    }
  }
}
