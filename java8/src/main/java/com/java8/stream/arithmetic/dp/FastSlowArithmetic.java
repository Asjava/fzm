package com.java8.stream.arithmetic.dp;

public class FastSlowArithmetic {



    public static void main(String[] args) {
        Node node = new Node(1);
        Node head = node.getNodeList();

        Node loopNode = getLoopNode(head);
        System.out.println(loopNode);

        FastSlowArithmetic fastSlowArithmetic = new FastSlowArithmetic();
        boolean result = fastSlowArithmetic.LoopJuger(head);
        System.out.println(result);
    }

    /**
     * 判断链表是否无环还是有环
     * @param node
     * @return
     */
    public boolean LoopJuger(Node node) {
        if (node == null || node.getNext() == null || node.getNext().getNext() == null) {
            return false;
        }

        Node fastNode = node.getNext().getNext();
        Node slowNode = node.getNext();

        // 找到快指针与慢指针第一次相遇的点
        while (fastNode != slowNode) {
            if (fastNode.getNext() == null || fastNode.getNext().getNext() == null) {
                return false;
            }

            if (fastNode == slowNode) {
                break;
            }
            fastNode = fastNode.getNext().getNext();
            slowNode = slowNode.getNext();
        }

        // 从头节点重新遍历下去直到与慢指针相遇就是相交点
        fastNode = node;
        while (fastNode != slowNode) {
            fastNode = fastNode.getNext();
            slowNode = slowNode.getNext();
        }

        System.out.println("相交的点为；"+fastNode.getValue());
        return true;
    }

    /**
     * 判断链表是否无环还是有环，获取对应的相交节点
     * @param node
     * @return
     */
    public static Node getLoopNode(Node node) {
        if (node == null || node.getNext() == null || node.getNext().getNext() == null) {
            return null;
        }

        Node fastNode = node.getNext().getNext();
        Node slowNode = node.getNext();

        // 找到快指针与慢指针第一次相遇的点
        while (fastNode != slowNode) {
            if (fastNode.getNext() == null || fastNode.getNext().getNext() == null) {
                return null;
            }

            if (fastNode == slowNode) {
                break;
            }

            fastNode = fastNode.getNext().getNext();
            slowNode = slowNode.getNext();
        }

        // 从头节点重新遍历下去直到与慢指针相遇就是相交点
        fastNode = node;
        while (fastNode != slowNode) {
            fastNode = fastNode.getNext();
            slowNode = slowNode.getNext();
        }

        System.out.println("相交的点为；"+ fastNode);
        return fastNode;
    }
}
