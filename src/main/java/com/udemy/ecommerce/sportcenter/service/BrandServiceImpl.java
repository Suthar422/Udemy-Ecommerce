package com.udemy.ecommerce.sportcenter.service;

import com.udemy.ecommerce.sportcenter.entity.Brand;
import com.udemy.ecommerce.sportcenter.model.BrandResponse;
import com.udemy.ecommerce.sportcenter.repository.BrandRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Log4j2
public class BrandServiceImpl implements BrandService{

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @Override
    public List<BrandResponse> getAllBrands() {
        log.info("Fetching All Brands !!!");
        //Fetch Brands
        List<Brand> brandList = brandRepository.findAll();
        System.out.println(brandList);
        //now use stream operator to map with Response
        List<BrandResponse> brandResponses = brandList.stream()
                .map(this::convertToBrandResponse)
                .toList();

        log.info("Fetched All Brands!!!");
        System.out.println(brandResponses);
        return brandResponses;
    }

    private BrandResponse convertToBrandResponse(Brand brand) {
        return BrandResponse.builder()
                .id(brand.getId())
                .name(brand.getName())
                .build();
    }
}
