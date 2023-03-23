package org.mark.berry;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Land> propertyArray = new ArrayList<>();
    ArrayList<BuyerSeller> buyerSellers = new ArrayList<>();
    ArrayList<Sale> salesArchive = new ArrayList<>();


    public void commandLoop() {
        //welcome();
        propertyArray.add(new Land());
        buyerSellers.add(new BuyerSeller());

        boolean commandLoop = true;
        while (commandLoop) {

            int mainMenuChoice = 0;
            System.out.print(mainMenu());
            mainMenuChoice = isInt(scanner.nextLine());
            switch (mainMenuChoice) {

                case 1: {
                    int propertyTypeChoice = 0;
                    boolean propertyChoiceLoop = true;
                    while (propertyChoiceLoop == true) {

                        System.out.println(propertyTypeMenu());
                        propertyTypeChoice = isInt(scanner.nextLine());

                        switch (propertyTypeChoice) {
                            case 1:
                                setUpLand();
                                break;
                            case 2:
                                setUpHouseAndLand();
                                break;
                            case 3:
                                propertyChoiceLoop = false;
                                break;
                        }
                    }
                    break;
                }

                case 2:
                    setUpBuyerSeller();
                    break;

                case 3:
                    Sale sale = new Sale();
                    System.out.print("Enter sale ID: ");
                    sale.setSaleId(scanner.nextLine());
                    System.out.print("Enter sale date (YYYY-MM-DD) :");
                    sale.setDate(LocalDate.parse(scanner.nextLine()));
                    System.out.print("Enter sale price $ ");
                    sale.setSoldPrice(isDouble(scanner.nextLine()));
                    boolean itemCheck = true;
                    while (itemCheck) {
                        System.out.print("Enter property address");
                        sale.setProperty(findAddress(scanner.nextLine()));
                        System.out.print("Enter Seller name: ");
                        sale.setSeller(findPerson(scanner.nextLine()));
                        if (sale.getSeller().getName().equals("X")) {
                            itemCheck = false;
                        }
                        System.out.print("Enter Buyer name: ");
                        sale.setBuyer(findPerson(scanner.nextLine()));
                        if (sale.getBuyer().getName().equals("X")) {
                            itemCheck = false;
                        }
                        if (!sale.getBuyer().getName().equals("X") && !sale.getSeller().getName().equals("X")){
                            itemCheck = false;
                        }
                    }
                    salesArchive.add(sale);
                    System.out.println("\nNew sale created" + sale);



                    break;

                case 4:
                    System.out.println("Option 4 Search and display an existing sale record based on saleId");
                    break;

                case 9:
                    System.out.println("Exit");
                    commandLoop = false;
                    break;

                case 10:
                    for (Land l : propertyArray) {
                        System.out.println(l);
                    }
                case 11:
                    for (BuyerSeller b : buyerSellers) {
                        System.out.println(b);
                    }

                default:
                    System.out.println("Error - please enter an integer from the menu options");
                    System.out.println("Returning to main menu");
            }

        }

    }


    private void welcome() {
        String welcome = "\n";
        welcome += "\033[0;34m" + "-----------------------------------------------------------------\n" + "\033[0m";
        welcome += "\033[0;34m" + "------------------------Welcome To CQ----------------------------\n" + "\033[0m";
        welcome += "\033[0;34m" + "-------------------------Real estate-----------------------------" + "\033[0m";
        for (int i = 0; i < welcome.length(); i++) {
            System.out.print(welcome.charAt(i));
            try {
                Thread.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //System.out.println("Please follow the instructions given.\n\n");
    }

    private String mainMenu() {

        String menu = "\n";
        menu += "\033[0;34m" + "-----------------------------------------------------------------\n" + "\033[0m";
        menu += "\033[0;34m" + "--------------------------Main Menu------------------------------\n" + "\033[0m";
        menu += "\033[0;34m" + "-----------------------------------------------------------------\n" + "\033[0m";
        menu += "1: Create a new property record\n";
        menu += "2: Create a new buyer or seller record\n";
        menu += "3: Create a new (property) sale record\n";
        menu += "4: Search and display an existing sale record based on sale Id\n";
        menu += "9: Exit Program\n";
        menu += "10 TEST - print all stored property\n";
        menu += "11 TEST - Print all buyer / seller\n";
        menu += "\033[0;34m" + "-----------------------------------------------------------------\n" + "\033[0m";
        menu += "Enter Choice:";
        return menu;
    }

    private void setUpLand() {
        Land land = new Land();
        System.out.println("Enter Lot Number");
        land.setLotNumber(isInt(scanner.nextLine()));
        System.out.println("Enter Address");
        land.setAddress(scanner.nextLine());
        System.out.println("Enter Land Area");
        land.setLandArea(isDouble(scanner.nextLine()));
        propertyArray.add(land);
    }

    private void setUpHouseAndLand() {
        HouseAndLand built = new HouseAndLand();
        System.out.println("Enter Lot Number");
        built.setLotNumber(isInt(scanner.nextLine()));
        System.out.println("Enter Address");
        built.setAddress(scanner.nextLine());
        System.out.println("Enter Land Area");
        built.setLandArea(isDouble(scanner.nextLine()));
        System.out.println("Enter Constructed area");
        built.setConstructedArea(isDouble(scanner.nextLine()));
        System.out.println("Enter number of bedrooms");
        built.setNumberOfBedrooms(isInt(scanner.nextLine()));
        System.out.println("Enter number of bathrooms");
        built.setNumberOfBathrooms(isInt(scanner.nextLine()));
        propertyArray.add(built);
    }

    private void setUpBuyerSeller() {
        BuyerSeller buyerSeller = new BuyerSeller();
        System.out.println("Enter client ID");
        buyerSeller.setClientID(scanner.nextLine());
        System.out.println("Enter Client name");
        buyerSeller.setName(scanner.nextLine());
        System.out.println("Enter client address");
        buyerSeller.setAddress(scanner.nextLine());
        System.out.println("Enter client phone number");
        buyerSeller.setPhoneNumber(isInt(scanner.nextLine()));
        buyerSellers.add(buyerSeller);
    }

    private Land findAddress(String address){
        Land foundLand = searchLand(address);

        if (foundLand.getAddress().equals(address)){
            System.out.println(address + " added to sale");
        }else System.out.println(address + " could not be found in records");
        return foundLand;
    }

    private Land searchLand(String name) {
        Land tempLand = propertyArray.get(0);
        for (Land l : propertyArray) {
            if (name.equals(l.getAddress())) {
                tempLand = l;
            }
        }
        return tempLand;
    }

    private BuyerSeller findPerson(String name) {
        BuyerSeller foundPerson = searchBuyerSeller(name);

        if (foundPerson.getName().equals(name)) {
            System.out.println(name + " added to sale record");

        } else System.out.println(name + " could not be found in records");

        return foundPerson;
    }

    private BuyerSeller searchBuyerSeller(String name) {
        BuyerSeller tempBuyerSeller = buyerSellers.get(0);
        for (BuyerSeller b : buyerSellers) {
            if (name.equals(b.getName())) {
                tempBuyerSeller = b;
            }
        }
        return tempBuyerSeller;
    }

    private String propertyTypeMenu() {
        String menu = "";
        menu += ("\033[0;34m" + "Please select property type" + "\033[0m\n");
        menu += "\033[0;34m" + "-----------------------------------------------------------------\n" + "\033[0m";
        menu += ("1: Land Only\n");
        menu += ("2: House & Land Package\n");
        menu += ("3: Return to Main menu\n");
        menu += "\033[0;34m" + "-----------------------------------------------------------------\n" + "\033[0m";
        menu += "Enter Choice:";
        return menu;
    }

    private int isInt(String passed) {
        int userInput = 0;
        boolean isOk = false;
        while (!isOk) {
            try {
                userInput = Integer.parseInt(passed);
                isOk = true;

            } catch (NumberFormatException e) {
                System.out.println("");
                break;
            }
        }
        return userInput;
    }

    private double isDouble(String passed) {
        double userInput = 0.0;
        boolean isOk = false;
        while (!isOk) {
            try {
                userInput = Double.parseDouble(passed);
                isOk = true;

            } catch (NumberFormatException e) {
                System.out.println("");
                break;
            }
        }
        return userInput;
    }

}
