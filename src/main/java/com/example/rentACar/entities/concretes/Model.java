package com.example.rentACar.entities.concretes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "models")
//@Data  // GETTER SETTER , EQUALS , CanEqual, hashcode, brand() -> Hepsini oluşturuyor. Lombok.
@AllArgsConstructor // Parametreli constructor oluşturuyor
@NoArgsConstructor
@Getter // sadece Getter
@Setter // sadece setterlar için
@Entity // Bir veritabanı varlığısın
public class Model {

    @Id  // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik üret 1-2-3-4
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

}
