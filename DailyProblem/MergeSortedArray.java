public class MergeSortedArray {
  public static void merge(int[] nums1,int m, int[] nums2,int n) {
    int i = m - 1, j = n - 1, k = n + m - 1;
    while (i >= 0 && j >= 0) {
      if (nums1[i] > nums2[j]) {
        nums1[k--] = nums1[i--];
      } else {
        nums1[k--] = nums2[j--];
      }
    }
    while(j >= 0) {
      nums1[k--] = nums2[j--];
    }
  }
  
  public static void print(int[] nums, int n) {
    for (int i = 0; i < n; i++) {
      System.out.print(nums[i] + " ");
    }
    System.out.println();
  }  
  
  public static void main(String[] args) {
    int m = 3;
    int[] nums1 = {1,2,3,0,0,0};
    print(nums1, m);
    int n = 3;
    int[] nums2 = {2,5,6};
    print(nums2, n);
    merge(nums1, m, nums2, n);
    print(nums1, m + n);
  }
}
