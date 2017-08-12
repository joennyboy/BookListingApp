package com.example.android.mybooklisingapp;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class QueryUtils {

    public static String formatListOfAuthors(JSONArray authorsList) throws JSONException {

        String authorsListInString = null;

        if (authorsList.length() == 0) {
            return null;
        }

        for (int i = 0; i < authorsList.length(); i++) {
            if (i == 0) {
                authorsListInString = authorsList.getString(0);
            } else {
                authorsListInString += ", " + authorsList.getString(i);
            }
        }

        return authorsListInString;
    }

    public static List<Info> extractBooks(String json) {

        List<Info> books = new ArrayList<>();

        try {
            JSONObject jsonResponse = new JSONObject(json);

            if (jsonResponse.getInt("totalItems") == 0) {
                return books;
            }
            JSONArray jsonArray = jsonResponse.getJSONArray("items");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject bookObject = jsonArray.getJSONObject(i);

                JSONObject volumeInfo = bookObject.getJSONObject("volumeInfo");

                String title = volumeInfo.getString("title");
                String authors = "N/A";
                if (volumeInfo.has("authors")) {
                    // Extract the value for the key called "authors"
                    JSONArray authorsArray = volumeInfo.getJSONArray("authors");
                    authors = formatListOfAuthors(authorsArray);
                }

                Info book = new Info(authors, title);
                books.add(book);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return books;
    }
}
