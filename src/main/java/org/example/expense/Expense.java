package org.example.expense;

import jakarta.persistence.*;
import org.example.category.Category;
import java.time.LocalDate;


@Entity
@Table (name = "expense")
public class Expense {
    @Id
    @GeneratedValue
    @Column (name = "expense_id")
    private Integer expenseId;
    @Column (name = "expense_amount")
    private double amount;
    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Category category;
    @Column (name = "expense_date")
    private LocalDate date;
    @Column (name = "expanse_comment")
    private String comment;

    public Expense() {
    }

    public Expense(double amount, Category category, LocalDate date, String comment) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.comment = comment;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
        return "Expense{" +
                "expenseId=" + expenseId +
                ", amount=" + amount +
                ", category=" + category +
                ", date=" + date +
                ", comment='" + comment + '\'' +
                '}';
    }
}
