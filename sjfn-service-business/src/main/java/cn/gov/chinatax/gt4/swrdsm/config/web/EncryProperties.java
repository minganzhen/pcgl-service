package cn.gov.chinatax.gt4.swrdsm.config.web;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;
import java.util.List;

/**
 * encryption 配置属性
 */
@ConfigurationProperties(prefix = "chinatax.gt4.encryption")
@Validated
@Data
public class EncryProperties {

    /**
     * 是否开启，默认为 true
     */
    private boolean enable = true;
    /**
     * 需要排除的 URL，默认为空
     */
    private List<String> excludeUrls = Collections.emptyList();

}
