package br.edu.ufrn.account.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.ufrn.account.model.Recipient;


public interface RecipientDao extends CrudRepository<Recipient, Long> {
    
    List<Recipient> findAll();

    Recipient findByName(String recipientName);

    void deleteByName(String recipientName);
}
