package ru.pav.emulator.model;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Clients {
   // Tariff tarif;


    public Clients(String clientCode, String name, Boolean margin) {
        this.clientCode = clientCode;
        this.name = name;
        this.margin = margin;
    }

    String clientCode;

    String name;

    Boolean margin;

}
