/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1q1_bankloan;

import java.util.Scanner;

/**
 * @title Bank Loan
 * @filename Assignment1Q1_BankLoan.java
 * @purpose To encapsulate the  client functions of the bank loan application
 * @assumptions the inputs will only be numerical with integers for the period
 * and doubles for loan amount and interest
 * @author rebecca
 */
public class Assignment1Q1_BankLoan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        char theFlag = 'y';
        //char theInput;
        Scanner theKB = new Scanner(System.in);
        InterestPmt thePmt = new InterestPmt();
        do
        {
            thePmt.inputScreen();
            thePmt.displayTable();
            theFlag = thePmt.exitProg();
            
        }while (theFlag == 'y');
        
    }
    
}
