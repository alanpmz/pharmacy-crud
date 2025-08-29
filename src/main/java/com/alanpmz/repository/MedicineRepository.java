package com.alanpmz.repository;

import com.alanpmz.conn.ConnectionFactory;
import com.alanpmz.model.Medicine;
import com.alanpmz.util.BuildMedicineList;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Log4j2

public class MedicineRepository {

    public static Optional<Medicine> findById (Integer id) {
        log.info("Finding medicine by id '{}'", id);
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createFindById(connection, id);
             ResultSet rs = preparedStatement.executeQuery()) {

            if (!rs.next()) return Optional.empty();

            return Optional.of(Medicine.builder()
                    .id(rs.getInt("idmedicamento"))
                    .name(rs.getString("nome"))
                    .dosage_form(rs.getString("forma_dosagem"))
                    .dosage(rs.getInt("dosagem"))
                    .quantity(rs.getInt("quantidade"))
                    .price(rs.getDouble("preco"))
                    .expiry_date(rs.getDate("validade"))
                    .supplierId(rs.getInt("idfornecedor"))
                    .build());

        } catch (SQLException e) {
            log.error("Error while trying to find medicine with id: '{}'", id, e);
        }

        return Optional.empty();
    }

    public static List<Medicine> findByName (String name) {
        log.info("Finding medicine by name '{}'", name);
        List<Medicine> medicines = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createFindByName(connection, name)) {
            ResultSet rs = preparedStatement.executeQuery();

            medicines = BuildMedicineList.fromResultSet(rs);

        } catch (SQLException e) {
            log.error("Error while trying to find medicines with '{}'", name, e);
        }

        return medicines;
    }

    public static List<Medicine> findByDosageForm (String dosageForm) {
        log.info("Finding medicine by dosage form '{}'", dosageForm);
        List<Medicine> medicines = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createFindByDosageForm(connection, dosageForm)) {
            ResultSet rs = preparedStatement.executeQuery();

            medicines = BuildMedicineList.fromResultSet(rs);

        } catch (SQLException e) {
            log.error("Error while trying to find medicines with dosage form: '{}'", dosageForm, e);
        }

        return medicines;
    }

    public static List<Medicine> findByDosage (int dosage) {
        log.info("Finding medicine by dosage '{}'", dosage);
        List<Medicine> medicines = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createFindByDosage(connection, dosage)) {
            ResultSet rs = preparedStatement.executeQuery();

            medicines = BuildMedicineList.fromResultSet(rs);

        } catch (SQLException e) {
            log.error("Error while trying to find medicines with dosage '{}'", dosage, e);
        }

        return medicines;
    }

    public static List<Medicine> findByDosageGreater (int dosage) {
        log.info("Finding medicine by dosage greater than '{}'", dosage);
        List<Medicine> medicines = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createFindByDosageGreater(connection, dosage)) {
            ResultSet rs = preparedStatement.executeQuery();

            medicines = BuildMedicineList.fromResultSet(rs);

        } catch (SQLException e) {
            log.error("Error while trying to find medicines with dosage greater than '{}'", dosage, e);
        }

        return medicines;
    }

    public static List<Medicine> findByDosageLess (int dosage) {
        log.info("Finding medicine by dosage less than '{}'", dosage);
        List<Medicine> medicines = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createFindByDosageLess(connection, dosage)) {
            ResultSet rs = preparedStatement.executeQuery();

            medicines = BuildMedicineList.fromResultSet(rs);

        } catch (SQLException e) {
            log.error("Error while trying to find medicines with dosage less than '{}'", dosage, e);
        }

        return medicines;
    }


    public static List<Medicine> findByQuantity (int quantity) {
        log.info("Finding medicine by quantity '{}'", quantity);
        List<Medicine> medicines = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createFindByQuantity(connection, quantity)) {
            ResultSet rs = preparedStatement.executeQuery();

            medicines = BuildMedicineList.fromResultSet(rs);

        } catch (SQLException e) {
            log.error("Error while trying to find medicines with quantity '{}'", quantity, e);
        }

        return medicines;
    }

    public static List<Medicine> findByQuantityGreater (int quantity) {
        log.info("Finding medicine by quantity greater than '{}'", quantity);
        List<Medicine> medicines = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createFindByQuantityGreater(connection, quantity)) {
            ResultSet rs = preparedStatement.executeQuery();

            medicines = BuildMedicineList.fromResultSet(rs);

        } catch (SQLException e) {
            log.error("Error while trying to find medicines with quantity greater than '{}'", quantity, e);
        }

        return medicines;
    }

    public static List<Medicine> findByQuantityLess (int quantity) {
        log.info("Finding medicine by quantity less than '{}'", quantity);
        List<Medicine> medicines = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createFindByQuantityLess(connection, quantity)) {
            ResultSet rs = preparedStatement.executeQuery();

            medicines = BuildMedicineList.fromResultSet(rs);

        } catch (SQLException e) {
            log.error("Error while trying to find medicines with quantity less than '{}'", quantity, e);
        }

        return medicines;
    }

    public static List<Medicine> findByPrice (double price) {
        log.info("Finding medicine by price '{}'", price);
        List<Medicine> medicines = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createFindByPrice(connection, price)) {
            ResultSet rs = preparedStatement.executeQuery();

            medicines = BuildMedicineList.fromResultSet(rs);

        } catch (SQLException e) {
            log.error("Error while trying to find medicines with price '{}'", price, e);
        }

        return medicines;
    }

    public static List<Medicine> findByPriceGreater (double price) {
        log.info("Finding medicine by price greater than '{}'", price);
        List<Medicine> medicines = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createFindByPriceGreater(connection, price)) {
            ResultSet rs = preparedStatement.executeQuery();

            medicines = BuildMedicineList.fromResultSet(rs);

        } catch (SQLException e) {
            log.error("Error while trying to find medicines with price greater than '{}'", price, e);
        }

        return medicines;
    }

    public static List<Medicine> findByPriceLess (double price) {
        log.info("Finding medicine by price less than '{}'", price);
        List<Medicine> medicines = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createFindByPriceLess(connection, price)) {
            ResultSet rs = preparedStatement.executeQuery();

            medicines = BuildMedicineList.fromResultSet(rs);

        } catch (SQLException e) {
            log.error("Error while trying to find medicines with price less than '{}'", price, e);
        }

        return medicines;
    }

    public static List<Medicine> findByExpiryDate (Date expiryDate) {
        log.info("Finding medicine by expiry date '{}'", expiryDate);
        List<Medicine> medicines = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createFindByExpiryDate(connection, expiryDate)) {
            ResultSet rs = preparedStatement.executeQuery();

            medicines = BuildMedicineList.fromResultSet(rs);

        } catch (SQLException e) {
            log.error("Error while trying to find medicines with expiry date '{}'", expiryDate, e);
        }

        return medicines;
    }

    public static List<Medicine> findByExpiryDateAfter (Date expiryDate) {
        log.info("Finding medicine by expiry date after '{}'", expiryDate);
        List<Medicine> medicines = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createFindByExpiryDateAfter(connection, expiryDate)) {
            ResultSet rs = preparedStatement.executeQuery();

            medicines = BuildMedicineList.fromResultSet(rs);

        } catch (SQLException e) {
            log.error("Error while trying to find medicines with expiry date after '{}'", expiryDate, e);
        }

        return medicines;
    }

    public static List<Medicine> findByExpiryDateBefore (Date expiryDate) {
        log.info("Finding medicine by expiry date before '{}'", expiryDate);
        List<Medicine> medicines = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createFindByExpiryDateBefore(connection, expiryDate)) {
            ResultSet rs = preparedStatement.executeQuery();

            medicines = BuildMedicineList.fromResultSet(rs);

        } catch (SQLException e) {
            log.error("Error while trying to find medicines with expiry date before '{}'", expiryDate, e);
        }

        return medicines;
    }

    public static List<Medicine> findExpired () {
        log.info("Finding expired medicine");
        List<Medicine> medicines = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createFindExpired(connection, Date.valueOf(LocalDate.now()))) {
            ResultSet rs = preparedStatement.executeQuery();

            medicines = BuildMedicineList.fromResultSet(rs);

        } catch (SQLException e) {
            log.error("Error while trying to find expired medicines", e);
        }

        return medicines;
    }

    public static List<Medicine> findBySupplierId (Integer id) {
        log.info("Finding medicine by supplier id '{}'", id);
        List<Medicine> medicines = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createFindBySupplierID(connection, id);
             ResultSet rs = preparedStatement.executeQuery()) {

            medicines = BuildMedicineList.fromResultSet(rs);

        } catch (SQLException e) {
            log.error("Error while trying to find medicine with supplier id: '{}'", id, e);
        }

        return medicines;
    }

    public static List<Medicine> findByDosageAndForm (String dosage_form, int dosage) {
        log.info("Finding medicine by dosage form '{}' and dosage '{}'", dosage_form, dosage);
        List<Medicine> medicines = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createFindByDosageAndForm(connection, dosage_form, dosage);
             ResultSet rs = preparedStatement.executeQuery()) {

            medicines = BuildMedicineList.fromResultSet(rs);

        } catch (SQLException e) {
            log.error("Error while trying to find medicine with dosage form '{}' and dosage '{}'", dosage_form, dosage, e);
        }

        return medicines;
    }

    public static void delete(int id) {
        log.info("Deleting medicine by id '{}'", id);
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createDelete(connection, id)) {
            preparedStatement.execute();
            log.info("Deleted medicine ID:'{}' from the database", id);
        } catch (SQLException e) {
            log.error("Error while trying to delete medicine with id: '{}'", id, e);
        }
    }

    public static void create (String name, String dosageForm, int dosage, int quantity, double price, Date date, int supplierId) {
        log.info("Creating medicine '{}'", name);

        if (SupplierRepository.findById(supplierId).isPresent()) {

            try (Connection connection = ConnectionFactory.getConnection();
                 PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createSave(connection, name, dosageForm, dosage, quantity, price, date, supplierId)) {
                preparedStatement.execute();
                log.info("Created medicine '{}' in the database", name);
            } catch (SQLException e) {
                log.error("Error while trying to create medicine '{}'", name, e);
            }
        } else {
            System.out.println("Not a valid supplier ID.");
        }
    }


    public static void updateQuantity (Medicine medicine) {
        log.info("Updating medicine '{}' quantity", medicine.getId());
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createUpdateQuantity(connection, medicine)) {

            preparedStatement.executeUpdate();
            log.info("Updated medicine '{}' quantity in the database", medicine.getId());
        } catch (SQLException e) {
            log.error("Error while trying to update medicine '{}'", medicine.getId(), e);
        }
    }

    public static void updatePrice (Medicine medicine) {
        log.info("Updating medicine '{}' price", medicine.getId());
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createUpdatePrice(connection, medicine)) {

            preparedStatement.executeUpdate();
            log.info("Updated medicine '{}' price in the database", medicine.getId());
        } catch (SQLException e) {
            log.error("Error while trying to update medicine '{}'", medicine.getId(), e);
        }
    }

    public static void updateDate (Medicine medicine) {
        log.info("Updating medicine '{}' date", medicine.getId());
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = MedicinePreparedStatementFactory.createUpdateDate(connection, medicine)) {

            preparedStatement.executeUpdate();
            log.info("Updated medicine '{}' date in the database", medicine.getId());
        } catch (SQLException e) {
            log.error("Error while trying to update medicine '{}'", medicine.getId(), e);
        }
    }

}
