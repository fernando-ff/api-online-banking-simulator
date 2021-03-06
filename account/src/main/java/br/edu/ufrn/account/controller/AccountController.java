package br.edu.ufrn.account.controller;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufrn.account.model.PrimaryAccount;
import br.edu.ufrn.account.model.PrimaryTransaction;
import br.edu.ufrn.account.model.SavingsAccount;
import br.edu.ufrn.account.model.SavingsTransaction;
import br.edu.ufrn.account.model.User;
import br.edu.ufrn.account.service.AccountService;
import br.edu.ufrn.account.service.TransactionService;
import br.edu.ufrn.account.service.UserService;


@RestController
public class AccountController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionService transactionService;


    /* PRIMARY ACCOUNT */
    @PostMapping("primary-account")
    public PrimaryAccount savePrimaryAccount(@RequestBody PrimaryAccount account) {
        return accountService.savePrimaryAccount(account);
    }

    @GetMapping("{id}/primary-account")
    public PrimaryAccount findPrimaryAccountById(@PathVariable Long id) {
        return accountService.findPrimaryAccountById(id);
    }

    @DeleteMapping("{id}/primary-account")
    public void deletePrimaryAccountById(@PathVariable Long id) {
        accountService.deletePrimaryAccountById(id);
    }

    @PutMapping("{id}/{accountType}/primary-account")
    public Object deposit(@RequestBody Float amount, @PathVariable Long id, @PathVariable String accountType) throws Exception {
        return accountService.deposit(id, accountType,amount);
    }


    /* SAVINGS ACCOUNT */
    @PostMapping("savings-account")
    public SavingsAccount savePrimaryAccount(@RequestBody SavingsAccount account) {
        return accountService.saveSavingsAccount(account);
    }

    @GetMapping("{id}/savings-account")
    public SavingsAccount findSavingsAccountById(@PathVariable Long id) {
        return accountService.findSavingsAccountById(id);
    }

    @DeleteMapping("{id}/savings-account")
    public void deleteSavingsAccountById(@PathVariable Long id) {
        accountService.deleteSavingsAccountById(id);
    }

    /* --------------------------------------------------------------*/
	
	@RequestMapping("/primaryAccount")
	public String primaryAccount(Model model, Principal principal) {
		List<PrimaryTransaction> primaryTransactionList = transactionService.findPrimaryTransactionList(principal.getName());
		
		User user = userService.findByUsername(principal.getName());
        PrimaryAccount primaryAccount = user.getPrimaryAccount();

        model.addAttribute("primaryAccount", primaryAccount);
        model.addAttribute("primaryTransactionList", primaryTransactionList);
		
		return "primaryAccount";
	}

	@RequestMapping("/savingsAccount")
    public String savingsAccount(Model model, Principal principal) {
		List<SavingsTransaction> savingsTransactionList = transactionService.findSavingsTransactionList(principal.getName());
        User user = userService.findByUsername(principal.getName());
        SavingsAccount savingsAccount = user.getSavingsAccount();

        model.addAttribute("savingsAccount", savingsAccount);
        model.addAttribute("savingsTransactionList", savingsTransactionList);

        return "savingsAccount";
    }
	
	@RequestMapping(value = "/deposit", method = RequestMethod.GET)
    public String deposit(Model model) {
        model.addAttribute("accountType", "");
        model.addAttribute("amount", "");

        return "deposit";
    }

    // @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    // public String depositPOST(@ModelAttribute("amount") String amount, @ModelAttribute("accountType") String accountType, Principal principal) {
    //     accountService.deposit(accountType, Double.parseDouble(amount), principal);

    //     return "redirect:/userFront";
    // }
    
    // @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    // public String withdraw(Model model) {
    //     model.addAttribute("accountType", "");
    //     model.addAttribute("amount", "");

    //     return "withdraw";
    // }

    // @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    // public String withdrawPOST(@ModelAttribute("amount") String amount, @ModelAttribute("accountType") String accountType, Principal principal) {
    //     accountService.withdraw(accountType, Double.parseDouble(amount), principal);

    //     return "redirect:/userFront";
    // }
}