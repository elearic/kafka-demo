package net.eric.kafka.demo.pojo;

/**
 * @Author: eric
 * @Date: 2021/7/1 11:52 下午
 */
public class Demo1 {

    public static void main(String[] args) {
        Message m1 = new Message();
        m1.setId("1");
        m1.setContent("this is m1");

        Message m2 = m1;

//        System.out.println("==> m1 <=="+ m1);
//        System.out.println("==> m2 <=="+ m2);

        Message m3 = new Message();
        m3.setId("3");
        m3.setContent("this is m3");

        m2 = m3;

        System.out.println("==> m1 <=="+ m1);
        System.out.println("==> m2 <=="+ m2);
        System.out.println("==> m3 <=="+ m3);
    }


}
