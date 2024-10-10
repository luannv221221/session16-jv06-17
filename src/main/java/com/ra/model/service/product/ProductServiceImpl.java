package com.ra.model.service.product;

import com.ra.model.dao.product.ProductDAO;
import com.ra.model.dto.product.ProductDTO;
import com.ra.model.entity.Product;
import com.ra.model.service.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private FileService fileService;

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public boolean create(ProductDTO productDTO) {
        // bước 1: upload file
        String image = fileService.uploadImage(productDTO.getFileImage());
        // bước 2: convertDTO
        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setImage(image);
        product.setCategory(productDTO.getCategory());
        product.setPrice(productDTO.getPrice());
        product.setStatus(productDTO.isStatus());

        return productDAO.create(product);
    }
}
