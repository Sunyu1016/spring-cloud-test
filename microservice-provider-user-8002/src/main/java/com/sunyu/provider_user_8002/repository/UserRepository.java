package com.sunyu.provider_user_8002.repository;

import com.sunyu.provider_user_8002.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author SunYu
 * @date 2018/12/3 14:27
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
