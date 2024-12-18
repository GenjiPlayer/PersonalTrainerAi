package demo.rabbitMQ;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Configuration
public class config {
    @Bean
    public MessageHandlerMethodFactory messageHandlerMethodFactory(){
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        final MappingJackson2MessageConverter jsonConverter = new MappingJackson2MessageConverter();
        jsonConverter.getObjectMapper().registerModule(new ParameterNamesModule(JsonCreator.Mode.PROPERTIES));
        factory.setMessageConverter(jsonConverter);
        return factory;
    }

    @Bean
    public SimpleMessageConverter converter() {
        SimpleMessageConverter converter = new SimpleMessageConverter();
        converter.setAllowedListPatterns(List.of("com.example.microserviceexam.*"));
        return converter;
    }
    @Bean
    public RabbitListenerConfigurer rabbitListenerConfigurer(final MessageHandlerMethodFactory messageHandlerMethodFactory){
        return (c) -> c.setMessageHandlerMethodFactory(messageHandlerMethodFactory);
    }

    @Bean
    public TopicExchange inputExchange(@org.springframework.beans.factory.annotation.Value("${input.exchange}") final String exchangeName)
    {
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Queue inputQueue (@org.springframework.beans.factory.annotation.Value("${input.queue}") final String queueName){
        return new Queue(queueName, true);
    }

    @Bean
    Binding binding(final Queue queue, final TopicExchange exchange, @Value("${input.anything.routing-key}") final String routingKey) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }


}
