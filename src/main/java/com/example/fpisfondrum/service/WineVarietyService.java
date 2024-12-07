package com.example.fpisfondrum.service;

import com.example.fpisfondrum.model.WineVariety;
import com.example.fpisfondrum.repo.WineVarietyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WineVarietyService {
    private final WineVarietyRepo wineVarietyRepo;

    public List<WineVariety> findAll() {
        return wineVarietyRepo.findAll();
    }

    public WineVariety save(WineVariety wineVariety) {
        return wineVarietyRepo.save(wineVariety);
    }
}
