package sort;

import java.util.Random;

/**
 * @Author: fengluo
 * @Date: 2022/8/11 22:20
 */
public class HeapSort {

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

        heapSort(arr, arr.length);

        System.out.println("排序后");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void heapSort(int[] nums, int n) {
        // 建堆
        int i;
        for (i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        for (i = n - 1; i > 0; i--) {
            swap(nums, i, 0);
            heapify(nums, i, 0);
        }
    }

    // 核心方法，堆化
    private static void heapify(int[] nums, int n, int i) {
        int largest = i;
        int l_son = i * 2 + 1;
        int r_son = i * 2 + 2;
        // 寻找父子之中更大的节点
        if (l_son < n && nums[largest] < nums[l_son]) {
            largest = l_son;
        }
        if (r_son < n && nums[largest] < nums[r_son]) {
            largest = r_son;
        }
        if (largest != i) {
            swap(nums, largest, i);
            // 如果交换之后，仍需维护子树堆，即下滤操作
            heapify(nums, n, largest);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
