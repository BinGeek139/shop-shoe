package com.ptit.shopshoe.service.impl;

import com.ptit.shopshoe.config.GenericMapper;
import com.ptit.shopshoe.controller.request.CategoryRequest;
import com.ptit.shopshoe.dao.CategoryDao;
import com.ptit.shopshoe.dto.CategoryDto;
import com.ptit.shopshoe.entity.Category;
import com.ptit.shopshoe.service.CategoryService;
import com.ptit.shopshoe.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Autowired
    GenericMapper genericMapper;

    @Override
    public CategoryDto getById(Integer id) {
        Category category = categoryDao.findById(id).orElse(null);
        return Objects.isNull(category)? null : genericMapper.mapToType(category,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAll() {
        List<Category> categoryDaoAll = categoryDao.findAll();
        return genericMapper.mapToListOfType(categoryDaoAll,CategoryDto.class);
    }

    @Override
    public CategoryDto create(CategoryRequest categoryRequest) {
        Category save = categoryDao.save(genericMapper.mapToType(categoryRequest, Category.class));
        return genericMapper.mapToType(save,CategoryDto.class);
    }

    @Override
    public CategoryDto update(Integer id, CategoryRequest categoryRequest) {
        Category category = genericMapper.mapToType(categoryRequest, Category.class);
        category.setIdCategory(id);
        category=categoryDao.save(category);
        return genericMapper.mapToType(category,CategoryDto.class);
    }

    @Override
    public Boolean delete(Integer id) {
        if(!categoryDao.findById(id).isPresent()){
           return  false;
        }
        categoryDao.deleteById(id);
        return true;
    }
}
