package com.example.ceo.procrastinaut;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.orm.SugarRecord;
import com.orm.dsl.Table;
import java.util.ArrayList;


public class Assignment {//extends SugarRecord{

    int id;
    String assignment;
    int estTime;

    public Assignment(){
    }

    public Assignment(int id, String assignment, int estTime){
        this.id = id;
        this.assignment = assignment;
        this.estTime = estTime;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setAssignment(String assignment){
        this.assignment = assignment;
    }

    public void setEstTime(int estTime){
        this.estTime = estTime;
    }

    public int getId(){
        return id;
    }
    public String getAssignment(){
        return assignment;
    }

    public int getEstTime(){
        return estTime;
    }


    /*public static void addAssignment(String assignment, int estTime){
        Assignment assignment1 = new Assignment(assignment, estTime);
        assignment1.save();
    }

    public static void removeAssignment(){
        Assignment assignment = findById(Assignment.class, 1);
        assignment.delete();
    }

    public static void loadAssignment(){
        Assignment assignment = findById(Assignment.class, 1);
    }

    public static void updateAssingmentName(){
        Assignment assignment = findById(Assignment.class, 1);
        assignment.assignment = "New assignment title";
        assignment.save();
    }

    public void updateEstTime(){
        Assignment assignment = findById(Assignment.class, 1);
        assignment.estTime = 120;
        assignment.save();
    }
    */


}