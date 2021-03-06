package at.qe.sepm.skeleton.ui.controllers;

import at.qe.sepm.skeleton.model.Aircraft;
import at.qe.sepm.skeleton.services.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Controller for the user detail view.
 *
 * This class is part of the skeleton project provided for students of the
 * courses "Software Architecture" and "Software Engineering" offered by the
 * University of Innsbruck.
 */
@Component
@Scope("view")
public class AircraftDetailController {

    @Autowired
    private AircraftService aircraftService;

    /**
     * Attribute to cache the currently displayed aircraft
     */
    private Aircraft aircraft;

    /**
     * Sets the currently displayed aircraft and reloads it form db. This aircraft is
     * targeted by any further calls of
     * {@link #doReloadAircraft()}, {@link #doSaveAircraft()} and
     * {@link #doDeleteAircraft()}.
     *
     * @param aircraft
     */
    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
        doReloadAircraft();
    }

    /**
     * Returns the currently displayed aircraft.
     *
     * @return
     */
    public Aircraft getAircraft() {
        return aircraft;
    }

    /**
     * Action to force a reload of the currently displayed aircraft.
     */
    public void doReloadAircraft() {
        aircraft = aircraftService.loadAircraft(aircraft.getAircraftIdentification());
    }

    /**
     * Action to save the currently displayed aircraft.
     */
    public void doSaveAircraft() {
        aircraft = this.aircraftService.saveAircraft(aircraft);
    }

    /**
     * Action to delete the currently displayed aircraft.
     */
    public void doDeleteAircraft() {
        this.aircraftService.deleteAircraft(aircraft);
        aircraft = null;
    }

}
