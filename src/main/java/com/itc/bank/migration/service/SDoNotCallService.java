package com.itc.bank.migration.service;

import com.itc.bank.migration.entity.source.SDoNotCall;
import com.itc.bank.migration.repository.query.SDoNotCallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SDoNotCallService {

    @Autowired
    private SDoNotCallRepository sDoNotCallRepository;

    public List<SDoNotCall> findAll() {
        return (List<SDoNotCall>) sDoNotCallRepository.findAll();
    }
}
