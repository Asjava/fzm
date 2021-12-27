package com.fxs.fzm.util;

import com.fxs.fzm.bean.Transaction;

import java.util.LinkedList;

public class TransactionUtil {
    private static final ThreadLocal<LinkedList<Transaction>> tl = new ThreadLocal<LinkedList<Transaction>>(){
        @Override
        protected LinkedList<Transaction> initialValue() {
            return new LinkedList<>();
        }
    };

    public static Transaction requiredTransation() {
        LinkedList<Transaction> stack = tl.get();
        Transaction transaction = stack.peek();
        if (transaction != null && transaction.isOpen()) {
            transaction.increaseCount();
        } else {
            transaction = new Transaction();
            stack.push(transaction);
        }
        return transaction;
    }

    public static Transaction newTransaction() {
        LinkedList<Transaction> stack = tl.get();
        Transaction transaction = new Transaction();
        stack.push(transaction);
        return transaction;
    }

    public static void destoryTransaction() {
        LinkedList<Transaction> stack = tl.get();
        stack.pop();
    }
}
