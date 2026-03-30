public class LinkedList {
  private Node head;
  private int size;

  public static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }
  
  public void addFirst(int data) {
    Node newNode = new Node(data);
    
    newNode.next = head;
    head = newNode;
    size++;
  }

  public void addLast(int data) {
    Node newNode = new Node(data);

    if (head == null) {
      head = newNode;
      size++;
      return;      
    }
    
    Node curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }
    
    curr.next = newNode;
    size++;
  }
  
  public void addAtIndex(int index, int data) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    
    if (index == 0) {
      addFirst(data);
      return;
    }

    Node newNode = new Node(data);
    Node curr = head;
    
    for (int i = 0; i < index - 1; i++) {
      curr = curr.next;
    }
  
    newNode.next = curr.next;
    curr.next = newNode;
    size++;
  }

  public int get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    if (index == 0) {
      return head.data;
    }
    
    Node curr = head;
  
    for (int i = 0; i < index; i++) {
      curr = curr.next;
    }
    
    return curr.data;
  }

  public int removeFirst() {
    if (head == null) {
      return null;
    }
    
    int value = head.data;
    head = head.next;
    size--;
    return value;
  }
  
  public void removeLast() {
    if (head == null) {
      return;
    }
    if (head.next == null) {
      head = null;
      size--;
      return;
    }
    
    Node curr = head;
  
    while (curr.next.next != null) {
      curr = curr.next;
    }
    
    curr.next = null;
    size--;
  }

  public void removeAtIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    if (index == 0) {
      removeFirst();
      return;
    }
    
    Node curr = head;
    
    for (int i = 0; i < index - 1; i++) {
      curr = curr.next;
    }
    
    curr.next = curr.next.next;
    size--;
  }
  
  public void removeByValue(int value) {
    if (head == null) {
      return;
    }
    if (head.data == value) {
      head = head.next;
      size--;
      return;
    }

    Node curr = head;
    
    while (curr.next != null && curr.next.data != value) {
      curr = curr.next;
    }
    
    if (curr.next != null) {
      curr.next = curr.next.next;
      size--;
    }
  }
  
  public boolean contains(int value) {
    if (head == null) {
      return false;
    }
    if (head.data == value) {
      return true;
    }
    
    Node curr = head;
    
    while (curr != null) {
      if (curr.data == value) {
        return true;
      }
      curr = curr.next;
    }
    
    return false;
  }
  
  public int size() {
    return size;
  }
  
  public boolean isEmpty() {
    return size == 0;
  }
  
  public void printList() {
    if (head == null) {
      System.out.println("null");
      return;
    }
    
    Node curr = head;
    while (curr != null) {
      System.out.print(curr.data + " -> ");
      curr = curr.next;
    }
    System.out.print("null");
  }
}
