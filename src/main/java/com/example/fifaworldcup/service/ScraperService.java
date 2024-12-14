package com.example.fifaworldcup.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.example.fifaworldcup.dto.MatchDetails;

@Service
public class ScraperService {

    public List<MatchDetails> scrapeFifaData() throws IOException {
        String url = "https://en.wikipedia.org/wiki/List_of_FIFA_World_Cup_finals";
        Document document = Jsoup.connect(url).get();
        Elements tableRows = document.select("table.wikitable tbody tr");

        List<MatchDetails> matchDetailsList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) { 
            Element row = tableRows.get(i);
            Elements cols = row.select("td");

            MatchDetails details = new MatchDetails(
                    cols.get(0).text(), // Year
                    cols.get(1).text(), // Winner
                    cols.get(2).text(), // Score
                    cols.get(3).text() // Runners-up
            );

            matchDetailsList.add(details);
        }

        return matchDetailsList;
    }
}
