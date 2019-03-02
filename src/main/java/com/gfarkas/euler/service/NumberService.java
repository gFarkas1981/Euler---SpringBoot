package com.gfarkas.euler.service;

import com.gfarkas.euler.domain.Number;
import com.gfarkas.euler.repository.NumberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumberService {

    private NumberRepository numberRepo;

    public NumberRepository getNumberRepo() {
        return numberRepo;
    }

    public void setNumberRepo(NumberRepository numberRepo) {
        this.numberRepo = numberRepo;
    }

    public List<Number> getNumbers() {
        return numberRepo.findAll();
    }
}
