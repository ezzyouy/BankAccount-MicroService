package org.sid.bankaccountservice.entities;

import lombok.*;
import org.sid.bankaccountservice.enums.AccountType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class BankAcount {
    @Id
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @ManyToOne
    private Customer customer;
}