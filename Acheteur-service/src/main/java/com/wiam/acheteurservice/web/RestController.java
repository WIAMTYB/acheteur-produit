package com.wiam.acheteurservice.web;

import com.wiam.acheteurservice.Model.Produit;
import com.wiam.acheteurservice.entities.Acheteur;

import com.wiam.acheteurservice.produit.ProduitFeingController;
import com.wiam.acheteurservice.repositories.AcheteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@org.springframework.web.bind.annotation.RestController




public class RestController {

    @Autowired
    AcheteurRepository acheteurRepository;

    @Autowired
    private ProduitFeingController produitFeingController;



    @GetMapping("/acheteurs")
    public List<Acheteur> getAll(){
        List<Produit> ls = produitFeingController.findAll();
        List<Acheteur> la = acheteurRepository.findAll();

        for (Acheteur a:la){
            for (Produit p:ls){
                if(p.getIdP() == a.getIdProduit()){
                    a.setProduit(p); break;
                }
            }
        }

        return la;
    }

    @GetMapping("/acheteurs/{id}")
    public Acheteur getById(@PathVariable ("id") Integer id){



        Acheteur e = acheteurRepository.findById(id).get();

        Produit p = produitFeingController.findBy(e.getIdProduit());

        e.setProduit(p);

        return e;
    }

    /*@PutMapping("/acheteurs/{id}")
    public void save(@PathVariable ("id") Integer id, @RequestBody Acheteur a){
        Acheteur ar = acheteurRepository.findById(id).get();

        if(a.getNom()!=null) {ar.setNom(a.getNom());}
        if(a.getVille()!=null){ar.setVille(a.getVille());}

        acheteurRepository.save(ar);
    }

    @PostMapping("/acheteurs")
    public void add(@RequestBody Acheteur a){
        acheteurRepository.save(a);
    }

    @DeleteMapping("/acheteurs/{id}")
    public void supprimer(@PathVariable ("id") Integer id){
        acheteurRepository.deleteById(id);
    }*/

}
