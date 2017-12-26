package com.evolutionarysoftwares.vmathebula.justpoetry.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PoemResponse {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("lines")
    @Expose
    private List<String> lines = null;
    @SerializedName("linecount")
    @Expose
    private Integer linecount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public Integer getLinecount() {
        return linecount;
    }

    public void setLinecount(Integer linecount) {
        this.linecount = linecount;
    }

}
