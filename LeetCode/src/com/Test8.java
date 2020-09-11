package com;

/**
 * @author LiSheng
 * @date 2020/7/22 20:05
 */
public class Test8 {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int y = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] tmp = new int[2];
            for (int j = 0; j < 2; j++) {
                tmp[j] = sc.nextInt();
            }
            list.add(tmp);
        }
        Collections.sort(list, Comparator.comparingInt(o -> o[0]));

        int count = 0;
        int x = 0;
        for (int i = 0; i < n; i++) {
            int[] m = list.get(i);
            x = m[0] + y;
            if (m[1] > 0) {
                count += m[1];
                for (int j = i + 1; j < n; j++) {
                    int[] tmp = list.get(j);
                    if (tmp[0] <= x + y) {
                        tmp[1] -= m[1];
                        list.set(j, tmp);
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(count);*/
        int[] arr = {1, 2, 3, 4};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);

        deleteNode(listNode, 2);

        System.out.println(listNode);
    }

    public static void deleteNode(ListNode list,int target) {
        //.........
    }
}
