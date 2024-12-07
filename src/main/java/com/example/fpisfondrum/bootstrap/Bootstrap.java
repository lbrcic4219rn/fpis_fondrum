package com.example.fpisfondrum.bootstrap;

import com.example.fpisfondrum.model.Order;
import com.example.fpisfondrum.model.Wine;
import com.example.fpisfondrum.model.WineStyle;
import com.example.fpisfondrum.model.WineVariety;
import com.example.fpisfondrum.service.OrderService;
import com.example.fpisfondrum.service.WineService;
import com.example.fpisfondrum.service.WineStyleService;
import com.example.fpisfondrum.service.WineVarietyService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final WineService wineService;
    private final WineStyleService wineStyleService;
    private final WineVarietyService wineVarietyService;
    private final OrderService orderService;

    @Override
    public void run(String... args) throws Exception {

        if (!wineService.findAll().isEmpty()) {
            return;
        }

        //generate initial data
        //Rizling, Pino griđo,Sovinjon Blan, Šardone, Pino noar, Zinfandel, Širaz, Kaberne sovinjon
        List<WineVariety> wineVarieties = List.of(
                new WineVariety("Rizling"),
                new WineVariety("Pino griđo"),
                new WineVariety("Sovinjon Blan"),
                new WineVariety("Sardone"),
                new WineVariety("Pino noar"),
                new WineVariety("Zinfandel"),
                new WineVariety("Siraz"),
                new WineVariety("Kaberne sovinjon")
        );

        wineVarieties.forEach(wineVarietyService::save);

        //Belo, Crveno, Rose
        List<WineStyle> wineStyles = List.of(
                new WineStyle("Belo"),
                new WineStyle("Crveno"),
                new WineStyle("Rose")
        );

        wineStyles.forEach(wineStyleService::save);

        //Create two copies for each combination of variety and style
        AtomicInteger globalCounter = new AtomicInteger();
        wineVarieties.forEach(wineVariety -> {
            wineStyles.forEach(wineStyle -> {
                wineService.save(new Wine(String.format("Wine %d", globalCounter.getAndIncrement()), wineStyle, wineVariety));
                wineService.save(new Wine(String.format("Wine %d", globalCounter.getAndIncrement()), wineStyle, wineVariety));
            });
        });

        List<Wine> wines = wineService.findAll();
        orderService.save(new Order(wines.subList(0, 3)));
    }
}
