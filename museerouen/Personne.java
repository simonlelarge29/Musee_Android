package com.example.simon.museerouen;

public class Personne {

    private int id;
    private char photo;
    private String nom;
    private String prenom;
    private String ville;
    private String email;
    private String password;
    private int statut; //1 = admin and 10 = user
    private int nombreMusee;

    public Personne(){}

    public Personne(int id, char photo, String nom, String prenom, String ville, String email, String password, int statut, int nombreMusee) {

        this.id = id;
        this.photo = photo;
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.email = email;
        this.password = password;
        this.statut = statut;
        this.nombreMusee = nombreMusee;
    }

    //Met par défaut une personne en user et pas admin lors de l'inscription
    public Personne(int id, char photo, String nom, String prenom, String ville, String email, String password) {

        this.id = id;
        this.photo = photo;
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.email = email;
        this.password = password;
        statut = 10;
        nombreMusee = 0;
    }

    //Choisi du statut à l'inscription
    public Personne(int id, char photo, String nom, String prenom, String ville, String email, String password, int statut) {

        this.id = id;
        this.photo = photo;
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.email = email;
        this.password = password;
        this.statut = statut;
        nombreMusee = 0;
    }

    //Si des champs vides existent
    public Personne(int id, String email, String password){
        this.id = id;
        photo = 0;
        nom = "unknown";
        prenom = "unknown";
        ville = "unknown";
        this.email = email;
        this.password = password;
        statut = 10;
        nombreMusee = 0;
    }


    //GETTER
    public int getId(){
        return id;
    }

    public String getPhoto(){
        return photo;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getVille() {
        return ville;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public int getStatut(){
        return statut;
    }

    public int getNombreMusee() {
        return nombreMusee;
    }


    //SETTER
    public void setId(int id){
        this.id = id;
    }

    public void setPhoto(char photo) {
        this.photo = photo;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setStatut(int statut){
        this.statut = statut;
    }

    public void setNombreMusee(int nombreMusee) {
        this.nombreMusee = nombreMusee;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", photo=" + photo +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", ville='" + ville + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", statut=" + statut +
                ", nombreMusee=" + nombreMusee +
                '}';
    }

}
