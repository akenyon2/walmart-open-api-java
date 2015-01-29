package com.walmart.openapi;

import com.walmart.openapi.responses.SearchResponse;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class SearchApiTest extends TestCase {

    SearchApi rq;
    Logger log = LoggerFactory.getLogger(SearchApiTest.class);
    
    @Override
    public void setUp() throws IOException {
        FileInputStream input = new FileInputStream("config.properties");
        Properties prop = new Properties();
        prop.load(input);
        String apiKey = prop.getProperty("apikey");
        String lsPublisherId = prop.getProperty("lspublisherid");
        rq = new SearchApi(apiKey, lsPublisherId);
    }

    /**
     * Test search api lookup.
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void test_search_lookup() throws IOException, ExecutionException, InterruptedException {
        SearchResponse sr = rq.getSearchResponse("ipad");
        log.debug("Search query : " + sr.getQuery());
        log.debug("No of items in response : " +  sr.getItems().size());
        log.debug("First item : " + sr.getItems().get(0).getName());
    }

}