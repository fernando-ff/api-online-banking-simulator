package br.edu.ufrn.core.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufrn.core.model.ApplicationUser;

/**
 * @author William Suane
 */
@Repository
public interface ApplicationUserRepository extends PagingAndSortingRepository<ApplicationUser, Long> {

    ApplicationUser findByUsername(String username);

}
