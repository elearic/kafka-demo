package net.eric.kafka.demo.producer;

/**
 * @Author: eric
 * @Date: 2021/6/17 11:34 下午
 */
public class ExecutorProducer {

    public static void main(String[] args) {

        for (int i = 0; i < 1; i++) {
            Thread producer = new Thread(new ProducerThread("topic", i));
            producer.start();
        }
    }
}
