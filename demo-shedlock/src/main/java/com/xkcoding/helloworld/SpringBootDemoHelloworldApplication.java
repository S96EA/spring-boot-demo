package com.xkcoding.helloworld;

import cn.hutool.core.util.StrUtil;
import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.redis.spring.RedisLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * SpringBoot启动类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-09-28 14:49
 */
@SpringBootApplication
@RestController
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "1m")
public class SpringBootDemoHelloworldApplication {

    final Logger logger = LoggerFactory.getLogger(SpringBootDemoHelloworldApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoHelloworldApplication.class, args);
    }

    /**
     * Hello，World
     *
     * @param who 参数，非必须
     * @return Hello, ${who}
     */
    @GetMapping("/hello")
    public String sayHello(@RequestParam(required = false, name = "who") String who) {
        if (StrUtil.isBlank(who)) {
            who = "World";
        }
        return StrUtil.format("Hello, {}!", who);
    }

    @Bean
    public LockProvider lockProvider(RedisConnectionFactory connectionFactory) {
        return new RedisLockProvider(connectionFactory, "SpringDemo");
    }

    @Scheduled(cron = "*/5 * * * * *")
    @SchedulerLock(name = "doProcessSchedulerLock", lockAtMostFor = "10s", lockAtLeastFor = "1s")
    public void doProcess() {
        logger.info("doProcess called");
    }

    @Scheduled(cron = "*/5 * * * * *")
    @SchedulerLock(name = "doProcessSchedulerLock", lockAtMostFor = "10s", lockAtLeastFor = "1s")
    public void doProcess2() {
        logger.info("doProcess2 called");
    }
}
