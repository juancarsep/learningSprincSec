package ar.com.jics.springsec.service;

import ar.com.jics.springsec.model.Product;

import java.util.List;

public interface IProductService {
    boolean saveProduct(Product product);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    boolean editProduct (Long id, Product newProd);
    boolean deleteProductById(Long id);
}
