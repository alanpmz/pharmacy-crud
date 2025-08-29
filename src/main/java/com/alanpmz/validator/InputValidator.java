package com.alanpmz.validator;

import com.alanpmz.exceptions.InvalidInputException;
import com.alanpmz.exceptions.InvalidSupplierException;
import com.alanpmz.model.Supplier;
import com.alanpmz.repository.SupplierRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.Scanner;

public class InputValidator {

    public static void validateEmpty (String string) {
        if (string == null) {
            throw new InvalidInputException("Input cant be empty");
        }
    }

    public static void validateNumber (int num){
        if (num <= 0 ){
            throw new InvalidInputException("Input must be positive.");
        }
    }

    public static void validateNumber (double num) {
        if (num <= 0 ){
            throw new InvalidInputException("Input must be positive.");
        }
    }


    public static void validateSupplierId (int id){
        if (id <= 0){
            throw new InvalidSupplierException("Not a valid supplier id.");
        } else {
            Optional<Supplier> supplier = SupplierRepository.findById(id);
            if (supplier.isEmpty()) {
                throw new InvalidSupplierException("Not a valid supplier id.");
            }
        }
    }

    public static Integer readInteger(Scanner SCANNER) {
        while (true) {
            System.out.print("> ");
            String input = SCANNER.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Invalid number.");
                return null;
            }
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
    }

    public static Double readDouble(Scanner SCANNER) {
        while (true) {
            System.out.print("> ");
            String input = SCANNER.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Invalid number.");
                return null;
            }
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
    }

    public static Date readSqlDate(Scanner SCANNER) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.print("> ");
            String input = SCANNER.nextLine().trim();

            if (input.isEmpty()){
                System.out.println("Date format can't be empty.");
                return null;
            }

            try {
                LocalDate localDate = LocalDate.parse(input, formatter);
                return Date.valueOf(localDate);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please type in yyyy-MM-dd.");
            }
        }
    }
}
