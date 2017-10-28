/************
Hannie Kim
Professor Wood
CSCI 1015
10/28/17
Programming Assignment 8
************/

import java.util.Scanner;      // Needed for Scanner class
import java.io.*;              // Needed for the File and IOException

/**
    Using files as input and output
*/

public class kimPass8
{
  public static void main(String[] args) throws IOException
  {

    // Open the file for reading.
    File file = new File("BeginningBalance.dat");
    Scanner inputFile = new Scanner(file);

    // Open an output file for our text
    PrintWriter outputFile = new PrintWriter("NewBalance.dat");

    // The header column names.
    // Use printf to format the width of columns
    System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "Cust No", "Beg. Bal.", "Finance Charge",
                "Purchases", "Payments", "Ending Bal.");

    // Declare total variables we're going to use
    double beginningBalanceTotal = 0,
           financeChargeTotal = 0,
           purchasesTotal = 0,
           paymentsTotal = 0,
           endingBalanceTotal = 0;

    // Read lines from the file until no more are left.
    while (inputFile.hasNext())
    {
      // Variables to read lines in the BeginningBalance file
      int customerNo = inputFile.nextInt();
      double beginningBalance = inputFile.nextDouble();
      double purchases = inputFile.nextDouble();
      double payments = inputFile.nextDouble();

      // Calculating financeCharge. Multiply beginning balance by 1%
      double financeCharge = beginningBalance * 0.01;

      // Ending balance is the sum of finance charge, purchases, and payments.
      double endingBalance = financeCharge + purchases + payments;

      // Print out the first row of data with spaced out columns aligned to the left
      // and to 2 decimals places
      System.out.printf("%-15d%-15.2f%-15.2f%-15.2f%-15.2f%-15.2f\n",
                        customerNo, beginningBalance, financeCharge,
                        purchases, payments, endingBalance);

      // Calculate totals
      beginningBalanceTotal += beginningBalance;
      financeChargeTotal += financeCharge;
      purchasesTotal += purchases;
      paymentsTotal += payments;
      endingBalanceTotal += endingBalance;

      // This information will be written in the NewBalance file.
      outputFile.println(customerNo);
      outputFile.println(endingBalance);
    }

    // Print out the row of Totals with
    System.out.printf("\n%-15s%-15.2f%-15.2f%-15.2f%-15.2f%-15.2f\n", "Totals",
                      beginningBalanceTotal, financeChargeTotal, purchasesTotal,
                      paymentsTotal, endingBalanceTotal);

    // Close the file objects
    inputFile.close();
    outputFile.close();
  }
}