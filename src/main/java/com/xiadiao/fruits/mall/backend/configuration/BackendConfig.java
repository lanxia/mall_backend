package com.xiadiao.fruits.mall.backend.configuration;

import com.github.pagehelper.PageInterceptor;
import lombok.Data;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.util.Map;
import java.util.Properties;

@Configuration
@MapperScan("com.xiadiao.fruits.mall.backend.dao")
public class BackendConfig {
    @Autowired
    private MybatisProperties mybatisProperties;

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setResolveLazily(true);
        resolver.setMaxInMemorySize(40960);
        resolver.setMaxUploadSize(50 * 1024 * 1024);
        return resolver;
    }


    @Bean
    @ConditionalOnExpression("${database.mybatis.enable:false}")
    public PageInterceptor pageInterceptor() {
        PageInterceptor interceptor = new PageInterceptor();
        if (!CollectionUtils.isEmpty(mybatisProperties.pagehelper)) {
            Properties properties = new Properties();
            for (Map.Entry<String, String> entry : mybatisProperties.pagehelper.entrySet()) {
                properties.setProperty(entry.getKey(), entry.getValue());
            }
            interceptor.setProperties(properties);
        }
        return interceptor;
    }

    /**
     * mybatis配置类
     */
    @Data
    @Component
    @ConfigurationProperties(prefix = "database.mybatis")
//    @ConditionalOnExpression("${database.mybatis.enable:false}")
    public static class MybatisProperties {
        /**
         * 分页组件配置信息
         */
        private Map<String, String> pagehelper;
    }
}
