package com.mapToFiction.mapToFiction.model.dto.omdb;

import java.util.List;

public class OMDBSerieDTO extends OMDBFiction {
    public String Title;
    public String Year;
    public String Rated;
    public String Released;
    public String Runtime;
    public String Genre;
    public String Director;
    public String Writer;
    public String Actors;
    public String Plot;
    public String Language;
    public String Country;
    public String Awards;
    public String Poster;
    public List<RatingDTO> Ratings;
    public String Metascore;
    public String imdbRating;
    public String imdbVotes;
    public String imdbID;
    public String Type;
    public String TotalSeasons;
    public String Response;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getRated() {
        return Rated;
    }

    public void setRated(String rated) {
        Rated = rated;
    }

    public String getReleased() {
        return Released;
    }

    public void setReleased(String released) {
        Released = released;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getAwards() {
        return Awards;
    }

    public void setAwards(String awards) {
        Awards = awards;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public List<RatingDTO> getRatings() {
        return Ratings;
    }

    public void setRatings(List<RatingDTO> ratings) {
        Ratings = ratings;
    }

    public String getMetascore() {
        return Metascore;
    }

    public void setMetascore(String metascore) {
        Metascore = metascore;
    }

    public String getIMDBRating() {
        return imdbRating;
    }

    public void setIMDBRating(String IMDBRating) {
        this.imdbRating = IMDBRating;
    }

    public String getIMDBVotes() {
        return imdbVotes;
    }

    public void setIMDBVotes(String IMDBVotes) {
        this.imdbVotes = IMDBVotes;
    }

    public String getIMDBID() {
        return imdbID;
    }

    public void setIMDBID(String IMDBID) {
        this.imdbID = IMDBID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getTotalSeasons() {
        return TotalSeasons;
    }

    public void setTotalSeasons(String totalSeasons) {
        TotalSeasons = totalSeasons;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }
}
