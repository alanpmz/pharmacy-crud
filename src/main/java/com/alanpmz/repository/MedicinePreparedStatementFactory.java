package com.alanpmz.repository;

import com.alanpmz.model.Medicine;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class MedicinePreparedStatementFactory {

    static PreparedStatement createFindByName (Connection conn, String name) throws SQLException {
        String sql = "SELECT * FROM estoque_farmacia.medicamento WHERE nome LIKE ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, String.format("%%%s%%", name));
        return ps;
    }

    static PreparedStatement createFindById(Connection conn, Integer id) throws SQLException {
        String sql = "SELECT * FROM estoque_farmacia.medicamento WHERE idmedicamento = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    static PreparedStatement createFindByDosageForm (Connection conn, String dosageForm) throws SQLException {
        String sql = "SELECT * FROM estoque_farmacia.medicamento WHERE forma_dosagem like ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, String.format("%%%s%%", dosageForm));
        return ps;
    }

    static PreparedStatement createFindByDosage (Connection conn, int dosage) throws SQLException {
        String sql = "SELECT * FROM estoque_farmacia.medicamento WHERE dosagem = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, dosage);
        return ps;
    }

    static PreparedStatement createFindByDosageGreater (Connection conn, int dosage) throws SQLException {
        String sql = "SELECT * FROM estoque_farmacia.medicamento WHERE dosagem > ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, dosage);
        return ps;
    }

    static PreparedStatement createFindByDosageLess (Connection conn, int dosage) throws SQLException {
        String sql = "SELECT * FROM estoque_farmacia.medicamento WHERE dosagem < ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, dosage);
        return ps;
    }

    static PreparedStatement createFindByQuantity (Connection conn, int quantity) throws SQLException {
        String sql = "SELECT * FROM estoque_farmacia.medicamento WHERE quantidade = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, quantity);
        return ps;
    }

    static PreparedStatement createFindByQuantityGreater (Connection conn, int quantity) throws SQLException {
        String sql = "SELECT * FROM estoque_farmacia.medicamento WHERE quantidade > ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, quantity);
        return ps;
    }

    static PreparedStatement createFindByQuantityLess (Connection conn, int quantity) throws SQLException {
        String sql = "SELECT * FROM estoque_farmacia.medicamento WHERE quantidade < ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, quantity);
        return ps;
    }

    static PreparedStatement createFindByPrice (Connection conn, double price) throws SQLException {
        String sql = "SELECT * FROM estoque_farmacia.medicamento WHERE preco = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDouble(1, price);
        return ps;
    }

    static PreparedStatement createFindByPriceGreater (Connection conn, double price) throws SQLException {
        String sql = "SELECT * FROM estoque_farmacia.medicamento WHERE preco > ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDouble(1, price);
        return ps;
    }

    static PreparedStatement createFindByPriceLess (Connection conn, double price) throws SQLException {
        String sql = "SELECT * FROM estoque_farmacia.medicamento WHERE preco < ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDouble(1, price);
        return ps;
    }

    static PreparedStatement createFindByExpiryDate (Connection conn, Date expiryDate) throws SQLException {
        String sql = "SELECT * FROM estoque_farmacia.medicamento WHERE validade = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDate(1, expiryDate);
        return ps;
    }

    static PreparedStatement createFindByExpiryDateAfter (Connection conn, Date expiryDate) throws SQLException {
        String sql = "SELECT * FROM estoque_farmacia.medicamento WHERE validade > ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDate(1, expiryDate);
        return ps;
    }

    static PreparedStatement createFindByExpiryDateBefore (Connection conn, Date expiryDate) throws SQLException {
        String sql = "SELECT * FROM estoque_farmacia.medicamento WHERE validade < ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDate(1, expiryDate);
        return ps;
    }

    static PreparedStatement createFindExpired (Connection conn, Date today) throws SQLException {
        String sql = "SELECT * FROM estoque_farmacia.medicamento WHERE validade < ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDate(1, today);
        return ps;
    }

    static PreparedStatement createFindBySupplierID (Connection conn, Integer supplierId) throws SQLException {
        String sql = "SELECT * FROM estoque_farmacia.medicamento WHERE idfornecedor = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, supplierId);
        return ps;
    }

    static PreparedStatement createFindByDosageAndForm(Connection conn, String dosageForm, int dosage) throws SQLException {
        String sql = "SELECT * FROM estoque_farmacia.medicamento WHERE forma_dosagem LIKE ? AND dosagem = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, String.format("%%%s%%", dosageForm));
        ps.setInt(2, dosage);
        return ps;
    }


    static PreparedStatement createDelete (Connection conn, Integer id) throws SQLException {
        String sql = "DELETE FROM estoque_farmacia.fornecedor WHERE (idmedicamento = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    static PreparedStatement createSave (Connection conn, String name, String dosageForm, int dosage, int quantity, double price, Date date, int supplierId) throws SQLException {
        String sql = """
                INSERT INTO estoque_farmacia.medicamento
                (nome, forma_dosagem, dosagem, quantidade, preco, validade, idfornecedor)
                VALUES (?, ?, ?, ?, ?, ?, ?);
                """;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, dosageForm);
        ps.setInt(3, dosage);
        ps.setInt(4, quantity);
        ps.setDouble(5, price);
        ps.setDate(6, date);
        ps.setInt(7, supplierId);
        return ps;
    }

    static PreparedStatement createUpdateQuantity (Connection conn, Medicine medicine) throws SQLException {
        String sql = "UPDATE `estoque_farmacia`.`medicamento` SET `quantidade` = ? WHERE (`idmedicamento` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, medicine.getQuantity());
        ps.setInt(2, medicine.getId());
        return ps;
    }

    static PreparedStatement createUpdatePrice (Connection conn, Medicine medicine) throws SQLException {
        String sql = "UPDATE `estoque_farmacia`.`medicamento` SET `preco` = ? WHERE (`idmedicamento` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDouble(1, medicine.getPrice());
        ps.setInt(2, medicine.getId());
        return ps;
    }

    static PreparedStatement createUpdateDate (Connection conn, Medicine medicine) throws SQLException {
        String sql = "UPDATE `estoque_farmacia`.`medicamento` SET `validade` = ? WHERE (`idmedicamento` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDate(1, medicine.getExpiry_date());
        ps.setInt(2, medicine.getId());
        return ps;
    }
}
