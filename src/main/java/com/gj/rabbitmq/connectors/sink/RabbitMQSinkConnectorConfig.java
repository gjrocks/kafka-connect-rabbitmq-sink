package com.gj.rabbitmq.connectors.sink;

import java.util.Map;


import org.apache.kafka.common.config.ConfigDef;



public class RabbitMQSinkConnectorConfig extends RabbitMQConnectorConfig {
    static final String KAFKA_TOPIC_TEMPLATE = "kafkaTopicTemplate";
    public static final String TOPIC_CONF = "topics";
    static final String TOPIC_DOC = "Kafka topic to read the messages from.";

    //TODO: add the support for queue destinations

    public static final String EXCHANGE_CONF = "rabbitmq.exchange";
    static final String EXCHANGE_DOC = "exchange to publish the messages on.";

    public static final String ROUTING_KEY_CONF = "rabbitmq.routing.key";
    static final String ROUTING_KEY_DOC = "routing key used for publishing the messages.";


    public static final String HEADER_CONF = "rabbitmq.headers";
    public static final String HEADER_CONF_DOC = "Headers to set for outbounf messages. Set with `headername1`:`headervalue1`,`headername2`:`headervalue2`";
    //TODO: include other config variables here

    public final String kafkaTopic;
    public final String exchange;
    public final String routingKey;

    public RabbitMQSinkConnectorConfig(Map<String, String> settings) {
        super(config(), settings);
        final String kafkaTopicFormat = this.getString(TOPIC_CONF);
        this.kafkaTopic =this.getString(TOPIC_CONF);
     //   this.kafkaTopic.addTemplate(KAFKA_TOPIC_TEMPLATE, kafkaTopicFormat);
        this.exchange = this.getString(EXCHANGE_CONF);
        this.routingKey = this.getString(ROUTING_KEY_CONF);
    }

    public static ConfigDef config() {
        return RabbitMQConnectorConfig.config()
                .define(TOPIC_CONF, ConfigDef.Type.STRING, ConfigDef.Importance.HIGH, TOPIC_DOC)
                .define(EXCHANGE_CONF, ConfigDef.Type.STRING, "", ConfigDef.Importance.MEDIUM, EXCHANGE_DOC)
                .define(ROUTING_KEY_CONF, ConfigDef.Type.STRING, ConfigDef.Importance.HIGH, ROUTING_KEY_DOC)
                .define(HEADER_CONF, ConfigDef.Type.STRING, null, null, ConfigDef.Importance.LOW, HEADER_CONF_DOC);


    }

}
