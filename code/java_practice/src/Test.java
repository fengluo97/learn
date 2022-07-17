import java.util.*;

/**
 * @Author: fengluo
 * @Date: 2022/7/7 20:50
 */
public class Test {

    public static void main(String[] args) {

        Vector<Integer> vector = new Vector<>();

        vector.add(1);

        List<Integer> list = new ArrayList<Integer>();
        list.add(new Random().nextInt(10));
        list.add(new Random().nextInt(10));
        list.add(new Random().nextInt(10));
        list.add(new Random().nextInt(10));
        list.add(new Random().nextInt(10));
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(list);
        Object o = new Object();
        o.hashCode();

        Queue<Integer> queue1 = new ArrayDeque<>();
        Deque<Integer> queue2 = new ArrayDeque<>();
        System.out.println(queue2.peekFirst()); // 返回空值
        Integer i = null;
        System.out.println(i);
        System.out.println(new String(""));
        String str = new String();
        str = null;
        System.out.println(str); //
    }

}
