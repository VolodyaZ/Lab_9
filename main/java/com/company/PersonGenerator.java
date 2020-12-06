package com.company;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonGenerator {
    private static final Pattern genderPattern;
    private static final Pattern firstNamePattern;
    private static final Pattern lastNamePattern;
    private static final Pattern agePattern;
    private static final Pattern countryPattern;

    static {
        genderPattern = Pattern.compile("(?<=\"gender\":\").+?(?=\")");
        firstNamePattern = Pattern.compile("(?<=\"first\":\").+?(?=\")");
        lastNamePattern = Pattern.compile("(?<=\"last\":\").+?(?=\")");
        agePattern = Pattern.compile("(?<=\"age\":)\\d+");
        countryPattern = Pattern.compile("(?<=\"country\":\").+?(?=\")");
    }

    /**
     *
     * @param amount amount of persons generated( its not guaranteed to be exactly that amount. Can be less)
     * @return list of generated persons
     */
    public static List<Person> generate(int amount) {
        List<Person> list = new ArrayList<>(amount);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://randomuser.me/api/"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpClient client = HttpClient.newHttpClient();
        try {
            while (amount-- > 0) {
                String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
                try {
                    list.add(createPersonFromJson(response));
                } catch (Exception ignored) {

                }
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    private static Person createPersonFromJson(String jsonStr) {
        return new Person(
                getMatchedSubstring(jsonStr, genderPattern),
                getMatchedSubstring(jsonStr, firstNamePattern),
                getMatchedSubstring(jsonStr, lastNamePattern),
                Integer.parseInt(getMatchedSubstring(jsonStr, agePattern)),
                getMatchedSubstring(jsonStr, countryPattern)
        );
    }

    private static String getMatchedSubstring(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }
}
