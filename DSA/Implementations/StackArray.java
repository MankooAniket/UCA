import java.util.*;

public class StackArray {
  private int[] array;
  private int N;
  private int capacity;

  public StackArray() {
    array = new int[1];
    capacity = 1;
    N = 0;
  }
  
  public static void main(String[] args) {
    StackArray stack = new StackArray();
    
    stack.push(3);
    stack.push(5);
    stack.push(7);

    assert stack.size() == 3;
    assert !stack.isEmpty();

    assert stack.pop() == 7;
    assert stack.size() == 2;
    assert !stack.isEmpty();

    assert stack.pop() == 5;
    assert stack.size() == 1;
    assert !stack.isEmpty();

    assert stack.pop() == 3;
    assert stack.size() == 0;
    assert stack.isEmpty();
    
    System.out.println("All assertions passed ✅"); 
  }

  public void resize(int new_capacity) {
    int[] new_array = new int[new_capacity];
    for(int i = 0; i < N; i++) {
      new_array[i] = array[i];
    }
    array = new_array;
  }

  public void push(int value) {
    if(N == capacity - 1) {
      capacity *= 2;
      resize(capacity);
    }
    array[N++] = value;
  }

  public int pop() {
    int item = array[--N];
    if(N <= 0) {
      System.out.println("Stack is Empty. No Element to pop!");
    } if(N <= capacity / 4) {
      capacity /= 2;
      resize(capacity);
    }
    return item;
  }

  public int peek() {
    int item = array[N - 1];
    return item;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }
}
