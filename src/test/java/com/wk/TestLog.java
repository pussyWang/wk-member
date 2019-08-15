package com.wk;

import com.demo.controller.SystemConfigController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wangkang04 on 2018/8/17
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/applicationContext-server.xml"})
public class TestLog {
    private static final Logger logger = LoggerFactory.getLogger(TestLog.class);

    @Value("${catalina.home}")
    String catalinaHome;

    @Test
    public void test(){
        logger.info("wk-->this is test log");
        logger.info("wk-->catalina.home:{}",catalinaHome);
    }
}
