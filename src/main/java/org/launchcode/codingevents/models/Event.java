package org.launchcode.codingevents.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;


@Entity
public class Event {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String description;
    private String img;
    private String address;

    public Event(String name, String description, String address) {
        this.name = name;
        this.description = description;
        this.address = address;
    }

    public Event(String name, String description, String address, String img) {
        this(name, description, address);
        this.img = img;
    }

    public Event(){ }// implicit default constructor needed when attempting model binding with more than one constructor


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

    public int getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return getId() == event.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
