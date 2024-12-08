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
    public static String ROUTING_KEY_ATTENDANCE= "attendance.rounting.key";
    public static String ROUTING_KEY_ABSENCES= "absences.rounting.key";
    public static String QUEUE_ATTENDANCE = "attendance.queue";
    public static String QUEUE_ABSENCES = "absences.queue";

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
    public Queue attendanceQueue() {
        return new Queue(QUEUE_ATTENDANCE, true);
    }

    @Bean
    public Queue absencesQueue() {
        return new Queue(QUEUE_ABSENCES, true);
    }
    /**
     * Configure the binding with fanout exchange
    */
    @Bean
    public Binding bindingAttendanceQueue(FanoutExchange fanoutExchange, Queue attendanceQueue) {
        return BindingBuilder.bind(attendanceQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingAbsencesQueue(FanoutExchange fanoutExchange, Queue absencesQueue) {
        return BindingBuilder.bind(absencesQueue).to(fanoutExchange);
    }

    /**
     * Configure the binding with topic exchange
    */
    @Bean
    public Binding bindingAttendanceQueueTopic(TopicExchange exchange, Queue attendanceQueue) {
        return BindingBuilder.bind(attendanceQueue).to(exchange).with(ROUTING_KEY_ATTENDANCE);
    }

    @Bean
    public Binding bindingAbsencesQueueTopic(TopicExchange exchange, Queue absencesQueue) {
        return BindingBuilder.bind(absencesQueue).to(exchange).with(ROUTING_KEY_ABSENCES);
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