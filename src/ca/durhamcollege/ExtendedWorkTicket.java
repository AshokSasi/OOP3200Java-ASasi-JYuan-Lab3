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
