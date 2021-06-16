package net.eric.kafka.demo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * @Author: eric
 * @Date: 2021/6/16 11:26 下午
 */
public class BaseConsumer {
    /**
     * 模拟消息处理
     *
     * @param record
     */
    public static void recordProcess(ConsumerRecord<String, String> record,String handleName) {
        //模拟消息的业务处理
        System.out.println(
                handleName + ", topic = " + record.topic() + ", partition =" + record.partition() + ", offset = "
                + record.offset() + ", consumer = " + record.key() + ", record = " + record
                        .value());
    }

}
