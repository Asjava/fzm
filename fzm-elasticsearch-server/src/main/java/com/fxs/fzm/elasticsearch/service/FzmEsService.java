package com.fxs.fzm.elasticsearch.service;

import java.io.IOException;

public interface FzmEsService {

    void createIndex(String index) throws IOException;

    boolean exitIndex(String index) throws IOException;

    void deleteIndex(String index) throws IOException;

    void insertDocument() throws IOException;

    void updateDocument() throws IOException;

    void deleteDocument() throws IOException;

    void searchDocument() throws IOException;

    void bulkInsertDocument() throws IOException;

}
