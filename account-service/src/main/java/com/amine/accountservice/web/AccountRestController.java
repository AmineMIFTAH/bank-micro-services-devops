package com.amine.accountservice.web;

import com.amine.accountservice.clients.CustomerRestClient;
import com.amine.accountservice.entities.BankAccount;
import com.amine.accountservice.model.Customer;
import com.amine.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private final BankAccountRepository accountRepository;
    private final CustomerRestClient customerRestClient;

    @GetMapping("testHello")
    public String helloAccount(){
        return "Hello from ACCOUNT!!";
    }


    public AccountRestController(
            BankAccountRepository accountRepository,
            CustomerRestClient customerRestClient) {
        this.accountRepository = accountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){

        List<BankAccount> accountList = accountRepository.findAll();
        accountList.forEach(acc->{
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
        });

        return accountList;
        // return accountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
        BankAccount bankAccount = accountRepository.findById(id).orElse(null);
        assert bankAccount != null;
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
