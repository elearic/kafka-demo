package net.eric.kafka.demo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

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
    public static void recordProcess(ConsumerRecord<String, String> record, String handleName) {
        //模拟消息的业务处理
        System.out.println(
                handleName + ", topic = " + record.topic() + ", partition =" + record.partition()
                + ", offset = " + record.offset() + ", consumer = " + record.key() + ", record = "
                + record.value());

    }

//    public void outFile(String fileName, String content) {
//        File file = new File("/Users/zz_huns/tools/kafka/consumerlog/" + fileName + ".txt");
//
//        try (FileOutputStream outputStream = new FileOutputStream(file)) {
//            content += "\n";
//            outputStream.write(content.getBytes(StandardCharsets.UTF_8));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
