package br.edu.ufrn.core.repository;

import br.edu.ufrn.core.model.SavingsAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsAccountRepository extends CrudRepository<SavingsAccount, Long> {


}
