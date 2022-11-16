package ru.pav.emulator.model;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Clients {
    Tariff tarif;

    String clientId;

    String name;

    Boolean margin;

}
