package com.alanpmz.cli;

import com.alanpmz.service.SupplierService;
import com.alanpmz.service.MedicineService;
import com.alanpmz.validator.InputValidator;

import java.util.Scanner;

public class AppCLI {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMainMenu();
        }
    }

    static void displayMainMenu() {
        System.out.println("\n:::: PHARMACY CRUD ::::");
        System.out.println("[1] Supplier Services");
        System.out.println("[2] Medicine Services");
        System.out.println("[3] Exit");

        Integer ans = InputValidator.readInteger(SCANNER);
        switch (ans) {
            case 1 -> supplierServiceMenu();
            case 2 -> medicineServiceMenu();
            case 3 -> {
                System.out.println("Exiting Pharmacy CLI... Goodbye!");
                System.exit(0);
            }
            case null, default -> System.out.println();
        }
    }

    static void supplierServiceMenu() {
        while (true) {
            System.out.println("\n:::: SUPPLIER SERVICES ::::");
            System.out.println("[1] Read");
            System.out.println("[2] Create");
            System.out.println("[3] Update");
            System.out.println("[4] Delete");
            System.out.println("[5] Back");

            Integer ans = InputValidator.readInteger(SCANNER);
            switch (ans) {
                case 1 -> supplierReadMenu();
                case 2 -> SupplierService.create();
                case 3 -> SupplierService.update();
                case 4 -> SupplierService.delete();
                case 5 -> {
                    return;
                }
                case null, default -> System.out.println();
            }
        }
    }

    static void supplierReadMenu() {
        while (true) {
            System.out.println("\n:::: SUPPLIER READ ::::");
            System.out.println("[1] Find by Name");
            System.out.println("[2] Find by Id");
            System.out.println("[3] Back");

            Integer ans = InputValidator.readInteger(SCANNER);
            switch (ans) {
                case 1 -> SupplierService.findByName();
                case 2 -> SupplierService.findById();
                case 3 -> {
                    return;
                }
                case null, default -> System.out.println();
            }
        }
    }


    static void medicineServiceMenu() {
        while (true) {
            System.out.println("\n:::: MEDICINE SERVICES ::::");
            System.out.println("[1] Read");
            System.out.println("[2] Create");
            System.out.println("[3] Update");
            System.out.println("[4] Delete");
            System.out.println("[5] Back");

            Integer ans = InputValidator.readInteger(SCANNER);
            switch (ans) {
                case 1 -> medicineReadMenu();
                case 2 -> MedicineService.create();
                case 3 -> medicineUpdateMenu();
                case 4 -> MedicineService.delete();
                case 5 -> {
                    return;
                }
                case null, default -> System.out.println();
            }
        }
    }

    static void medicineReadMenu() {
        while (true) {
            System.out.println("\n\n:::: MEDICINE READ ::::\n");
            System.out.println("[1] Find by Name         | [2] Find by Id");
            System.out.println("[3] Dosages              | [4] Quantity");
            System.out.println("[5] Prices               | [6] Expiry Dates");
            System.out.println("[7] Find by Supplier Id  | ");
            System.out.println("[8] Back");

            Integer ans = InputValidator.readInteger(SCANNER);
            switch (ans) {
                case 1 -> MedicineService.findByName();
                case 2 -> MedicineService.findById();
                case 3 -> medicineDosageMenu();
                case 4 -> medicineQuantityMenu();
                case 5 -> medicinePriceMenu();
                case 6 -> medicineExpiryDateMenu();
                case 7 -> MedicineService.findBySupplierId();
                case 8 -> {
                    return;
                }
                case null, default -> System.out.println();
            }
        }
    }

    static void medicineDosageMenu() {
        while (true) {
            System.out.println("\n:::: MEDICINE DOSAGES MENU ::::");
            System.out.println("[1] Find by Dosage Form");
            System.out.println("[2] Find by Dosage");
            System.out.println("[3] Find by Dosage Greater");
            System.out.println("[4] Find by Dosage Less");
            System.out.println("[5] Find by Dosage & Form");
            System.out.println("[6] Back");

            Integer ans = InputValidator.readInteger(SCANNER);
            switch (ans) {
                case 1 -> MedicineService.findByDosageForm();
                case 2 -> MedicineService.findByDosage();
                case 3 -> MedicineService.findByDosageGreater();
                case 4 -> MedicineService.findByDosageLess();
                case 5 -> MedicineService.findByDosageAndForm();
                case 6 -> {
                    return;
                }
                case null, default -> System.out.println();
            }
        }
    }

    static void medicineQuantityMenu() {
        while (true) {
            System.out.println("\n:::: MEDICINE QUANTITY MENU ::::");
            System.out.println("[1] Find by Quantity");
            System.out.println("[2] Find by Quantity Greater");
            System.out.println("[3] Find by Quantity Less");
            System.out.println("[4] Back");

            Integer ans = InputValidator.readInteger(SCANNER);
            switch (ans) {
                case 1 -> MedicineService.findByQuantity();
                case 2 -> MedicineService.findByQuantityGreater();
                case 3 -> MedicineService.findByQuantityLess();
                case 4 -> {
                    return;
                }
                case null, default -> System.out.println();
            }
        }
    }

    static void medicinePriceMenu() {
        while (true) {
            System.out.println("\n:::: MEDICINE PRICE MENU ::::");
            System.out.println("[1] Find by Price");
            System.out.println("[2] Find by Price Greater");
            System.out.println("[3] Find by Price Less");
            System.out.println("[4] Back");

            Integer ans = InputValidator.readInteger(SCANNER);
            switch (ans) {
                case 1 -> MedicineService.findByPrice();
                case 2 -> MedicineService.findByPriceGreater();
                case 3 -> MedicineService.findByPriceLess();
                case 4 -> {
                    return;
                }
                case null, default -> System.out.println();
            }
        }
    }

    static void medicineExpiryDateMenu() {
        while (true) {
            System.out.println("\n:::: MEDICINE EXPIRY DATE MENU ::::");
            System.out.println("[1] Find by Expiry Date");
            System.out.println("[2] Find by Expiry Date After");
            System.out.println("[3] Find by Expiry Date Before");
            System.out.println("[4] Find Expired");
            System.out.println("[5] Back");

            Integer ans = InputValidator.readInteger(SCANNER);
            switch (ans) {
                case 1 -> MedicineService.findByExpiryDate();
                case 2 -> MedicineService.findByExpiryDateAfter();
                case 3 -> MedicineService.findByExpiryDateBefore();
                case 4 -> MedicineService.findExpired();
                case 5 -> {
                    return;
                }
                case null, default -> System.out.println();
            }
        }
    }

    static void medicineUpdateMenu() {
        while (true) {
            System.out.println("\n:::: MEDICINE UPDATE ::::");
            System.out.println("[1] Update Quantity");
            System.out.println("[2] Update Price");
            System.out.println("[3] Update Expiry Date");
            System.out.println("[4] Back");

            Integer ans = InputValidator.readInteger(SCANNER);
            switch (ans) {
                case 1 -> MedicineService.updateQuantity();
                case 2 -> MedicineService.updatePrice();
                case 3 -> MedicineService.updateDate();
                case 4 -> {
                    return;
                }
                case null, default -> System.out.println();
            }
        }
    }

}

