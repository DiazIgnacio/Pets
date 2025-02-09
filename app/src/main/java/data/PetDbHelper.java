package data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import data.PetContract.PetEntry;

public class PetDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Pets.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PetEntry.TABLE_NAME + " (" + PetEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT,"
            + PetEntry.COLUMN_PET_NAME + TEXT_TYPE + " NOT NULL" + COMMA_SEP
            + PetEntry.COLUMN_PET_BREED + TEXT_TYPE + COMMA_SEP
            + PetEntry.COLUMN_PET_GENDER + INTEGER_TYPE + " NOT NULL" + COMMA_SEP
            + PetEntry.COLUMN_PET_WEIGHT + INTEGER_TYPE + " NOT NULL DEFAULT 0" + " );";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PetEntry.TABLE_NAME;

    public PetDbHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

}
