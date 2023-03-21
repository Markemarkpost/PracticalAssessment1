package org.mark.berry;

import java.util.Scanner;

public class Application {
    Scanner scanner = new Scanner(System.in);

    public Application() {

    }

    public void commandLoop() {
        //welcome();

        boolean commandLoop = true;
        while (commandLoop) {

            int mainMenuChoice = 0;
            System.out.println(mainMenu());
            mainMenuChoice = isInt(scanner.nextLine());
            switch (mainMenuChoice) {
                case 1: {
                    int propertyTypeChoice = 0;
                    boolean propertyChoiceLoop = true;

                    while (propertyChoiceLoop) {
                        System.out.println(propertyTypeMenu());
                        propertyTypeChoice = isInt(scanner.nextLine());


                        if (propertyTypeChoice == 1) {

                            System.out.println("Enter Lot Number");
                            System.out.println("Enter Address");
                            System.out.println("Enter Land Area");

                        }
                        if (propertyTypeChoice == 2) {
                            System.out.println("House & Land");
                        } else {
                            System.out.println("Please choose from the menu");
                        }
                    }
                    break;
                }

                case 2:
                    System.out.println("Option 2 Create a new buyer or seller record");
                    break;

                case 3:
                    System.out.println("Option 3 Create a new (property) sale record");
                    break;

                case 4:
                    System.out.println("Option 4 Search and display an existing sale record based on saleId");
                    break;

                case 9:
                    System.out.println("Exit");
                    commandLoop = false;
                    break;

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
        menu += "\033[0;34m" + "-----------------------------------------------------------------\n" + "\033[0m";
        menu += "Enter Choice:";
        return menu;
    }

    private String propertyTypeMenu() {
        String menu = "";
        menu += ("\033[0;34m" + "Please select property type" + "\033[0m\n");
        menu += "\033[0;34m" + "-----------------------------------------------------------------\n" + "\033[0m";
        menu += ("1: Land Only\n");
        menu += ("2: House & Land Package\n");
        menu += "\033[0;34m" + "-----------------------------------------------------------------\n" + "\033[0m";
        menu += "Enter Choice:";
        return menu;
    }

    private static int isInt(String passed) {
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

}
