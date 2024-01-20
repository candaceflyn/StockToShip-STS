package com.ttida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.ttida.model.Location;
import com.ttida.service.LocationService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/location")
public class LocationController {

	@Autowired
	private LocationService locationService;

	@GetMapping("/locations")
	public ResponseEntity<List<Location>> getAllLocations() {
		List<Location> locations = locationService.getAllLocations();
		return ResponseEntity.ok(locations);
	}

	@GetMapping("/check-location/{locationId}")
	public ResponseEntity<Boolean> checkLocationIdAvailability(@PathVariable Long locationId) {
		boolean isLocationIdAvailable = locationService.isLocationIdAvailable(locationId);
		return ResponseEntity.ok(!isLocationIdAvailable);
	}
	@GetMapping("/check-locationNo/{locationId}")
	public ResponseEntity<Boolean> checkLocationIdNonAvailability(@PathVariable Long locationId) {
		boolean isLocationIdAvailable = locationService.isLocationIdAvailable(locationId);
		return ResponseEntity.ok(isLocationIdAvailable);
	}

	@PostMapping("/addLocation")
	public ResponseEntity<?> addLocation(@RequestBody Location location) {
		try {
			Location addedLocation = locationService.addLocation(location);
			return ResponseEntity.ok(Map.of("success", true, "location", addedLocation));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("success", false, "message", "Failed to add location."));
		}
	}
	
	 @PutMapping("/{locationId}")
	    public ResponseEntity<String> updateLocation(@PathVariable Long locationId, @RequestBody @Validated Location updatedLocation) {
	        boolean success = locationService.updateLocation(locationId, updatedLocation);

	        if (success) {
	            return ResponseEntity.ok("Location updated successfully");
	        } else {
	            return ResponseEntity.badRequest().body("Unable to update location. Please try again.");
	        }
	    }
}
