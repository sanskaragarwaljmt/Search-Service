package com.example.search.service;


import com.example.search.dto.ProductDTO;
import com.example.search.entity.Product;
import com.example.search.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;




    public List<ProductDTO> getAllProducts() {
        Iterable<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        products.forEach(product -> {
            ProductDTO productDTO = ProductDTO.builder().productId(product.getProductId()).merchantId(product.getMerchantId()).productname(product.getProductname()).price(product.getPrice()).categoryId(product.getCategoryId()).rating(product.getRating()).imageUrl(product.getImageurl()).build();
            productDTOS.add(productDTO);
        });
        return productDTOS;
    }

    public void saveProduct(ProductDTO productDTO) {

        Product product = new Product();
        product.setProductname(productDTO.getProductname());
        product.setPrice(productDTO.getPrice());
        product.setMerchantId(productDTO.getMerchantId());
        product.setProductId(productDTO.getProductId());
        product.setRating(productDTO.getRating());
        product.setImageurl(productDTO.getImageUrl());
        product.setCategoryId(productDTO.getCategoryId());

        productRepository.save(product);

    }
//    public List<Product> findBYName(String pname){
//        return  productRepository.findByProductNameOrderByProductNameAsc(pname);
//
//    }
//    public List<Product> findProductsByAttributes(
//             String productname,
//             String productId,
//             double rating,
//            double price,
//
//             String merchantId,
//
//                  String categoryId
//    ) {
//        String productName= "";
//        for(int i=0;i<productname.length();i++){
//            productName = productname.charAt(i)+"*";
//        }
//        return productRepository.findProductsByAttributes(
//       productName,
//      productId,
//        rating,
//
//         price,merchantId,
//        categoryId
//        );
//    }




    public List<Product> findProductsByNameAndSort(String name, String sortBy) {
        String productName= "";
        for(int i=0;i<name.length();i++){
            productName = name.charAt(i)+"*";
        }
        Sort sort = sortBy != null && !sortBy.isEmpty() ? Sort.by(sortBy) : Sort.by("price");
        PageRequest pageable = PageRequest.of(0, Integer.MAX_VALUE, sort);
        return productRepository.findProductsByName(productName,pageable);
    }


}