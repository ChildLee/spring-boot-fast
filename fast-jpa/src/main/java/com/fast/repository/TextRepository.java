package com.fast.repository;

import com.fast.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextRepository extends JpaRepository<SysUser, Long> {
}
