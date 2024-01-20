package com.ttida.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttida.model.Location;
import com.ttida.repository.LocationRepository;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
    public boolean isLocationIdAvailable(Long locationId) {
        return !locationRepository.existsById(locationId);
    }

    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }
    public boolean updateLocation(Long locationId, Location updatedLocation) {
        if (locationRepository.existsById(locationId)) {
            updatedLocation.setLocationId(locationId);
            locationRepository.save(updatedLocation);
            return true; 
        } else {
            return false; 
        }
    }

}
