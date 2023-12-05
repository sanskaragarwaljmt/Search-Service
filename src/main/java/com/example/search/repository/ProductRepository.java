package com.example.search.repository;

import com.example.search.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductRepository extends SolrCrudRepository<Product, String> {
    // ...
    @Query("pname:?0")
    List<Product> findByProductNameOrderByProductNameAsc(String pname);

    @Query("productname:*?0* OR rating:?1 OR productId:?2  OR price:?3 OR merchantId:?4 OR categoryId:?5")
    List<Product> findProductsByAttributes(  String productname,
                                           String productId,
                                             Double rating,

                                           Double  price, String merchantId,
                                           String categoryId
    );



    @Query("productname:*?0*")
    List<Product> findProductsByName(String name, Pageable pageable);
}


