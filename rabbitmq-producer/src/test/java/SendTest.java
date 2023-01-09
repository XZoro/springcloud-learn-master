import com.example.rabbitmq.producer.RabbitProducerApplication;
import com.example.rabbitmq.producer.config.RabbitmqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author xzq
 * @date 2023年01月09日 16:22
 */
@SpringBootTest(classes = RabbitProducerApplication.class)
@RunWith(SpringRunner.class)
public class SendTest {

    @Resource
    RabbitTemplate rabbitTemplate;

    @Test
    public void sendMsgByTopics() {
        for (int i = 0; i < 5; i++) {
            String message = "恭喜您，注册成功！userid=" + i;
            rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_NAME, "topic.sms.email", message);
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}
