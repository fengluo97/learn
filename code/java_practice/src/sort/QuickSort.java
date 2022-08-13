package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: fengluo
 * @Date: 2022/8/11 20:32
 */
public class QuickSort {

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

        quickSort(arr, 0, arr.length - 1);

        System.out.println("排序后");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int randomIndex = new Random().nextInt(right - left + 1) + left;
            swap(nums, randomIndex, left);
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = left, index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, index);
                index++;
            }
        }
        // 得到的 index
        swap(nums, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] nums, int i, int j) {
        if (nums[i] != nums[j]) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
