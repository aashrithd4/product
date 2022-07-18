package com.example.spbootProduct.service;

import com.example.spbootProduct.model.product;
import com.example.spbootProduct.repository.productRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class productService {
    private final productRepository productRepository;

    public List<product> findAll(){
        return productRepository.findAll();
    }

    public Optional<product> findById(int id){
        return productRepository.findById(id);
    }

    public product save(product stock){
        return productRepository.save(stock);
    }

    public void deleteById(int id){
        productRepository.deleteById(id);
    }

}
