class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class LinkedListClone {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        // 复制节点加在原节点之后
        RandomListNode currentNode = pHead;
        while (currentNode != null) {
            RandomListNode tmp = new RandomListNode(currentNode.label);
            RandomListNode next = currentNode.next;
            currentNode.next = tmp;
            tmp.next = next;
            currentNode = next;
        }
        // 重新返回起点
        currentNode = pHead;
        // 为复制节点的random指针赋值
        while (currentNode != null) {
            if (currentNode.random == null) {
                currentNode.next.random = null;
            } else {
                currentNode.next.random = currentNode.random.next;
            }
            currentNode = currentNode.next.next;
        }
        // 重新回到起点
        currentNode = pHead;
        // 定义结果链表头结点
        RandomListNode result = currentNode.next;
        // 拆分原链表
        while (currentNode != null) {
            RandomListNode tmp = currentNode.next;
            currentNode.next = tmp.next;
            tmp.next = (tmp.next == null ? null : tmp.next.next);
            currentNode = currentNode.next;
        }
        return result;
    }
}
