package com.alanpmz.service;

import com.alanpmz.model.Supplier;
import com.alanpmz.repository.SupplierRepository;
import com.alanpmz.validator.InputValidator;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SupplierService {

    private static final Scanner SCANNER = new Scanner(System.in);



    public static void findByName () {

        System.out.println("Type the supplier name or empty to all");
        System.out.print("> ");
        String name = SCANNER.nextLine().toUpperCase();
        List<Supplier> suppliers = SupplierRepository.findByName(name);

        suppliers.forEach(s -> System.out.printf("ID [ %d ] -- %s%n", s.getId(), s.getName()));
    }

    public static void findById () {
        System.out.println("Type the supplier id");

        Integer id = InputValidator.readInteger(SCANNER);
        if (id == null) return;
        InputValidator.validateNumber(id);

        InputValidator.validateNumber(id);
        Optional<Supplier> supplier = SupplierRepository.findById(id);

        supplier.ifPresentOrElse(s -> System.out.printf("ID [ %d ] -- %s%n",
                        s.getId(), s.getName()), () -> System.out.printf("No supplier with the id [ %d ] found%n", id));
    }

    public static void create () {
        System.out.println("Type the supplier name");
        System.out.print("> ");
        String name = SCANNER.nextLine().toUpperCase();
        InputValidator.validateEmpty(name);
        SupplierRepository.create(name);

    }

    public static void delete () {
        System.out.println("Type the supplier id to delete");

        Integer id = InputValidator.readInteger(SCANNER);
        if (id == null) return;
        InputValidator.validateNumber(id);

        System.out.printf("Every medicine of this supplier are going to be deleted. Are you sure you wanna delete supplier with the id: [ %d ] ? Y/N%n", id);
        System.out.println("> ");

        if (SCANNER.nextLine().equalsIgnoreCase("Y")){
            SupplierRepository.delete(id);
        } else {
            System.out.println("Operation canceled, going back.");
        }
    }

    public static void update () {
        System.out.println("Type the supplier id to update name");

        Integer id = InputValidator.readInteger(SCANNER);
        if (id == null) return;
        InputValidator.validateNumber(id);

        Optional<Supplier> supplier = SupplierRepository.findById(id);

        if (supplier.isPresent()){
            System.out.println("Type the new name or empty to keep the same");
            System.out.print("> ");
            String name = SCANNER.nextLine().toUpperCase();
            if (!name.isEmpty()){
                Supplier oldSup = supplier.get();

                Supplier updSup = Supplier.builder()
                        .id(oldSup.getId())
                        .name(name)
                        .build();

                SupplierRepository.update(updSup);
            } else {
                System.out.println("No changes made, going back.");
            }
        } else {
            System.out.printf("Supplier with the id [ %d ] not found.", id);
        }
    }


}
