package com.sskva.footballnewsmvc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "footballNew")
public class FootballNew  implements Comparable<FootballNew>{

    @Id
    private String id;
    private String text;
    private String url;
    private String type;
    private Date date;

    public FootballNew() {

    }

    public FootballNew(String id, String text) {
        this.id = id;
        this.text = text;
    }


    public int compareTo(FootballNew p){

        return p.getDate().compareTo(date);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
