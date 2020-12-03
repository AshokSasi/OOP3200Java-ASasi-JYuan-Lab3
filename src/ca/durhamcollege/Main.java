/*
Title: OOP3200Java-ASasi-JYuan-Lab3
Name:Ashok Sasitharan 100745484, Jacky Yuan 100520106
Date: December 02 2020
Changes: Added a ExtendedWorkticket class and adjusted input section to take in a ticket open or closed input
 */
package ca.durhamcollege;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        //Constants
        final int NUMBER_OF_OBJECTS = 3;
        final int MIN_YEARS = 2000;
        final int MAX_YEARS = 2099;
        final int MIN_TICKET_NUMBER = 1;

        //Variable Declarations
        int ticketNumber;
        String clientID;
        LocalDate workTicketDate;
        String issueDescription;
        boolean myOpen;
        boolean isValid =false;
       // WorkTicket[] workticketObj = new WorkTicket [NUMBER_OF_OBJECTS];
        ExtendedWorkTicket[] extendedWorkticketObj = new ExtendedWorkTicket [NUMBER_OF_OBJECTS];
        String date;

        //Input Section
        for (int i =0; i < NUMBER_OF_OBJECTS; i++)
        {
            System.out.println("\nWork Ticket #" + (i+1));
            System.out.println("----------------------------------------------------");
            while (isValid==false)
            {
                try
                {

                    System.out.print("Enter the work ticket number: ");
                    ticketNumber= keyboard.nextInt();
                    //check if ticket number is less than or equal to 0 and throw an exception
                    if (ticketNumber < MIN_TICKET_NUMBER)
                    {
                        throw new IllegalArgumentException("Ticket Number must be a whole positive number greater than 0");
                    }
                    keyboard.nextLine();

                    System.out.print("Enter the Client ID: ");
                    clientID = keyboard.nextLine();

                    System.out.print("Enter the date (dd/mm/yyyy): ");
                    date = keyboard.nextLine();

                    //parse the string date into a LocalDate
                    workTicketDate = LocalDate.parse(date, dateFormat);
                    //check if the entered year is less than 2000 or greater than 2099 and throw and exception
                    if (workTicketDate.getYear() < MIN_YEARS || workTicketDate.getYear() > MAX_YEARS)
                    {
                        throw new IllegalArgumentException(  "Year: " + workTicketDate.getYear()+ " is out of bounds. Year must be between 2000 and 2099");
                    }

                    System.out.print("Enter the description of the issue: ");
                    issueDescription = keyboard.nextLine();

                    //prompts for ticket status input
                    System.out.print("Is ticket open? (true/false): ");
                    myOpen=keyboard.nextBoolean();

                    //set the input into a WorkTicket object
                    extendedWorkticketObj[i]= new ExtendedWorkTicket(ticketNumber,clientID,workTicketDate,issueDescription,myOpen);

                    //check if the inputs are valid in setWorkTicket and set the flag true or false
                    isValid= extendedWorkticketObj[i].setWorkTicket(ticketNumber,clientID,workTicketDate,issueDescription,myOpen);

                }
                catch(Exception e)
                {
                    System.out.println("Error: " + e);
                    System.out.println("----------------------------------------------------");
                    keyboard.nextLine();
                    isValid=false;
                }

            }
            //reset error flag to false
            isValid=false;
        }

        //OUTPUT SECTION
        //loop through the array of objects
        for(int j =0; j < NUMBER_OF_OBJECTS; j++)
        {
            //print out the work tickets using the overrided toString method
            System.out.println("\nWork Ticket #" + (j+1));
            System.out.println(extendedWorkticketObj[j].toString());

        }

    }
}
