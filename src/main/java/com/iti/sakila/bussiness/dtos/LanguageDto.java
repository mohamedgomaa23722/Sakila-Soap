package com.iti.sakila.bussiness.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@NoArgsConstructor
public class LanguageDto {
    private Byte languageId;
    private String name;
    private Timestamp lastUpdate;
}
