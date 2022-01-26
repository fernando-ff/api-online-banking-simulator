package br.edu.ufrn.recipient.endpoint.controller;

import br.edu.ufrn.core.model.Recipient;
import br.edu.ufrn.recipient.endpoint.service.RecipientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("recipient")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "Endpoints to manage recipients")
public class RecipientController {
    private final RecipientService recipientService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "List all available recipients", response = Recipient[].class)
    public List<Recipient> list() {
        return recipientService.list();
    }

    @GetMapping(path = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Get specific recipient", response = Recipient.class)
    public ResponseEntity<Recipient> getById(@PathVariable Long id) {
        Optional<Recipient> recipient = recipientService.findById(id);

        return recipient.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Save a new recipient", response = Recipient.class)
    public @ResponseBody ResponseEntity<Recipient> save(@Valid @RequestBody Recipient recipient){
        return recipientService.save(recipient);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Update specific recipient", response = Recipient.class)
    public @ResponseBody ResponseEntity<Recipient> update(@Valid @RequestBody Recipient recipient){
        return recipientService.save(recipient);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete specific recipient", response = Recipient.class)
    public void delete(@PathVariable Long id){
        recipientService.delete(id);
    }





}
