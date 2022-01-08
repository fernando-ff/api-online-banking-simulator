package br.edu.ufrn.core.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import br.edu.ufrn.core.model.ApplicationUser;

/**
 * @author William Suane
 */
public interface ApplicationUserRepository extends PagingAndSortingRepository<ApplicationUser, Long> {

    ApplicationUser findByUsername(String username);

}
