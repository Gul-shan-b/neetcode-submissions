/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int n = mountainArr.length();

        // Find peak
        int left = 0;
        int right = n - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int peak = left;

        // Search increasing part
        left = 0;
        right = peak;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            int value = mountainArr.get(mid);

            if (value == target) {
                return mid;
            }

            if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Search decreasing part
        left = peak + 1;
        right = n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            int value = mountainArr.get(mid);

            if (value == target) {
                return mid;
            }

            if (value > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}