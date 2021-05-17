package kafka.demo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

/**
 * 功能说明：测试学习Kafka生产者 Kafka-clients: v2.3
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/17
 */
public class MProducer {
    private Properties kafkaProps = new Properties();

    @Before
    public void init() {
        kafkaProps.put("bootstrap.servers", "192.168.88.100:9092");
        kafkaProps.put("acks", "all");
        kafkaProps.put("retries", 1);
        kafkaProps.put("batch.size", 10);
        kafkaProps.put("linger.ms", 1);
        kafkaProps.put("buffer.memory", 1024);
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    }

    @Test
    public void testSendMsgs() {
        KafkaProducer<String, String> producer = new KafkaProducer(kafkaProps);
        for (int i = 0; i < 100; i++) {
            producer.send(new ProducerRecord("mtopic", "MsgNo." + i));
        }
        producer.close();
    }
}
