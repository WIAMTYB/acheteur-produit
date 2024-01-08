package com.wiam.produitservice.web;

import com.wiam.produitservice.config.GlobalConfig;
import com.wiam.produitservice.entities.Produit;
import com.wiam.produitservice.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@org.springframework.web.bind.annotation.RestController

public class RestController {

    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    GlobalConfig globalConfig;

    @GetMapping("/globalConfig")
    public GlobalConfig globalconfig (){
        return globalConfig;
    }

    @GetMapping("/produits")
    public List<Produit> getAll(){
        return produitRepository.findAll();
    }

    @GetMapping("/produits/{id}")
    public Produit getById(@PathVariable ("id") Integer id){
        return produitRepository.findById(id).get();
    }

    @PutMapping("/produits/{id}")
    public void save(@PathVariable ("id") Integer id, @RequestBody Produit p){
        Produit pr = produitRepository.findById(id).get();

        if(p.getMarque()!=null) {pr.setMarque(p.getMarque());}
        if (p.getDesc()!=null) {pr.setDesc(p.getDesc());}
        if(p.getPrix()!=null) {pr.setPrix(p.getPrix());}
        if (p.getQuantite()!=null) {pr.setQuantite(p.getQuantite());}

        produitRepository.save(pr);
    }

    @PostMapping("/produits")
    public void add(@RequestBody Produit a){
        produitRepository.save(a);
    }

    @DeleteMapping("/produits/{id}")
    public void supprimer(@PathVariable ("id") Integer id){
        produitRepository.deleteById(id);
    }

}