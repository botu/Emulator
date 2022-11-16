package ru.pav.emulator.service.scheduller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.pav.emulator.model.Clients;
import ru.pav.emulator.model.Tariff;

import java.math.BigDecimal;

@Service
public class EmulatorService {

    @Scheduled(fixedRate = 20000L)
    @Async
    public void process()
    {
        System.out.println("чего нибудь");
        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate template = builder.build();
        Clients body = new Clients();
        body.setName("Tima");
        body.setMargin(true);
        body.setClientId("9999");
        Tariff tarrif = new Tariff();
        tarrif.setCode("tarifCode");
        tarrif.setId(1);
        tarrif.setMinSumm(BigDecimal.ONE);
        tarrif.setMaxSumm(new BigDecimal("65.58974586783945789354798"));
        body.setTarif(tarrif);
        HttpEntity<Clients> request = new HttpEntity<>(body);
        template.exchange("http://localhost:8080/postClient", HttpMethod.POST,request,String.class);
    }

}
