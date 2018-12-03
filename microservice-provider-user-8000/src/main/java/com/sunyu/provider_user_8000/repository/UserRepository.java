package com.sunyu.provider_user_8000.repository;

import com.sunyu.provider_user_8000.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author SunYu
 * @date 2018/12/3 11:45
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
