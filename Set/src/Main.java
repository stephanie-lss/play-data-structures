import java.util.Random;

/**
 * @author LiSheng
 * @date 2020/1/4 15:13
 */
public class Main {
    private static double testSet(Set<Integer> set){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            set.add(random.nextInt(1000000000));
        }
        System.out.println(set.getSize());
        long endTime = System.nanoTime();

        return (endTime-startTime)/1000000000;
    }

    public static void main(String[] args) {
        BSTSet<Integer> bstSet = new BSTSet<>();
        System.out.println("time1:"+testSet(bstSet));

        System.out.println();

        LinkedListSet<Integer> linkedListSet = new LinkedListSet<>();
        System.out.println("time2:"+testSet(linkedListSet));
    }
}
