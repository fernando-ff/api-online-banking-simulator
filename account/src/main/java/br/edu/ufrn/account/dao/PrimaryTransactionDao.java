package br.edu.ufrn.account.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.ufrn.account.model.PrimaryTransaction;


public interface PrimaryTransactionDao extends CrudRepository<PrimaryTransaction, Long> {

    List<PrimaryTransaction> findAll();
}
