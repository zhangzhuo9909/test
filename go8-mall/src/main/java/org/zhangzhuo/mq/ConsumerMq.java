package org.zhangzhuo.mq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.zhangzhuo.common.util.JsonUtils;
import org.zhangzhuo.pojo.Product;
import org.zhangzhuo.service.SearchService;
import java.util.List;
@Component
public class ConsumerMq implements CommandLineRunner {
    @Autowired
    private SearchService searchService;
    @Override
    public void run(String... args) throws Exception {
        try {
            //新建一个消费
            DefaultMQPushConsumer pushConsumer = new DefaultMQPushConsumer("goods_group");
            //路径
            pushConsumer.setNamesrvAddr("127.0.0.1:9876");
            pushConsumer.subscribe("goods_topic","goods_es_tag");
            pushConsumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext context) {
                    for (MessageExt messageExt : list) {
                        Product product = JsonUtils.jsonToPoJo(new String(messageExt.getBody()), Product.class);
                        searchService.index(product);
                        System.out.printf("消费消息"+Thread.currentThread().getName()+list);
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            System.out.println("====================>>>>>>>>>>>>>>>开始消费数据");
            pushConsumer.start();
            System.out.println("====================>>>>>>>>>>>>>>>消费成功");

        } catch (Exception e) {
            System.out.println("============================>>>>>>>>>>消费数据失败");
            e.printStackTrace();
        }
    }
}
