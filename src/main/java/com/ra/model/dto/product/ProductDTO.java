package com.ra.model.dto.product;

import com.ra.model.entity.Category;
import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {
    private String productName;
    private double price;
    private MultipartFile fileImage;
    private boolean status;
    private Category category;
    public ProductDTO() {
    }
    public ProductDTO(String productName, double price, MultipartFile fileImage, boolean status, Category category) {
        this.productName = productName;
        this.price = price;
        this.fileImage = fileImage;
        this.status = status;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MultipartFile getFileImage() {
        return fileImage;
    }

    public void setFileImage(MultipartFile fileImage) {
        this.fileImage = fileImage;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
