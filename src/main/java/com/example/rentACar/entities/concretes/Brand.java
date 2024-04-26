package com.example.rentACar.entities.concretes;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Table(name = "brands")
//@Data  // GETTER SETTER , EQUALS , CanEqual, hashcode, brand() -> Hepsini oluşturuyor. Lombok.
@AllArgsConstructor // Parametreli constructor oluşturuyor
@NoArgsConstructor
@Getter // sadece Getter
@Setter // sadece setterlar için
@Entity // Bir veritabanı varlığısın
public class Brand {

    @Id  // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik üret 1-2-3-4
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand")
    List<Model> models;



}
