package com.iti.sakila.api.soap.webservice;

import com.iti.sakila.bussiness.dtos.languagedtos.LanguageDto;
import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.mapper.LanguageMapper;
import com.iti.sakila.bussiness.service.BaseService;
import com.iti.sakila.persistance.entity.Language;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class LanguageWebService {

    private final BaseService<Language, LanguageDto> languageService;

    public LanguageWebService() {
        languageService = new BaseService<>(Language.class, LanguageMapper.INSTANCE);
    }

    @WebMethod
    public List<LanguageDto> getLanguages(@WebParam(name = "page") int page){
        return languageService.getAll(page);
    }

    @WebMethod
    public LanguageDto getLanguage(@WebParam(name = "id") int id){
        return languageService.findById(id);
    }

    @WebMethod
    public Message insertLanguage(@WebParam(name = "language") LanguageDto languageDto){
        System.out.println("insert lang");
        return languageService.insert(languageDto);
    }

    @WebMethod
    public Message updateLanguage(@WebParam(name = "") LanguageDto languageDto) {
        return languageService.update(languageDto, languageDto.getLanguageId());
    }

    @WebMethod
    public Message deleteLanguage(@WebParam(name = "languageId") int id){
        return languageService.delete(id);
    }
}
