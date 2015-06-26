import java.util.*;

class ListNode {
    int val;
    int key;
    ListNode pre;
    ListNode next;
    
    public ListNode(int key, int value) {
        this.key = key;
        this.val = value;
        this.pre = null;
        this.next = null;
    }
}
public class LRUCache {
    HashMap<Integer, ListNode> map;
    int capacity;
    int size;
    ListNode dummyHead;
    ListNode dummyTail;
    // @param capacity, an integer
    public LRUCache(int capacity) {
        // write your code here
        map =  new HashMap<Integer, ListNode>();
        this.capacity = capacity;
        size = 0;
        dummyHead = new ListNode(0, 0);
        dummyTail = new ListNode(0, 0);
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    // @return an integer
    //use hashmap to get the value. if not found return -1; if fond, move this node to the end
    public int get(int key) {
        // write your code here
        if (map.containsKey(key)) {
            moveToTail(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    //if not found the key, check capacity, if < capacity, append node in the tail. if = capacity, remove head append to tail.
    //if found the key, move the element to the tail
    public void set(int key, int value) {
        // write your code here
        if (map.containsKey(key)) {
            ListNode n = map.get(key);
            n.val = value;
            moveToTail(n);
        } else {
            if(size == capacity) {
                map.remove(dummyHead.next.key);
                dummyHead.next = dummyHead.next.next;
                dummyHead.next.pre = dummyHead;
                size--;
            }
            ListNode n = new ListNode(key, value);
            map.put(key, n);
            moveToTail(n);
            size++;
        }
    }
    private void moveToTail(ListNode n) {
        if (n.next != null) {
            n.pre.next = n.next;
            n.next.pre = n.pre;
        }
        ListNode last = dummyTail.pre;
        last.next = n;
        n.next = dummyTail;
        dummyTail.pre = n;
        n.pre = last;
    }
}
