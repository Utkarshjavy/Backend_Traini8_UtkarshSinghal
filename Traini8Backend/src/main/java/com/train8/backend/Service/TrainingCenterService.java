package com.train8.backend.Service;

import com.train8.backend.Model.TrainingCenter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingCenterService {

    private List<TrainingCenter> trainingCenters = new ArrayList<>();  // we doing an in memory storage

    public TrainingCenter createTrainingCenter(TrainingCenter center) {
        // Set the createdOn timestamp to current system time (epoch)
        center.setCreatedOn(System.currentTimeMillis());

        // in memory storage of the training centers
        trainingCenters.add(center);
        return center;
    }

    public List<TrainingCenter> getAllTrainingCenters() {
        return trainingCenters;
    }
}