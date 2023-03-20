package org.mark.berry;

public class Main {



    private static void welcome() {
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

    public static String mainMenu(){

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

        return menu;
    }

    public static void main(String[] args) {
        welcome();
        System.out.println(mainMenu());




//        Application requirements
//
//        By using the application, the user should be able to do the following:
//
//          •	Create a new property record
//          •	Create a new buyer or seller record
//          •	Create a new (property) sale record
//          •	Search and display an existing sale record based on saleId
//
//        Design guidelines:
//
//        In your application, you can use a menu of your choice and you can create the
//        above mentioned-required objects and store them in the respective ArrayLists.
//        If there are no property or a buyer or a seller, then a sale cannot occur.
//        Hence, you have to make sure that the required values are available for a sale.
//        You may also note that a property can be sold many times over a period of time.
//        Hence, additional fields can be used in the classes to find out whether a property
//        is available for sale or sold out.  (optional) You may assume that a property is
//        sold only once in any one day.


    }

}