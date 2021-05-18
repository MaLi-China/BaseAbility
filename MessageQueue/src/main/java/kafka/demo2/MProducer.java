package kafka.demo2;

import com.nengli51.property.PropertyUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

/**
 * 功能说明：探索生产者原理
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/17
 */
public class MProducer {
    private Properties producerProps = null;

    @Before
    public void initProp() {
        //获取配置属性
        producerProps = PropertyUtils.getProperties(MProducer.class, "/kafkaProducerConfig.properties");

    }

    @Test
    public void testProducer() {
        try (
                KafkaProducer<String, String> producer = new KafkaProducer<>(producerProps)
        ) {
            String topic = "mtopic";
            for (int i = 0; i < 10; i++) {
                producer.send(new ProducerRecord<>(topic, "msg"));
            }
        }
    }
}
