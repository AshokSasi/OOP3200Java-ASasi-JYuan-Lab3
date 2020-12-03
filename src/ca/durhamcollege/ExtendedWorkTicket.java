/*
Title: OOP3200Java-ASasi-JYuan-Lab3
Name:Ashok Sasitharan 100745484, Jacky Yuan 100520106
Date: December 02 2020
Changes: Added a Extended Workticket class and adjusted input section to take in a ticket open or closed input
 */
package ca.durhamcollege;

import java.time.LocalDate;

public class ExtendedWorkTicket extends WorkTicket
{
    // PRIVATE INSTANCE VARIABLES
    boolean myOpen;

    // GETTERS
    public boolean isOpen()
    {
        return myOpen;
    }

    // SETTERS
    public void openTicket()
    {
        this.myOpen = true;
    }
    public void closeTicket()
    {
        this.myOpen = false;
    }

    // CONSTRUCTORS

    // default constructor
    ExtendedWorkTicket()
    {
        super();
        openTicket();
    }

    //parameterized constructor
    ExtendedWorkTicket(final int ticketNumber, final String clientID, final LocalDate workTicketDate, final String issueDescription, final boolean myOpen)
    {

    }
    //PUBLIC METHODS

    /**
     * Accepts all of the ExtendedWorkTicket parameters and checks if they are valid. If they are then create an ExtendedWorkticket, if not return false
     * @param ticketNumber
     * @param clientID
     * @param workTicketDate
     * @param issueDescription
     * @param myOpen
     * @return boolean
     */
    public boolean setWorkTicket( int ticketNumber,  String clientID,  LocalDate workTicketDate,  String issueDescription, boolean myOpen)
    {

        //checks if the description, client ID and date are not empty and sets the inputs while returning true
        if (issueDescription.isEmpty() == false && clientID.isEmpty()==false && workTicketDate != null)
        {
            super.setWorkTicket(ticketNumber,clientID,workTicketDate,issueDescription);

            //check if the myOpen variable is true or false and set it as such
            if (myOpen==true)
            {
                openTicket();
            }
            else
            {
                closeTicket();
            }
            return true;
        }
        else
        {

            return false;
        }
    }

    /**
     * Outputs a formatted string of the ExtendedWorkTicket object
     * @return string
     */
    @Override
    public String toString()
    {
        String outputString="";
        if (isOpen()==true)
        {
            outputString="OPEN";
        }
        else
        {
            outputString="CLOSED";
        }
        return super.toString() + "\nTicket:\t" + outputString;
    }

}
