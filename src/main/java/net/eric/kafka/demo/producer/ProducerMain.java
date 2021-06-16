package net.eric.kafka.demo.producer;

import net.eric.kafka.demo.common.ProducerCreator;
import net.eric.kafka.demo.pojo.Message;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * @Author: eric
 * @Date: 2021/6/13 12:53 上午
 */
public class ProducerMain {

    private static final String TOPIC = "topic1";

    private static final int PARTITION_INDEX = 4;

    public static void main(String[] args) {
        Producer producer = ProducerCreator.createProducer();

        for (int i = 1; i < 100000; i++) {
            Message msg = new Message(String.valueOf(i), "this is " + i + " record.");
            ProducerRecord record = new ProducerRecord(TOPIC, PARTITION_INDEX, String.valueOf(i),
                    msg.toString());
            try {
                //此方法并未实时发送，只是将消息放入了cache
                producer.send(record);

                //同步发送消息，
                RecordMetadata metadata = (RecordMetadata) producer.send(record).get();
                System.out.println(
                        "主题: " + metadata.topic() + ", " + "分区: " + metadata.partition() + ", "
                        + "偏移量: " + metadata.offset());
            } catch (Exception e) {
                System.out.println("第 " + i + " 条发送失败");
                e.printStackTrace();
            }
        }
    }
}
