package com.CourseSecurity.Security.repository;

import com.CourseSecurity.Security.entity.Role;
import com.CourseSecurity.Security.entity.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByRoleName(RoleName roleName);
}
