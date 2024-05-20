package com.gj.rabbitmq.connectors.sink;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.kafka.connect.errors.ConnectException;
import org.apache.kafka.connect.errors.RetriableException;
import org.apache.kafka.connect.sink.SinkRecord;
import org.apache.kafka.connect.sink.SinkTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeoutException;



public class RabbitMQSinkTask extends SinkTask {
    private static final Logger log = LoggerFactory.getLogger(RabbitMQSinkTask.class);
    RabbitMQSinkConnectorConfig config;
    public static final String HEADER_CONF = "rabbitmq.headers";
    Channel channel;
    Connection connection;


    @Override
    public String version() {
        return VersionUtil.version(this.getClass());
    }

    @Override
    public void put(Collection<SinkRecord> sinkRecords) {
        for (SinkRecord record : sinkRecords) {
            log.trace("current sinkRecord value: " + record.value());
            System.out.println("current sinkRecord value: " + record.value());
            System.out.println("current sinkRecord value type: " + record.value().getClass().getName());
            byte[] payload=null;
            if (!(record.value() instanceof byte[])) {
                //throw new ConnectException("the value of the record has an invalid type (must be of type byte[]) it is of type " + record.value().getClass().getName());
                if(record.value() instanceof java.util.HashMap){
                    java.util.HashMap mp=(java.util.HashMap)record.value();
                    payload=org.apache.commons.lang3.SerializationUtils.serialize(mp);
                }


            }else{
                System.out.println("I got my bytes");
                payload=(byte[]) record.value();
            }


            try {
                channel.basicPublish(this.config.exchange, this.config.routingKey,
                        RabbitMQSinkHeaderParser.parse(config.getString(HEADER_CONF)), payload);
            } catch (IOException e) {
                log.error("There was an error while publishing the outgoing message to RabbitMQ");
                throw new RetriableException(e);
            }
        }
    }

    @Override
    public void start(Map<String, String> settings) {
        this.config = new RabbitMQSinkConnectorConfig(settings);
        ConnectionFactory connectionFactory = this.config.connectionFactory();
        try {
            log.info("Opening connection to {}:{}/{} (SSL: {})", this.config.host, this.config.port, this.config.virtualHost, this.config.useSsl);
            this.connection = connectionFactory.newConnection();
        } catch (IOException | TimeoutException e) {
            throw new ConnectException(e);
        }

        try {
            log.info("Creating Channel");
            this.channel = this.connection.createChannel();
            log.info("Declaring queue");
            this.channel.queueDeclare(this.config.routingKey, true, false, false, null);
        } catch (IOException e) {
            throw new ConnectException(e);
        }
    }

    @Override
    public void stop() {
        try {
            this.connection.close();
        } catch (IOException e) {
            log.error("Exception thrown while closing connection.", e);
        }
    }

}
