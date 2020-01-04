/**
 * @author LiSheng
 * @date 2020/1/4 14:57
 */
public class Main2 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.addFirst(2);
        System.out.println(linkedList);
        linkedList.removeElement(2);
        System.out.println(linkedList);
    }
}
