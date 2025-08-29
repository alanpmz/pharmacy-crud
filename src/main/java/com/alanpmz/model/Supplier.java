package com.alanpmz.model;


import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Supplier {
    Integer id;
    String name;
}
