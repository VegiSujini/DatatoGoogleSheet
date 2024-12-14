package com.example.fifaworldcup.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fifaworldcup.service.GoogleSheetsService;

@RestController
public class DataController {

    private final GoogleSheetsService googleSheetsService;

    public DataController(GoogleSheetsService googleSheetsService) {
        this.googleSheetsService = googleSheetsService;
    }

    @PostMapping("/append")
    public void appendToGoogleSheet(@RequestBody List<List<String>> data) throws IOException {
        try {
            List<List<Object>> convertedData = new ArrayList<>();
            for (List<String> row : data) {
                convertedData.add(new ArrayList<>(row));
            }
            googleSheetsService.appendToGoogleSheet(convertedData);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}
