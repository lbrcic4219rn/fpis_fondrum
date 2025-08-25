package com.example.fpisfondrum.service.wine;

import com.example.fpisfondrum.model.Wine;
import com.example.fpisfondrum.repo.WineRepo;
import com.example.fpisfondrum.repo.specification.WineSpecification;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface WineService {
    List<Wine> findAll();
    Wine findById(Long id);
    void save(Wine wine);
    List<Wine> searchWines(List<Long> wineVarietyIds, List<Long> wineStyleIds);

}
