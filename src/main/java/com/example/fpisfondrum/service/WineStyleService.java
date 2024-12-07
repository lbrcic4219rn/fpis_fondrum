package com.example.fpisfondrum.service;

import com.example.fpisfondrum.model.WineStyle;
import com.example.fpisfondrum.repo.WineStyleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WineStyleService {
    private final WineStyleRepo wineStyleRepo;

    public List<WineStyle> findAll() {
        return wineStyleRepo.findAll();
    }

    public WineStyle save(WineStyle wineStyle) {
        return wineStyleRepo.save(wineStyle);
    }
}
