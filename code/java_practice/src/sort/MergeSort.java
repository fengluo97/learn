package sort;

import java.util.Random;

/**
 * @Author: fengluo
 * @Date: 2022/8/11 21:46
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = new Random().nextInt(100);
        }

        System.out.println("排序前");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        mergeSort(arr, new int[arr.length],0, arr.length - 1);

        System.out.println("排序后");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void mergeSort(int[] nums, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, temp, left, mid);
            mergeSort(nums, temp, mid + 1, right);

            // 待合并的两个子数组的起始下标
            int l_pos = left;
            int r_pos = mid + 1;
            // 复制数组的下标
            int pos = left;
            while (l_pos <= mid && r_pos <= right) {
                if (nums[l_pos] <= nums[r_pos]) {
                    temp[pos++] = nums[l_pos++];
                } else {
                    temp[pos++] = nums[r_pos++];
                }
            }
            while (l_pos <= mid) {
                temp[pos++] = nums[l_pos++];
            }
            while (r_pos <= right) {
                temp[pos++] = nums[r_pos++];
            }
            while (left <= right) {
                nums[left] = temp[left];
                left++;
            }
        }
    }

}
