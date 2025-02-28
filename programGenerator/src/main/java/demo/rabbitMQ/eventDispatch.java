package demo.rabbitMQ;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    @Autowired
    private ObjectMapper objectMapper;

    public void send(WorkoutModel workoutModel) {
        try {
            String json = objectMapper.writeValueAsString(workoutModel);
            rabbitTemplate.convertAndSend(inputExchange, inputAnythingRoutingKey, json, message -> {
                message.getMessageProperties().setContentType("application/json");
                return message;
            });
        } catch (Exception e) {
            System.err.println("Error while sending message: " + e.getMessage());
        }
    }
}
