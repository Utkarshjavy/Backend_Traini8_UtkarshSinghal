package com.train8.backend.Controller;

import com.train8.backend.Model.TrainingCenter;
import com.train8.backend.Service.TrainingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/trainingcenters")// this the website route
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService service;

    @PostMapping("/create")
    public ResponseEntity<?> createTrainingCenter(@RequestBody TrainingCenter center) {
        // center should have valid length
        if (center.getCenterName().length() > 40) {
            return ResponseEntity.badRequest().body("Center Name length can't exceed 40 characters.");
        }

        // center code should be exactly 12 characters long
        if (center.getCenterCode().length() != 12) {
            return ResponseEntity.badRequest().body("Center Code must be exactly 12 characters long.");
        }

        // using regular exp for email verifications
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        // intials canhave anything from A-Z and a-z and 0-9 and +_.- and then @ and then A-Z and a-z and 0-9 and -
        if (!Pattern.matches(emailRegex, center.getContactEmail())) {
            // not matching the email regex we send this error
            return ResponseEntity.badRequest().body("Invalid Email Format.");
        }

        //Mobile Number length check (Should be exactly 10 digits)
        String mobileRegex = "\\d{10}";
        if (!Pattern.matches(mobileRegex, center.getContactPhone())) {
            return ResponseEntity.badRequest().body("Invalid Mobile Number. Must be 10 digits.");
        }

        // create Training Center if it passes every check
        TrainingCenter savedCenter = service.createTrainingCenter(center);
        return ResponseEntity.ok(savedCenter);
    }

    @GetMapping("/all")
    // in this get path we are getting all the training centers
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        List<TrainingCenter> centers = service.getAllTrainingCenters();
        return ResponseEntity.ok(centers);
    }
}
// so here is the both get and post api for the training centers