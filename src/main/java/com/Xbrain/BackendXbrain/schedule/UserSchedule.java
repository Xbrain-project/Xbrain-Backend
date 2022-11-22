package com.Xbrain.BackendXbrain.schedule;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserSchedule {

    @Scheduled(cron = "0 * * * * *")
    public void testEveryMin(){
//        log.info("test 1");
    }
}
