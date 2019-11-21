package com.czxy.changgou.config;

import com.czxy.changggou.config.IdWorker;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/18
 */
@EnableConfigurationProperties(IdWorkerProperties.class)
@Component
public class IdWorkerConfig {

    @Bean
    public IdWorker idWorker(IdWorkerProperties idWorkerProperties){
        return new IdWorker(idWorkerProperties.getWorkerId() ,idWorkerProperties.getDatacenterId());
    }
}
