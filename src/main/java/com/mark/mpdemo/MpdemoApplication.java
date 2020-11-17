package com.mark.mpdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
//@ImportResource("classpath:applicationContext-mp.xml")
//@MapperScan("com.mark.mpdemo.mapper")
public class MpdemoApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(MpdemoApplication.class, args);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
