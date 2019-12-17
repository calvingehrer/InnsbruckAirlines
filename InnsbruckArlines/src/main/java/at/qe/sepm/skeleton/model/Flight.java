package at.qe.sepm.skeleton.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * Entity representing Flight
 */

@Entity
public class Flight implements Persistable<String>, Serializable {

    @Id
    @Column(length = 100)
    private String flightNumber;
    private String iataCode;
    @Temporal(TemporalType.TIMESTAMP)
    private Date utcDepartureTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date utcArrivalTime;
    @Temporal(TemporalType.DATE)
    private Date dateOfFlight;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @ManyToMany
    private List<User> pilots;
    @ManyToMany
    private List<User> groundStaff;
    private int numberOfPassengerSeats;
    @ManyToOne
    private Aircraft usedAircraft;


    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public Date getUtcDepartureTime() {
        return utcDepartureTime;
    }

    public void setUtcDepartureTime(Date utcDepartureTime) {
        this.utcDepartureTime = utcDepartureTime;
    }

    public Date getUtcArrivalTime() {
        return utcArrivalTime;
    }

    public void setUtcArrivalTime(Date utcArrivalTime) {
        this.utcArrivalTime = utcArrivalTime;
    }

    public Date getDateOfFlight() {
        return dateOfFlight;
    }

    public void setDateOfFlight(Date dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<User> getPilots() {
        return pilots;
    }

    public void setPilots(List<User> pilots) {
        this.pilots = pilots;
    }

    public List<User> getGroundStaff() {
        return groundStaff;
    }

    public void setGroundStaff(List<User> groundStaff) {
        this.groundStaff = groundStaff;
    }


    public int getNumberOfPassengerSeats() {
        return numberOfPassengerSeats;
    }

    public void setNumberOfPassengerSeats(int numberOfPassengerSeats) {
        this.numberOfPassengerSeats = numberOfPassengerSeats;
    }


    public Aircraft getUsedAircraft() {
        return usedAircraft;
    }

    public void setUsedAircraft(Aircraft usedAircraft) {
        this.usedAircraft = usedAircraft;
    }


    @Override
    public String toString() {
        return "at.qe.sepm.skeleton.model.Flight[ id=" + flightNumber + " ]";
    }

    @Override
    public String getId(){
        return getFlightNumber();
    }

    @Override
    public boolean isNew(){
        return (null == createDate);
    }
}