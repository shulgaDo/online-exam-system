package com.code.onlineexamsys.repository;

import com.code.onlineexamsys.entity.Role;
import com.code.onlineexamsys.entity.UserRole;
import com.code.onlineexamsys.entity.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
    List<Role> findRolesByUserId(Long id);
}