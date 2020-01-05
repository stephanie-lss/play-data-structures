/**
 * @author LiSheng
 * @date 2020/1/5 13:37
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        System.out.println(segmentTree);
        Integer res1 = segmentTree.query(0, 2);
        Integer res2 = segmentTree.query(2, 5);
        Integer res3 = segmentTree.query(0, 5);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
