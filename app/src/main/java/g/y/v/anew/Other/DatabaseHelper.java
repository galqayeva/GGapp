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

    public static final String DATABASE_NAME = "asd.db";
    public static final String TABLE_NAME = "asd";

    public static final String COL1 = "ID";
    public static final String COL2="date";
    public static final String COL3="clothesText";
    public static final String COL4="clothesM";
    public static final String COL5="cosmeticsText";
    public static final String COL6="cosmeticsM";
    public static final String COL7="medicineText";
    public static final String COL8="medicineM";
    public static final String COL9="entertainText";
    public static final String COL10="entertainM";
    public static final String COL11="restauranText";
    public static final String COL12="restauranM";
    public static final String COL13="birthdayText";
    public static final String COL14="birthdayM";
    public static final String COL15="marketText";
    public static final String COL16="marketTextM";
    public static final String COL17="transportText";
    public static final String COL18="transportTextM";
    public static final String COL19="jewelleryText";
    public static final String COL20="jewelleryM";
    public static final String COL21="otherText";
    public static final String COL22="otherM";



    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " DATE INTEGER, " +
                COL3+" TEXT, "+COL5+" TEXT, "+COL9+" TEXT, "+COL7+" TEXT, "+COL11+" TEXT, "+COL13+" TEXT, "+
                COL15+" TEXT, "+COL17+" TEXT, "+COL19+" TEXT, "+COL21+" TEXT, "+
                COL4+" INTEGER, "+COL6+" INTEGER, "+COL10+" INTEGER, "+COL8+" INTEGER, "+COL12+" INTEGER, "+
                COL14+" INTEGER, "+COL16+" INTEGER, "+COL18+" INTEGER, "+COL20+" INTEGER, "+COL22+" INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean addData(int date,String clothesText,int clothesM,String cosmeticsText,int cosmeticsM,String medicineText,
                           int medicineM,String entertainText,int entertainM,String restauranText,int restauranM, String birthdayText,
                           int birthdayM, String marketText,int marketTextM,String transportText,int transportTextM,String jewelleryText,
                           int jewelleryM,String otherText, int otherM)

    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, date);
        contentValues.put(COL3, clothesText);
        contentValues.put(COL4, clothesM);
        contentValues.put(COL5, cosmeticsText);
        contentValues.put(COL6, cosmeticsM);
        contentValues.put(COL7, medicineText);
        contentValues.put(COL8, medicineM);
        contentValues.put(COL9, entertainText);
        contentValues.put(COL10, entertainM);
        contentValues.put(COL11, restauranText);
        contentValues.put(COL12, restauranM);
        contentValues.put(COL13, birthdayText);
        contentValues.put(COL14, birthdayM);
        contentValues.put(COL15, marketText);
        contentValues.put(COL16, marketTextM);
        contentValues.put(COL17, transportText);
        contentValues.put(COL18, transportTextM);
        contentValues.put(COL19, jewelleryText);
        contentValues.put(COL20, jewelleryM);
        contentValues.put(COL21, otherText);
        contentValues.put(COL22, otherM);


        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Cursor getListContents(String day){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME +" WHERE DAY="+day, null);
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