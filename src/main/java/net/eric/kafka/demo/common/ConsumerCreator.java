package net.eric.kafka.demo.common;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;

/**
 * @Author: eric
 * @Date: 2021/6/13 12:55 上午
 */
public class ConsumerCreator {

    public static Consumer creatorConsumer() {
        Properties prop = new Properties();
        prop.put("bootstrap.servers", "localhost:9092");
        prop.put("group.id", "audi");
        prop.put("key.deserializer", StringDeserializer.class);
        prop.put("value.deserializer", StringDeserializer.class);
        prop.put("auto.offset.reset","earliest");
        return new KafkaConsumer(prop);
    }

}
