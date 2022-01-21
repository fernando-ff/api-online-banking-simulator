package br.edu.ufrn.core.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.edu.ufrn.core.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByUsername(String username);

}