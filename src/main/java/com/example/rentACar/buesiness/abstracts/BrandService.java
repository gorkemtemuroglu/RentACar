package com.example.rentACar.buesiness.abstracts;

import com.example.rentACar.buesiness.requests.CreateBrandRequest;
import com.example.rentACar.buesiness.requests.UpdateBrandRequest;
import com.example.rentACar.buesiness.responses.GetAllBrandsResponse;
import com.example.rentACar.buesiness.responses.GetByIdBrandResponse;
import com.example.rentACar.entities.concretes.Brand;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);

}
