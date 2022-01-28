package br.edu.ufrn.account.service.impl;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufrn.account.dao.PrimaryAccountDao;
import br.edu.ufrn.account.dao.SavingsAccountDao;
import br.edu.ufrn.account.helper.AccountHelper;
import br.edu.ufrn.account.model.PrimaryAccount;
import br.edu.ufrn.account.model.PrimaryTransaction;
import br.edu.ufrn.account.model.SavingsAccount;
import br.edu.ufrn.account.model.SavingsTransaction;
import br.edu.ufrn.account.model.User;
import br.edu.ufrn.account.service.AccountService;
import br.edu.ufrn.account.service.TransactionService;
import br.edu.ufrn.account.service.UserService;

@Service
public class AccountServiceImpl implements AccountService {
	
	private static int nextAccountNumber = 11223145;

    @Autowired
    private PrimaryAccountDao primaryAccountDao;

    @Autowired
    private SavingsAccountDao savingsAccountDao;

    @Autowired
    private UserService userService;
    
    @Autowired
    private TransactionService transactionService;

    /* PRIMARY ACCOUNT */
    @Override
    public PrimaryAccount savePrimaryAccount(PrimaryAccount account) {
        return primaryAccountDao.save(account);
    }

    @Override
    public PrimaryAccount findPrimaryAccountById(Long id) {
        return primaryAccountDao.findById(id).get();
    }

    @Override
    public void deletePrimaryAccountById(Long id) {
        primaryAccountDao.deleteById(id);
    }

    /* SAVINGS ACCOUNT */
    @Override
    public SavingsAccount saveSavingsAccount(SavingsAccount account) {
        return savingsAccountDao.save(account);
    }

    @Override
    public SavingsAccount findSavingsAccountById(Long id) {
        return savingsAccountDao.findById(id).get();
    }

    @Override
    public void deleteSavingsAccountById(Long id) {
        savingsAccountDao.deleteById(id);
    }

    /* --------------------------------------------------------------*/


    public PrimaryAccount createPrimaryAccount() {
        PrimaryAccount primaryAccount = new PrimaryAccount();
        primaryAccount.setAccountBalance(new BigDecimal(0.0));
        primaryAccount.setAccountNumber(accountGen());

        primaryAccountDao.save(primaryAccount);

        return primaryAccountDao.findByAccountNumber(primaryAccount.getAccountNumber());
    }

    public SavingsAccount createSavingsAccount() {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountBalance(new BigDecimal(0.0));
        savingsAccount.setAccountNumber(accountGen());

        savingsAccountDao.save(savingsAccount);

        return savingsAccountDao.findByAccountNumber(savingsAccount.getAccountNumber());
    }
    
    // public void deposit(String accountType, double amount, Principal principal) {
    //     User user = userService.findByUsername(principal.getName());

    //     if (accountType.equalsIgnoreCase("Primary")) {
    //         PrimaryAccount primaryAccount = user.getPrimaryAccount();
    //         primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().add(new BigDecimal(amount)));
    //         primaryAccountDao.save(primaryAccount);

    //         Date date = new Date();

    //         PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, "Deposit to Primary Account", "Account", "Finished", amount, primaryAccount.getAccountBalance(), primaryAccount);
    //         transactionService.savePrimaryDepositTransaction(primaryTransaction);
            
    //     } else if (accountType.equalsIgnoreCase("Savings")) {
    //         SavingsAccount savingsAccount = user.getSavingsAccount();
    //         savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().add(new BigDecimal(amount)));
    //         savingsAccountDao.save(savingsAccount);

    //         Date date = new Date();
    //         SavingsTransaction savingsTransaction = new SavingsTransaction(date, "Deposit to savings Account", "Account", "Finished", amount, savingsAccount.getAccountBalance(), savingsAccount);
    //         transactionService.saveSavingsDepositTransaction(savingsTransaction);
    //     }
    // }
    
    // public void withdraw(String accountType, double amount, Principal principal) {
    //     User user = userService.findByUsername(principal.getName());

    //     if (accountType.equalsIgnoreCase("Primary")) {
    //         PrimaryAccount primaryAccount = user.getPrimaryAccount();
    //         primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().subtract(new BigDecimal(amount)));
    //         primaryAccountDao.save(primaryAccount);

    //         Date date = new Date();

    //         PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, "Withdraw from Primary Account", "Account", "Finished", amount, primaryAccount.getAccountBalance(), primaryAccount);
    //         transactionService.savePrimaryWithdrawTransaction(primaryTransaction);
    //     } else if (accountType.equalsIgnoreCase("Savings")) {
    //         SavingsAccount savingsAccount = user.getSavingsAccount();
    //         savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().subtract(new BigDecimal(amount)));
    //         savingsAccountDao.save(savingsAccount);

    //         Date date = new Date();
    //         SavingsTransaction savingsTransaction = new SavingsTransaction(date, "Withdraw from savings Account", "Account", "Finished", amount, savingsAccount.getAccountBalance(), savingsAccount);
    //         transactionService.saveSavingsWithdrawTransaction(savingsTransaction);
    //     }
    // }
    
    private int accountGen() {
        return ++nextAccountNumber;
    }

    @Override
    public Object deposit(Long id, String accountType, Float amount) throws Exception {
        switch (accountType) {
            case "PRIMARY":
                return depositOnPrimaryAccount(id, amount);
                
            case "SAVINGS":
                return depositOnSavingsAccount(id, amount);
            default:
                throw new Exception("Error while trying to deposit amount.");
                
        }
        
    }

    private PrimaryAccount depositOnPrimaryAccount(Long id, Float amount) {
        PrimaryAccount primaryAccount = primaryAccountDao.findById(id).orElseThrow();
        AccountHelper.depositOnPrimary(primaryAccount, amount);
        return savePrimaryAccount(primaryAccount);
    }

    private SavingsAccount depositOnSavingsAccount(Long id, Float amount) {
        SavingsAccount savingsAccount = savingsAccountDao.findById(id).orElseThrow();
        AccountHelper.depositOnSavings(savingsAccount, amount);
        return saveSavingsAccount(savingsAccount);
    }
}
