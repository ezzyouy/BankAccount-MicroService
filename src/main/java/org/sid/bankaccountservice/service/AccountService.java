package org.sid.bankaccountservice.service;

import org.sid.bankaccountservice.dto.BankAccounRequesttDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAcount;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccounRequesttDTO bankAccountDTO);

}
