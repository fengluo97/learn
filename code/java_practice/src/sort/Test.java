package sort;

import java.util.Random;

/**
 * @Author: fengluo
 * @Date: 2022/8/12 19:16
 */
public class Test {

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

        //quickSort(arr, 0, arr.length - 1);
        //mergeSort(arr, new int[arr.length], 0, arr.length - 1);
        heapSort(arr, arr.length);

        System.out.println("排序后");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void swap(int[] nums, int i, int j) {
        if (nums[i] != nums[j]) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    private static void heapSort(int[] nums, int n) {
        // 建大顶堆
        int i;
        for (i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }
        // 上浮排序
        for (i = n - 1; i > 0; i--) {
            swap(nums, i, 0);
            heapify(nums, i, 0);
        }
    }

    private static void heapify(int[] nums, int n, int i) {
        // 下滤堆化
        int largest = i;
        int l_son = i * 2 + 1;
        int r_son = i * 2 + 2;
        if (l_son < n && nums[l_son] > nums[largest]) {
            largest = l_son;
        }
        if (r_son < n && nums[r_son] > nums[largest]) {
            largest = r_son;
        }
        if (largest != i) {
            swap(nums, largest, i);
            // 递归调整
            heapify(nums, n, largest);
        }
    }

    private static void mergeSort(int[] nums, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, temp, left, mid);
            mergeSort(nums, temp, mid + 1, right);
            // 归并
            int l_pos = left;
            int r_pos = mid + 1;
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

    private static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int random = new Random().nextInt(right - left + 1) + left;
            swap(nums, random, left);
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
        swap(nums, pivot, index - 1);
        return index - 1;
    }



}
