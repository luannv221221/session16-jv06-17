package com.ra.model.dto.product;

import com.ra.model.entity.Category;
import com.ra.validate.FileNotNull;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProductDTO {
    @Size(min = 10,message = "Tối thiểu 10 ký tự")
    private String productName;
    @Min(value = 1,message = "Giá không được nhỏ hơn 0")
    private double price;
    @FileNotNull(message = "Chọn cái di")
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
