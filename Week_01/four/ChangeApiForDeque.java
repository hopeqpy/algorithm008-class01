package four;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: algorithm
 * @description: 改写Deque的代码
 * @author: qpy
 */
public class ChangeApiForDeque {

    public static void main(String[] args) {
        Deque<String> deque =new LinkedList<String>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);
        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size()>0){
            System.out.println(deque.pollFirst());
        }
        System.out.println(deque);


        deque.addLast("c");
        deque.addLast("b");
        deque.addLast("a");
        System.out.println(deque);
        String last = deque.peekLast();
        System.out.println(last);
        System.out.println(deque);
        while (deque.size()>0){
            System.out.println(deque.pollLast());
        }
        System.out.println(deque);

    }
}
