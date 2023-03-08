package org.example.service;

import org.example.income.Income;
import org.example.income.IncomeRepository;

import java.time.LocalDate;

public class IncomeService {

    private IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public void createIncome(double amount, LocalDate date, String comment) {
        Income income = new Income(amount, date, comment);
        incomeRepository.insertIncome(income);
    }
}
