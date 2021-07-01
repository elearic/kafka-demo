package net.eric.kafka.demo.pojo;

/**
 * @Author: eric
 * @Date: 2021/7/1 11:18 下午
 */
public class RefTest {

    public static void doErrorHandle() {
        boolean a = false;
        int b = 5;
        passBaseValue(a, b);
        if (a == true || b == 10) {
            System.out.println("Execute Something");
        } else {
            System.out.println("param result wrong");
        }
    }

    public static void passBaseValue(boolean flg, int num) {
        flg = true;
        num = 10;
    }

    public static void main(String[] args) {
        doErrorHandle();
    }
}
