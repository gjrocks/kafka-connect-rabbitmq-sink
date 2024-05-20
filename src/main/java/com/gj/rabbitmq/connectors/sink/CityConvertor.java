package com.gj.rabbitmq.connectors.sink;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaAndValue;
import org.apache.kafka.connect.storage.Converter;
import org.apache.kafka.connect.storage.HeaderConverter;

import java.io.IOException;
import java.util.Map;

public class CityConvertor implements Converter, HeaderConverter {

    //private
   private CitySerializer citySerializer;

   public CityConvertor(){
       citySerializer=new CitySerializer();
   }
    @Override
    public void close() throws IOException {
        System.out.println("I am called close");
    }

    @Override
    public void configure(Map<String, ?> map) {
        System.out.println("I am called configure");
    }

    @Override
    public void configure(Map<String, ?> map, boolean b) {
        System.out.println("I am called configure-1");
    }

    @Override
    public byte[] fromConnectData(String topic, Schema schema, Object value) {
        System.out.println("I am called fromConnectData with Topic: " + topic + " Schema :" +schema + " value:" +value);

        if (value == null) {
            System.out.println("Value is returning null");
            return null;
        }
       byte [] ret=citySerializer.serialize(topic,(City)value);
        System.out.println("Returning bytes ");
        return ret;
    }

    @Override
    public SchemaAndValue toConnectData(String s, byte[] bytes) {
        System.out.println("I am called toConnectData :" + s + " Data :" + bytes);
        if(bytes !=null)
            System.out.println("bytes size :" +bytes.length);

        return new SchemaAndValue(Schema.OPTIONAL_BYTES_SCHEMA,bytes);
    }

    @Override
    public SchemaAndValue toConnectHeader(String s, String s1, byte[] bytes) {
        System.out.println("I am called toConnectHeader");
        return null;
    }

    @Override
    public byte[] fromConnectHeader(String s, String s1, Schema schema, Object o) {
        System.out.println("I am called toConnectHeader");
        return new byte[0];
    }

    @Override
    public ConfigDef config() {
        System.out.println("I am called config");
        return null;
    }
}
