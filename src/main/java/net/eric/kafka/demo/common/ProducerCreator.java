package net.eric.kafka.demo.common;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @Author: eric
 * @Date: 2021/6/13 12:55 上午
 */
public class ProducerCreator {

    public static Producer createProducer() {
        Properties prop = new Properties();
        prop.put("bootstrap.servers", "localhost:9092");
        prop.put("key.serializer", StringSerializer.class);
        prop.put("value.serializer", StringSerializer.class);
        return new KafkaProducer(prop);
    }
}
