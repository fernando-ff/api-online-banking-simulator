package br.edu.ufrn.auth.endpoint.service;

import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import br.edu.ufrn.core.repository.UserRepository;
import br.edu.ufrn.core.model.User;


@Service
@Transactional
public class UserService{


    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }
}