package com.iti.sakila.api.soap.webservice;

import com.iti.sakila.api.soap.dtos.categorydtos.InsertCategoryRequest;
import com.iti.sakila.api.soap.dtos.categorydtos.UpdateCategoryRequest;
import com.iti.sakila.bussiness.dtos.CategoryDto;
import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.countrydtos.CountryDto;
import com.iti.sakila.bussiness.mapper.CountryMapper;
import com.iti.sakila.bussiness.mapper.filmmapper.CategoryMapper;
import com.iti.sakila.bussiness.service.BaseService;
import com.iti.sakila.bussiness.service.BaseTransactionService;
import com.iti.sakila.persistance.entity.Category;
import com.iti.sakila.persistance.entity.Country;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;
@WebService
public class CategoryWebService {
    private final BaseService<Category, CategoryDto> baseService = new BaseTransactionService<>(Category.class, CategoryMapper.INSTANCE);

    @WebMethod
    public List<CategoryDto> getCategories(@WebParam(name = "page") int page) {
        return baseService.getAll(page);
    }

    @WebMethod
    public CategoryDto getCategory(@WebParam(name = "id") int id) {
        return baseService.findById(id);
    }

    @WebMethod
    public Message insertCategory(@WebParam(name = "category") InsertCategoryRequest insertCategoryRequest) {
        CategoryDto category = CategoryMapper.INSTANCE.fromInsertCategoryRequest(insertCategoryRequest);
        return baseService.insert(category);
    }

    @WebMethod
    public Message updateCategory(@WebParam(name = "category") UpdateCategoryRequest updateCategoryRequest) {
        CategoryDto category = CategoryMapper.INSTANCE.fromUpdateCategoryRequest(updateCategoryRequest);
        return baseService.update(category, category.getCategoryId());
    }

    @WebMethod
    public Message deleteCategory(@WebParam(name = "id") int id) {
        return baseService.delete(id);
    }

    @WebMethod
    public List<CategoryDto> findCategoriesByName(@WebParam(name = "name") String name, @WebParam(name = "page") int page) {
        return baseService.findByName(name, "name", page);
    }
}
