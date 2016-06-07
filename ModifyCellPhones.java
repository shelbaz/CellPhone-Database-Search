//---------------------------------
// Assignment 5
// Part 3
// Written by: Shawn Elbaz , 7754132
//---------------------------------

/* The purpose of the assignment is to create a 2 dimensional array of CellularPhones, assign random integers between
 100-299 to each using a random function, and then ask the user to input two numbers. The first number will search the array
 and look for a match. The second number will replace the first number if a match is found. The program will
 then display how many changes were made and where in the index of the array. Program loops infinitely.
 */

package com.company;

import java.util.Random;
import java.util.Scanner;



public class ModifyCellPhones
{

    public static void main(String[] args)
    {
        // Initialize variables as well as CellularPhone object array
        double numb;
        int counter, number1, number2;
        CellularPhoneCopy objects[][] = new CellularPhoneCopy[10][10];


        Scanner kb = new Scanner(System.in);

        Random randomGenerator = new Random(); // object to generate random numbers

        // Loop for initializing x & y objects in array : Regular Constructor

        for (int i = 0; i < 5; i++)
            for (int j=0; j< objects[i].length;j++ )
                objects[i][j] = new CellularPhoneCopy();

        // Loop for initializing  x & y objects in array : Copy Constructor
        for (int i = 5; i < objects.length; i++)
            for (int j=0; j< objects[i].length;j++ )
                objects[i][j] = new CellularPhoneCopy(objects[0][0]);



        // Assigning random number between 100-299 to all objects in the array
        for (int i = 0; i < objects.length; i++)
            for (int j=0; j< objects[i].length ;j++ )
            {
                numb = randomGenerator.nextInt(300-100) + 100;
                objects[i][j].setPrice(numb);
            }


        // Initial display of array
        for (int i = 0; i < objects.length; i++)
        {
            for (int j=0; j< objects[i].length;j++ )
            {
                System.out.printf("%5.2f" + "      " , objects[i][j].getPrice());
            }
            System.out.println();
        }

        int myLoop=0;

        // Loop to search for number and replace it with another
        while (myLoop==0) {
            System.out.println("Please enter a number to search: ");
            number1 = kb.nextInt();
            System.out.println("Now enter a number to replace it with: ");
            number2 = kb.nextInt();

// Counter searches array, tracks how many items were changed as well as displaying where changes were made
            counter = ModifyCellPhones.ModifyPhonePrices(objects, number1, number2);
            System.out.println("There was " + counter + " change(s) made\n");
            System.out.println("Here are the current contents of the array after price modifications: \n");

            // Display array after changes have been made
            for (int i = 0; i < objects.length; i++) {
                for (int j = 0; j < objects[i].length; j++) {
                    System.out.printf("%5.2f" + "      ", objects[i][j].getPrice());
                }
                System.out.println();
            }

        }

    }

    static int ModifyPhonePrices(CellularPhoneCopy[][] objects, double value1, double value2 )
    {
        int ctr = 0;

        for (int i = 0; i < objects.length; i++)
        {
            for (int j = 0; j < objects[i].length; j++)
            {
                if (objects[i][j].getPrice() == value1)
                {
                    objects[i][j].setPrice(value2) ;
                    System.out.println("A change of phone price has taken place at index:  [" + i + "][" + j +"]\n");
                    ctr++;
                }

            }
        }
        if (ctr==0)
            System.out.println("No match found in array");
        return ctr;
    }
}

class CellularPhoneCopy {

    Scanner kb = new Scanner(System.in);
    // Initialization of private variables in CellPhone class
    private String phoneBrand, comparison;
    private double price;
    private long serial;

    // Default CellPhone function, assigns new objects initialized with these values
    public CellularPhoneCopy() {
        phoneBrand = "Apple";
        price = 1000;
        serial = 888888888;
    }

    public CellularPhoneCopy(CellularPhoneCopy other )
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
