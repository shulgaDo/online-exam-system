package com.code.onlineexamsys.repository;

import com.code.onlineexamsys.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    @Query("""
    SELECT DISTINCT p.permissionCode
    FROM Permission p, RolePermission rp, UserRole ur
    WHERE p.id = rp.permissionId
      AND rp.roleId = ur.role.id
      AND ur.user.id = :id
""")
    List<String> findPermissionCodesByUserId(Long id);
}