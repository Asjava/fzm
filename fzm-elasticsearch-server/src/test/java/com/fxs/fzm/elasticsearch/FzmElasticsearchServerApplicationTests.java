package com.fxs.fzm.elasticsearch;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class FzmElasticsearchServerApplicationTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void createIndex() throws IOException {
        // 1、 创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("fzm_index");
        // 2、 客户端执行请求IndicesClient,请求后获得响应
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);

        System.out.println(createIndexResponse);
    }



}
