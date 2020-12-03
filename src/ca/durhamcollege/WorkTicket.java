/*
Title: OOP3200Java-ASasi-JYuan-Lab3
Name:Ashok Sasitharan 100745484, Jacky Yuan 100520106
Date: December 02 2020
Changes: Added a Extended Workticket class and adjusted input section in main to take in a ticket open or closed boolean input
 */
package ca.durhamcollege;
import java.time.LocalDate;
public class WorkTicket
{
    // PRIVATE INSTANCE VARIABLES
    int ticketNumber;
    String clientID;
    LocalDate workTicketDate;
    String issueDescription;

    //PUBLIC PROPERTIES (MUTATORS AND ACCESSORS)
    public LocalDate getWorkTicketDate()
    {
        return workTicketDate;
    }

    public void setWorkTicketDate(LocalDate workTicketDate)
    {
        this.workTicketDate = workTicketDate;
    }

    public int getTicketNumber()
    {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber)
    {
        this.ticketNumber = ticketNumber;
    }

    public String getClientID()
    {
        return clientID;
    }

    public void setClientID(String clientID)
    {
        this.clientID = clientID;
    }

    public String getIssueDescription()
    {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription)
    {

        this.issueDescription = issueDescription;
    }

    //CONSTRUCTORS

    //default constructor
    WorkTicket()
    {
        this.ticketNumber=0;
        this.clientID=null;
        this.workTicketDate=null;
        this.issueDescription=null;
    }

    //parameterized constructor
    WorkTicket(final int ticketNumber, final String clientID,  final LocalDate workTicketDate, final String issueDescription)
    {

    }
    //PUBLIC METHODS
    public boolean setWorkTicket( int ticketNumber,  String clientID,  LocalDate workTicketDate,  String issueDescription)
    {
        //checks if the description, client ID and date are not empty and sets the inputs while returning true
        if (issueDescription.isEmpty() == false && clientID.isEmpty()==false && workTicketDate != null)
        {
            setTicketNumber(ticketNumber);
            setClientID(clientID);
            setWorkTicketDate(workTicketDate);
            setIssueDescription(issueDescription);
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
        return "Ticket Number:\t\t" + getTicketNumber() + "\nClient ID:\t\t\t" + getClientID()
                + "\nWork Ticket Date:\t"+ getWorkTicketDate()
                + "\nIssue Description:\t" + getIssueDescription() + ".";
    }
}
