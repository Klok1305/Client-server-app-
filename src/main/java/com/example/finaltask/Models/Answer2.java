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
public class Answer2 {
    @Id
    private Long customer_id;
    private Double abs;
    private int N;

}
