package com.xkcoding.orm.mybatis.plus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xkcoding.orm.mybatis.plus.entity.Role;

public interface RoleService extends IService<Role> {
    void updateDescription();
}
