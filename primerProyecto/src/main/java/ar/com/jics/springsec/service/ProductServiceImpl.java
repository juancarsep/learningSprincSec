package ar.com.jics.springsec.service;

import ar.com.jics.springsec.model.Product;
import ar.com.jics.springsec.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductRepository repo;

    @Override
    public boolean saveProduct(Product product) {
        try{
            repo.save(product);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public Product getProductById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    public boolean editProduct(Long id, Product newProd) {
        try{
            Product product = this.getProductById(id);
            if(product != null){
                product.setName(newProd.getName());
                product.setPrice(newProd.getPrice());
                product.setDescription(newProd.getDescription());
                repo.save(product);
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public boolean deleteProductById(Long id) {
        try{
            repo.deleteById(id);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}
