//不使用任何内建的哈希表库设计一个哈希映射（HashMap）。 
//
// 实现 MyHashMap 类： 
//
// 
// MyHashMap() 用空映射初始化对象 
// void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，
//则更新其对应的值 value 。 
// int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。 
// void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
//[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
//输出：
//[null, null, null, 1, -1, null, 1, null, -1]
//
//解释：
//MyHashMap myHashMap = new MyHashMap();
//myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
//myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
//myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
//myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
//myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= key, value <= 10⁶ 
// 最多调用 10⁴ 次 put、get 和 remove 方法 
// 
//
// 
//
// 进阶：你能否不使用内置的 HashMap 库解决此问题？ 
// Related Topics 设计 数组 哈希表 链表 哈希函数 👍 239 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MyHashMap {
    Node[] data = new Node[100];
    public MyHashMap() {
        Arrays.fill(data, new Node());
    }

    int hash_func(int key) {
        return key & 0x7fffffff;
    }
    public Node getNode(int key) {
        int ind = hash_func(key) % data.length;
        Node p = data[ind];
        while (p.next != null && p.next.key != key) p = p.next;
        return p;
    }

    public void put(int key, int value) {
        Node p = getNode(key);
        if (p.next == null) p.add(new Node(key, value));
        else p.next.val = value;
    }
    
    public int get(int key) {
        Node p = getNode(key);
        if (p.next == null) return -1;
        return p.next.val;
    }
    
    public void remove(int key) {
        Node p = getNode(key);
        if (p.next == null) return;
        p.delete();
    }
}
class Node {
    int key = -1;
    int val = -1;
    Node next = null;
    public Node() {

    }
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
    public void add(Node node) {
        node.next = this.next;
        this.next = node;
    }
    public void delete() {
        if (this.next == null) return;
        this.next = this.next.next;
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
//leetcode submit region end(Prohibit modification and deletion)
