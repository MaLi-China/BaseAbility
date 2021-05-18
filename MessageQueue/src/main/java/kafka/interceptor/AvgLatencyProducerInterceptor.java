package kafka.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * 功能说明：实现生产者拦截器
 * 开发人员：@Author MaLi
 */
public class AvgLatencyProducerInterceptor implements ProducerInterceptor {
    //初始化Jedis
    private Jedis jedis;

    public AvgLatencyProducerInterceptor() {
        jedis = new Jedis("localhost");
    }

    @Override
    public ProducerRecord onSend(ProducerRecord record) {
        // 逻辑: 发送消息前更新总的已发送消息数
        jedis.incr("totalSentMessage");
        return record;
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {

    }

    @Override
    public void close() {
        jedis.close();
    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
