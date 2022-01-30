package br.edu.ufrn.account.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.ufrn.account.model.SavingsTransaction;


public interface SavingsTransactionDao extends CrudRepository<SavingsTransaction, Long> {

    List<SavingsTransaction> findAll();
}

