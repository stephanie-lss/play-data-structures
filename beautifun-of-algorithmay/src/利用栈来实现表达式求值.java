import java.util.ArrayList;
import java.util.Stack;

/**
 * @author LiSheng
 * @date 2020/1/3 9:20
 */
public class 利用栈来实现表达式求值 {

    public int operateStack(String equator) {
        if (equator.isEmpty()){
            return 0;
        }
        ArrayList<String> lists = getStrings(equator);
        Stack<Integer> nums = new Stack<>();
        Stack<String> operates = new Stack<>();
        for (String list : lists) {
            if (!"+".equals(list) && !"-".equals(list) && !"*".equals(list) && !"/".equals(list)) {
                nums.push(Integer.valueOf(list));
            } else {
                if (operates.isEmpty()) {
                    operates.push(list);
                } else {
                    if ("-".equals(list) || "+".equals(list)) {
                        while (!operates.isEmpty()) {
                            operate(nums, operates);
                        }
                        operates.push(list);
                    } else {
                        operates.push(list);
                    }
                }
            }
        }
        while (!operates.isEmpty()) {
            operate(nums, operates);
        }
        return nums.pop();
    }

    private ArrayList<String> getStrings(String equator) {
        char[] arrs = equator.toCharArray();
        ArrayList<String> lists = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arrs.length; i++) {
            if (arrs[i] != '+' && arrs[i] != '-' && arrs[i] != '*' && arrs[i] != '/' && i != arrs.length - 1) {
                res.append(arrs[i]);
            } else if (i == arrs.length - 1) {
                lists.add(String.valueOf(arrs[i]));
            } else {
                lists.add(res.toString());
                res = new StringBuilder();
                lists.add(String.valueOf(arrs[i]));
            }
        }
        return lists;
    }

    private void operate(Stack<Integer> nums, Stack<String> operates) {
        if ("*".equals(operates.peek())) {
            operates.pop();
            nums.push(nums.pop() * nums.pop());
        } else if ("/".equals(operates.peek())) {
            operates.pop();
            int n1 = nums.pop();
            int n2 = nums.pop();
            nums.push(n2 / n1);
        } else if ("+".equals(operates.peek())) {
            operates.pop();
            nums.push(nums.pop() + nums.pop());
        } else if ("-".equals(operates.peek())) {
            operates.pop();
            nums.push(-nums.pop() + nums.pop());
        }
    }

    public static void main(String[] args) {
        System.out.println(new 利用栈来实现表达式求值().operateStack("34+13*9+44-12/3"));
        System.out.println(new 利用栈来实现表达式求值().operateStack("3+5*8-6"));
        System.out.println(new 利用栈来实现表达式求值().operateStack("0"));
        System.out.println(new 利用栈来实现表达式求值().operateStack("1"));
        System.out.println(new 利用栈来实现表达式求值().operateStack(""));
    }
}
