package com.code.onlineexamsys.repository;

import com.code.onlineexamsys.entity.Role;
import com.code.onlineexamsys.entity.UserRole;
import com.code.onlineexamsys.entity.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {

    @Query(value = "SELECT ur.role FROM UserRole ur WHERE ur.user.id = :id")
    List<Role> findRolesByUserId(Long id);
}