package com.backend.shoppingCart.Services;

import com.backend.shoppingCart.model.Role;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);
    List<Role> getAllRole();
    Role getRoleById(int roleId);
    Role updateRole(Role role);
    Role deleteRole(int roleId);
}
