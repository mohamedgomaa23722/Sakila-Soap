package com.iti.sakila.bussiness.mapper.filmmapper;

import com.iti.sakila.api.soap.dtos.categorydtos.InsertCategoryRequest;
import com.iti.sakila.api.soap.dtos.categorydtos.UpdateCategoryRequest;
import com.iti.sakila.api.soap.dtos.citydtos.InsertCityRequest;
import com.iti.sakila.api.soap.dtos.citydtos.UpdateCityRequest;
import com.iti.sakila.bussiness.dtos.CategoryDto;
import com.iti.sakila.bussiness.dtos.addressdtos.CityDto;
import com.iti.sakila.bussiness.mapper.BaseMapper;
import com.iti.sakila.persistance.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "default")
public interface CategoryMapper extends BaseMapper<Category, CategoryDto> {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto fromInsertCategoryRequest(InsertCategoryRequest insertCityRequest);

    CategoryDto fromUpdateCategoryRequest(UpdateCategoryRequest updateCityRequest);
}
