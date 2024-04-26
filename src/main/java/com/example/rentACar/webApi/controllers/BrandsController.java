package com.example.rentACar.webApi.controllers;

import com.example.rentACar.buesiness.abstracts.BrandService;
import com.example.rentACar.buesiness.requests.CreateBrandRequest;
import com.example.rentACar.buesiness.requests.UpdateBrandRequest;
import com.example.rentACar.buesiness.responses.GetAllBrandsResponse;
import com.example.rentACar.buesiness.responses.GetByIdBrandResponse;
import com.example.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/brands")
public class BrandsController {

    private BrandService brandService;


   /* @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }*/

    @GetMapping()
    public List<GetAllBrandsResponse> getAllBrands() {

        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){

        return brandService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody CreateBrandRequest createBrandRequest) {
        this.brandService.add(createBrandRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);

    }


}
