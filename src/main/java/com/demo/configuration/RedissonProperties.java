package com.demo.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description: RedissonProperties
 * @date: 2020/6/11 3:09 下午
 * @author: TX
 * @version: 1.0
 */
@Data
@ConfigurationProperties(prefix = "redisson")
public class RedissonProperties {

    private int timeout = 3000;

    private String address;

    private String password;

    private int database = 0;

    private int connectionPoolSize = 20;

    private int connectionMinimumIdleSize = 10;

    private int slaveConnectionPoolSize = 20;

    private int masterConnectionPoolSize = 20;

    private String[] sentinelAddresses;

    private String masterName;

    public void setSentinelAddresses(String sentinelAddresses) {
        this.sentinelAddresses = sentinelAddresses.split(",");
    }
}
