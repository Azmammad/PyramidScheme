package com.example.pyramidscheme.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double balance = 100.0;
    private Double investment = 0.0;
    private Double earnings = 0.0;

    @ManyToOne
    @JoinColumn(name = "sponsor_id")
    private User sponsor;

    public void addInvestment(Double amount) {
        this.investment += amount;
    }

    public void addEarnings(Double amount) {
        this.earnings += amount;
    }
}
