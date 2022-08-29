import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


@Slf4j
public class TreeNode {
    public static void main(String[] args) {
        AwaitSignal awaitSignal = new AwaitSignal(5);
        // 构建三个条件变量
        Condition a = awaitSignal.newCondition();
        Condition b = awaitSignal.newCondition();
        Condition c = awaitSignal.newCondition();
        // 开启三个线程
        new Thread(() -> {
            awaitSignal.print("a", a, b);
        }).start();

        new Thread(() -> {
            awaitSignal.print("b", b, c);
        }).start();

        new Thread(() -> {
            awaitSignal.print("c", c, a);
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        awaitSignal.lock();
        try {
            // 先唤醒a
            a.signal();
        } finally {
            awaitSignal.unlock();
        }
    }


    static class AwaitSignal extends ReentrantLock {

        // 循环次数
        private int loopNumber;

        public AwaitSignal(int loopNumber) {
            this.loopNumber = loopNumber;
        }

        /**
         * @param print   输出的字符
         * @param current 当前条件变量
         * @param next    下一个条件变量
         */
        public void print(String print, Condition current, Condition next) {

            for (int i = 0; i < loopNumber; i++) {
                lock();
                try {
                    try {
                        // 获取锁之后等待
                        current.await();
                        System.out.print(print);
                    } catch (InterruptedException e) {
                    }
                    next.signal();
                } finally {
                    unlock();
                }
            }
        }
    }
}

