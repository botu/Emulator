package ru.pav.emulator.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class TariffSet {
    Tariff tariff;
    List<String> fromTo;
    List<BigDecimal> rate;

}
