package com.example.ceo.procrastinaut;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.orm.SugarRecord;
import com.orm.dsl.Table;
import java.util.List;
import java.util.ArrayList;

public class SQLHandler {

    private DBHandler dbHandler;
    private Context incContext;
    private SQLiteDatabase database;

    public SQLHandler(Context c) {
        incContext = c;
    }

    public SQLHandler open() throws SQLException {
        dbHandler = new DBHandler(incContext);
        database = dbHandler.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHandler.close();
    }

    //ADDING AN ASSIGNMENT TO THE DATABASE, GOING TO BE HANDLED BY SQLHandler
    public void addAssignment(Assignment assignment){
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHandler.KEY_ASSIGN, assignment.getAssignment());
        values.put(DBHandler.KEY_EST_TIME, assignment.getEstTime());
        //db.insert(table_assign, null, values);
        //db.insert(TABLE_ASSIGN, null, values);
        db.close();
    }

    //GET NAME OF AN ASSIGNMENT, GOING TO BE HANDLED BY SQLHandler
    public Assignment getAssignment(int id){
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        Cursor cursor = db.query(DBHandler.TABLE_NAME, new String[]{DBHandler.KEY_ID, DBHandler.KEY_ASSIGN, DBHandler.KEY_EST_TIME}, DBHandler.KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
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
        String selectQuery = "SELECT *  FROM " + DBHandler.TABLE_NAME;
        SQLiteDatabase db = dbHandler.getWritableDatabase();
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
        String countQuery = "SELECT * FROM " + DBHandler.TABLE_NAME;
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    //UPDATING AN ASSIGNMENT IN THE DATABASE, GOING TO BE HANDLED BY SQLHandler
    public int updateAssignment(Assignment assignment){
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHandler.KEY_ASSIGN, assignment.getAssignment());
        values.put(DBHandler.KEY_EST_TIME, assignment.getEstTime());
        return db.update(DBHandler.TABLE_NAME, values, DBHandler.KEY_ID + " =? ", new String[]{String.valueOf(assignment.getId())});
    }

    //DELETING AN ASSIGNMENT IN THE DATABASE, GOING TO BE HANDLED B SQLHandler
    public void deleteAssignment(Assignment assignment){
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        db.delete(DBHandler.TABLE_NAME, DBHandler.KEY_ID + " =? ", new String[]{String.valueOf(assignment.getId())});
        db.close();
    }

}
