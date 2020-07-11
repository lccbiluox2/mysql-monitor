package com.neo.config;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class BlogConfig {

    private static final Logger LOG = LoggerFactory.getLogger(BlogConfig.class);

    /**
     * 绑定的主机名
     */
    @Value("${blog.md.path:/Users/lcc/IdeaProjects/docs}")
    private String blogAddress;
}
