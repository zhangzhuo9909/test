package org.zhangzhuo.mq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

@Component
public class ProducterMq {
    public void sendMessage(String group,String topic,String tag,byte[] message) throws Exception {
        //新建一个生产者
        DefaultMQProducer producer = new DefaultMQProducer(group);
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        producer.setRetryTimesWhenSendAsyncFailed(0);
        Message message1 = new Message(topic, tag, message);
        //发送消息
        producer.send(message1);
        //关闭
        producer.shutdown();
    }
}
