import java.util.EmptyStackException;

/**
 * A simple implementation of stack using a linked List.
 * It supports basic stack operations:
 * {@code push}, {@code peek}, {@code pop}, {@code size}, {@code isEmpty}
 *
 * @author Aniket
 * @version 1.0
 */
public class StackLinkedList {
  /**
   *  Node class represents an element in a linked list.
   */
  class Node {
    int value;
    Node next;
    
    /**
     * Creates a new node with the given value.
     *
     * @param value the value to store in this node
     */ 
    Node(int value) {
      this.value = value;
      this.next = null;
    }
  }

  private Node head;
  private int size;

  /**
   * Create an empty stack.
   */ 
  public StackLinkedList() {
    this.head = null;
    this.size = 0;
  }
  
  /**
   * Checks if the stack is empty.
   *
   * @returns {@code true} if the stack if empty; {@code false} otherwise 
   */
  public boolean isEmpty() {
    return head == null;
  }
  
  /**
   * Returns the size of the array.
   *
   * @return the size of the array
   */
  public int size() {
    return size;
  }

  /**
   * Pushes the value to the top of the stack.
   *
   * @param value value of the element to push
   */ 
  public void push(int value) {
    Node temp = head;
    head = new Node(value);
    head.next = temp;
    size++;
  }
  
  /**
   * Returns the value at the top of the stack.
   *
   * @return element at the top of the stack
   * @throws EmptyStackException if the stack is empty
   */ 
  public int peek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return head.value;
  }
  
  /** Removes and returns the value at the top of the stack.
   *
   * @return element at the top of the stack
   * @throws EmptyStackException if the stack is empty
   */
  public int pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    int value = head.value;
    head = head.next;
    size--;
    return value;
  }
  
  /**
   * Runs basic tests for the stack implemetation.
   *
   * @param args unused
   */
  public static void main(String[] args) {
    StackLinkedList stack = new StackLinkedList();

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
