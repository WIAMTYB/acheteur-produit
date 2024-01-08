package com.wiam.acheteurservice.Model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Produit {
    private Long idP;
    private String marque;
    private String desc;
    private Float prix;
    private Integer quantite;
}
