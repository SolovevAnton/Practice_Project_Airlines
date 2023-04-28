package com.solovev.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solovev.model.ForumProfile;
import com.solovev.model.FrequentFlyer;
import com.solovev.model.RegisteredFlight;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * class to store FrequentFliers got from JSON
 */
public class FrequentFlyerRepository {
    private FrequentFlyer frequentFlyer;
    private ObjectMapper objectMapper = new ObjectMapper();

    {
        //initialisation for working with date
        this.objectMapper.findAndRegisterModules();
    }

    public FrequentFlyerRepository() {
    }

    /**
     * Constructor to read FrequentFlyers from the given file and write them to passengers
     *
     * @param path path to the file to be read
     * @throws IOException in case of problems with filename
     */
    public FrequentFlyerRepository(File path) throws IOException {
        frequentFlyer = objectMapper.readValue(path, FrequentFlyer.class);
    }

    /**
     * Method that returns all Profiles, who have a Departure out of a certain City anytime at least once
     * empty list if nothing was found
     *
     * @param cityToCheck - cityToCheck name where they have departed. Cannot be null
     * @return list of all found profiles, or empty if nothing was found
     */
    public List<ForumProfile> search(String cityToCheck) {
        Predicate<ForumProfile> wasFlyingFromThere = fp -> {
            for (RegisteredFlight flight : fp.getRegisteredFlights()) {
                String cityDep = flight.getDeparture().getCity();
                if (cityDep != null && cityDep.equals(cityToCheck)) {
                    return true;
                }
            }
            return false;
        };
        return search(wasFlyingFromThere);
    }

    /**
     * Method that returns all Profiles, who have a Departure later than the given date
     * empty list if nothing was found
     *
     * @param dateToCheck - date to start. Cannot be null
     * @return list of all found profiles, or empty if nothing was found
     */
    public List<ForumProfile> search(LocalDate dateToCheck) {
        Predicate<ForumProfile> flyingLaterThan = fp -> {
            for (RegisteredFlight flight : fp.getRegisteredFlights()) {
                LocalDate dateOfFlight = flight.getDate();
                if (dateOfFlight != null && dateOfFlight.isAfter(dateToCheck)) {
                    return true;
                }
            }
            return false;
        };
        return search(flyingLaterThan);
    }

    /**
     * Method that returns all Profiles, who match a given predicate
     * empty list if nothing was found
     *
     * @param predicate -predicate to check. Cannot be null
     * @return list of all found profiles, or empty if nothing was found
     */
    public List<ForumProfile> search(Predicate<ForumProfile> predicate) {
        return frequentFlyer
                .getForumProfiles()
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }


    public FrequentFlyer getFrequentFlyer() {
        return frequentFlyer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FrequentFlyerRepository that = (FrequentFlyerRepository) o;

        if (!Objects.equals(frequentFlyer, that.frequentFlyer))
            return false;
        return Objects.equals(objectMapper, that.objectMapper);
    }

    @Override
    public int hashCode() {
        int result = frequentFlyer != null ? frequentFlyer.hashCode() : 0;
        result = 31 * result + (objectMapper != null ? objectMapper.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FrequentFlyerRepository{" +
                "frequentFlyer=" + frequentFlyer +
                ", objectMapper=" + objectMapper +
                '}';
    }
}
