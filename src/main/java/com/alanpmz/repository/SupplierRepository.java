package com.alanpmz.repository;


import com.alanpmz.conn.ConnectionFactory;
import com.alanpmz.model.Supplier;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
public class SupplierRepository {

    public static List<Supplier> findByName (String name) {
        log.info("Finding supplier by name '{}'", name);
        List<Supplier> suppliers = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = SupplierPreparedStatementFactory.createFindByName(connection, name)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Supplier supplier = Supplier.builder()
                        .id(rs.getInt("idfornecedor"))
                        .name(rs.getString("nome"))
                        .build();
                suppliers.add(supplier);
            }

        } catch (SQLException e) {
            log.error("Error while trying to find suppliers with '{}'", name, e);
        }

        return suppliers;
    }

    public static Optional<Supplier> findById (Integer id) {
        log.info("Finding supplier by id '{}'", id);
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = SupplierPreparedStatementFactory.createFindById(connection, id);
             ResultSet rs = preparedStatement.executeQuery()) {

            if (!rs.next()) return Optional.empty();

            return Optional.of(Supplier.builder()
                    .id(rs.getInt("idfornecedor"))
                    .name(rs.getString("nome"))
                    .build());

        } catch (SQLException e) {
            log.error("Error while trying to find supplier with id: '{}'", id, e);
        }

        return Optional.empty();
    }

    public static void delete(int id) {
        log.info("Deleting supplier by id '{}'", id);
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = SupplierPreparedStatementFactory.createDelete(connection, id)) {
            preparedStatement.execute();
            log.info("Deleted supplier ID:'{}' from the database", id);
        } catch (SQLException e) {
            log.error("Error while trying to delete supplier with id: '{}'", id, e);
        }
    }

    public static void create (String name) {
        log.info("Creating supplier '{}'", name);

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = SupplierPreparedStatementFactory.createSave(connection, name)) {
            preparedStatement.execute();
            log.info("Created supplier '{}' in the database", name);
        } catch (SQLException e) {
            log.error("Error while trying to create supplier '{}'", name, e);
        }
    }

    public static void update (Supplier supplier) {
        log.info("Updating supplier '{}'", supplier.getId());
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = SupplierPreparedStatementFactory.createUpdate(connection, supplier)) {

            preparedStatement.executeUpdate();
            log.info("Updated supplier '{}' in the database", supplier.getId());
        } catch (SQLException e) {
            log.error("Error while trying to update supplier '{}'", supplier.getId(), e);
        }
    }

}
