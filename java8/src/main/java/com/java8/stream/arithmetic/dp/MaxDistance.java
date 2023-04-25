package com.java8.stream.arithmetic.dp;

import lombok.AllArgsConstructor;
import lombok.Data;

public class MaxDistance {

    @Data
    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    @Data
    @AllArgsConstructor
    public static class ResultInfo {
        private int distance;
        private int height;
    }

    public int getMaxDistance(Node head){
       return process(head).getDistance();
    }

    public ResultInfo process(Node node) {
        if (node == null) {
            return new ResultInfo(0,0);
        }

        ResultInfo leftInfo = process(node.left);
        ResultInfo right = process(node.right);

        int p1 = leftInfo.getDistance();
        int p2 = right.getDistance();
        int p3 = leftInfo.getHeight() + 1 + right.getHeight();
        int maxDistance = Math.max(Math.max(p1, p2), p3);
        int maxHeight = Math.max(leftInfo.getHeight(), right.getHeight()) + 1;
        return  new ResultInfo(maxDistance, maxHeight);
    }

    public static void main(String[] args) {

        Node left2 = new Node(5, null, null);
        Node left1 = new Node(4, left2, null);
        Node left = new Node(1, left1, null);

        Node right = new Node(2, null, null);
        Node head = new Node(3, left, right);

        int maxDistance = new MaxDistance().getMaxDistance(head);
        System.out.println(maxDistance);
    }

}
