package demo.rabbitMQ;

import demo.model.WorkoutModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class eventDispatch {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${input.exchange}")
    private String inputExchange;
    @Value("${input.anything.routing-key}")
    private String inputAnythingRoutingKey;

    public WorkoutModel send(WorkoutModel model){
        rabbitTemplate.convertAndSend(inputExchange, inputAnythingRoutingKey, model);
        System.out.println("YAHOOO!" + model);
        return model;
    }
}
