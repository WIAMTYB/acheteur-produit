package com.wiam.acheteurservice;

import com.wiam.acheteurservice.entities.Acheteur;
import com.wiam.acheteurservice.repositories.AcheteurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class AcheteurServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcheteurServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(AcheteurRepository acheteurRepository){
        return args -> {
            acheteurRepository.save(Acheteur.builder()
                    .nom("Ali Mohammed")
                    .ville("Rabat")
                    .idProduit(1L)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Khaoula Jadimoussa")
                    .ville("Rabat")
                    .idProduit(2L)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Salem salem")
                    .ville("Sale")
                    .idProduit(3L)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Aya aya")
                    .ville("Tanger")
                    .idProduit(4L)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Jack Pattinson")
                    .ville("London")
                    .idProduit(5L)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Ahmad Khan")
                    .ville("Delhi")
                    .idProduit(6l)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Michel Duchamps")
                    .ville("Nice")
                    .idProduit(7L)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Julia Robert")
                    .ville("Munich")
                    .idProduit(8L)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Djamel ALI")
                    .ville("Tunis")
                    .idProduit(9L)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Luisa Clarck")
                    .ville("Whales")
                    .idProduit(10L)
                    .build());

            List<Acheteur> liste = acheteurRepository.findAll();

            for (Acheteur a:liste){
                System.out.println("*********");
                System.out.println(a.getNom());
                System.out.println(a.getVille());
            }

        };



    }


}