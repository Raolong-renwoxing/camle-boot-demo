package com.example.camelboot.config;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.boot.CamelConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rao QingLong
 * @date 2022/5/25 17:18
 */
@Configuration
public class CamelConfig {

    @Bean
    ProducerTemplate producerTemplate(CamelContext camelContext, CamelConfigurationProperties config) throws Exception {
        final ProducerTemplate producerTemplate = camelContext.createProducerTemplate(config.getProducerTemplateCacheSize());
        camelContext.addService(producerTemplate);
        return producerTemplate;
    }

}
