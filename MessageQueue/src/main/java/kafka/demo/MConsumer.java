package kafka.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Properties;

/**
 * 功能说明：数据消费端: 消费mtopic主题数据
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/17
 */
public class MConsumer {

    private Properties kafkaProps = new Properties();

    @Before
    public void initKafka() {
        kafkaProps.put("bootstrap.servers", "192.168.88.100:9092");
        kafkaProps.put("enable.auto.commit", "true");
        kafkaProps.put("auto.commit.interval.ms", "1000");
        kafkaProps.put("session.timeout.ms", "30000");
        kafkaProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProps.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProps.put("group.id", "mconsumers");
//        kafkaProps.put(ConsumerConfig.GROUP_ID_CONFIG,"mbigdata");
    }

    @Test
    public void testGetMsgs() {
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(kafkaProps);
        consumer.subscribe(Arrays.asList("mtopic"));
        try {
            while (true) {
                //这里面是我们所有拉取到的数据
                ConsumerRecords<String, String> consumerRecords = consumer.poll(1000);
                for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                    long offset = consumerRecord.offset();
                    String value = consumerRecord.value();
                    System.out.println("消息的offset值为" + offset + "消息的value值为" + value);
                }
            }
        } finally {
            consumer.close();
        }
    }
}
