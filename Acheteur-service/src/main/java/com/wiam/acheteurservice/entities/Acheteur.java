package com.wiam.acheteurservice.entities;

import jakarta.persistence.*;
import lombok.*;
import com.wiam.acheteurservice.Model.Produit;

@Entity
@Getter  @Setter  @NoArgsConstructor
@AllArgsConstructor
@ToString @Builder
public class Acheteur {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String nom;
    private  String ville;
    private  Long idProduit;
    @Transient
    private  Produit  produit;


}