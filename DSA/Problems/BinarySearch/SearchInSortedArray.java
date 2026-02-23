/**
 * Implements binary search on a sorted array of distinct integers.
 * Provides a method to find the index of a given target value, 
 * and main method for assertion-based testing.
 * Usage: Compile and run with assertions enabled for internal test validation.
 * Features:
 * <ul>
 *   <li>Efficient O(log n) binary search algorithm.</li>
 *   <li>Input validation via assertions in the main method.</li>
 *   <li>Demo of Java assertion syntax for automated correctness checks during development.</li>
 * </ul>
 *
 * @author Aniket
 */ 
public class SearchInSortedArray {
  /**
   * Given a sorted array of distinct integers and a target value,
   * return the index of target if found, or -1 otherwise.
   *
   * @param nums - Sorted integer array (distinct values). 1 <= nums.length <= 10^5
   * @param target - The integer value to search for.
   * @returns int - Index of target or -1 if not found.
   */
  public int binarySearch(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return nums[low] == target ? low : -1;
  }

  /**
   * Main method for testing the SearchInSortedArray class.
   */
  public static void main(String[] args) {
    SearchInSortedArray s = new SearchInSortedArray();
    int[] arr = {1, 2, 3, 4, 5};
    System.out.println(s.binarySearch(arr, 1) == 0 ? "Test case 1 passed" : "Test case 1 failed");
    System.out.println(s.binarySearch(arr, 3) == 2 ? "Test case 2 passed" : "Test case 2 failed");
    System.out.println(s.binarySearch(arr, 5) == 4 ? "Test case 3 passed" : "Test case 3 failed");
    System.out.println(s.binarySearch(arr, 6) == -1 ? "Test case 4 passed" : "Test case 4 failed");
  }
}

