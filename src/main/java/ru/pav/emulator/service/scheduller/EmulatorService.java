package ru.pav.emulator.service.scheduller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jdk.jfr.ContentType;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.pav.emulator.model.ClientModelList;
import ru.pav.emulator.model.Clients;
import ru.pav.emulator.model.Tariff;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmulatorService {

//    @Scheduled(fixedRate = 200L)
//    @Async
//    public void process()
//    {
//        System.out.println("чего нибудь");
//        RestTemplateBuilder builder = new RestTemplateBuilder();
//        RestTemplate template = builder.build();
//        Clients body = new Clients();
//        body.setClientCode(UUID.randomUUID().toString());
//        body.setName("Tima");
//        body.setMargin(true);
//        Tariff tarrif = new Tariff();
//        tarrif.setCode("tarifCode");
//        tarrif.setId(1);
//        tarrif.setMinSumm(BigDecimal.ONE);
//        tarrif.setMaxSumm(new BigDecimal("65.58974586783945789354798"));
//        HttpEntity<Clients> request = new HttpEntity<>(body);
//        template.exchange("http://localhost:8080", HttpMethod.POST,request,String.class);
//    }


   // @ConditionalOnProperty("from.1")
  //  @Scheduled(fixedRate = 200L)
    @Async
    public void process02()
    {
        System.out.println("чего нибудь");
        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate template = builder.build();


        ClientModelList body = generateClientModelList();
        try {
            final ClientModelList result = new ClientModelList();
            System.out.println("begin");
            List<Clients> clientsList = Files.readAllLines(Path.of("/Users/borisov-ty/develope/Emulator/src/main/resources/hhh.test"))
                    .parallelStream().map(
                            (rr) -> {
                                return (new Clients(UUID.randomUUID().toString(), "Pavel", true));
                            }

                    ).collect(Collectors.toList());

            System.out.println(clientsList.size());
            result.getClientModelList().addAll(clientsList);

            System.out.println("finish");
            HttpEntity<ClientModelList> request = new HttpEntity(result);

            template.exchange("http://localhost:8080/list", HttpMethod.POST,request,String.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        }


    @Scheduled(fixedRate = 2000L)
    @Async
    public void process03()
    {
        System.out.println("чего нибудь json");
        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate template = builder.build();


        ClientModelList body = generateClientModelList();
        try {
            final ClientModelList result = new ClientModelList();
            System.out.println("begin");
            String clientsList = Files.readString(Path.of("/Users/borisov-ty/develope/Emulator/src/main/resources/test.json"));


            System.out.println("finish");
            HttpEntity<String> request = new HttpEntity(clientsList);


            template.exchange("http://localhost:8080/listString", HttpMethod.POST,request,String.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ClientModelList generateClientModelList() {
        ClientModelList result = new ClientModelList();

        //for (int i = 0; i < 1000; i++) {
            Clients client01 = new Clients(UUID.randomUUID().toString(),"Pavel",true);
            result.getClientModelList().add(client01);

        Clients client02 = new Clients(UUID.randomUUID().toString(),"Pavel",true);
        result.getClientModelList().add(client02);



        return result;
    }

}
