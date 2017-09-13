/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1q1_bankloan;

import java.util.Scanner;

/**
 * @title Bank Loan
 * @filename InterestPmt.java
 * @purpose To encapsulate the functions of the bank loan application
 * @assumptions the inputs will only be numerical with integers for the period
 * and doubles for loan amount and interest
 * @author rebecca
 */
public class InterestPmt 
{
    private double thePrincipal;
    private int thePeriod;
    private double theStartInterest;
    private double theEndInterest;
    Scanner theKB = new Scanner(System.in);

    public double getThePrincipal() 
    {
        return thePrincipal;
    }

    public void setThePrincipal(double thePrincipal) 
    {
        this.thePrincipal = thePrincipal;
    }

    public double getThePeriod() 
    {
        return thePeriod;
    }

    public void setThePeriod(int thePeriod) 
    {
        this.thePeriod = thePeriod;
    }

    public double getTheStartInterest() 
    {
        return theStartInterest;
    }

    public void setTheStartInterest(double theStartInterest) 
    {
        this.theStartInterest = theStartInterest;
    }
    
    public double getTheEndInterest() 
    {
        return theEndInterest;
    }

    public void setTheEndInterest(double theEndInterest) 
    {
        this.theEndInterest = theEndInterest;
    }
    
    public void studentInfo()
    {
        System.out.println("Name:               Rebecca Lim");
        System.out.println("Student Number:     33111264");
        System.out.println("Enrolement:         Internal");
        System.out.println("Tutor:              Mark Abernethy");
        System.out.println("Tutorial:           Thursday, 10.30am");
    }
    
    /**
     * The method allows the user to input the principal, the interest rates,
     * the number of years into the application.
     */
    public void inputScreen()
    {
        boolean theFlag = false; 
        
        do
        {
            System.out.println("Please enter the principal amount: ");
            thePrincipal = theKB.nextDouble();
            if(isInvalid(thePrincipal))
            {
                System.out.println("Please enter a number greater than 0:");
            }

        }while(isInvalid(thePrincipal));
        
        do
        {
            System.out.println("Please enter the rate of starting interest: ");
            theStartInterest = theKB.nextDouble();
            if(isInvalid(theStartInterest))
            {
                System.out.println("Please enter a number greater than 0:");
            }
        }while(isInvalid(theStartInterest));
        
        do
        {
            
            System.out.println("Please enter the rate of ending interest: ");
            theEndInterest = theKB.nextDouble();
            
            if (this.isSmaller())
            {
                System.out.println("Please enter an interest greater than "
                        + "the starting interest");
                theFlag = true;
            }
            else
            {
                theFlag = false;
            }    
            
            if(this.isInvalid(theEndInterest))
            {
                System.out.println("Please enter a number greater than 0:");
                theFlag = true;
            }
            else
            {
                theFlag  = false;
            }
            
            if(this.theEndInterest >= 100.00)
            {
                System.out.println("Please enter a interest rate less than 100%");
                theFlag = true;
            }
            
        }while(theFlag);
        
        do
        {
          
            System.out.println("Please enter the number of years: ");
            thePeriod = theKB.nextInt();
           
            if(isInvalid(thePeriod))
            {
                System.out.println("Please enter a number greater than 0:");
            }
        }while(isInvalid(thePeriod));
    }
    
    /**
     * This method checks if the period is less than 0
     * @param zPeriod is checked for whether it is less than or equal to 0.
     * @return
     */
    public boolean isInvalid(int zPeriod)
    {
        boolean theFlag = false;
        
        if(zPeriod <= 0)
        {
            theFlag = true;
        }
        return theFlag;
    }
    
    /**
     * This method checks if the amount is less than 0.
     * @param zAmount the input amount to be tested.
     * @return a boolean value
     */
    public boolean isInvalid(double zAmount)
    {
        boolean theFlag = false;
        
        if(zAmount <= 0)
        {
            theFlag = true;
        }
        return theFlag;
    }
    
    /**
     * Method that checks if the the starting interest is bigger than the 
     * ending interest. 
     * @return a boolean value
     */
    public boolean isSmaller()
    {
        boolean theFlag = false;
        
        if(Math.abs(this.theStartInterest) > Math.abs(this.theEndInterest))
        {
            theFlag = true;
        }
        return theFlag;
    }
    
    /**
     * This method is a helper method for calculating the monthly payment
     * @param inputInt the monthly interest rate
     * @param inputN the period number
     * @return
     */
    private double pmtCalc(double inputInt, int inputN)
    {
        double calcPmt;
        
        calcPmt = (inputInt * (thePrincipal))/(1-(Math.pow((1+inputInt), 
                (-1*inputN))));
        return calcPmt;
    }
    
    /**
     * Method that will display the interest and loan payments
     */
    public void displayTable()
    {
        double thePmt;
        double totPmt;
        
        System.out.println("Loan Amount: "+ thePrincipal);
        System.out.println("Number of years: "+ thePeriod);
        System.out.printf("%20s %20s %20s\n", "Interest Rate", 
                "Monthly Payment", "Total Payment");
        while(theStartInterest <= theEndInterest)
        {
            double r = (theStartInterest /12)/100;
            int  n = (int)thePeriod*12;
            thePmt = pmtCalc(r, n);
            totPmt = thePmt*n;
            System.out.printf("%20.2f%% %20.2f %20.2f\n", theStartInterest, 
                    thePmt, totPmt);
            theStartInterest = theStartInterest + 0.25;
        }
    }
    
    /**
     * Method to exit the program. 
     * @return boolean flag to end program
     */
    public char exitProg()
    {   
        char theFlag = 'y';
        char theInput;
        do
        {
            System.out.println("Would you like to continue? (Y/N)");
            theInput = theKB.next().charAt(0);
            if((theInput == 'y') || (theInput == 'Y')|| (theInput =='n')||(theInput == 'N'))
            {
                if((theInput == 'n') || (theInput == 'N'))
                {
                    theFlag = 'n';
                }
                else
                {
                    break;
                }
            }
            else
            {
                System.out.println("Please enter [Y/N]");
            }
            
        }while(theFlag == 'y');
        
        return theFlag;
    }
    
    
}
