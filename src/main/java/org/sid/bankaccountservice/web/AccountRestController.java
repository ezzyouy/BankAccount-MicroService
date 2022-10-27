package org.sid.bankaccountservice.web;

import lombok.AllArgsConstructor;
import org.sid.bankaccountservice.dto.BankAccounRequesttDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAcount;
import org.sid.bankaccountservice.mappers.AccountMapper;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.sid.bankaccountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;

    @GetMapping("/bankAccounts")
    public List<BankAcount> bankAcounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAcount bankAcounts(@PathVariable String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account % not found", id)));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccounRequesttDTO requesttDTO) {

        return accountService.addAccount(requesttDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAcount update(@PathVariable String id, @RequestBody BankAcount bankAcount) {
        BankAcount acount = bankAccountRepository.findById(id).orElseThrow();
        if (bankAcount.getBalance() != null) acount.setBalance(bankAcount.getBalance());
        if (bankAcount.getCreatedAt() != null) acount.setCreatedAt(new Date());
        if (bankAcount.getType() != null) acount.setType(bankAcount.getType());
        if (bankAcount.getCurrency() != null) acount.setCurrency(bankAcount.getCurrency());
        return bankAccountRepository.save(acount);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id) {
         bankAccountRepository.deleteById(id);
    }
}
