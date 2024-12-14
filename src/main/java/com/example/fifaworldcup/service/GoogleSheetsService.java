package com.example.fifaworldcup.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;

@Service
public class GoogleSheetsService {

        private static final String SPREADSHEET_ID = "1-PIXS1xbU8h1szvV0AugTeb3HORDVY8PCzTRoFh2i64";
        private static final String RANGE = "Sheet1!A2:D";

        public void appendToGoogleSheet(List<List<Object>> data) throws IOException, GeneralSecurityException {
                GoogleCredentials credentials = GoogleCredentials
                                .fromStream(new FileInputStream("src/main/resources/credentials.json"))
                                .createScoped(List.of("https://www.googleapis.com/auth/spreadsheets"));

                JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

                Sheets sheetsService = new Sheets.Builder(
                                GoogleNetHttpTransport.newTrustedTransport(),
                                jsonFactory,
                                new HttpCredentialsAdapter(credentials))
                                .setApplicationName("FIFA World Cup Data Scraper")
                                .build();

                ValueRange body = new ValueRange().setValues(data);

                sheetsService.spreadsheets().values()
                                .append(SPREADSHEET_ID, RANGE, body)
                                .setValueInputOption("RAW")
                                .execute();
        }
}
