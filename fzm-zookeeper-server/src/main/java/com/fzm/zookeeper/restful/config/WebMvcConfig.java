package com.fzm.zookeeper.restful.config;

import com.fzm.zookeeper.restful.factory.DollarToCentFormatAnnotationFormatterFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldAnnotation(new DollarToCentFormatAnnotationFormatterFactory());
    }
}
