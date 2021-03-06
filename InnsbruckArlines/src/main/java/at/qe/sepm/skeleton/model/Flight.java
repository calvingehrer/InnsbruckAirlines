package at.qe.sepm.skeleton.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
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
    private String iataCodeDeparture;
    private String iataCodeArrival;
    @Temporal(TemporalType.TIMESTAMP)
    private Date utcDepartureTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date utcArrivalTime;
    @Temporal(TemporalType.DATE)
    private Date dateOfFlight;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.DATE)
    private Date updateDate;
    @ManyToMany
    private Collection<User> pilots;
    @ManyToMany
    private Collection<User> crew;
    private int numberOfPassengerSeats;
    @ManyToOne
    private Aircraft usedAircraft;
    private boolean available;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getIataCodeDeparture() {
        return iataCodeDeparture;
    }

    public void setIataCodeDeparture(String iataCode) {
        this.iataCodeDeparture = iataCode;
    }

    public String getIataCodeArrival() {
        return iataCodeArrival;
    }

    public void setIataCodeArrival(String iataCodeArrival) {
        this.iataCodeArrival = iataCodeArrival;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Collection<User> getPilots() {
        return pilots;
    }

    public void setPilots(Collection<User> pilots) {
        this.pilots = pilots;
    }

    public Collection<User> getCrew() {
        return crew;
    }

    public void setCrew(Collection<User> groundStaff) {
        this.crew = groundStaff;
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