package cn.itcast.mq.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAmqpTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessage2SimpleQueue(){
        String queueName = "simple.queue";
        String message = "hello,spring amqp!";
        rabbitTemplate.convertAndSend(queueName,message);
    }

    @Test
    public void testSendMessage2Exchange(){
        String exchangeName = "itcast.fanout";
        String message = "hello,every one!";
        rabbitTemplate.convertAndSend(exchangeName,"",message);
    }

    @Test
    public void testSendDirectExchange(){
        String exchangeName = "itcast.direct";
        String message = "hello,yellow!";
        rabbitTemplate.convertAndSend(exchangeName,"yellow",message);
    }

}
