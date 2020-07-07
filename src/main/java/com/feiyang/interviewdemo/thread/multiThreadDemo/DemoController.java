package com.feiyang.interviewdemo.thread.multiThreadDemo;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-08-07 15:38
 **/
@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping
    public synchronized void getMethod() {

        System.out.println("getMethod controller");
    }

    public static void main(String[] args) throws Exception {
        //URL realUrl = new URL("http://localhost:15017/demo");
        //URLConnection connection = realUrl.openConnection();
        //connection.connect();



        //CloseableHttpClient httpClient = HttpClients.createDefault();
        //HttpGet httpGet = new HttpGet("http://localhost:15017/demo");
        //httpClient.execute(httpGet);

        requestByGet();

    }

    public static void requestByGet() throws InterruptedException {
        DemoController demoController = new DemoController();
        CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(demoController.new RequestOper(latch));
            thread.setName("Thread" + i);
            thread.start();
        }

        System.out.println("threads already start, sleep for a while...");
        Thread.sleep(1000);
        latch.countDown();

    }

    public class RequestOper implements Runnable {

        CountDownLatch latch;

        public RequestOper(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                latch.await();
                CloseableHttpClient httpClient = HttpClients.createDefault();
                HttpGet httpGet = new HttpGet("http://localhost:15017/demo");
                httpClient.execute(httpGet);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Sync Started!");
        }
    }

}
