package com.xkcoding.orm.jpa.repository;

import com.xkcoding.orm.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * User Dao
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-07 14:07
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {
    // 按照规范命名 不需要写
    //    @Query("select u from User u where u.name = ?1")
    Optional<User> findByName(String name);

    List<User> findByStatus(Integer status);

    @Transactional
    @Modifying
    @Query("update User set status = ?2 where name = ?1")
    void updateStatusByName(String name, int status);
}
