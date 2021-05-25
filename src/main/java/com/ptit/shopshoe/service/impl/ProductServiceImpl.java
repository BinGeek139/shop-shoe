package com.ptit.shopshoe.service.impl;

import com.ptit.shopshoe.config.GenericMapper;
import com.ptit.shopshoe.dao.*;
import com.ptit.shopshoe.dto.ProductDto;
import com.ptit.shopshoe.entity.Product;
import com.ptit.shopshoe.service.ProductService;
import com.ptit.shopshoe.controller.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    GenericMapper genericMapper;

    @Autowired
    ProductDao productDao;

    @Override
    public ProductDto getById(Integer id) {
        Optional<Product> optionalProduct = productDao.findById(id);
        if (optionalProduct.isPresent()) {
            return genericMapper.mapToType(optionalProduct.get(), ProductDto.class);
        }
        return null;
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> all = productDao.findAll();
        return genericMapper.mapToListOfType(all, ProductDto.class);

    }

    @Override
    public List<ProductDto> getNewProduct(Integer number) {
        Pageable pageable= PageRequest.of(0,number, Sort.by(Sort.Direction.DESC,"timeIn"));
        return genericMapper.mapToListOfType(productDao.findNewProduct(number,pageable),ProductDto.class);
    }

    @Override
    public List<ProductDto> getNewProductForCategory(Integer idCategory, Integer number) {
        if(Objects.isNull(number)){
            return genericMapper.mapToListOfType(productDao.findNewProductForCategory(idCategory),ProductDto.class);
        }
        Pageable pageable= PageRequest.of(0,number, Sort.by(Sort.Direction.DESC,"timeIn"));
        return genericMapper.mapToListOfType(productDao.findNewProductForCategoryLimit(idCategory,pageable),ProductDto.class);
    }
@Autowired
    OrderDao orderDao;

    @Transactional
    @Override
    public Boolean delete(Integer id) {
        Product supplier = productDao.findById(id).orElse(null);
        if (supplier == null) {
            return false;
        }
        productDao.delete(supplier);
        return true;
    }

    @Override
    public String updateImage(Integer id, MultipartFile multipartFile) {
        Product product = productDao.findById(id).orElse(null);
        if(product == null){
            return null;
        }
        String image = minioAdapter.uploadFile(multipartFile);
        product.setImage(image);
        productDao.save(product);
        return image;
    }

    @Override
    public ProductDto update(Integer id, ProductRequest productRequest) {
        Product product = productDao.findById(id).orElse(null);
        if(product == null){
            return null;
        }
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setSale(productRequest.getSale());
        product.setDescription(productRequest.getDescription());
        product.setStatus(productRequest.getStatus());
        product.setModem(productRequest.getModem());
        product.setQuantity(productRequest.getQuantity());
        product.setSold(productRequest.getSold());
        product.setSize(productRequest.getSize());
        product.setColor(productRequest.getColor());
        product.setGender(genderRepo.findById(productRequest.getIdGender()).orElse(null));
        product.setSupplier(supplierDao.findById(productRequest.getIdSupplier()).orElse(null));
        product.setCategory(categoryDao.findById(productRequest.getIdCategory()).orElse(null));
        product = productDao.save(product);
        return genericMapper.mapToType(product, ProductDto.class);
    }

    @Autowired
    MinioAdapter minioAdapter;
    @Autowired
    GenderDao genderRepo;
    @Autowired
    SupplierDao supplierDao;
    @Autowired
    CategoryDao categoryDao;

    @Override
    public ProductDto create(ProductRequest productRequest, MultipartFile multipartFile) {
        String image = minioAdapter.uploadFile(multipartFile);
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setSale(productRequest.getSale());
        product.setDescription(productRequest.getDescription());
        product.setStatus(productRequest.getStatus());
        product.setModem(productRequest.getModem());
        product.setQuantity(productRequest.getQuantity());
        product.setSold(productRequest.getSold());
        product.setSize(productRequest.getSize());
        product.setColor(productRequest.getColor());
        product.setTimeIn(Timestamp.valueOf(LocalDateTime.now()));
        product.setGender(genderRepo.findById(productRequest.getIdGender()).orElse(null));
        product.setSupplier(supplierDao.findById(productRequest.getIdSupplier()).orElse(null));
        product.setCategory(categoryDao.findById(productRequest.getIdCategory()).orElse(null));
        product.setImage(image);
        product = productDao.save(product);
        return genericMapper.mapToType(product, ProductDto.class);
    }
}
