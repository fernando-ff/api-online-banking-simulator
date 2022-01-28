package br.edu.ufrn.account.service;

import java.math.BigDecimal;

import br.edu.ufrn.account.model.PrimaryAccount;
import br.edu.ufrn.account.model.SavingsAccount;

public interface AccountService {

    PrimaryAccount savePrimaryAccount(PrimaryAccount account);

    PrimaryAccount findPrimaryAccountById(Long id);

    void deletePrimaryAccountById(Long id);

    SavingsAccount saveSavingsAccount(SavingsAccount account);

    SavingsAccount findSavingsAccountById(Long id);

    void deleteSavingsAccountById(Long id);

    Object deposit(Long id, String accountType, Float amount) throws Exception;

    /* --------------------------------------------------------------*/

    PrimaryAccount createPrimaryAccount();
    
    SavingsAccount createSavingsAccount();
    
    // void deposit(String accountType, double amount, Principal principal);
    
    // void withdraw(String accountType, double amount, Principal principal);

}
