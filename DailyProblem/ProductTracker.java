import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The {@code ProductTracker} class maintains a collection of products
 * and tracks how frequently each product is added (wishlisted) or removed (delisted).
 *
 * <p>Internally, it uses a doubly linked list of frequency nodes. Each node stores
 * products with the same frequency in a {@link java.util.Set}. This design allows
 * efficient updates when product frequencies increase or decrease.
 * Core operations supported:
 * <ul>
 *   <li>{@link #wishlist(String)} – Increases the frequency of a product (adding it if new).</li>
 *   <li>{@link #delist(String)} – Decreases the frequency of a product 
 *   (removing it if it reaches zero).</li>
 *   <li>{@link #getMaxProduct()} – Retrieves a product with the highest frequency.</li>
 *   <li>{@link #getMinProduct()} – Retrieves a product with the lowest frequency.</li>
 * </ul>
 */
 
public class ProductTracker {
  /**
   * Node class represents a element in the doubly linked list.
   */
  class Node {
    int freq;
    Node next;
    Node prev;
    Set<String> products;
    
    /**
     * Creates a {@code Node} with the given frequency.
     *
     * @param freq frequency count associated with this node
     */
    Node(int freq) {
      this.freq = freq;
      this.products = new HashSet<>(); 
    }
  }

  private Node head;
  private Node tail;
  private Map<String, Node> productNodeMap;
  
  /**
   * Constructs a new {@code Product Tracker}.
   * Initialises head/tail sentinel and internal map.
   */
  public ProductTracker() {
    head = new Node(-1);
    tail = new Node(-1);

    head.next = tail;
    tail.prev = head;

    productNodeMap = new HashMap<>(); 
  }
  
  /**
   * Adds a product to the wishlist or increments its frequency if it already exists.
   *
   * @param productName the product to add or increment
   */
  public void wishlist(String productName) {
    if (productNodeMap.containsKey(productName)) {
      Node currNode = productNodeMap.get(productName);

      if ((currNode.freq + 1) == currNode.next.freq) {
        Node nextNode = currNode.next;
        nextNode.products.add(productName);
        productNodeMap.put(productName, nextNode);
      } else {
        Node nextNode = new Node(currNode.freq + 1);
        nextNode.products.add(productName);
        insertAfter(currNode, nextNode);
        productNodeMap.put(productName, nextNode);
      }
    
      currNode.products.remove(productName);
    
      if (currNode.products.size() == 0) {
        removeNode(currNode);
      }
    } else {
      Node nextHead = head.next;
      
      if (nextHead.freq == 1) {
        nextHead.products.add(productName);
        productNodeMap.put(productName, nextHead);
      } else {
        Node newNode = new Node(1);
        newNode.products.add(productName);
        insertAfter(head, newNode);
        productNodeMap.put(productName, newNode);
      }
    }
  }
  
  /**
   * Removes a product from the wishlist or decrement its frequency
   * if its count is greater than 1.
   *
   * @param productName the product to remove or decrement
   */ 
  public void delist(String productName) {
    if (!productNodeMap.containsKey(productName)) {
      return;
    }
    
    Node currNode = productNodeMap.get(productName);
    
    if (currNode.freq == 1) {
      currNode.products.remove(productName);
      productNodeMap.remove(productName);

      if (currNode.products.size() == 0) {
        removeNode(currNode);
      }
    } else {
      Node prevNode = currNode.prev;

      if (prevNode.freq  == currNode.freq - 1) {
        prevNode.products.add(productName);
        productNodeMap.put(productName, prevNode);
      } else {
        Node newNode = new Node(currNode.freq - 1);
        newNode.products.add(productName);
        insertAfter(prevNode, newNode);
        productNodeMap.put(productName, newNode);
      }

      currNode.products.remove(productName);

      if (currNode.products.size() == 0) {
        removeNode(currNode);
      }
    }
  }

  /**
   * Retrieves the product with the highest frequency.
   *
   * @return a product name with highest frequency, or {@code null} 
   *         if no product exists
   */ 
  public String getMaxProduct() {
    if (tail.prev == head) {
      return null;
    }
    return tail.prev.products.stream().findFirst().orElse(null);
  }

  /**
   * Retrieves the product with the lowest frequency.
   *
   * @return a product name with lowest frequency, or {@code null}
   *         if no product exists
   */
  public String getMinProduct() {
    if (head.next == tail) {
      return null;
    }
    return head.next.products.stream().findFirst().orElse(null);
  }
  
  /**
   * Inserts a new node after a given node in the doubly linked list.
   *
   * @param currNode the existing node
   * @param newNode the new node to insert
   */
  public void insertAfter(Node currNode, Node newNode) {
    Node nextNode = currNode.next;
    newNode.next = nextNode;
    nextNode.prev = newNode;
    currNode.next = newNode;
    newNode.prev = currNode;
  }
  
  /**
   * Removes a node from the doubly linked list.
   *
   * @param node the node to remove
   */ 
  public void removeNode(Node node) {
    Node prev = node.prev;
    Node next = node.next;
    prev.next = next;
    next.prev = prev;
  }
  
  /**
   * Demonstrates the example usage of {@code Product Tracker}.
   *
   * @param args command-line arguments (unused)
   */
  public static void main(String[] args) {
    ProductTracker pt = new ProductTracker();

    pt.wishlist("a");
    pt.wishlist("a");
    pt.wishlist("a");

    pt.wishlist("b");
    pt.wishlist("b");

    System.out.println("MAX : " + pt.getMaxProduct());
    System.out.println("MIN : " + pt.getMinProduct());
  
    pt.delist("a");
    pt.delist("a");
    System.out.println("MAX : " + pt.getMaxProduct());
    System.out.println("MIN : "  + pt.getMinProduct());

    pt.delist("a");
    pt.delist("a");

    System.out.println("MAX : " + pt.getMaxProduct());
    System.out.println("MIN : " + pt.getMinProduct());
  }
}
