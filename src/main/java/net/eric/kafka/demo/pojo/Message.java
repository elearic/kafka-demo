package net.eric.kafka.demo.pojo;

/**
 * @Author: eric
 * @Date: 2021/6/14 12:00 上午
 */
public class Message {

    private String id;

    private String content;

    public Message() {
    }

    public Message(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override public String toString() {
        return "Message{" + "id='" + id + ", content='" + content + '}';
    }
}
