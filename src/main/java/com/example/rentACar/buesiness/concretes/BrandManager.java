package com.example.rentACar.buesiness.concretes;

import com.example.rentACar.buesiness.abstracts.BrandService;
import com.example.rentACar.buesiness.requests.CreateBrandRequest;
import com.example.rentACar.buesiness.requests.UpdateBrandRequest;
import com.example.rentACar.buesiness.responses.GetAllBrandsResponse;
import com.example.rentACar.buesiness.responses.GetByIdBrandResponse;
import com.example.rentACar.core.utilities.mappers.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.BrandRepository;
import com.example.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service // Bu sınıf bir business nesnesidir.
@AllArgsConstructor
public class BrandManager implements BrandService {
    //lousely coupled
    private BrandRepository brandRepository;

    private ModelMapperService modelMapperService;




  //  @Autowired // Bunu otomatik olarak yapıyor ama ben buna bir allargsconstructor lombok ile yaparsam buna da gerek kalmaz
  //  public BrandManager(BrandRepository brandRepository) {
  //      this.brandRepository = brandRepository;
  //  }


    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
   /*     List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();

        for (Brand brand : brands) {
            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());
            brandsResponse.add(responseItem);
        }
    */

        List<GetAllBrandsResponse> brandsResponse = brands.stream().map(brand -> this.modelMapperService
                .forResponse().map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());


        return brandsResponse;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();

        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);

        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {

       // Brand brand = new Brand();
       // brand.setName(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);

        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);  // id yoksa yeni kaydeder id varsa üstüne save yapar.

    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
