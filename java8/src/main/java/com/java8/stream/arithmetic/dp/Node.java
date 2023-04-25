package com.java8.stream.arithmetic.dp;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

@Data
@RequiredArgsConstructor
public class Node {

    @NonNull
    private int value;
    private Node next;

    public Node getNodeList() {
        HashMap<Integer, Node> nodeHashMap = new LinkedHashMap<>();
        for (int i = 0; i <= 5; i++) {
            Node node = new Node(i);
            nodeHashMap.put(i, node);
        }

        for (int i = 0; i <= 5; i++) {
            Node node = nodeHashMap.get(i);

            if(i < 5) {
                node.setNext(nodeHashMap.get(i+1));
            }
        }

        Node node7 = new Node(7);
        Node node6 = new Node(6);

        nodeHashMap.get(5).setNext(node6);
        node6.setNext(node7);

        node7.setNext(nodeHashMap.get(3));
//        node7.setNext(new Node(8));




        Node head = nodeHashMap.get(0);

        HashSet<Object> sets = new HashSet<>();

        Node current = nodeHashMap.get(0);
        while (current.getNext() != null) {
            System.out.println(current.getValue());
            if (sets.contains(current.getValue())) {
                break;
            }
            sets.add(current.getValue());
            current = current.getNext();
        }
        return head;
    }
}
