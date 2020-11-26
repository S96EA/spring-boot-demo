package com.xkcoding.orm.jpa;

import com.xkcoding.orm.jpa.repository.UserDao;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 启动类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-10-28 22:58
 */
@SpringBootApplication
public class SpringBootDemoOrmJpaApplication {
    @Autowired
    UserDao userDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoOrmJpaApplication.class, args);
    }

    @Transactional
    public void updateStatusByName(String name) {
        userDao.updateStatusByName(name, 0);
        int i = 1 / 0;
    }
}
