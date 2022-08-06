package com.Maker.cmd_prompt;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
@Component
public class MyBean {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent event) {
        logger.info("All Beans have been initizalized. Application is ready to service requests");
    }
}