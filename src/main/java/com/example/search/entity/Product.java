package com.example.search.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SolrDocument(collection = "oclockecom")
public class Product {
//    @Id
//
//
//productId
//    rating
//            imageUrl;


    @Id

    @Indexed(name = "productname" , type = "string")
    private String productname;
    @Indexed(name = "productId" , type = "string")
    private String productId;
    @Indexed(name = "rating" , type = "double")
    private double rating;
    @Indexed(name = "imageUrl" , type = "string")
    private String imageurl;
    @Indexed(name = "price", type = "double")
    private double price;

    @Indexed(name = "merchantId", type = "string")
    private String merchantId;


    @Indexed(name = "categoryId", type = "string")
    private String categoryId;



}