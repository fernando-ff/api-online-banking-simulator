package br.edu.ufrn.account.dao;

import org.springframework.data.repository.CrudRepository;

import br.edu.ufrn.account.model.PrimaryAccount;

public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount,Long> {

    PrimaryAccount findByAccountNumber (int accountNumber);
}
