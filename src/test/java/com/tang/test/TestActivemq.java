package com.tang.test;

import com.tang.service.QueueConsumerService;
import com.tang.service.QueueProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;

/**
 * Created by tangjingxiang on 2016/12/23.
 */



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestActivemq {

//    @Autowired
//    private JmsTemplate jmsTemplate;
//
//    @Autowired
//    private Destination queueDestination1;

    @Autowired
    private QueueProducerService producerService;

    @Autowired
    private Destination queueDestination;

    @Autowired
    private QueueConsumerService consumerService;

    @Test
    public void testQueueProducerMQ(){

//        jmsTemplate.send(queueDestination1, new MessageCreator() {
//            @Override
//            public Message createMessage(Session session) throws JMSException {
//                return session.createTextMessage("test queueDestination1");
//            }
//        });

        producerService.sendMessage(queueDestination, "test queueDestination1");
    }

    @Test
    public void testQueueConsumerMQ(){
        consumerService.receive(queueDestination);

    }


    @Autowired
    private Destination topicDestination;

    @Test
    public void testTopicMQ(){

    }


}
