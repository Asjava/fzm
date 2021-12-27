package com.fxs.fzm.concurrent.ForkJoinPool;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Title: RecursiveTask<>又返回值
 *          RecursiveAction 无返回值
 * Description:
 * Copyright: Copyright (c) 2020-09-27
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class CountTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 1000;
    private long start;
    private long end;

    public CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) < 1000;
        if (canCompute) {
            for (long i = start; i <= end; i++) {
                sum += i ;
            }
        } else {
            long step = (start + end) / 100;
            ArrayList<CountTask> subTasks = new ArrayList<>();
            long pos = start;
            for (int i = 0; i < 100; i++) {
                long lastOne = pos + step;
                if (lastOne > end) {
                    lastOne = end;
                }
                CountTask countTask = new CountTask(pos, lastOne);
                pos += step +1;
                subTasks.add(countTask);
                countTask.fork();
            }

            for (CountTask t : subTasks) {
                sum += t.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task= new CountTask(0, 2000L);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);

        try {
            Long res = result.get();
            System.out.println("sum=" + res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
