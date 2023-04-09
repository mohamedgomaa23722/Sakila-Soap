package com.iti.sakila.utils;

import java.math.BigDecimal;

public record FilterRecord(int page,
                           int categoryId,
                           BigDecimal price,
                           BigDecimal rate,
                           String name) {
}
