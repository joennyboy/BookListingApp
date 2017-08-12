package com.example.android.mybooklisingapp;


public class Info {

    /**
     * Name of the author)
     */
    public final String author;

    /**
     * title of the book
     */
    public final String title;

    /**
     * Constructs a new {@link Info}.
     *
     * @param infoTitle  is the title of the booklisting
     * @param infoAuthor is the time name of author of the books
     */
    public Info(String infoTitle, String infoAuthor) {

        author = infoAuthor;
        title = infoTitle;

    }
    /**
     * Get the name of the artist
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Get the title of the song.
     */
    public String getTitle() {
        return title;
    }

}
