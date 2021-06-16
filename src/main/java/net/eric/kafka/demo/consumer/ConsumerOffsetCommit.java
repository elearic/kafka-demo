package net.eric.kafka.demo.consumer;

import net.eric.kafka.demo.common.ConsumerCreator;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static net.eric.kafka.demo.consumer.BaseConsumer.recordProcess;

/**
 * @Author: eric
 * @Date: 2021/6/13 12:53 上午
 */
public class ConsumerOffsetCommit implements Runnable {

    private static final Map<TopicPartition, OffsetAndMetadata> currentOffsets = new HashMap<>();
    private static       int                                    count          = 0;

    /**
     * 5.指定偏移量提交
     * 模拟每消费1000消息后，提交一次偏移量
     */
    private static void offsetCommit() {
        Consumer consumer = ConsumerCreator.creatorConsumer();
        consumer.subscribe(Collections.singleton("topic1"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                recordProcess(record, "ConsumerOffsetCommit");
                TopicPartition topicPartition = new TopicPartition(record.topic(),
                        record.partition());
                OffsetAndMetadata offsetAndMetadata = new OffsetAndMetadata(record.offset() + 1,
                        "no metadata");
                currentOffsets.put(topicPartition, offsetAndMetadata);
                if (count % 1000 == 0) {
                    consumer.commitAsync(currentOffsets, null);
                }
                count++;
            }
        }
    }

    @Override public void run() {
        offsetCommit();
    }
}
