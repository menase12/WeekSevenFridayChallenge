package com.example.demo.Repository;

import com.example.demo.Entity.Role;
import org.springframework.data.repository.CrudRepository;


public interface RoleRepository extends CrudRepository<Role, Integer> {
}