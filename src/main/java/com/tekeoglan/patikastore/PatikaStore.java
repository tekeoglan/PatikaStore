package com.tekeoglan.patikastore;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.UUID;

class PatikaStore {
    private ArrayList<NoteBookPc> noteBookPcs;
    private ArrayList<Phone> phones;

    private LinkedList<String> brandsNames;

    private boolean isRunning;

    PatikaStore() {
        this.isRunning = false;
        this.noteBookPcs = new ArrayList<>();
        this.phones = new ArrayList<>();
        this.brandsNames = new LinkedList<>();

        this.brandsNames.add("Apple");
        this.brandsNames.add("Asus");
        this.brandsNames.add("Casper");
        this.brandsNames.add("HP");
        this.brandsNames.add("Huawei");
        this.brandsNames.add("Lenova");
        this.brandsNames.add("Monster");
        this.brandsNames.add("Samsung");
        this.brandsNames.add("Xiaomi");

        this.noteBookPcs.add(
                new NoteBookPc(
                        new Product(UUID.randomUUID().toString(), 7000, 10, 20, "HUAWEI Matebook 14", "HUAWEI"),
                        new NoteBookPcProperties(512, 14, 16)
                )
        );
        this.noteBookPcs.add(
                new NoteBookPc(
                        new Product(UUID.randomUUID().toString(), 3699, 20, 30, "LENOVA V14 IGL", "LENOVA"),
                        new NoteBookPcProperties(1024, 14, 8)
                )
        );
        this.noteBookPcs.add(
                new NoteBookPc(
                        new Product(UUID.randomUUID().toString(), 8199, 15, 12, "ASUS Tuf Gaming", "ASUS"),
                        new NoteBookPcProperties(2048, 15.6, 32)
                )
        );

        this.phones.add(
                new Phone(
                        new Product(UUID.randomUUID().toString(), 3199, 25, 21, "Samsung Galaxy A51", "SAMSUNG"),
                        new PhoneProperties(128, 6.5, 32, 4000, 6, "Dark")
                )
        );

        this.phones.add(
                new Phone(
                        new Product(UUID.randomUUID().toString(), 7379, 13, 50, "Iphone 11 64 GB", "APPLE"),
                        new PhoneProperties(64, 6.1, 5, 3046, 6, "Blue")
                )
        );

        this.phones.add(
                new Phone(
                        new Product(UUID.randomUUID().toString(), 4012, 8, 100, "Redmi Note 10 Pro 8GB", "XIAOMI"),
                        new PhoneProperties(128, 6.5, 35, 4000, 12, "White")
                )
        );
    }

    private void createNoteBook(Scanner scanner) {
        System.out.println("Input the notebook's properties:");

        System.out.println("name ->");
        scanner.nextLine();
        String name = scanner.nextLine().trim();

        System.out.println("price ->");
        double price = scanner.nextDouble();

        System.out.println("brand ->");
        scanner.nextLine();
        String brand = scanner.nextLine().trim().toUpperCase();

        System.out.println("storage ->");
        int storage = scanner.nextInt();

        System.out.println("display ->");
        double display = scanner.nextDouble();

        System.out.println("memory ->");
        int memory = scanner.nextInt();

        NoteBookPc pc = new NoteBookPc(new Product(UUID.randomUUID().toString(), price, 10, 40, name, brand), new NoteBookPcProperties(storage, display, memory));
        this.noteBookPcs.add(pc);
    }

    private void removeNotebookPc(Scanner scanner) {
        System.out.println("Give the Id of the NoteBook you want to remove from store:");
        scanner.nextLine();
        String id = scanner.nextLine();
        this.noteBookPcs.removeIf(pc -> pc.id.equals(id.trim()));
    }

    private void getNoteBookList() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        String headerFormat = "| %-36s | %-22s | %-10s | %-10s | %-8s | %-10s | %-10s |\n";
        System.out.printf(headerFormat, "ID", "Product Name", "Price", "Brand", "Storage", "Display", "Memory");
        String format = "| %-36s | %-22s | %-10s | %-10s | %-8d | %-10s | %-10d |\n";
        for (NoteBookPc notebook : this.noteBookPcs) {
            System.out.printf(format, notebook.id, notebook.name, notebook.price, notebook.brand, notebook.properties.storage, notebook.properties.display, notebook.properties.memory);
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
    }

    void getNoteBookMenu(Scanner scanner) {
        boolean showing = true;

        while (showing) {
            System.out.println("Notebook Operations");
            System.out.println("1- List by IDs");
            System.out.println("2- List by Brand Names");
            System.out.println("3- Add a new Notebook");
            System.out.println("4- Remove a Notebook");
            System.out.println("5- go back");

            switch (scanner.nextInt()) {
                case 1:
                    this.noteBookPcs.sort(new Product.ProductComparatorById());
                    getNoteBookList();
                    break;
                case 2:
                    this.noteBookPcs.sort(new Product.ProductComparatorByBrand());
                    getNoteBookList();
                    break;
                case 3:
                    this.createNoteBook(scanner);
                    break;
                case 4:
                    this.removeNotebookPc(scanner);
                    break;
                case 5:
                    showing = false;
                    break;
                default:
                    break;
            }
        }

    }

    void getPhoneMenu() {
    }

    void getMainMenu() {
        Scanner input = new Scanner(System.in);
        while (isRunning) {
            System.out.println("PatikaStore Product Management Panel !");
            System.out.println("1- NoteBook Operations");
            System.out.println("2- CellPhone Operations");
            System.out.println("3- List The Brand Names");
            System.out.println("4- Exit");

            switch (input.nextInt()) {
                case 1:
                    this.getNoteBookMenu(input);
                    break;
                case 2:
                    break;
                case 3:
                    this.printBrandsList();
                    break;
                case 4:
                    this.isRunning = false;
                    break;
                default:
                    System.out.println("Please give a valid input.");
                    break;
            }
        }
        input.close();
    }

    void printBrandsList() {
        System.out.println("Brands");
        System.out.println("------------");
        for (String brandName : this.brandsNames) {
            System.out.println("- " + brandName);
        }
    }

    void run() {
        this.isRunning = true;
        this.getMainMenu();
    }
}
