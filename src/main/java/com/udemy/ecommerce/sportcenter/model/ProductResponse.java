package com.udemy.ecommerce.sportcenter.model;

import com.udemy.ecommerce.sportcenter.entity.Brand;
import com.udemy.ecommerce.sportcenter.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private Integer id;
    private String name;
    private String description;
    private Long price;
    private String pictureUrl;
    private String productBrand;
    private String productType;
}
