package com.example.simon.museerouen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDeDonnees extends SQLiteOpenHelper {
    public BaseDeDonnees(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //Création de la BDD
        db.execSQL("CREATE TABLE personne (ID INTEGER PRIMARY KEY AUTOINCREMENT, PHOTO STRING NOT NULL, NOM TEXT NOT NULL, PRENOM TEXT NOT NULL, VILLE VARCHAR, EMAIL TEXT NOT NULL, PASSWORD TEXT NOT NULL, STATUT INT NOT NULL, NOMBREMUSEE INT)");
        //Initialisation de la table
        db.execSQL("INSERT INTO personne (PHOTO, NOM, PRENOM, VILLE, EMAIL, PASSWORD, STATUT, NOMBREMUSEE) VALUES (\"PhotoTest\", \"TESTO\", \"Test\", \"Rouen\", \"test@test.fr\", \"test\", \"10\", \"0\")");
        db.execSQL("INSERT INTO personne (PHOTO, NOM, PRENOM, VILLE, EMAIL, PASSWORD, STATUT, NOMBREMUSEE) VALUES (\"PhotoTest\", \"ADMIN\", \"Rachid\", \"Brest\", \"admin@admin.fr\", \"admin\", \"1\", \"42\")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Suppression de la table
        db.execSQL("DROP TABLE IF EXISTS personne");
        //Création de la nouvelle table
        onCreate(db);
    }

}
