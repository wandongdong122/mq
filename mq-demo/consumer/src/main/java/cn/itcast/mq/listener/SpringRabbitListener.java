package cn.itcast.mq.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
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

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "itcast.direct",type = ExchangeTypes.DIRECT),
            key = {"red","blue"}
    ))
    public void listenDirectQueue1(String msg){
        System.out.println("消费者接收到direct.queue2的消息：【"+ msg +"】");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "itcast.direct",type = ExchangeTypes.DIRECT),
            key = {"red","yellow"}
    ))
    public void listenDirectQueue2(String msg){
        System.out.println("消费者接收到direct.queue2的消息：【"+ msg +"】");
    }
}
