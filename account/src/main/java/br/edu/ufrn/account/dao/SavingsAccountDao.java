package br.edu.ufrn.account.dao;

import org.springframework.data.repository.CrudRepository;

import br.edu.ufrn.account.model.SavingsAccount;

public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {

    SavingsAccount findByAccountNumber (int accountNumber);
}
