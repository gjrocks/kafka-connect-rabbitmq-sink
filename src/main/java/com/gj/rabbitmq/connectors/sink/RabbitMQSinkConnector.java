package com.gj.rabbitmq.connectors.sink;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.sink.SinkConnector;




public class RabbitMQSinkConnector extends SinkConnector {
    Map<String, String> settings;
    RabbitMQSinkConnectorConfig config;



    @Override
    public ConfigDef config() {
        return RabbitMQSinkConnectorConfig.config();
    }

    @Override
    public void start(Map<String, String> settings) {
        this.config = new RabbitMQSinkConnectorConfig(settings);
        this.settings = settings;
    }

    @Override
    public void stop() {

    }

    @Override
    public Class<? extends Task> taskClass() {
        return RabbitMQSinkTask.class;
    }

    @Override
    public List<Map<String, String>> taskConfigs(int maxTasks) {
        List<Map<String, String>> taskConfigs = new ArrayList<>();
        for (int i = 0; i < maxTasks; i++) {
            taskConfigs.add(this.settings);
        }
        return taskConfigs;

    }

    @Override
    public String version() {
        return VersionUtil.version(this.getClass());
    }

}
