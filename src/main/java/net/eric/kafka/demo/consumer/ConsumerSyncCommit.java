package net.eric.kafka.demo.consumer;

import net.eric.kafka.demo.common.ConsumerCreator;
import org.apache.kafka.clients.consumer.CommitFailedException;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.util.Collections;

import static net.eric.kafka.demo.consumer.BaseConsumer.recordProcess;

/**
 * @Author: eric
 * @Date: 2021/6/13 12:53 上午
 */
public class ConsumerSyncCommit implements Runnable {

    /**
     * 2.同步提交 (提交当前偏移量)
     */
    private static void syncCommit() {
        Consumer consumer = ConsumerCreator.creatorConsumer();
        consumer.subscribe(Collections.singleton("topic1"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                recordProcess(record, "ConsumerSyncCommit");
                try {
                    consumer.commitSync();
                } catch (CommitFailedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override public void run() {
        syncCommit();
    }
}
