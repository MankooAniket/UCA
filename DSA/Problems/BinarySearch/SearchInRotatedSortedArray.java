/**
 * SearchInRotatedSortedArray provides an efficient method for finding a target value
 * in a rotated sorted array with no duplicate values.
 * It uses an optimized binary search approach to maintain O(log n) performance.
 *
 * @author      Aniket
 * @version     1.0
 * @since       2025-09-23
 */
public class SearchInRotatedSortedArray {
  /**
   * Given a sorted array that is rotated at some pivot (with no duplicate values), 
   * find the index of a target value. If the target is not found, return -1.*
   * Example: [4, 5, 6, 7, 0, 1, 2], target = 0 -> returns 4.
   *
   * @param nums - Rotated sorted integer array (no duplicates).
   * @param target - The integer to search for.
   * @returns int - Index of target or -1 if not found.
   */
  public int search(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[low] < nums[mid]) {
        if (target >= nums[low] && target < nums[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else {
        if (target > nums[mid] && target <= nums[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      } 
    }
    return nums[low] == target ? low : -1;
  }

  /**
   * Main method for testing the SearchInRotatedSortedArray class.
   */
  public static void main(String[] args) {
    SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
    int[] arr1 = {4, 5, 6, 7, 0, 1, 2};
    System.out.println(s.search(arr1, 0) == 4 ? "Test case 1 passed" : "Test case 1 failed");
    System.out.println(s.search(arr1, 3) == -1 ? "Test case 2 passed" : "Test case 2 failed");
    int[] arr2 = {3, 1};
    System.out.println(s.search(arr2, 3) == 0 ? "Test case 3 passed" : "Test case 3 failed");
  }
}
