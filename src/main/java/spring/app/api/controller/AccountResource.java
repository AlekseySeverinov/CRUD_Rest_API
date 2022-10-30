package spring.app.application.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.app.application.model.Account;

import spring.app.application.service.AccountService;

import java.util.List;

import static spring.app.application.controller.EmployeeResource.getLocation;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/accounts")
public class AccountResource {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account newAccount = accountService.createAccount(account);
        return ResponseEntity.created(getLocation((int) newAccount.getId())).body
                (newAccount);

    }
    @GetMapping
    public ResponseEntity<List<Account>>getAccount(){
        return ResponseEntity.ok(accountService.getAccounts());
    }
}
