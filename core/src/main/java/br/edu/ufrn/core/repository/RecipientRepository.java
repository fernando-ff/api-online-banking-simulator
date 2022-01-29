package br.edu.ufrn.core.repository;

import br.edu.ufrn.core.model.Recipient;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RecipientRepository extends PagingAndSortingRepository<Recipient, Long> {
}
