package com.wiam.acheteurservice.produit;


import com.wiam.acheteurservice.Model.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name="PRODUIT-SERVICE")

public interface ProduitFeingController {

    @GetMapping("/produits")
    public List<Produit> findAll();

    @GetMapping("/produits/{id}")
    public Produit findBy(@PathVariable Long id);


}
