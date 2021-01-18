package com.xkcoding.orm.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.orm.mybatis.plus.entity.Role;
import com.xkcoding.orm.mybatis.plus.mapper.RoleMapper;
import com.xkcoding.orm.mybatis.plus.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public void updateDescription() {
        Role role = new Role().setName("ttttt");
        role.insert();
        test();
    }
    @Transactional
    public void test() {
        Role role = new Role().setName("aaaaa");
        role.insert();
        if (true) {
            int num = 1/0;
        }
        this.update(new UpdateWrapper<Role>().eq("id", role.getId()).set("description", "aaaaaaa"));
    }
}
