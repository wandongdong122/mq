package cn.itcast.mq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SpringRabbitListener {
    @RabbitListener(queues = "simple.queue")
    private void listenSimpleQueue(String msg){
        System.out.println("消费者接收到simple.queue的消息：【"+ msg +"】");
    }

    @RabbitListener(queues = "fanout.queue1")
    private void listenFanoutQueue1(String msg){
        System.out.println("消费者1接收到fanout.queue1的消息：【"+ msg +"】");
    }

    @RabbitListener(queues = "fanout.queue2")
    private void listenFanoutQueue2(String msg){
        System.err.println("消费者2接收到fanout.queue2的消息：【"+ msg +"】");
    }
}
