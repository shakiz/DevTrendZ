package com.shakil.devtrendz.models;

public class Library {
    private int Image;
    private String RepoName;
    private String RepoOwner;
    private String RepoLink;
    private String Language;
    private int NumberOfStars;
    private int NumberOfForks;
    private int NumberOfWatch;


    public Library(int image, String repoName, String ownerName, String repoLink, String language, int numberOfStars, int numberOfForks, int numberOfWatch) {
        Image = image;
        RepoName = repoName;
        RepoOwner = ownerName;
        RepoLink = repoLink;
        Language = language;
        NumberOfStars = numberOfStars;
        NumberOfForks = numberOfForks;
        NumberOfWatch = numberOfWatch;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getRepoName() {
        return RepoName;
    }

    public void setRepoName(String repoName) {
        RepoName = repoName;
    }

    public String getRepoOwner() {
        return RepoOwner;
    }

    public void setRepoOwner(String repoOwner) {
        RepoOwner = repoOwner;
    }

    public String getRepoLink() {
        return RepoLink;
    }

    public void setRepoLink(String repoLink) {
        RepoLink = repoLink;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public int getNumberOfStars() {
        return NumberOfStars;
    }

    public void setNumberOfStars(int numberOfStars) {
        NumberOfStars = numberOfStars;
    }

    public int getNumberOfForks() {
        return NumberOfForks;
    }

    public void setNumberOfForks(int numberOfForks) {
        NumberOfForks = numberOfForks;
    }

    public int getNumberOfWatch() {
        return NumberOfWatch;
    }

    public void setNumberOfWatch(int numberOfWatch) {
        NumberOfWatch = numberOfWatch;
    }
}
