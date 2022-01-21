package br.edu.ufrn.account.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.ufrn.account.model.Appointment;


public interface AppointmentDao extends CrudRepository<Appointment, Long> {

    List<Appointment> findAll();

    // Appointment findOne(Long id);
}
