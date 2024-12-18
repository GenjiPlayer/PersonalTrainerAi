package demo.rabbitMQ;

import demo.model.WorkoutModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class consumer {
    @RabbitListener(queues = "${input.queue}")
    public void recievedPayload(WorkoutModel workoutModel){
        System.out.println("YIPPIIEIIEIEIEIEIEI" + workoutModel);
    }

}
