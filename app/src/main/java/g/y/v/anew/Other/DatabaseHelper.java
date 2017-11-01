package g.y.v.anew.Other;

/**
 * Created by galqayeva on 25.10.2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "BudgetDb.db";
    public static final String TABLE_NAME = "BudgetDb";

    public static final String COL0 = "ID";
    public static final String COL1="date";
    public static final String COL2="clothesText";
    public static final String COL3="clothesM";
    public static final String COL4="medicineText";
    public static final String COL5="medicineM";
    public static final String COL6="entertainText";
    public static final String COL7="entertainM";
    public static final String COL8="transportText";
    public static final String COL9="transportTextM";
    public static final String COL10="otherText";
    public static final String COL11="otherM";



    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " ("+COL0+" INTEGER PRIMARY KEY AUTOINCREMENT, " +COL1+
                "  TEXT, " +
                COL2+" TEXT, "+COL3+" INTEGER, "+COL4+" TEXT, "+COL5+" INTEGER, "+
                COL6+" TEXT, "+COL7+" INTEGER, "+COL8+" TEXT, "+COL9+" INTEGER, "+
                COL10+" TEXT, "+COL11+" INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean addData(String  date,String clothesText,int clothesM,String medicineText,
                           int medicineM,String entertainText,int entertainM,String transportText,int transportTextM,String otherText, int otherM)

    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, date);
        contentValues.put(COL2, clothesText);
        contentValues.put(COL3, clothesM);
        contentValues.put(COL4, medicineText);
        contentValues.put(COL5, medicineM);
        contentValues.put(COL6, entertainText);
        contentValues.put(COL7, entertainM);
        contentValues.put(COL8, transportText);
        contentValues.put(COL9, transportTextM);
        contentValues.put(COL10, otherText);
        contentValues.put(COL11, otherM);


        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Cursor getListContents(String money){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT  sum("+money+ ") FROM " + TABLE_NAME , null);
        return data;
    }

    public Cursor getLimitedData( String limit){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT "+
                "  (  SUM(clothesM) + SUM(medicineM) + SUM(entertainM) + SUM(transportTextM) + SUM(otherM) )  from" + " (SELECT * FROM " +TABLE_NAME +" order by id DESC limit "+limit+" )", null);
        return data;
    }
    public Cursor getAlldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME , null);
        return data;
    }


    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME ;
        db.execSQL(query);
    }
}