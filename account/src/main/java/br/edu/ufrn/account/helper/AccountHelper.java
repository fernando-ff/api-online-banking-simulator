package br.edu.ufrn.account.helper;

import java.math.BigDecimal;

import br.edu.ufrn.account.model.PrimaryAccount;
import br.edu.ufrn.account.model.SavingsAccount;

public class AccountHelper {
    public static void depositOnPrimary(PrimaryAccount account, Float amount) {
        account.setAccountBalance(account.getAccountBalance().add(new BigDecimal(Float.toString(amount))));
    }

    public static void depositOnSavings(SavingsAccount account, Float amount) {
        account.setAccountBalance(account.getAccountBalance().add(new BigDecimal(Float.toString(amount))));
    }
}
