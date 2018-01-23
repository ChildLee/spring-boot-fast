package com.fast.repository;

import com.fast.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);

    SysUser findByUsernameAndPasswordOrderByPasswordDescIdAsc(String username, String password);

}