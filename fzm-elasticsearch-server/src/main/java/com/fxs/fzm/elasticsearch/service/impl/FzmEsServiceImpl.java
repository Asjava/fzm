package com.fxs.fzm.elasticsearch.service.impl;

import com.alibaba.fastjson.JSON;
import com.fxs.fzm.common.utils.ParseUtil;
import com.fxs.fzm.elasticsearch.bean.User;
import com.fxs.fzm.elasticsearch.service.FzmEsService;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Iterator;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-10
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
@Component
public class FzmEsServiceImpl implements FzmEsService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Override
    public void createIndex(String index) throws IOException {
        // 1、 创建索引请求
        CreateIndexRequest request = new CreateIndexRequest(index);
        // 2、 客户端执行请求IndicesClient,请求后获得响应
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);
    }

    @Override
    public boolean exitIndex(String index) throws IOException {
        // 1、 创建是否存在索引请求
        GetIndexRequest request = new GetIndexRequest(index);
        boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
        return false;
    }

    @Override
    public void deleteIndex(String index) throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest(index);
        AcknowledgedResponse response = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(response);
        System.out.println(response.isAcknowledged());
    }

    @Override
    public void insertDocument() throws IOException {
        IndexRequest request = new IndexRequest("fzm_index");
        User user = new User("fzm", 20);
        request.source(JSON.toJSONString(user), XContentType.JSON);
        request.id("1");

        IndexResponse index = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        System.out.println(index.toString());
        System.out.println(index.status());

    }

    @Override
    public void updateDocument() throws IOException {
        UpdateRequest request = new UpdateRequest("fzm_index", "1");
        User user = new User("fzm_update", 20);
        request.fetchSource(true);
        request.doc(JSON.toJSONString(user), XContentType.JSON);

        UpdateResponse response = restHighLevelClient.update(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
        System.out.println(response.status());
        System.out.println(response.getGetResult());
    }

    @Override
    public void deleteDocument() throws IOException {
//        DeleteIndexRequest request = new DeleteIndexRequest("fzm_index", "1");
        DeleteRequest request = new DeleteRequest("fzm_index", "1");
        restHighLevelClient.delete(request, RequestOptions.DEFAULT);
    }

    @Override
    public void searchDocument() throws IOException {
        SearchRequest request = new SearchRequest("fzm_index");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        TermQueryBuilder queryBuilder = new TermQueryBuilder("name", "fzm");

        searchSourceBuilder.query(queryBuilder);
        request.source(searchSourceBuilder);
        SearchResponse search = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = search.getHits();
        Iterator<SearchHit> iterator = hits.iterator();
        while(iterator.hasNext()) {
            SearchHit searchHit = iterator.next();
            System.out.println(searchHit.getSourceAsString());
        }

        System.out.println(hits.toString());
        System.out.println(hits.getHits());
        System.out.println(search.toString());
    }

    @Override
    public void bulkInsertDocument() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();

        for (int i = 0; i < 5; i++) {
            IndexRequest request = new IndexRequest("fzm_index");
            User user = new User("fzm", i+1);
            request.source(JSON.toJSONString(user), XContentType.JSON);
            request.id(ParseUtil.parseString(i+1));
            bulkRequest.add(request);
        }

        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulk.hasFailures());
    }


}
