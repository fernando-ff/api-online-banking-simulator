package br.edu.ufrn.auth.endpoint.service;

import br.edu.ufrn.core.model.SavingsAccount;
import br.edu.ufrn.core.repository.SavingsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import br.edu.ufrn.core.repository.UserRepository;
import br.edu.ufrn.core.model.User;

import java.math.BigDecimal;
import java.util.Random;


@Service
@Transactional
public class UserService{


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SavingsAccountRepository savingsAccountRepository;

    public User save(User user){
        if(userRepository.findByUsername(user.getUsername()) == null) {
            SavingsAccount savingsAccount = generateSavingsAccount();
            user.setSavingsAccount(savingsAccount);

            return userRepository.save(user);
        }
        return null;
    }

    private SavingsAccount generateSavingsAccount(){
        SavingsAccount savingsAccount = new SavingsAccount();
        Random random = new Random();

        savingsAccount.setAccountBalance(BigDecimal.ZERO);

        return savingsAccountRepository.save(savingsAccount);
    }

}