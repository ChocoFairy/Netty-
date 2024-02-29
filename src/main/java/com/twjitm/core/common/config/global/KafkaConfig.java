package com.twjitm.core.common.config.global;import org.springframework.stereotype.Service;import java.io.IOException;import java.util.Properties;/** * kafka 配置 * * @author twjitm - [Created on 2018-09-04 14:17] * @company https://github.com/twjitm/ * @jdk java version "1.8.0_77" */@Servicepublic class KafkaConfig {    private int taskThreadSize;    private int corePoolSize;    private int maximumPoolSize;    private int keepAliveTime;    public void init() {        Properties properties = new Properties();        try {            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(GlobalConstants.ConfigFile.KAFKA_PROPERTIES_FILE_PATH));            taskThreadSize = Integer.parseInt(properties.getProperty("kafka.taskThreadSize"));            corePoolSize = Integer.parseInt(properties.getProperty("kafka.corePoolSize"));            maximumPoolSize = Integer.parseInt(properties.getProperty("kafka.maximumPoolSize"));            keepAliveTime = Integer.parseInt(properties.getProperty("kafka.keepAliveTime"));        } catch (IOException e) {            e.printStackTrace();        }    }    public int getTaskThreadSize() {        return taskThreadSize;    }    public int getCorePoolSize() {        return corePoolSize;    }    public int getMaximumPoolSize() {        return maximumPoolSize;    }    public int getKeepAliveTime() {        return keepAliveTime;    }}