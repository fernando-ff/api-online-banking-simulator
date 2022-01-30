package br.edu.ufrn.account.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufrn.account.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    
	User findByUsername(String username);
	
    User findByEmail(String email);
    
    List<User> findAll();
}
