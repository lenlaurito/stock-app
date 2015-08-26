package com.rockie.stock.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by len on 8/18/2015.
 */
@Transactional
public interface UserDao extends JpaRepository<User, Long>{
    User findOneByEmail(String email);
}
