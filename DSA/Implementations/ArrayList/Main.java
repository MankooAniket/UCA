public class Main {
  public static void main(String[] args) {

    ArrayList<Integer> list = new ArrayList<>();

    // Add elements
    list.add(10);
    list.add(20);
    list.add(30);

    // Print size
    System.out.println("Size: " + list.size());

    // Get elements
    System.out.println("Element at index 1: " + list.get(1));

    // Set element
    list.set(1, 99);
    System.out.println("After set: " + list.get(1));

    // Remove element
    list.remove(0);
    System.out.println("After remove index 0:");
    
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }

    // Contains
    System.out.println("Contains 99? " + list.contains(99));
    System.out.println("Index of 30: " + list.indexOf(30));

    // Clear
    list.clear();
    System.out.println("Size after clear: " + list.size());
  }
}
