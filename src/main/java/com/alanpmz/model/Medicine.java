package com.alanpmz.model;

import lombok.Builder;
import lombok.Value;

import java.sql.Date;

@Value
@Builder
public class Medicine {
    Integer id;
    String name;
    String dosage_form;
    int dosage;
    int quantity;
    double price;
    Date expiry_date;
    Integer supplierId;

}
