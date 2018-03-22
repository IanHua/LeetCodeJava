class LRUCache {
    
    private class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    private void addNode(DLinkedNode node){
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    private void removeNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        pre.post = post;
        post.pre = pre;
    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail(){
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }

    private Map<Integer, DLinkedNode> cache;
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        count = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        head.pre = null;
        tail = new DLinkedNode();
        tail.post = null;
        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        DLinkedNode node = cache.get(key);
        moveToHead(node);
        return node.value;
    }


    public void put(int key, int value) {
        if(!cache.containsKey(key)){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            addNode(newNode);
            ++count;
            if(count > capacity){
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --count;
            }
        } else {
            DLinkedNode node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */