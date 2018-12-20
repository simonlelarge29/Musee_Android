package com.example.simon.museerouen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PersonneBDD {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "museerouen.db";

    private static final String TABLE_PERSONNE = "personne";

    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;

    private static final String COL_PHOTO = "PHOTO";
    private static final int NUM_COL_PHOTO = 1;

    private static final String COL_NOM = "NOM";
    private static final int NUM_COL_NOM = 2;

    private static final String COL_PRENOM = "PRENOM";
    private static final int NUM_COL_PRENOM = 3;

    private static final String COL_VILLE = "VILLE";
    private static final int NUM_COL_VILLE = 4;

    private static final String COL_EMAIL = "EMAIL";
    private static final int NUM_COL_EMAIL = 5;

    private static final String COL_PASSWORD = "PASSWORD";
    private static final int NUM_COL_PASSWORD = 6;

    private static final String COL_STATUT = "STATUT";
    private static final int NUM_COL_STATUT = 7;

    private static final String COL_NOMBREMUSEE = "NOMBREMUSEE";
    private static final int NUM_COL_NOMBREMUSEE = 8;

    private SQLiteDatabase bdd;

    private BaseDeDonnees maBase;

    public PersonneBDD(Context context){
        //On crée la BDD et sa table
        maBase = new BaseDeDonnees(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open(){
        //Ouvre la BDD en écriture
        bdd = maBase.getWritableDatabase();
    }

    public void close(){
        //Ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD(){
        return bdd;
    }

    public long ajouterPersonne(Personne p){
        //Création d'un ContentValues
        ContentValues values = new ContentValues();
        //On associe une valeur à une clé (le nom de la colonne)
        values.put(COL_PHOTO, p.getPhoto());
        values.put(COL_NOM, p.getNom());
        values.put(COL_PRENOM, p.getPrenom());
        values.put(COL_VILLE, p.getVille());
        values.put(COL_EMAIL, p.getEmail());
        values.put(COL_PASSWORD, p.getPassword());
        values.put(COL_STATUT, p.getStatut());
        values.put(COL_NOMBREMUSEE, p.getNombreMusee());
        //On insère l'objet dans la BDD
        return bdd.insert(TABLE_PERSONNE, null, values);
    }

    //MAJ du statut de la personne
    public int majPersonneStatut(int statut, Personne p){
        ContentValues values = new ContentValues();
        values.put(COL_ID, p.getId());
        values.put(COL_PHOTO, p.getPhoto());
        values.put(COL_NOM, p.getNom());
        values.put(COL_PRENOM, p.getPrenom());
        values.put(COL_VILLE, p.getVille());
        values.put(COL_EMAIL, p.getEmail());
        values.put(COL_PASSWORD, p.getPassword());
        values.put(COL_NOMBREMUSEE, p.getNombreMusee());
        return bdd.update(TABLE_PERSONNE, values, COL_STATUT + "=" + statut, null);
    }

    //MAJ de la photo de la personne
    public int majPersonneStatut(char photo, Personne p){
        ContentValues values = new ContentValues();
        values.put(COL_ID, p.getId());
        values.put(COL_NOM, p.getNom());
        values.put(COL_PRENOM, p.getPrenom());
        values.put(COL_VILLE, p.getVille());
        values.put(COL_EMAIL, p.getEmail());
        values.put(COL_PASSWORD, p.getPassword());
        values.put(COL_STATUT, p.getStatut());
        values.put(COL_NOMBREMUSEE, p.getNombreMusee());
        return bdd.update(TABLE_PERSONNE, values, COL_PHOTO + "=" + photo, null);
    }

    public int supprimerPersonneParSonID(int id){
        return bdd.delete(TABLE_PERSONNE, COL_ID + "=" + id, null);
    }

    public Personne getPersonneParNom(String nom){
        //Récupère dna sun Cursor la liste des personnes ayant le nom de famille en argument
        Cursor c = bdd.query(TABLE_PERSONNE, new String[]{
                COL_ID, COL_NOM, COL_PRENOM },
                COL_NOM + "LIKE\"" + nom + "\"", null,null,null,null);
                return cursorToPersonne(c);
        }

    private Personne cursorToPersonne(Cursor c) {
        //si aucun élément n'a été retourné, renvoie null
        if (c.getCount() == 0)
            return null;
        //sinon on se place sur le premier élément
        c.moveToFirst();
        //on crée une personne et on lui affecte les différentes infos contenues dans le Cursor
        Personne personne = new Personne();
        personne.setId(c.getInt(NUM_COL_ID));
        personne.setNom((c.getString(NUM_COL_NOM)));
        personne.setPrenom(c.getString(NUM_COL_PRENOM));

        c.close();
        return personne;
    }
}
