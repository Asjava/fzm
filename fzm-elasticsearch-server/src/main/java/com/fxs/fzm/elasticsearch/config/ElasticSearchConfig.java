package com.fxs.fzm.elasticsearch.config;

import com.fxs.fzm.common.utils.ParseUtil;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-10
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
@Configuration
public class ElasticSearchConfig {

    /*@Value("elasticsearch.server.host")
    private String host;

    @Value("elasticsearch.server.port")
    private String port;

    @Value("elasticsearch.server.type")
    private String type;*/
    /**
     * bean注解 id=restHighLevelClient，class = RestHighLevelClient
     * @return
     */
    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")));
        return client;
    }

}
