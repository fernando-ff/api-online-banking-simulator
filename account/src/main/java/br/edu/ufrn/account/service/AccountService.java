package br.edu.ufrn.account.service;

import java.security.Principal;

import br.edu.ufrn.account.model.PrimaryAccount;
import br.edu.ufrn.account.model.SavingsAccount;

public interface AccountService {
    PrimaryAccount createPrimaryAccount();
    
    SavingsAccount createSavingsAccount();
    
    void deposit(String accountType, double amount, Principal principal);
    
    void withdraw(String accountType, double amount, Principal principal);
}
