package me.lv.record.util;


import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicLong;

class StatData {
    public long last10SecondAverage;
    public long last1MinuteAverage;
    public long last60MinuteAverage;

    public List<Long> last60SecondHistory;
}

public interface ICounter {
    void hit();

    StatData stat();
}

class Counter implements ICounter {

    private AtomicLong count = new AtomicLong();
    private CountQueue queue = new CountQueue(3600);

    @Override
    public void hit() {
        count.incrementAndGet();
    }

    @Override
    public StatData stat() {
        StatData data = new StatData();

        data.last10SecondAverage = queue.getAverage(10);
        data.last1MinuteAverage = queue.getAverage(60);
        data.last60MinuteAverage = queue.getAverage(3600);
        data.last60SecondHistory = queue.getHistory(60);

        return data;
    }

    @Scheduled(cron = "* * * * * *")
    private void onSecondTimer() {
        queue.add(count.getAndSet(0));
    }
}

class CountQueue {
    private int maxLength;
    private Deque<Long> deque = new ConcurrentLinkedDeque();

    public CountQueue(int maxLength) {
        this.maxLength = maxLength;
    }

    public synchronized void add(long count) {
        if(deque.size() == maxLength) {
            deque.pollFirst();
        }

        deque.offerLast(count);
    }

    public synchronized long getAverage(int length) {
        Iterator<Long> it = deque.descendingIterator();

        int step = 0;
        long sum = 0;

        while(it.hasNext() && step < length) {
            long count = it.next();
            sum += count;
        }

        return sum / length;
    }

    public synchronized List<Long> getHistory(int length) {
        Iterator<Long> it = deque.descendingIterator();

        int step = 0;
        List<Long> history = new ArrayList();

        while(it.hasNext() && step < length) {
            long count = it.next();

            history.add(count);
        }

        return history;
    }
}
