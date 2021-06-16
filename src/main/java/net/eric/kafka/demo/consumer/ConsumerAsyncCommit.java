package net.eric.kafka.demo.consumer;

import net.eric.kafka.demo.common.ConsumerCreator;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.util.Collections;

import static net.eric.kafka.demo.consumer.BaseConsumer.recordProcess;

/**
 * @Author: eric
 * @Date: 2021/6/13 12:53 上午
 */
public class ConsumerAsyncCommit implements Runnable {
    /**
     * 3.异步提交
     */
    private static void asyncCommit() {
        Consumer consumer = ConsumerCreator.creatorConsumer();
        consumer.subscribe(Collections.singleton("topic1"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                recordProcess(record, "ConsumerAsyncCommit");
            }
            consumer.commitAsync();
        }
    }

    @Override public void run() {
        asyncCommit();
    }
}
