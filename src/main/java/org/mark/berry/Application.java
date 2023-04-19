package org.mark.berry;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Name : Mark Berry
 * Student ID : 12205528
 * Date : 22/03/23
 * File Name : Application.java
 * Purpose of Class : This class handles the user interaction and data verification, it also acts as the data
 * storage while the application is running.
 **/

public class Application {
    // Arraylist's are declared and assigned names for later use.
    // Scanner is declared at class level to be used in all further methods.
    Scanner scanner = new Scanner(System.in);
    ArrayList<Land> propertyArray = new ArrayList<>();
    ArrayList<BuyerSeller> buyerSellers = new ArrayList<>();
    ArrayList<Sale> salesArchive = new ArrayList<>();

    private boolean commandLoop = true;// command loop control variables created.

    public void commandLoop() {
        welcome();// Calls void method for welcome message, comment out for faster load.

        // default objects created, the default variables are used to determine search outcomes.
        propertyArray.add(new Land());
        buyerSellers.add(new BuyerSeller());

        int mainMenuChoice = 0;// variable is used to direct switch statement / user choice.
        // Beginning of command loop.
        while (commandLoop) {
            System.out.print(mainMenu());
            mainMenuChoice = isInt(scanner.nextLine(), mainMenu());

            // switch statement calls a method depending on user choice.
            switch (mainMenuChoice) {
                case 1 -> {
                    propertyRecordMenu();
                }
                case 2 -> {
                    setUpBuyerSeller();
                }
                case 3 -> {
                    setUpSale();
                }
                case 4 -> {
                    searchBySaleID();
                }
                case 5 -> {
                    exitProgram();
                }
                default -> System.out.println("Option not available\nReturning to main menu");
            }

        }

    }

    // Option 1 methods
    private void propertyRecordMenu() {
        // This method is a sub menu controller for the property record, it calls for a menu to print and then uses
        // a switch statement to call a method based on user choice.
        // The switch is encapsulated in a loop until the user opts to exit.
        int propertyTypeChoice = 0;
        boolean propertyChoiceLoop = true;
        while (propertyChoiceLoop) {
            System.out.print(propertyTypeMenu());
            propertyTypeChoice = isInt(scanner.nextLine(), propertyTypeMenu());

            switch (propertyTypeChoice) {
                case 1 -> setUpLand();
                case 2 -> setUpHouseAndLand();
                case 3 -> propertyChoiceLoop = false;
            }

        }
    }

    private void setUpHouseAndLand() {
        // This method constructs a temporary HouseAndLand object and then accepts user information to populate the object
        // some variables are verified by secondary methods, once all information is appended the object is added to
        // the appropriate arraylist and the user is given a read back of the information.
        HouseAndLand built = new HouseAndLand();
        System.out.println("Enter Lot Number:");
        built.setLotNumber(isInt(scanner.nextLine(), "Lot number must be an integer.\n Enter Lot Number:"));
        System.out.println("Enter Address:");
        built.setAddress(scanner.nextLine());
        System.out.println("Enter Land Area:");
        built.setLandArea(isDouble(scanner.nextLine(), "Land area must be numeric only\n Enter Land area:"));
        built.setConstructedArea(checkArea(built.getLandArea()));
        System.out.println("Enter number of bedrooms:");
        built.setNumberOfBedrooms(isInt(scanner.nextLine(), "Number of bedrooms must be an integer\nEnter number of bedrooms:"));
        System.out.println("Enter number of bathrooms");
        built.setNumberOfBathrooms(isInt(scanner.nextLine(), "Number of bathrooms must be an integer\nEnter number of bathrooms"));
        System.out.print("\n---New property created---\nType = House & Land\n" + built + "\n");
        propertyArray.add(built);
    }

    private void setUpLand() {
        // This method constructs a temporary Land object and then accepts user information to populate the object
        // some variables are verified by secondary methods, once all information is appended the object is added to
        // the appropriate arraylist and the user is given a read back of the information.
        Land land = new Land();
        System.out.print("Enter Lot Number:");
        land.setLotNumber(isInt(scanner.nextLine(), "Lot number must be an integer.\nEnter Lot Number:"));
        System.out.print("Enter Address:");
        land.setAddress(scanner.nextLine());
        System.out.print("Enter Land Area:");
        land.setLandArea(isDouble(scanner.nextLine(), "Land area must be numeric only\nEnter Land Area:"));
        System.out.print("\n---New property created---\nType = Land Only\n" + land + "\n");
        propertyArray.add(land);
    }

    private double checkArea(double landArea) {
        // This method checks that the constructed or built on area in not greater than the land area available.
        // a while loop make sure the user inputs the correct values.
        double constructedArea = 0.0;
        boolean areaOK = false;
        while (!areaOK) {
            System.out.println("Enter Constructed area");
            constructedArea = isDouble(scanner.nextLine(), "Constructed area must be numeric only");
            if (constructedArea < landArea) {
                areaOK = true;
            } else {
                System.out.println("Land area = " + landArea);
                System.out.println("Constructed area cannot be bigger than land area.");

            }
        }
        return constructedArea;
    }

    private String propertyTypeMenu() {
        // This method is holds the sub menu for the new property option, it is returned as a string.
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

    // Option 2 methods

    private void setUpBuyerSeller() {
        // This method constructs a temporary BuyerSeller object and then accepts user information to populate the object,
        // some variables are verified by secondary methods, once all information is appended the object is added to
        // the appropriate arraylist and the user is given a read back of the information.
        BuyerSeller buyerSeller = new BuyerSeller();
        System.out.print("Enter client ID:");
        buyerSeller.setClientID(scanner.nextLine());
        System.out.print("Enter Client name:");
        buyerSeller.setName(scanner.nextLine());
        System.out.print("Enter client address:");
        buyerSeller.setAddress(scanner.nextLine());
        System.out.print("Enter client phone number:");
        buyerSeller.setPhoneNumber(scanner.nextLine());
        System.out.print("\n---New Person created---\n" + buyerSeller + "\n");
        buyerSellers.add(buyerSeller);
    }

    // Option 3 methods

    private void setUpSale() {
        // This method constructs a temporary Land object and then accepts user information to populate the object
        // some variables are verified by secondary methods, once all information is appended the object is added to
        // the appropriate arraylist and the user is given a read back of the information.
        boolean itemCheck = true;
        Sale sale = new Sale();
        System.out.print("Enter sale ID: ");
        sale.setSaleId(scanner.nextLine());
        System.out.print("Enter date of sale, YYYY-MM-DD:");
        sale.setDate(isLocalDate(scanner.nextLine()));
        System.out.print("Enter sale price $ ");
        sale.setSoldPrice(isDouble(scanner.nextLine(), "Sale price must be numeric only,\nEnter sale price $"));
        // the additional loop is used to verify that the user selects property and buyer/sellers that have already been created.
        // this is where the default objects are used to assist the search process.
        //the if statements can be toggled if no object is bound outside the default.
        while (itemCheck) {
            System.out.print("Enter property address: ");
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
            if (!sale.getBuyer().getName().equals("X") && !sale.getSeller().getName().equals("X")) {
                itemCheck = false;
            }
        }

        checkSale(sale);

    }

    private void checkSale(Sale sale) {
        // This method checks variables to make sure the sale can occur, an if statement is used to compare and validate
        // user input against records.
        boolean valid = true;
        String checkSeller = sale.getSeller().getName();
        String checkBuyer = sale.getBuyer().getName();
        String checkAddress = sale.getProperty().getAddress();

        if (checkSeller.equals("X")) {
            System.out.println("Sale cannot occur, missing seller information.");
            valid = false;
        }
        if (checkBuyer.equals("X")) {
            System.out.println("Sale cannot occur, missing Buyer information.");
            valid = false;
        }
        if (checkAddress.equals("address")) {
            System.out.println("Sale cannot occur, missing Property information.");
            valid = false;
        }
        if (valid) {
            salesArchive.add(sale);
            System.out.println("\n----New sale created----" + sale);
        }


    }

    private BuyerSeller findPerson(String name) {
        // this method checks the user input is equal to the record being returned to it.
        // if the name matches the object is passed back else the default is passed back.
        BuyerSeller foundPerson = searchBuyerSeller(name);

        if (foundPerson.getName().equals(name)) {
            System.out.println(name + " added to sale record");

        } else System.out.println(name + " could not be found in records");

        return foundPerson;
    }

    private BuyerSeller searchBuyerSeller(String name) {
        // this method loops though the BuyerSeller arraylist to match user input against names stored in each object,
        // if found the BuyerSeller object containing the match is returned else the object at position 0 in the arraylist
        // is returned.
        BuyerSeller tempBuyerSeller = buyerSellers.get(0);
        for (BuyerSeller b : buyerSellers) {
            if (name.equals(b.getName())) {
                tempBuyerSeller = b;
            }
        }
        return tempBuyerSeller;
    }

    private Land findAddress(String address) {
        // this method compares user search input against returned object variable to decide if the correct
        // object was found.
        Land foundLand = searchLand(address);
        if (foundLand.getAddress().equals(address)) {
            System.out.println(address + " added to sale");
        } else System.out.println(address + " could not be found in records");
        return foundLand;
    }

    private Land searchLand(String name) {
        // This method is used to search the arraylist of Land type for matching address, a match is returned else the
        // default object is returned - position 0.
        Land tempLand = propertyArray.get(0);
        for (Land l : propertyArray) {
            if (name.equals(l.getAddress())) {
                tempLand = l;
            }
        }
        return tempLand;
    }

    // Option 4 methods
    private void searchBySaleID() {
        // This method search's the salesArchive and compares user input search to locate a matching object,
        // if found the object information is displayed to the user, else a message (No matching record) is displayed.
        String search = "";
        System.out.println("Enter sale ID:");
        search = scanner.nextLine();
        for (Sale s : salesArchive) {
            if (search.equals(s.getSaleId())) {
                System.out.println(s);
            } else System.out.println("No matching record for " + search);
        }
        System.out.print("Press Enter to return to main menu");
        scanner.nextLine();
    }

    // Option 5 method
    private void exitProgram() {
        // this method displays an exit message and sets the command loops boolean value to false, the program then ends.
        System.out.println("CQ Real estate V1.0");
        System.out.println("Closing Program, Thank you.");
        commandLoop = false;
    }

    // generic methods.
    private void welcome() {
        // This method displays a rather long-winded but pretty welcome string, a loop and try catch is used
        // to achieve a scrolling affect inside the console.
        String welcome = "\n";
        welcome += "Student Name: Mark Berry \n";
        welcome += "Student ID: 12205528\n";
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
    }

    private String mainMenu() {
        // This method is a simple string, returned as the main menu display for the user.
        String menu = "\n";
        menu += "\033[0;34m" + "-----------------------------------------------------------------\n" + "\033[0m";
        menu += "\033[0;34m" + "--------------------------Main Menu------------------------------\n" + "\033[0m";
        menu += "\033[0;34m" + "-----------------------------------------------------------------\n" + "\033[0m";
        menu += "1: Create a new property record\n";
        menu += "2: Create a new buyer or seller record\n";
        menu += "3: Create a new (property) sale record\n";
        menu += "4: Search and display an existing sale record based on sale Id\n";
        menu += "5: Exit Program\n";
        menu += "\033[0;34m" + "-----------------------------------------------------------------\n" + "\033[0m";
        menu += "Enter Choice:";
        return menu;
    }

    private int isInt(String passed, String message) {
        // This method takes two arguments, the first is a value to try and parse to an integer and the second is a
        // message to be displayed should the parse fails.
        // try catch is used to prevent the parse crashing the application if non integer information is passed over.
        // the loop then asks for the user to try again and reruns until the information is correct and an inger is returned.
        int userInput = 0;
        boolean isOk = false;
        while (!isOk) {
            try {
                userInput = Integer.parseInt(passed);


            } catch (NumberFormatException e) {
                System.out.println("Invalid Input");
                System.out.print(message);
                passed = scanner.nextLine();

            }
            if (userInput > 0) {
                isOk = true;
            } else {
                System.out.println("negative number not accepted\n" + message);
                passed = scanner.nextLine();
            }
        }


        return userInput;
    }

    private double isDouble(String passed, String message) {
        // This method takes two arguments, the first is a value to try and parse to a Double and the second is a
        // message to be displayed should the parse fails.
        // try catch is used to prevent the parse crashing the application if a non-Double value is passed over.
        // the loop then asks for the user to try again and reruns until the information is correct and a Double is returned.
        double userInput = 0.0;
        boolean isOk = false;
        while (!isOk) {
            try {
                userInput = Double.parseDouble(passed);
                isOk = true;

            } catch (NumberFormatException e) {
                System.out.println("Invalid Input");
                System.out.print(message);
                passed = scanner.nextLine();
            }
            if (userInput > 0) {
                isOk = true;
            } else {
                System.out.println("negative number not accepted\n" + message);
                passed = scanner.nextLine();
            }
        }
        return userInput;
    }

    private LocalDate isLocalDate(String passed) {
        // this method takes user input in the for of a string and attempts parses it into the LocalDate format.
        // if successful the date is returned in the correct format,
        // else the user is prompted on how to enter the information correctly and loops until successful.
        boolean dateOK = false;
        LocalDate date = LocalDate.now();
        while (!dateOK) {
            try {
                date = LocalDate.parse(passed);
                dateOK = true;
            } catch (DateTimeParseException e) {
                System.out.println("Information Entered:" + passed);
                System.out.println("Format must be \"YYYY-MM-DD\" ");
                System.out.println("Please enter date:");
                passed = scanner.nextLine();
            }

        }
        return date;
    }

}
