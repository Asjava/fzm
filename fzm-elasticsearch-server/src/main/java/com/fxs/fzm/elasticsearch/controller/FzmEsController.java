package com.fxs.fzm.elasticsearch.controller;

import com.fxs.fzm.elasticsearch.service.FzmEsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-10
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
@Controller
@RequestMapping("/api/v1/elasticsearch")
public class FzmEsController {
    @Autowired
    private FzmEsService fzmEsService;

    @GetMapping("/createIndex")
    @ResponseBody
    public void createIndex(@RequestParam String index) throws IOException {
        fzmEsService.createIndex(index);
    }

    @GetMapping("/exitIndex")
    @ResponseBody
    public void exitIndex(@RequestParam String index) throws IOException {
        fzmEsService.exitIndex(index);
    }

    @GetMapping("/deleteIndex")
    @ResponseBody
    public void deleteIndex(@RequestParam String index) throws IOException {
        fzmEsService.deleteIndex(index);
    }

    @GetMapping("/insertDocument")
    @ResponseBody
    public void insertDocument() throws IOException {
        fzmEsService.insertDocument();
    }

    @GetMapping("/updateDocument")
    @ResponseBody
    public void updateDocument() throws IOException {
        fzmEsService.updateDocument();
    }

    @GetMapping("/deleteDocument")
    @ResponseBody
    public void deleteDocument() throws IOException {
        fzmEsService.deleteDocument();
    }

    @GetMapping("/searchDocument")
    @ResponseBody
    public void searchDocument() throws IOException {
        fzmEsService.searchDocument();
    }

    @GetMapping("/bulkInsertDocument")
    @ResponseBody
    public void bulkInsertDocument() throws IOException {
        fzmEsService.bulkInsertDocument();
    }
}
