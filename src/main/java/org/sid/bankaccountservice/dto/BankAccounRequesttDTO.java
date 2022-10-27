package org.sid.bankaccountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bankaccountservice.enums.AccountType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccounRequesttDTO {
    private Double balance;
    private String currency;
    private AccountType type;
}
