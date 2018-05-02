package com.example.thymen.journal;

import java.io.Serializable;

public class JournalEntry implements Serializable {
    int id;

    String name;
    String content;
    String mood;
    float timestamp;

    public JournalEntry(int id, String name, String content, String mood, float timestamp) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.mood = mood;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public float getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(float timestamp) {
        this.timestamp = timestamp;
    }

}
