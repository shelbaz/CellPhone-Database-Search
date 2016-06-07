//---------------------------------
// Assignment 5
// Part 1 & Part 2
// Written by: Shawn Elbaz , 7754132
//---------------------------------

/* The purpose of the assignment is to allow the user to be able to view all attributes of each CellularPhone object
as well as be able to change any attribute. Once attributes have been changed through option 0 of switch statement,
a prompt asking the user if he wants to search the array. "Yes" with a uppercase y searches for a match in both model
and price, while anything else searches for a match in either model or price. The search will display if a match was
found or not and which phone it matched with.
 */

package com.company;
import java.util.Scanner;



public class CellPhoneSearch
{

    public static void main(String[] args)
    {
        //Initializing most base variables in the main class

        String var1; // Brand
        double var2; // Price
        long var3; // Serial number
        int question0, question1, question2, question3, question4 ; // Int values of which cell phone to change in the program


        // Initializing Scanner, CellularPhone array, and arrays for searching through all prices and brands

        Scanner kb = new Scanner(System.in);

        double[] searchPrice = new double[10];
        String[] searchBrand= new String[10];

        String[] changedBrand = new String[10];
        double[] changedPrice = new double [10];
        long[] changedSerial = new long[10];

        // Regular Constructor
        CellularPhone [] objects = new CellularPhone[10];
        for (int i = 0; i < 5; i++)
            objects[i] = new CellularPhone();
        // Copy constructor
        for (int i=5 ; i<10; i++)
            objects[i] = new CellularPhone(objects[0]);

        System.out.println("\n" + objects.length + " phones initialized.... ");
        System.out.println("========================================\nThe initial attributes of all 10 Phones are as follows:\n========================================");
        objects[1].showInfo();


        int always = 1;
        while (always == 1)
        {

            System.out.println("Please select among the following numbers/options: ");
            System.out.println("(0) To edit all attributes of a phone, then search for matches");
            System.out.println("(1) To compare if 2 phones are equal");
            System.out.println("(2) To edit the price of a phone");
            System.out.println("(3) To edit the brand of a phone");
            System.out.println("(4) To edit the serial number of a phone");
            System.out.println("(5) To view the contents/attributes of ALL phones");
            System.out.println("(6) To view the contents/attributes of A single specific phone");
            System.out.println("(7) To exit the application\n");



            question1 = kb.nextInt(); // Input for choosing selection in switch statement

            String[] compare = new String[10]; // Compare array for searching for matches in case 1
            String[] compare2= new String [10]; // Compare array for searching for matches in case 0
            int counter; //  Counter for else statement of case 0
            String YesNo; // Yes or no for searching for matches

            switch (question1) {

                case 0: // Setting individual phone brand & looking for matches in model and price or just price

                    System.out.println("Which phone do you wish to change? (1-10) ");
                    question0 = kb.nextInt();
                    System.out.println("\nPlease set the Brand of Phone " + (question0) + ":");
                    var1 = kb.next();
                    objects[question0 - 1].setBrand(var1);

                    System.out.println("Please set the Price of Phone " + (question0) + ":");
                    var2 = kb.nextDouble();
                    objects[question0 - 1].setPrice(var2);

                    System.out.println("Please set the Serial number of Phone " + (question0) + ":");
                    var3 = kb.nextLong();
                    objects[question0 - 1].setSerial(var3);

                    if (objects[question0 - 1].getSerial() <= 99999999 || objects[question0 - 1].getSerial() > 999999999) {
                        System.out.println("Please set the Serial number of Phone " + (question0) + " to 9 digits ");
                        var3 = kb.nextLong();
                        objects[question0 - 1].setSerial(var3);
                    }


                    System.out.println("Search the array for: (Yes) **Case Sensitive** - A brand AND price match. (No)- A price OR brand match");
                    YesNo = kb.next();
                    int count = 0;
                    if (YesNo.equals("Yes"))
                    {
                        for (int i = 0; i < compare2.length; i++)
                        {
                            compare2[i] = objects[i].compareAction();

                            if (compare2[i].equalsIgnoreCase(objects[question0 - 1].compareAction())) {
                                if (question0 == (i + 1))
                                    continue;
                                System.out.println("************************");
                                System.out.println("Phone " + question0 + " Matches Phone " + (i + 1));
                                System.out.println("************************");
                                count++;
                            }

                        }

                        if (count == 0) {
                            System.out.println("*****************");
                            System.out.println("NO Match Found ");
                            System.out.println("*****************");
                            break;
                        }

                    }

                    else
                    {
                        for (int i = 0; i < objects.length; i++)
                            searchPrice[i] = objects[i].getPrice();

                        for (int i = 0; i < objects.length; i++)
                            searchBrand[i] = objects[i].getBrand();

                        counter = CellularPhone.SearchForPhone(searchBrand, searchPrice, var1, var2, question0);
                        // counter increments for every match found except self match
                        if (counter == 0) {
                            System.out.println("*****************");
                            System.out.println("NO Match Found ");
                            System.out.println("*****************");

                        }

                    }


                    break;

                case 1: // Compare cell phones function


                    int answer1, answer2; // User inputted values for which phones to compare
                    System.out.println("What is the first phone you want to compare?");
                    answer1 = kb.nextInt();
                    System.out.println("What is the second phone you want to compare?");
                    answer2 = kb.nextInt();


                    compare[answer1-1] = objects[answer1-1].compareAction();
                    compare[answer2-1] = objects[answer2-1].compareAction();

                    if (compare[answer1-1].contentEquals(compare[answer2-1]))
                        System.out.println("Phone " + answer1 +  " and Phone " + answer2 + " are equal!\n");
                    else
                        System.out.println("Phone " + answer1 +  " and Phone " + answer2 + " are NOT equal\n");

                    break;

                case 2: // Changing price of cellphone function
                    System.out.println("Which phone price do you wish to change? (1-10) ");
                    question2 = kb.nextInt();

                    System.out.println("Please input the changed value ");
                    changedPrice[question2-1] = kb.nextDouble();
                    objects[question2-1].setPrice(changedPrice[question2-1]);
                    break;

                case 3: //Changing Brand of Cell phone function
                    System.out.println("Which phone brand do you wish to change? (1-10) ");
                    question3 = kb.nextInt();
                    System.out.println("Please input the changed brand ");
                    changedBrand[question3-1] = kb.next();
                    objects[question3-1].setBrand(changedBrand[question3 - 1]);
                    break;

                case 4: // Changing serial number of cell phone function
                    System.out.println("Which phone serial number do you wish to change? (1-10) ");
                    question4 = kb.nextInt();
                    System.out.println("Please input the changed serial ");
                    changedSerial[question4-1] = kb.nextLong();
                    objects[question4-1].setSerial(changedSerial[question4 - 1]);
                    break;

                case 5: // View contents of all object created from the CellularPhone class.

                    for (int i = 0; i < objects.length; i++) {
                        System.out.println();
                        System.out.println("Cellphone " + (i + 1) + ":") ;
                        System.out.println("Brand : " + objects[i].getBrand());
                        System.out.println("Price: " + objects[i].getPrice());
                        System.out.printf("Serial Number: %9.0f \n", objects[i].getSerial());
                        System.out.println();
                    }
                    break;

                case 6: // View contents of a single phone object in the CellularPhone class
                    System.out.println("Which phone do you wish to view? (1-10) ");
                    question4 = kb.nextInt();
                    System.out.println();
                    System.out.println("Cellphone " + (question4) + ":") ;
                    System.out.println("---------------------------------");
                    System.out.println(objects[question4 - 1]);
                    System.out.println("Brand: " + objects[question4 - 1].getBrand());
                    System.out.println("Price: " + objects[question4- 1].getPrice());
                    System.out.printf("Serial Number: %9.0f \n\n", objects[question4 - 1].getSerial());
                    break;

                case 7: // Exit Program on input 6
                    System.out.println("Thank you for using my program");
                    System.exit(0);

            }


        }
    }
}



class CellularPhone {

    Scanner kb = new Scanner(System.in);
    // Initialization of private variables in CellPhone class
    private String phoneBrand, comparison;
    private double price;
    private long serial;



    // Default CellPhone function, assigns new objects initialized with these values
    public CellularPhone() {
        phoneBrand = "Apple";
        price = 1000;
        serial = 888888888;
    }

    public CellularPhone(CellularPhone other )
    {
        this.phoneBrand = other.phoneBrand;
        this.price= other.price;
        this.serial = other.serial;
    }

    public static int SearchForPhone(String [] arr1, double [] arr, String model, double val1, int q0)
    {
        int ctr = 0;

        for (int i = 0; i < arr.length; i++)
        {
            if (q0 == (i + 1)) // Skip self match and do not increment counter
            {continue;}

            // If match is found in price OR model , display message and increment counter.
            if (arr[i] == val1 || arr1[i].equalsIgnoreCase(model))
            {
                System.out.println("************************");
                System.out.println("Phone " + q0 + " matches Phone " + (i+1) );
                System.out.println("************************");
                System.out.println();
                ctr++;
            }
        }

        return ctr;
    }

    // Show information function for whatever object calls it
    public void showInfo() {
        System.out.println("Cellphone: " + phoneBrand);
        System.out.println("Price: " + price );
        System.out.println("Serial Number: " + serial);
        System.out.println();

    }


    // Return the Brand of any CellPhone object
    public String getBrand() {
        return phoneBrand;
    }

    // Set Brand of CellPhone object
    public void setBrand(String br_ph) {
        phoneBrand = br_ph;
    }

    // Return Price of CellPhone object
    public double getPrice() {
        return price;
    }

    // Set Price of CellPhone object
    public void setPrice(double pr) {
        price = pr;
    }

    // Return Serial number of CellPhone object
    public double getSerial() {
        return serial;
    }

    // Set Serial number of CellPhone object
    public void setSerial(long sr) {

        serial = sr;
    }

    //Compare function for simplicity of not including the Serial number,
    // and making the brand in lowercase for easier comparison.
    public String compareAction() {
        comparison = phoneBrand + " " + price;
        comparison = comparison.toLowerCase();
        return comparison;
    }


}