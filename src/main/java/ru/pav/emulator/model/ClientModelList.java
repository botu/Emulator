package ru.pav.emulator.model;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ClientModelList {
    List<Clients> clientModelList = new ArrayList<>();
}
