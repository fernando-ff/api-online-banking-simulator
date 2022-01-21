package br.edu.ufrn.account.dao;

import org.springframework.data.repository.CrudRepository;

import br.edu.ufrn.account.model.security.Role;


public interface RoleDao extends CrudRepository<Role, Integer> {
    
    Role findByName(String name);
}
