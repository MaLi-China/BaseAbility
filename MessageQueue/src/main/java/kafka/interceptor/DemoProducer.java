package kafka.interceptor;

import com.nengli51.property.PropertyUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * 功能说明：用于测试拦截器的生产者
 * 开发人员：@Author MaLi
 */
public class DemoProducer {
    public static void main(String[] args) {
        Properties properties = PropertyUtils.getProperties(DemoProducer.class, "/kafkaProducerConfig.properties");
        try (KafkaProducer<String, String> producer = new KafkaProducer(properties)) {
            for (int i = 0; i < 10; i++) {
                producer.send(new ProducerRecord("mtopic", "kafka.interceptor-DemoProducer.No:" + i));
            }
        }
    }
}
