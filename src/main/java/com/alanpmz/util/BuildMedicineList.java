package com.alanpmz.util;

import com.alanpmz.model.Medicine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuildMedicineList {

    public static List<Medicine> fromResultSet(ResultSet rs) throws SQLException {
        List<Medicine> medicines = new ArrayList<>();

        while (rs.next()) {
            Medicine medicine = Medicine.builder()
                    .id(rs.getInt("idmedicamento"))
                    .name(rs.getString("nome"))
                    .dosage_form(rs.getString("forma_dosagem"))
                    .dosage(rs.getInt("dosagem"))
                    .quantity(rs.getInt("quantidade"))
                    .price(rs.getDouble("preco"))
                    .expiry_date(rs.getDate("validade"))
                    .supplierId(rs.getInt("idfornecedor"))
                    .build();
            medicines.add(medicine);
        }

        return medicines;
    }
}