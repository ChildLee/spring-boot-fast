package com.fast.repository;

import com.fast.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TextRepository extends JpaRepository<SysUser, Long> {
    @Query(value = "SELECT * from sys_user", nativeQuery = true)
    List<SysUser> getAllBy();

    @Query("select s.username from SysUser s")
    List<SysUser> getUsername();
}
