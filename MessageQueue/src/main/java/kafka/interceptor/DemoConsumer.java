package kafka.interceptor;

import com.nengli51.property.PropertyUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * 功能说明：测试拦截器的消费者
 * 开发人员：@Author MaLi
 */
public class DemoConsumer {
    public static void main(String[] args) {
        Properties properties = PropertyUtils.getProperties(DemoConsumer.class, "/kafkaConsumerConfig.properties");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        try {
            consumer.subscribe(Arrays.asList("mtopic"));

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println(record.key() + " ---> " + record.value());
                }
            }
        } finally {
            consumer.close();
        }
    }
}
