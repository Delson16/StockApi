package com.comerce.stockApi.repository;

import com.comerce.stockApi.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
    
}
