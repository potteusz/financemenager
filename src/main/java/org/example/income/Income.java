package org.example.income;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "income")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "amount")
    private double amount;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "comment")
    private String comment;

    public Income() {
    }

    public Income(double amount, LocalDate date, String comment) {
        this.amount = amount;
        this.date = date;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", comment='" + comment + '\'' +
                '}';
    }
}
