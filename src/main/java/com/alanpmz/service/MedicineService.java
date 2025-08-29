package com.alanpmz.service;

import com.alanpmz.exceptions.InvalidSupplierException;
import com.alanpmz.model.Medicine;
import com.alanpmz.repository.MedicineRepository;
import com.alanpmz.util.MedicinePrinter;
import com.alanpmz.validator.InputValidator;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static com.alanpmz.validator.InputValidator.readSqlDate;

public class MedicineService {

    private static final Scanner SCANNER = new Scanner(System.in);


    public static void findByName () {
        System.out.println("Type the medicine name or empty to all");
        System.out.print("> ");
        String name = SCANNER.nextLine().toUpperCase();
        List<Medicine> medicines = MedicineRepository.findByName(name);

        MedicinePrinter.print(medicines);
    }

    public static void findById () {
        System.out.println("Type the medicine id");

        Integer id = InputValidator.readInteger(SCANNER);
        if (id == null) return;
        InputValidator.validateNumber(id);

        InputValidator.validateNumber(id);
        Optional<Medicine> medicine = MedicineRepository.findById(id);

        medicine.ifPresentOrElse(m -> System.out.printf(
                "ID [ %d ] -- %s, %s, %s, %d units, R$%f, %s, [ %d ]", m.getId(), m.getName(),
                m.getDosage_form(), m.getDosage(), m.getQuantity(),
                m.getPrice(), m.getExpiry_date(), m.getSupplierId()), () -> System.out.printf("No medicine with the id [ %d ] found%n", id));
    }

    public static void findByDosageForm () {
        System.out.println("Type the dosage form");
        System.out.print("> ");
        String dosageForm = SCANNER.nextLine().toUpperCase();
        InputValidator.validateEmpty(dosageForm);

        List<Medicine> medicines = MedicineRepository.findByDosageForm(dosageForm);

        MedicinePrinter.print(medicines);
    }

    public static void findByDosage () {
        System.out.println("Type the dosage");


        Integer dosage = InputValidator.readInteger(SCANNER);
        if (dosage == null) return;
        InputValidator.validateNumber(dosage);

        List<Medicine> medicines = MedicineRepository.findByDosage(dosage);

        MedicinePrinter.print(medicines);
    }


    public static void findByDosageGreater () {
        System.out.println("Type the dosage");


        Integer dosage = InputValidator.readInteger(SCANNER);
        if (dosage == null) return;
        InputValidator.validateNumber(dosage);

        List<Medicine> medicines = MedicineRepository.findByDosageGreater(dosage);

        MedicinePrinter.print(medicines);
    }

    public static void findByDosageLess () {
        System.out.println("Type the dosage");


        Integer dosage = InputValidator.readInteger(SCANNER);
        if (dosage == null) return;
        InputValidator.validateNumber(dosage);

        List<Medicine> medicines = MedicineRepository.findByDosageLess(dosage);

        MedicinePrinter.print(medicines);
    }

    public static void findByQuantity () {
        System.out.println("Type the quantity");


        Integer quantity = InputValidator.readInteger(SCANNER);
        if (quantity == null) return;
        InputValidator.validateNumber(quantity);

        List<Medicine> medicines = MedicineRepository.findByQuantity(quantity);

        MedicinePrinter.print(medicines);
    }


    public static void findByQuantityGreater () {
        System.out.println("Type the quantity");


        Integer quantity = InputValidator.readInteger(SCANNER);
        if (quantity == null) return;
        InputValidator.validateNumber(quantity);

        List<Medicine> medicines = MedicineRepository.findByQuantityGreater(quantity);

        MedicinePrinter.print(medicines);
    }

    public static void findByQuantityLess () {
        System.out.println("Type the quantity");


        Integer quantity = InputValidator.readInteger(SCANNER);
        if (quantity == null) return;
        InputValidator.validateNumber(quantity);

        List<Medicine> medicines = MedicineRepository.findByQuantityLess(quantity);

        MedicinePrinter.print(medicines);
    }

    public static void findByPrice () {
        System.out.println("Type the price (Ex: 12.90) ");


        Double price = InputValidator.readDouble(SCANNER);
        if (price == null) return;
        InputValidator.validateNumber(price);

        List<Medicine> medicines = MedicineRepository.findByPrice(price);

        MedicinePrinter.print(medicines);
    }


    public static void findByPriceGreater () {
        System.out.println("Type the price (Ex: 12.90) ");


        Double price = InputValidator.readDouble(SCANNER);
        if (price == null) return;
        InputValidator.validateNumber(price);

        List<Medicine> medicines = MedicineRepository.findByPriceGreater(price);

        MedicinePrinter.print(medicines);
    }


    public static void findByPriceLess () {
        System.out.println("Type the price (Ex: 12.90) ");


        Double price = InputValidator.readDouble(SCANNER);
        if (price == null) return;
        InputValidator.validateNumber(price);

        List<Medicine> medicines = MedicineRepository.findByPriceLess(price);

        MedicinePrinter.print(medicines);
    }


    public static void findByExpiryDate () {

        System.out.println("Type the expiry date (yyyy-MM-dd) ");

        Date date = readSqlDate(SCANNER);
        if (date == null) {
            System.out.println("Operation cancelled.");
            return;
        }
        List<Medicine> medicines = MedicineRepository.findByExpiryDate(date);

        MedicinePrinter.print(medicines);
    }

    public static void findByExpiryDateAfter () {
        System.out.println("Type the expiry date (yyyy-MM-dd) ");

        Date date = readSqlDate(SCANNER);
        if (date == null) {
            System.out.println("Operation cancelled.");
            return;
        }
        List<Medicine> medicines = MedicineRepository.findByExpiryDateAfter(date);

        MedicinePrinter.print(medicines);
    }

    public static void findByExpiryDateBefore () {
        System.out.println("Type the expiry date (yyyy-MM-dd) ");

        Date date = readSqlDate(SCANNER);
        if (date == null) {
            System.out.println("Operation cancelled.");
            return;
        }
        List<Medicine> medicines = MedicineRepository.findByExpiryDateBefore(date);

        MedicinePrinter.print(medicines);
    }

    public static void findExpired () {
        List<Medicine> medicines = MedicineRepository.findExpired();

        MedicinePrinter.print(medicines);
    }

    public static void findBySupplierId () {
        System.out.println("Type the supplier id");


        Integer id = InputValidator.readInteger(SCANNER);
        if (id == null) return;
        InputValidator.validateNumber(id);

        List<Medicine> medicines = MedicineRepository.findBySupplierId(id);

        MedicinePrinter.print(medicines);
    }

    public static void findByDosageAndForm () {
        System.out.println("Type the dosage form");


        String dosageForm = SCANNER.nextLine().toUpperCase();
        InputValidator.validateEmpty(dosageForm);

        System.out.println("Type the dosage");
        Integer dosage = InputValidator.readInteger(SCANNER);
        if (dosage == null) return;
        InputValidator.validateNumber(dosage);

        List<Medicine> medicines = MedicineRepository.findByDosageAndForm(dosageForm, dosage);

        MedicinePrinter.print(medicines);
    }


    public static void create () {
        System.out.println("Type the medicine name");
        System.out.print("> ");
        String name = SCANNER.nextLine().toUpperCase();
        InputValidator.validateEmpty(name);

        System.out.println("Type the medicine dosage form");
        System.out.print("> ");
        String dosageForm = SCANNER.nextLine().toUpperCase();
        InputValidator.validateEmpty(dosageForm);

        System.out.println("Type the medicine dosage");


        Integer dosage = InputValidator.readInteger(SCANNER);
        if (dosage == null) return;
        InputValidator.validateNumber(dosage);


        System.out.println("Type the medicine quantity");

        Integer quantity = InputValidator.readInteger(SCANNER);
        if (quantity == null) return;
        InputValidator.validateNumber(quantity);


        System.out.println("Type the medicine price");


        Double price = InputValidator.readDouble(SCANNER);
        if (price == null) return;
        InputValidator.validateNumber(price);


        System.out.println("Type the medicine expiry date (yyyy-MM-dd)");

        Date date = readSqlDate(SCANNER);
        if (date == null) {
            System.out.println("Operation cancelled.");
            return;
        }

        System.out.println("Type the supplier ID");
        System.out.print("> ");
        int supplierId = Integer.parseInt(SCANNER.nextLine());
        try {
            InputValidator.validateSupplierId(supplierId);
        } catch (InvalidSupplierException e) {
            System.out.println("Invalid Supplier.");
        }


        MedicineRepository.create(name, dosageForm, dosage, quantity, price, date, supplierId);

    }

    public static void delete () {
        System.out.println("Type the medicine id to delete");
        System.out.print("> ");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.printf("Are you sure you wanna delete medicine with the id: [ %d ] ? Y/N%n", id);
        System.out.println("> ");

        if (SCANNER.nextLine().equalsIgnoreCase("Y")){
            MedicineRepository.delete(id);
        } else {
            System.out.println("Operation canceled, going back.");
        }
    }

    public static void updateQuantity () {
        System.out.println("Type the medicine id to update quantity");

        Integer id = InputValidator.readInteger(SCANNER);
        if (id == null) return;
        InputValidator.validateNumber(id);

        Optional<Medicine> medicine = MedicineRepository.findById(id);

        if (medicine.isPresent()){
            System.out.println("Type the new quantity");

            Integer quantity = InputValidator.readInteger(SCANNER);
            if (quantity == null) return;

            if (quantity > 0){
                Medicine oldMed = medicine.get();

                Medicine updMed = Medicine.builder()
                        .id(oldMed.getId())
                        .name(oldMed.getName())
                        .dosage_form(oldMed.getDosage_form())
                        .dosage(oldMed.getDosage())
                        .quantity(quantity)
                        .price(oldMed.getPrice())
                        .expiry_date(oldMed.getExpiry_date())
                        .supplierId(oldMed.getSupplierId())
                        .build();

                MedicineRepository.updateQuantity(updMed);
            } else {
                System.out.println("Invalid quantity. No changes made, going back.");
            }
        } else {
            System.out.printf("Medicine with the id [ %d ] not found.", id);
        }
    }

    public static void updatePrice () {
        System.out.println("Type the medicine id to update price");

        Integer id = InputValidator.readInteger(SCANNER);
        if (id == null) return;
        InputValidator.validateNumber(id);

        Optional<Medicine> medicine = MedicineRepository.findById(id);

        if (medicine.isPresent()){
            System.out.println("Type the new price");

            Double price = InputValidator.readDouble(SCANNER);
            if (price == null) return;

            if (price > 0){
                Medicine oldMed = medicine.get();

                Medicine updMed = Medicine.builder()
                        .id(oldMed.getId())
                        .name(oldMed.getName())
                        .dosage_form(oldMed.getDosage_form())
                        .dosage(oldMed.getDosage())
                        .quantity(oldMed.getQuantity())
                        .price(price)
                        .expiry_date(oldMed.getExpiry_date())
                        .supplierId(oldMed.getSupplierId())
                        .build();

                MedicineRepository.updatePrice(updMed);
            } else {
                System.out.println("Invalid price. No changes made, going back.");
            }
        } else {
            System.out.printf("Medicine with the id [ %d ] not found.", id);
        }
    }


    public static void updateDate () {
        System.out.println("Type the medicine id to update expiry date");
        System.out.print("> ");
        Integer id = Integer.parseInt(SCANNER.nextLine());
        Optional<Medicine> medicine = MedicineRepository.findById(id);

        if (medicine.isPresent()){
            System.out.println("Type the new expiry date");
            System.out.println("> ");
            String expDate = SCANNER.nextLine();


            if (!expDate.isEmpty()){
                Medicine oldMed = medicine.get();

                Medicine updMed = Medicine.builder()
                        .id(oldMed.getId())
                        .name(oldMed.getName())
                        .dosage_form(oldMed.getDosage_form())
                        .dosage(oldMed.getDosage())
                        .quantity(oldMed.getQuantity())
                        .price(oldMed.getPrice())
                        .expiry_date(Date.valueOf(expDate))
                        .supplierId(oldMed.getSupplierId())
                        .build();

                MedicineRepository.updateDate(updMed);
            } else {
                System.out.println("Invalid date. No changes made, going back.");
            }
        } else {
            System.out.printf("Medicine with the id [ %d ] not found.", id);
        }
    }

}
