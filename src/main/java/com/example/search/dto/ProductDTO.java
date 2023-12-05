package com.example.search.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.stereotype.Service;


@Data
@Service
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String productname;
    private String productId;
    private double rating;
    private String imageUrl;
    private double price;

    private String merchantId;


    private String categoryId;

}
