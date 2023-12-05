package com.example.search.controller;


import com.example.search.dto.ProductDTO;
import com.example.search.entity.Product;
import com.example.search.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public void saveProduct(@RequestBody ProductDTO productDTO) {
      productService.saveProduct(productDTO);
    }
//    @GetMapping("/{name}")
//    public List<Product> findProductWithLowestPriceByName(@PathVariable String name) {
//        return productService.findBYName(name);
//    }
//    @GetMapping("/{productName}")
//    public List<Product> findProductsByAttributes(
//            @RequestParam String productname,
//            @RequestParam(required = false,defaultValue = "0") String productId ,
//            @RequestParam(required = false , defaultValue = "0") Double rating,
//
//            @RequestParam(required = false , defaultValue = "0") Double price,
//            @RequestParam(required = false,defaultValue = "0") String merchantId,
//            @RequestParam(required = false,defaultValue = "0") String categoryId
//    ) {
//        return productService.findProductsByAttributes(
//                productname,
//                productId,
//                rating,
//
//                price,merchantId,
//                categoryId
//        );
//    }
    @GetMapping("/{searchProduct}")
    public List<Product> findProductsByNameAndSort(
            @RequestParam String productName,
            @RequestParam(required = false) String sortBy
    ) {
        return productService.findProductsByNameAndSort(productName, sortBy);
    }

}