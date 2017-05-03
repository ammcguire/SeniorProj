package com.example.ceo.procrastinaut;


public class Event {

    //VARIABLES

    public int id;

    public String day;

    public String event;

    public int timeAllotted;

    //GENERAL CONSTRUCTOR, EMPTY
    public Event(){
    }

    //EVENT CONSTRUCTOR
    public Event(int id, String day, String event, int timeAllotted){
        this.id = id;
        this.day = day;
        this.event = event;
        this.timeAllotted = timeAllotted;
    }

    //SETTERS
    public void setId(int id){ this.id = id; }

    public void setDay(String day){
        this.day = day;
    }

    public void setEvent(String event) { this.event = event; }

    public void setTimeAllotted(int timeAllotted){
        this.timeAllotted = timeAllotted;
    }


    //GETTERS
    public int getId(){
        return id;
    }

    public String getDay(){
        return day;
    }

    public String getEvent() { return event; }

    public int getTimeAllotted(){ return timeAllotted; }

}