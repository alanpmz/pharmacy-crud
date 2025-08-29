package com.alanpmz.util;

import com.alanpmz.model.Medicine;

import java.util.List;

public class MedicinePrinter {
    public static void print(List<Medicine> medicines){
        medicines.forEach(m -> System.out.printf(
                "ID [ %d ] -- %s, %s, %s, %d units, R$%f, %s, [ %d ]%n", m.getId(), m.getName(),
                m.getDosage_form(), m.getDosage(), m.getQuantity(),
                m.getPrice(), m.getExpiry_date(), m.getSupplierId()));

    }
}
