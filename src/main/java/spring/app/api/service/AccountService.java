package spring.app.application.service;


import spring.app.application.model.Account;

import java.util.List;


public interface AccountService {
    Account createAccount (Account account);
    Account findByUsername(String username);
    List<Account> getAccounts();
}
