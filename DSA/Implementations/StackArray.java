import java.util.*;

public class StackArray {
    private int[] arr;
    private int i;
    private int capacity;
    
    public StackArray() {
        arr = new int[1];
        size = 1;
        n = 0;
    }

    public void resize(size) {
        int[] new_arr = new int[size];
        for(int i = 0; i < n; i++) {
            new_arr[i] == arr[i];
        }
        arr = new_arr;
    }

    public void push(int value) {
        if(n == size) {
            size *= 2;
            resize(size);
        }
        arr[n++] = value;
    }

    public void pop() {
        if(n <= 0) {
            System.out.println("Stack is Empty. No Element to pop!");
        }
        return
    }
    
    public void peek() {
    
    }
    
    public boolean isEmpty() {
    
    }

    public int size() {
    
    }
}
