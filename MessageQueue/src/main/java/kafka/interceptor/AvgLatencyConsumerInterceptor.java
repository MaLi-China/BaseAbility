package kafka.interceptor;

import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * 功能说明：消费者拦截器
 * 开发人员：@Author MaLi
 */
public class AvgLatencyConsumerInterceptor implements ConsumerInterceptor {
    private Jedis jedis;

    public AvgLatencyConsumerInterceptor() {
        jedis = new Jedis("localhost");
    }

    //消费数据前
    @Override
    public ConsumerRecords onConsume(ConsumerRecords records) {
        long lantency = 0;
        for (Object record : records) {
            lantency += System.currentTimeMillis() - ((ConsumerRecord<?, ?>) record).timestamp();
        }
        jedis.incrBy("totalLatency", lantency);
        long totalLantency = Long.parseLong(jedis.get("totalLatency"));
        long totalSentMessage = Long.parseLong(jedis.get("totalSentMessage"));
        jedis.set("avgLatency", String.valueOf(totalLantency / totalSentMessage));
        return records;
    }

    @Override
    public void close() {
        jedis.close();
    }

    //消费数据后
    @Override
    public void onCommit(Map offsets) {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
