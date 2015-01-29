package com.walmart.openapi;

import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataFeedManagerTest extends TestCase {

    long startTimeInMillis;
    long endTimeInMillis;
    long itemsCount;
    DataFeedManager dataFeedManager;
    Logger log = LoggerFactory.getLogger(DataFeedManagerTest.class);

    @Override
    public void setUp() throws IOException {
        FileInputStream input = new FileInputStream("config.properties");
        Properties prop = new Properties();
        prop.load(input);
        String apiKey = prop.getProperty("apikey");
        dataFeedManager = new DataFeedManager(apiKey);
        startTimeInMillis = System.currentTimeMillis();
    }

    /**
     * Download specialbuys items from the electronics category.
     * @throws Exception
     */
    public void test_feedIterator_specialbuys_electronics() throws Exception {
        DataFeedManager.FeedIterator feedIterator = dataFeedManager.getFeedIterator(DataFeedManager.FeedsType.SPECIALBUY, "3944");
        int counter = 0;
        while(feedIterator.hasNext()) {
            counter = counter + 1;
            feedIterator.next();
            if (counter%1000 == 0) log.debug("." + counter + "...");
            if (counter == 10000) {
                break;
            }
        }
        itemsCount = counter;
    }

    /**
     * Download bestsellers items from the electronics category.
     * @throws Exception
     */
    public void test_feedIterator_bestsellers_electronics() throws Exception {
        DataFeedManager.FeedIterator feedIterator = dataFeedManager.getFeedIterator(DataFeedManager.FeedsType.BESTSELLERS, "3944");
        int counter = 0;
        while(feedIterator.hasNext()) {
            counter = counter + 1;
            feedIterator.next();
            if (counter%1000 == 0) log.debug("." + counter + "...");
            if (counter == 10000) {
                break;
            }
        }
        itemsCount = counter;
    }

    /**
     * Download preorder items from the electronics category.
     * @throws Exception
     */
    public void test_feedIterator_preorder() throws Exception {
        DataFeedManager.FeedIterator feedIterator = dataFeedManager.getFeedIterator(DataFeedManager.FeedsType.PREORDER, "");
        int counter = 0;
        while(feedIterator.hasNext()) {
            counter = counter + 1;
            feedIterator.next();
            if (counter%1000 == 0) log.debug("." + counter + "...");
            if (counter == 10000) {
                break;
            }
        }
        itemsCount = counter;
    }

    /**
     * Download clearance items from the electronics category.
     * @throws Exception
     */
    public void test_feedIterator_clearance() throws Exception {
        DataFeedManager.FeedIterator feedIterator = dataFeedManager.getFeedIterator(DataFeedManager.FeedsType.CLEARANCE, "");
        int counter = 0;
        while(feedIterator.hasNext()) {
            counter = counter + 1;
            feedIterator.next();
            if (counter%1000 == 0) log.debug("." + counter + "...");
            if (counter == 10000) {
                break;
            }
        }
        itemsCount = counter;
    }

    /**
     * Download roll back items from the electronics category.
     * @throws Exception
     */
    public void test_feedIterator_rollback_electronics() throws Exception {
        DataFeedManager.FeedIterator feedIterator = dataFeedManager.getFeedIterator(DataFeedManager.FeedsType.ROLLBACK, "3944");
        int counter = 0;
        while(feedIterator.hasNext()) {
            counter = counter + 1;
            feedIterator.next();
            if (counter%1000 == 0) log.debug("." + counter + "...");
            if (counter == 10000) {
                break;
            }
        }
        itemsCount = counter;
    }

    /**
     * Download the Electronics category feed.
     * @throws Exception
     */
    public void test_feedIterator_download_electronics_category_feed() throws Exception {
        DataFeedManager.FeedIterator feedIterator = dataFeedManager.getFeedIterator(DataFeedManager.FeedsType.ITEMS, "3944");
        int counter = 0;
        while(feedIterator.hasNext()) {
            counter = counter + 1;
            feedIterator.next();
            if (counter%1000 == 0) log.debug("." + counter + "...");
            if (counter == 10000) {
                break;
            }
        }
        itemsCount = counter;
    }


    /**
     * Download a sample from the complete Walmart catalog.
     * @throws Exception
     */
    public void test_feedIterator_download_complete_feed() throws Exception {
        DataFeedManager.FeedIterator feedIterator =
                dataFeedManager.getFeedIterator(DataFeedManager.FeedsType.ITEMS);
        int counter = 0;
        while(feedIterator.hasNext()) {
            counter = counter + 1;
            feedIterator.next();
            if (counter%1000 == 0) log.debug("." + counter + "...");
            if (counter == 10000) {
                break;
            }
        }
        itemsCount = counter;
    }

    @Override
    public void tearDown() {
        log.debug("Total Items seen : " + itemsCount);
        endTimeInMillis = System.currentTimeMillis();
        log.debug("Time consumed in seconds : " + (endTimeInMillis - startTimeInMillis)/1000);
    }

}