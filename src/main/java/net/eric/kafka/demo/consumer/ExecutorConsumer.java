package net.eric.kafka.demo.consumer;

/**
 * @Author: eric
 * @Date: 2021/6/16 11:57 下午
 */
public class ExecutorConsumer {

    public static void main(String[] args) {
        Thread threadAutocommit = new Thread(new ConsumerAutoCommit());
//        Thread threadSynccommit = new Thread(new ConsumerSyncCommit());

        threadAutocommit.start();
//        threadSynccommit.start();

//        Long start = System.currentTimeMillis();
//        start += 1*10*1000;
//        while (true){
//            if (System.currentTimeMillis() > start){
//                threadAutocommit.stop();
//                System.out.println("threadAutocommit.结束了");
//                break;
//            }
//        }
    }
}
