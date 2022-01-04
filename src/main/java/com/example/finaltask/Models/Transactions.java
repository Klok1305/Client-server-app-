package com.example.finaltask.Models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transactions {

    private Long customer_id;
    @Id
    private String tr_datetime;
    private Long mcc_code;
    private Long tr_type;
    private double amount;
    private double term_id;
}
