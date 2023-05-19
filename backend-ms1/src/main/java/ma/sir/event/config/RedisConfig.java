package ma.sir.event.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.lettuce.core.RedisClient;
import ma.sir.event.bean.core.EvenementRedis;
import ma.sir.event.ws.dto.EvenementDto;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.*;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;

import java.time.Duration;

@Configuration
@EnableCaching
@EnableRedisRepositories
public class RedisConfig {
   /* @Bean
    public JedisConnectionFactory connectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName("localhost");
        configuration.setPort(6379);
        return new JedisConnectionFactory(configuration);
    }

    @Bean
    public RedisTemplate<String, Object> template() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new JdkSerializationRedisSerializer());
        template.setEnableTransactionSupport(true);
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(EvenementDto.class));
        template.afterPropertiesSet();
        return template;
    }

    private final ObjectMapper mapper = createObjectMapper();
    private ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    public <T> T objectMapper(Object obj, Class<T> contentClass){
        return mapper.convertValue(obj, contentClass);
    }
*/
   @Bean
   public LettuceConnectionFactory connectionFactory() {
       return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost", 6379));
   }

    @Bean
   public ReactiveRedisTemplate<String, EvenementRedis> reactiveRedisTemplate() {
        Jackson2JsonRedisSerializer<EvenementRedis> serializer = new Jackson2JsonRedisSerializer<>(EvenementRedis.class);
        RedisSerializationContext<String, EvenementRedis> serializationContext = RedisSerializationContext.<String, EvenementRedis>newSerializationContext()
                .key(new StringRedisSerializer())
                .value(serializer)
                .hashKey(new StringRedisSerializer())
                .hashValue(serializer)
                .build();
        return new ReactiveRedisTemplate<>(connectionFactory(), serializationContext);
    }

    private final ObjectMapper mapper = createObjectMapper();

    private ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    public <T> T objectMapper(Object obj, Class<T> contentClass){
        return mapper.convertValue(obj, contentClass);
    }

}
