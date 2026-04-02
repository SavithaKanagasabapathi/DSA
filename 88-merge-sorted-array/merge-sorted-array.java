class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //TC-O() and SC-O()

        int i = m - 1, j = n - 1, k = m + n - 1;//elements position
        //ascending order with duplicates = non-decreasing
        //big num will be in last position
        while (j >= 0) {//upto j position 0
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        //if i is higher that j, keep i in k else j in k position
    }
}