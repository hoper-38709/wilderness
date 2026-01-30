package com.wilderness;

import java.util.concurrent.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wilderness on 11/28/2014.
 */
public class CallableClient {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(CallableClient.class);
        logger.info("Starting callable client.");


        //Callable callableTask = new CallableTask(2);
        // Call out test TEST_RUN_COUNT times;
        int TEST_RUN_COUNT = 10;
        for (int j =0 ; j< TEST_RUN_COUNT;++j) {
            ExecutorService executor = Executors.newFixedThreadPool(10);
            CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executor);
            //List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
            int startValue = 8;
            int maxValue = 850;
            for (int i = startValue; i < maxValue; ++i) {
                completionService.submit(new CallableTask(i));
            }
            for (int i = startValue; i < maxValue; ++i) {
                try {
                    Future<Integer> f = completionService.take();
                    if (f.get() != startValue) {
                        logger.info("unexpected result is : " + f.get());
                    }
                    //logger.info("Result is : " + f.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            logger.info("Shutdown callable client.");
            executor.shutdown();
            executor.shutdownNow();
        }
    }
}
