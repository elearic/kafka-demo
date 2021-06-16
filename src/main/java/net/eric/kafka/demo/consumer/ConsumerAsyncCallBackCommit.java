package net.eric.kafka.demo.consumer;

import net.eric.kafka.demo.common.ConsumerCreator;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.util.Collections;
import java.util.Map;

import static net.eric.kafka.demo.consumer.BaseConsumer.recordProcess;

/**
 * @Author: eric
 * @Date: 2021/6/13 12:53 上午
 */
public class ConsumerAsyncCallBackCommit implements Runnable{

    private static volatile int ASYNC_ID = 0;

    /**
     * 异步回调提交
     */
    private static void asyncCallBackCommit() {
        Consumer consumer = ConsumerCreator.creatorConsumer();
        consumer.subscribe(Collections.singleton("topic1"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                recordProcess(record,"ConsumerAsyncCallBackCommit");
            }
            consumer.commitAsync(new OffsetCommitCallback() {
                @Override public void onComplete(Map<TopicPartition, OffsetAndMetadata> map,
                                                 Exception e) {
                    ConsumerAsyncCallBackCommit.ASYNC_ID++;
                    int id = ConsumerAsyncCallBackCommit.ASYNC_ID;
                    if (null != e) {
                        //这里通过维护一个自增序列保证重试的安全性，如果条件成立则重试，若不成立。
                        //则说明ConsumerMain.async_id 肯定 大于 id，此时已经有其他有其他轮询提交了偏移量
                        if (id == ConsumerAsyncCallBackCommit.ASYNC_ID) {
                            // 重试
                        }
                    }
                }
            });
        }
    }

    @Override public void run() {
        asyncCallBackCommit();
    }
}
