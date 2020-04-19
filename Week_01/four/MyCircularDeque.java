package four;

/**
 * @program: algorithm
 * @description: 设计循环队列
 * @author: qpy
 */
public class MyCircularDeque {

    //队列的元素数
    int size;
    //队列的容量
    int capacity;
    Node head;
    Node tail;

    /**
     * Initialize your data structure here. Set the size the deque to be k.
     */
    public MyCircularDeque(int k) {
        head = new Node( -1 );
        tail = new Node( -1 );
        head.next = tail;
        tail.pre = head;
        head.pre = tail;
        tail.next = head;
        size = 0;
        capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        Node node = new Node( value );
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;

        size++;

        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        //tail 保持-1
        Node node = new Node( value );
        node.pre = tail.pre;
        node.next = tail;
        tail.pre.next = node;
        tail.pre = node;
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head.next.next.pre = head;
        head.next = head.next.next;
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail.pre.pre.next = tail;
        tail.pre = tail.pre.pre;
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        //空时候返回tail的-1
        return head.next.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        //空的时候返回Head的-1
        return tail.pre.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }

    //节点
    class Node {
        public Node pre;
        public Node next;
        public int val;
        public Node(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // set the size to be 3
        circularDeque.insertLast(1);			// return true
        circularDeque.insertLast(2);			// return true
        circularDeque.insertFront(3);			// return true
        circularDeque.insertFront(4);			// return false, the queue is full
        circularDeque.getRear();  			// return 2
        circularDeque.isFull();				// return true
        circularDeque.deleteLast();			// return true
        circularDeque.insertFront(4);			// return true
        circularDeque.getFront();			// return 4
    }
}
