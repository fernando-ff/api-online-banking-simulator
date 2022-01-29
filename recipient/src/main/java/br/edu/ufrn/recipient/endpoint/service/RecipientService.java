package br.edu.ufrn.recipient.endpoint.service;

import br.edu.ufrn.core.model.Recipient;
import br.edu.ufrn.core.repository.RecipientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RecipientService {
    private final RecipientRepository recipientRepository;

    public List<Recipient> list() {
        log.info("Listing all recipients");
        return (List<Recipient>) recipientRepository.findAll();
    }

    public Optional<Recipient> findById(Long id) {
        return  recipientRepository.findById(id);
    }

    public ResponseEntity<Recipient> save(Recipient recipient) {
        return new ResponseEntity<>(recipientRepository.save(recipient), HttpStatus.OK);
    }

    public ResponseEntity<Recipient> delete(Long id) {
        Optional<Recipient> recipient = recipientRepository.findById(id);

        if(recipient.isPresent()){
            recipientRepository.delete(recipient.get());
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }
}
