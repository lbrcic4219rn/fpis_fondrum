package com.example.fpisfondrum.service;

import com.example.fpisfondrum.model.Wine;
import com.example.fpisfondrum.repo.WineRepo;
import com.example.fpisfondrum.repo.specification.WineSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WineService {

    private final WineRepo wineRepo;

    public String test() {
        return "WineService test";
    }

    public List<Wine> findAll() {
        return wineRepo.findAll();
    }

    public Wine save(Wine wine) {
        return wineRepo.save(wine);
    }


    public List<Wine> searchWines(List<Long> wineVarietyIds, List<Long> wineStyleIds) {

        Specification<Wine> spec = Specification.where(null);

        if (wineVarietyIds != null && !wineVarietyIds.isEmpty()) {
            spec = spec.and(WineSpecification.hasVarietyIn(wineVarietyIds));
        }

        if (wineStyleIds != null && !wineStyleIds.isEmpty()) {
            spec = spec.and(WineSpecification.hasStyleIn(wineStyleIds));
        }

        return wineRepo.findAll(spec);
    }
}
