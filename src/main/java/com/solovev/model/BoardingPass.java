
package com.solovev.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class BoardingPass {
    @JsonProperty("PassengerFirstName")
    private String passengerFirstName;
    @JsonProperty("PassengerSecondName")
    private String passengerSecondName;
    @JsonProperty("PassengerLastName")
    private String passengerLastName;
    @JsonProperty("PassengerSex")
    private String passengerSex;
    @JsonProperty("PassengerBirthDate")
    @JsonFormat(pattern = "MM/dd/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate passengerBirthDate;

    @JsonProperty("PassengerDocument")
    private String passengerDocument;
    @JsonProperty("BookingCode")
    private String bookingCode;
    @JsonProperty("TicketNumber")
    private String ticketNumber;
    @JsonProperty("Baggage")
    private String baggage;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @JsonProperty("FlightDate")
    private LocalDate flightDate;
    @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING)
    @JsonProperty("FlightTime")
    private LocalTime flightTime;
    @JsonProperty("FlightNumber")
    private String flightNumber;
    @JsonProperty("CodeShare")
    private String codeShare;
    @JsonProperty("Destination")
    private String destination;


    public BoardingPass() {
    }

    public BoardingPass(String passengerFirstName, String passengerSecondName, String passengerLastName, String passengerSex, LocalDate passengerBirthDate, String passengerDocument, String bookingCode, String ticketNumber, String baggage, LocalDate flightDate, LocalTime flightTime, String flightNumber, String codeShare, String destination) {
        this.passengerFirstName = passengerFirstName;
        this.passengerSecondName = passengerSecondName;
        this.passengerLastName = passengerLastName;
        this.passengerSex = passengerSex;
        this.passengerBirthDate = passengerBirthDate;
        this.passengerDocument = passengerDocument;
        this.bookingCode = bookingCode;
        this.ticketNumber = ticketNumber;
        this.baggage = baggage;
        this.flightDate = flightDate;
        this.flightTime = flightTime;
        this.flightNumber = flightNumber;
        this.codeShare = codeShare;
        this.destination = destination;
    }

    public String getPassengerFirstName() {
        return passengerFirstName;
    }

    public void setPassengerFirstName(String passengerFirstName) {
        this.passengerFirstName = passengerFirstName;
    }

    public String getPassengerSecondName() {
        return passengerSecondName;
    }

    public void setPassengerSecondName(String passengerSecondName) {
        this.passengerSecondName = passengerSecondName;
    }

    public String getPassengerLastName() {
        return passengerLastName;
    }

    public void setPassengerLastName(String passengerLastName) {
        this.passengerLastName = passengerLastName;
    }

    public LocalDate getPassengerBirthDate() {
        return passengerBirthDate;
    }

    public void setPassengerBirthDate(LocalDate passengerBirthDate) {
        this.passengerBirthDate = passengerBirthDate;
    }

    public String getPassengerDocument() {
        return passengerDocument;
    }

    public void setPassengerDocument(String passengerDocument) {
        this.passengerDocument = passengerDocument;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getBaggage() {
        return baggage;
    }

    public void setBaggage(String baggage) {
        this.baggage = baggage;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public LocalTime getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(LocalTime flightTime) {
        this.flightTime = flightTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getCodeShare() {
        return codeShare;
    }

    public void setCodeShare(String codeShare) {
        this.codeShare = codeShare;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPassengerSex() {
        return passengerSex;
    }

    public void setPassengerSex(String passengerSex) {
        this.passengerSex = passengerSex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardingPass that = (BoardingPass) o;

        if (!Objects.equals(passengerFirstName, that.passengerFirstName))
            return false;
        if (!Objects.equals(passengerSecondName, that.passengerSecondName))
            return false;
        if (!Objects.equals(passengerLastName, that.passengerLastName))
            return false;
        if (!Objects.equals(passengerSex, that.passengerSex)) return false;
        if (!Objects.equals(passengerBirthDate, that.passengerBirthDate))
            return false;
        if (!Objects.equals(passengerDocument, that.passengerDocument))
            return false;
        if (!Objects.equals(bookingCode, that.bookingCode)) return false;
        if (!Objects.equals(ticketNumber, that.ticketNumber)) return false;
        if (!Objects.equals(baggage, that.baggage)) return false;
        if (!Objects.equals(flightDate, that.flightDate)) return false;
        if (!Objects.equals(flightTime, that.flightTime)) return false;
        if (!Objects.equals(flightNumber, that.flightNumber)) return false;
        if (!Objects.equals(codeShare, that.codeShare)) return false;
        return Objects.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {
        int result = passengerFirstName != null ? passengerFirstName.hashCode() : 0;
        result = 31 * result + (passengerSecondName != null ? passengerSecondName.hashCode() : 0);
        result = 31 * result + (passengerLastName != null ? passengerLastName.hashCode() : 0);
        result = 31 * result + (passengerSex != null ? passengerSex.hashCode() : 0);
        result = 31 * result + (passengerBirthDate != null ? passengerBirthDate.hashCode() : 0);
        result = 31 * result + (passengerDocument != null ? passengerDocument.hashCode() : 0);
        result = 31 * result + (bookingCode != null ? bookingCode.hashCode() : 0);
        result = 31 * result + (ticketNumber != null ? ticketNumber.hashCode() : 0);
        result = 31 * result + (baggage != null ? baggage.hashCode() : 0);
        result = 31 * result + (flightDate != null ? flightDate.hashCode() : 0);
        result = 31 * result + (flightTime != null ? flightTime.hashCode() : 0);
        result = 31 * result + (flightNumber != null ? flightNumber.hashCode() : 0);
        result = 31 * result + (codeShare != null ? codeShare.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BoardingPass{" +
                "passengerFirstName='" + passengerFirstName + '\'' +
                ", passengerSecondName='" + passengerSecondName + '\'' +
                ", passengerLastName='" + passengerLastName + '\'' +
                ", passengerSex='" + passengerSex + '\'' +
                ", passengerBirthDate=" + passengerBirthDate +
                ", passengerDocument=" + passengerDocument +
                ", bookingCode='" + bookingCode + '\'' +
                ", ticketNumber='" + ticketNumber + '\'' +
                ", baggage='" + baggage + '\'' +
                ", flightDate=" + flightDate +
                ", flightTime=" + flightTime +
                ", flightNumber='" + flightNumber + '\'' +
                ", codeShare='" + codeShare + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
