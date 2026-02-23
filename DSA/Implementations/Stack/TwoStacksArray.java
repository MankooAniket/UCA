/**
 * A class that implements two stacks using a single array.
 * 
 * <p>Stack 1 grows from the start of the array (index 0) toward the end,
 * while Stack 2 grows from the end of the array (last index) toward the start.
 * This approach efficiently utilizes available memory by sharing space between two stacks.
 * </p>
 */
public class TwoStacksArray {

  /** The array used to store stack elements. */
  private int[] arr;
  
  
  /** The top pointer for Stack 1 (grows from left to right). */
  private int top1;

  /** The top pointer for Stack 2 (grows from right to left). */
  private int top2;

  /** The total capacity of the array shared by both stacks. */
  private int capacity;
  
  /**
   * Constructs a {@code TwoStacksArray} with a specified capacity.
   *
   * @param capacity the total capacity of the array shared between both stacks
   * @throws IllegalArgumentException if {@code capacity} is less than or equal to zero
   */
  public TwoStacksArray(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("Capacity must be positive!");
    }
    this.capacity = capacity;
    arr = new int[capacity];
    top1 = -1;
    top2 = capacity;
  }
  
  /**
    * Pushes an element onto Stack 1.
    *
    * @param value the element to push
    * @implNote Prints "Stack Overflow on Stack 1!" if both stacks are full.
    */
  public void push1(int value) {
    if (isFull()) {
      System.out.println("Stack Overflow on Stack 1!");
      return;
    } 
    arr[++top1] = value;
  }
  
  /**
    * Pushes an element onto Stack 2.
    *
    * @param value the element to push
    * @implNote Prints "Stack Overflow on Stack 2!" if both stacks are full.
    */
  public void push2(int value) {
    if (isFull()) {
      System.out.println("Stack Overflow on Stack 2!");
      return;  
    }  
    arr[--top2] = value;
  }
    
  /**
   * Returns the top element of Stack 1 without removing it.
   *
   * @return the top element of Stack 1, or {@code -1} if Stack 1 is empty
   */
  public int peek1() {
    if (isEmpty1()) {
      System.out.println("Stack 1 is Empty!");
      return -1;
    }
    return arr[top1];
  }
  
  /**
   * Returns the top element of Stack 2 without removing it.
   *
   * @return the top element of Stack 2, or {@code -1} if Stack 2 is empty
   */
  public int peek2() {
    if (isEmpty2()) {
      System.out.println("Stack 2 is Empty!");
      return -1;
    }
    return arr[top2];
  }

  /**
   * Removes and returns the top element of Stack 1.
   *
   * @return the popped element from Stack 1, or {@code -1} if Stack 1 is empty
   */
  public int pop1() {
    if (isEmpty1()) {
      System.out.println("Stack Underflow on Stack 1!");
      return -1;
    }
    return arr[top1--];
  }

  /**
   * Removes and returns the top element of Stack 2.
   *
   * @return the popped element from Stack 2, or {@code -1} if Stack 2 is empty
   */
  public int pop2() {
    if (isEmpty2()) {
      System.out.println("Stack Underflow on Stack 2!");
      return -1;
    } 
    return arr[top2++];
  }
  
  /**
   * Checks if both stacks have filled the array.
   *
   * @return {@code true} if no space is left between Stack 1 and Stack 2, otherwise {@code false}
   */
  public boolean isFull() {
    return top1 + 1 == top2;
  }

  /**
   * Checks whether Stack 1 is empty.
   *
   * @return {@code true} if Stack 1 has no elements, otherwise {@code false}
   */
  public boolean isEmpty1() {
    return top1 == -1;
  }
  
  /**
   * Checks whether Stack 2 is empty.
   *
   * @return {@code true} if Stack 2 has no elements, otherwise {@code false}
   */
  public boolean isEmpty2() {
    return top2 == capacity;
  }
  
  /**
   * Prints the number of elements currently stored in both stacks.
   * 
   * <p>Example Output:
   * <pre>
   * Size of Stack 1 is 2 and Size of Stack 2 is 1
   * </pre>
   * </p>
   */
  public void printSizes() {
    int size1 = top1 + 1;
    int size2 = capacity - top2;
    System.out.println("Size of Stack 1 is " + size1 + " and Size of Stack 2 is " + size2);
  }

  /**
   * Prints the empty/non-empty status of both stacks.
   * 
   * <p>Example Output:
   * <pre>
   * Both Stacks are empty!
   * Stack 1 is Empty
   * Stack 2 is Empty
   * Both stacks have elements
   * </pre>
   * </p>
   */
  public void printStatus() {
    if (isEmpty1() && isEmpty2()) {
      System.out.println("Both Stacks are empty!");
    } else if (isEmpty1()) {
      System.out.println("Stack 1 is Empty");
    } else if (isEmpty2()) {
      System.out.println("Stack 2 is Empty");
    } else {
      System.out.println("Both stacks have elements");
    }
  }
  
  /**
   * The main method demonstrates the functionality of {@code TwoStacksArray}.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    TwoStacksArray ts = new TwoStacksArray(6);

    ts.push1(10);
    ts.push1(20);
    ts.push2(100);
    ts.push2(200);

    System.out.println("Peek Stack 1: " + ts.peek1());
    System.out.println("Peek Stack 2: " + ts.peek2());

    System.out.println("Popped from Stack 1: " + ts.pop1());
    System.out.println("Popped from Stack 2: " + ts.pop2());

    ts.printSizes();
    ts.printStatus();
  }
}
