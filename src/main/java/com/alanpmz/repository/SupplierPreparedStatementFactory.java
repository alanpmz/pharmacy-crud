package com.alanpmz.repository;

import com.alanpmz.model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class SupplierPreparedStatementFactory {

    static PreparedStatement createFindByName (Connection conn, String name) throws SQLException {
        String sql = "SELECT * FROM estoque_farmacia.fornecedor WHERE nome LIKE ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, String.format("%%%s%%", name));
        return ps;
    }

    static PreparedStatement createFindById(Connection conn, Integer id) throws SQLException {
        String sql = "SELECT * FROM estoque_farmacia.fornecedor WHERE idfornecedor = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    static PreparedStatement createDelete (Connection conn, Integer id) throws SQLException {
        String sql = "DELETE FROM estoque_farmacia.fornecedor WHERE (idfornecedor = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    static PreparedStatement createSave (Connection conn, String name) throws SQLException {
        String sql = "INSERT INTO `estoque_farmacia`.`fornecedor` (`nome`) VALUES (?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        return ps;
    }

    static PreparedStatement createUpdate (Connection conn, Supplier supplier) throws SQLException {
        String sql = "UPDATE `estoque_farmacia`.`fornecedor` SET `nome` = ? WHERE (`idfornecedor` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, supplier.getName());
        ps.setInt(2, supplier.getId());
        return ps;
    }


}
