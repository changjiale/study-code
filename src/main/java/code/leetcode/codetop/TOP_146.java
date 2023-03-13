package code.leetcode.codetop;


import java.util.HashMap;
import java.util.Map;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 *
 *
 * 示例：
 *
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *
 *
 * 提示：
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 */


class LinkedNode {
    int key;
    int value;
    LinkedNode next;
    LinkedNode pre;
    LinkedNode() {

    }
    LinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

}


//本质 是linkedhashmap的实现  linked  + hashmap
public class TOP_146 {

   private Map<Integer, LinkedNode> cache = new HashMap<Integer, LinkedNode>();
   private int capacity;  //容量
   private int size;  //实际长度 > capacity触发淘汰策略
   //增加tail节点  方便删除尾结点
   private LinkedNode head, tail;



    public TOP_146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //移动
        moveToHead(node);
        return node.value;
    }


    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if (node != null) { //创建新节点
            LinkedNode newNode = new LinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            size++;
            if (size > capacity) { //超出容量 淘汰策略->移除链表尾部
                LinkedNode pre = removeTail();
                //从cache中删除
                cache.remove(pre.key);
                size--;
            }
        } else { //更新
            node.value = value;
            moveToHead(node);
        }

    }

    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    void removeNode(LinkedNode node) {
       node.pre.next = node.next;
       node.next.pre = node.pre;
    }

    void addToHead(LinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;

    }

    LinkedNode removeTail() {
        LinkedNode pre = this.tail.pre;
        removeNode(pre);
        return pre;
    }


    public static void main(String[] args) {
        TOP_146 top_146 = new TOP_146(5);
        System.out.println();
    }

}
