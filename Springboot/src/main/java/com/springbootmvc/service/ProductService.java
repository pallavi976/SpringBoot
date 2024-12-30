package com.springbootmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootmvc.entity.ProductEntity;
import com.springbootmvc.model.ProductModel;
import com.springbootmvc.repository.ProductRepository;

@Service

public class ProductService {

@Autowired
ProductRepository productRepo;

public void saveProductDetails(ProductModel productModel) {
	
	double stockValue;
	stockValue = productModel.getPrice() * productModel.getQuantity();
    double discountPrice;
	discountPrice = productModel.getPrice() * productModel.getDiscountRate() / 100;
    double offerPrice;
	offerPrice = productModel.getPrice() - discountPrice;
    double taxPrice;
	taxPrice = offerPrice *18 / 100;
    double finalPrice;
	finalPrice = offerPrice + taxPrice;

	
	ProductEntity productEntity=new ProductEntity();
	productEntity.setName(productModel.getName());
	productEntity.setBrand(productModel.getBrand());
	productEntity.setMadeIn(productModel.getMadeIn());
	productEntity.setPrice(productModel.getPrice());
	productEntity.setQuantity(productModel.getQuantity());
	productEntity.setDiscountRate(productModel.getDiscountRate());
	
	productEntity.setDiscountPrice(discountPrice);
	productEntity.setOfferPrice(offerPrice);
	productEntity.setFinalPrice(finalPrice);
	productEntity.setStockValue(stockValue);
	productRepo.save(productEntity);
	
}

public List<ProductEntity> getAllProducts() {
	
	List <ProductEntity> products=productRepo.findAll();
	return products;
}

public  ProductEntity searchById(long id) {
	// TODO Auto-generated method stub
	Optional<ProductEntity> optionalData=productRepo.findById(id);
	if (optionalData.isPresent())
	{
		ProductEntity product=optionalData.get();
		return product;
	}
	else {
		return null;
	}
}

public void deleteByIdProduct(long id) {
	productRepo.deleteById(id);
}



public ProductModel editById(long id) {
    Optional<ProductEntity> optionalData = productRepo.findById(id);
    if (optionalData.isPresent()) {
        ProductEntity eproduct = optionalData.get();
        ProductModel product = new ProductModel();
        product.setName(eproduct.getName());
        product.setBrand(eproduct.getBrand());
        product.setMadeIn(eproduct.getMadeIn());
        product.setPrice(eproduct.getPrice());
        product.setQuantity(eproduct.getQuantity());
        product.setDiscountRate(eproduct.getDiscountRate());
        product.setTaxRate(eproduct.getTaxRate());
        return product;
    }
    return null;
}






public void updateById(long id, ProductModel productModel) {
    Optional<ProductEntity> optionalData = productRepo.findById(id);
    if (optionalData.isPresent()) {
        ProductEntity entity = optionalData.get();
        entity.setName(productModel.getName());
        entity.setBrand(productModel.getBrand());
        entity.setMadeIn(productModel.getMadeIn());
        entity.setPrice(productModel.getPrice());
        entity.setQuantity(productModel.getQuantity());
        entity.setDiscountRate(productModel.getDiscountRate());
        entity.setTaxRate(productModel.getTaxRate());

        double stockValue = productModel.getPrice() * productModel.getQuantity();
        double discountPrice = productModel.getPrice() * productModel.getDiscountRate() / 100;
        double offerPrice = productModel.getPrice() - discountPrice;
        double taxPrice = offerPrice * productModel.getTaxRate() / 100;
        double finalPrice = offerPrice + taxPrice;

        entity.setDiscountPrice(discountPrice);
        entity.setOfferPrice(offerPrice);
        entity.setFinalPrice(finalPrice);
        entity.setStockValue(stockValue);

        productRepo.save(entity);
    }
}


}

