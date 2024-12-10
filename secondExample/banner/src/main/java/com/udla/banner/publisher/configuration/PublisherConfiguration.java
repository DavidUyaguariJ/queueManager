package com.udla.banner.publisher.configuration;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublisherConfiguration {
    public static String EXCHANGE_TOPIC = "banner.topic";
    public static String EXCHANGE_FANOUT = "banner.fanout";
    public static String ROUTING_KEY= "share.*.attendance";
    public static String QUEUE_ATTENDANCES = "attendances.queue";
    public static String QUEUE_NOTIFICATIONS = "notifications.queue";

    /**
     * Configure the exchange
    */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_TOPIC);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE_FANOUT);
    }

    @Bean
    public Queue attendancesQueue() {
        return new Queue(QUEUE_ATTENDANCES, true);
    }

    @Bean
    public Queue notificationsQueue() {
        return new Queue(QUEUE_NOTIFICATIONS, true);
    }
    /**
     * Configure the binding with fanout exchange
    */
    @Bean
    public Binding bindingAttendancesQueue(FanoutExchange fanoutExchange, Queue attendancesQueue) {
        return BindingBuilder.bind(attendancesQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingNotificationsQueue(FanoutExchange fanoutExchange, Queue notificationsQueue) {
        return BindingBuilder.bind(notificationsQueue).to(fanoutExchange);
    }

    /**
     * Configure the binding with topic exchange
    */
    @Bean
    public Binding bindingAttendancesQueueTopic(TopicExchange exchange, Queue attendancesQueue) {
        return BindingBuilder.bind(attendancesQueue).to(exchange).with(ROUTING_KEY);
    }
    /**
     * Configure to convert the object to json
    */
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connection){
        final var template = new RabbitTemplate(connection);
        template.setMessageConverter(messageConverter());
        return template;
    }
}