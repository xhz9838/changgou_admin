package com.czxy.changgou.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/18
 */
@ConfigurationProperties(prefix = "sc.worker")
@Data
public class IdWorkerProperties {

    private Long  workerId;

    private Long datacenterId;


}
