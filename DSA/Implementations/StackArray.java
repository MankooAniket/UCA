import java.util.EmptyStackException;

/**
 * A implementation of a stack using an dynamically resizable array.
 * It supports typical stack operations:
 * {@code push}, {@code pop}, {@code peek}, {@code isEmpty}, {@code size}.
 * The internal array grows and shrinks as needed
 *
 * @author Aniket
 * @version 1.0
 */

public class StackArray {
  private int[] array;
  private int size;
  private int capacity;
  
  /**
   * Crates an empty stack with initial capacity of 1.
   */
  public StackArray() {
    array = new int[1];
    capacity = 1;
    size = 0;
  } 
 
  /**
   * Resizes the array to a new capacity.
   *
   * @param newCapacity the new capacity for the array
   */
  public void resize(int newCapacity) {
    int[] newArray = new int[newCapacity];
    for (int i = 0; i < size; i++) {
      newArray[i] = array[i];
    }
    array = newArray;
  }

  /**
   * Pushes a value to the top of the stack.
   * If the array is full, its capacity is doubled.
   *
   * @param value the value to be pushed
   */
  public void push(int value) {
    if (size == capacity) {
      capacity *= 2;
      resize(capacity);
    }
    array[size++] = value;
  }

  /** Removes and returns the top element of the stack.
 *
   * @return the value at the top of the stack
   * @throws EmptyStackException if the stack is empty
   */
  public int pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    int item = array[--size];
    if (size > 0 && size <= capacity / 4) {
      capacity /= 2;
      resize(capacity);
    }
    return item;
  }

  /** Returns the value at the top of the stack.
   *
   * @return the value at the top of the stack
   * @throws EmptyStackException if the stack is empty
   */
  public int peek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return array[size - 1];
  }

  /** Checks if the stack is empty.
   *
   * @return {@code true} if the stack is empty; {@false} otherwise
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /** Returns the number of element in the stack.
   *
   * @return the size of the stack
   */
  public int size() {
    return size;
  }
  
  /** Runs basic tests for the stack implementaion.
   *
   * @param args unused
   */
  public static void main(String[] args) {
    StackArray stack = new StackArray();

    stack.push(3);
    stack.push(5);
    stack.push(7);

    assert stack.size() == 3;
    assert !stack.isEmpty();

    assert stack.peek() == 7;
    assert stack.pop() == 7;
    assert stack.size() == 2;
    assert !stack.isEmpty();

    assert stack.peek() == 5;
    assert stack.pop() == 5;
    assert stack.size() == 1;
    assert !stack.isEmpty();

    assert stack.peek() == 3;
    assert stack.pop() == 3;
    assert stack.size() == 0;
    assert stack.isEmpty();

    System.out.println("All stack tests passed!");
  }
}
