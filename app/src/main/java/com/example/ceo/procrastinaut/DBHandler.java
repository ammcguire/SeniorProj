package com.example.ceo.procrastinaut;

import android.app.Activity;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Interpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.orm.SugarRecord;
import com.orm.dsl.Table;
import java.util.List;
import java.util.ArrayList;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SCHEDULE.DB";
    public static final String TABLE_NAME = "ASSIGNMENTS_TASKS";

    public static final String KEY_ID = "id";
    public static final String KEY_ASSIGN = "assignment";
    public static final String KEY_EST_TIME = "est_time";
    public static final String KEY_DATE = "date";


    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + KEY_ID
           + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_DATE + " TEXT NOT NULL, "+KEY_EST_TIME + " TEXT NOT NULL, " + KEY_ASSIGN + " TEXT);";






    public DBHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String SQL = "CREATE TABLE assignments ( " +
                " id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " assign VARCHAR2(40)," +
                " estTime INT )";

        /*String SQL = "CREATE TABLE" + TABLE_ASSIGN + "(" +
                KEY_ID + " INTEGER PRIMARY KEY, " +
                KEY_ASSIGN + " TEXT, " +
                KEY_EST_TIME + " TEXT " +
                ")";*/
        //db.execSQL(SQL);
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " +  TABLE_NAME);
        onCreate(db);
    }

    /*//ADDING AN ASSIGNMENT TO THE DATABASE, GOING TO BE HANDLED BY SQLHandler
    public void addAssignment(Assignment assignment){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ASSIGN, assignment.getAssignment());
        values.put(KEY_EST_TIME, assignment.getEstTime());
        //db.insert(table_assign, null, values);
        //db.insert(TABLE_ASSIGN, null, values);
        db.close();
    }

    //GET NAME OF AN ASSIGNMENT, GOING TO BE HANDLED BY SQLHandler
    public Assignment getAssignment(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_ID, KEY_ASSIGN, KEY_EST_TIME}, KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        assert cursor != null;
        Assignment newAssign = new Assignment(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getInt(2));
        cursor.close();
        return  newAssign;
    }

    //GET A LIST OF ALL THE ASSIGNMENTS, GOING TO BE HANDLED BY SQLHandler
    public List<Assignment> getAllAssignments() {
        List<Assignment> assignmentList = new ArrayList<Assignment>();
        String selectQuery = "SELECT *  FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do{
                Assignment assignment = new Assignment();
                assignment.setId(Integer.parseInt(cursor.getString(0)));
                assignment.setAssignment(cursor.getString(1));
                assignment.setEstTime(cursor.getInt(2));
                assignmentList.add(assignment);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return assignmentList;
    }

    //GETTING NUMBER OF ASSIGNMENTS IN THE DATABASE, GOING TO BE HANDLED BY SQLHandler
    public int getAssignmentCount() {
        String countQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    //UPDATING AN ASSIGNMENT IN THE DATABASE, GOING TO BE HANDLED BY SQLHandler
    public int updateAssignment(Assignment assignment){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ASSIGN, assignment.getAssignment());
        values.put(KEY_EST_TIME, assignment.getEstTime());
        return db.update(TABLE_NAME, values, KEY_ID + " =? ", new String[]{String.valueOf(assignment.getId())});
    }

    //DELETING AN ASSIGNMENT IN THE DATABASE, GOING TO BE HANDLED B SQLHandler
    public void deleteAssignment(Assignment assignment){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + " =? ", new String[]{String.valueOf(assignment.getId())});
        db.close();
    }*/
}

