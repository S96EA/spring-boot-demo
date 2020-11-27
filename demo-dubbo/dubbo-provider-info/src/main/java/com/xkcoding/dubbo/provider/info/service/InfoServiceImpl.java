package com.xkcoding.dubbo.provider.info.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xkcoding.dubbo.common.service.InfoService;
import org.springframework.stereotype.Component;


@Component
@Service
public class InfoServiceImpl implements InfoService {
    @Override
    public String getInfo(String name) {
        return "my name is " + name;
    }
}
