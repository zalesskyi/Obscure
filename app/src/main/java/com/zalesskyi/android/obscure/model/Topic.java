package com.zalesskyi.android.obscure.model;

/**
 * Created by dell e5540 on 3/11/2018.
 */

public class Topic {
    private String name;
    private String description;

    // topics is array of topic
    public static final Topic[] topics = {
            new Topic("Activities", "GUI abstraction to display info"),
            new Topic("Activity lifecycle", "Methods where actually things performed"),
            new Topic("Fragments", "More modular GUI element"),
            new Topic("MVVP", "Interaction beetwen components/model/view"),
            new Topic("List view and Adapters",  "Display list of elements"),
            new Topic("More fragments","Dynamic fragment and nested fragment"),
            new Topic("Recycler view","Recycler view"),
            new Topic("Card view","Card view"),
            new Topic("Navigation drawer","Navigation drawer"),
            new Topic("SqlLite database","SqlLite database"),
            new Topic("Basic cursor","Basic cursors"),
            new Topic("Started services","Started services"),
            new Topic("Bound services","Bound services details"),
            new Topic("Relative and Grdis layout","Relative and Grdis layout"),
            new Topic("Gradle","The gradle build tool"),
            new Topic("The Android runtime","The Android runtime"),
            new Topic("Distributing your apps","Distributing your apps"),
    };

    private Topic (String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
