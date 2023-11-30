package cn.gov.chinatax.gt4.swrdsm.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/**
 * Jackson配置
 *
 * @author huax
 */
@Configuration
public class JacksonConfig {

    /**
     * DateTime格式化字符串
     */
    private static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * Date格式化字符串
     */
    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

    /**
     * Time格式化字符串
     */
    private static final String DEFAULT_TIME_PATTERN = "HH:mm:ss";

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer defaultJackson2ObjectMapperBuilderCustomizer() {
        return builder -> {
            // long转为string给前端
            builder.serializerByType(Long.class, ToStringSerializer.instance)
                    // 忽略空字段
                    .serializationInclusion(JsonInclude.Include.NON_NULL)
                    // 指定时区
                    .timeZone(TimeZone.getDefault())
                    // 日期类型字符串处理
                    .dateFormat(new SimpleDateFormat(DEFAULT_DATETIME_PATTERN))
                    .serializerByType(LocalDateTime.class,
                           new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DEFAULT_DATETIME_PATTERN)))
                    .deserializerByType(LocalDateTime.class,
                            new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DEFAULT_DATETIME_PATTERN)));
//                    .serializerByType(LocalDate.class,
//                            new LocalDateSerializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN)))
//                    .deserializerByType(LocalDate.class,
//                            new LocalDateDeserializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN)))
//                    .serializerByType(LocalTime.class,
//                            new LocalTimeSerializer(DateTimeFormatter.ofPattern(DEFAULT_TIME_PATTERN)))
//                    .deserializerByType(LocalTime.class,
//                            new LocalTimeDeserializer(DateTimeFormatter.ofPattern(DEFAULT_TIME_PATTERN)));
        };
    }

}