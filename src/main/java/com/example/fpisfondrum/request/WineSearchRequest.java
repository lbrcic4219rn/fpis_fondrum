package com.example.fpisfondrum.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class WineSearchRequest {
    List<Long> wineVarietyIds;
    List<Long> wineStyleIds;
}
