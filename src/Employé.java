import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class Employé implements observateur {
    private String prenom;
    private String nom;
    private String email;
    private int tel;
    private String motdepasse;
    boolean estabonné=false;
    private static final String FICHIER_JSON ="data.json";
    public String userconnect;
    public static List<Employé>lesemployés=new ArrayList<>();

    //constructeur
    public Employé(String prenom,String nom,String email,int tel, String motdepasse){
        this.prenom=prenom;
        this.nom=nom;
        this.email=email;
        this.tel=tel;
        this.motdepasse=motdepasse;
    }

    //methode d'accès

    public String getPrenom(){
      return prenom;

    }

    public String getNom() {
        return nom;
    }

    public String getEmail(){
        return email;
    }

    public int getTel() {
        return tel;
    }

    public String getMotdepasse(){
        return motdepasse;
    }

    //methode de modification


    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setMotdepasse(String motdepasse){
        this.motdepasse=motdepasse;
    }

    //mes methodes

    public void seconnecter(String email,String motdepasse){

        Gson gson=new Gson();
        File file = new File(FICHIER_JSON);
        List<Employé>employés=new ArrayList<>();
        try {
            if (file.exists() && file.length() > 0) {
                try( FileReader read = new FileReader(file)){
                    Type listtype=new TypeToken<List<Employé>>() {}.getType();
                    List<Employé> temp = gson.fromJson(read, listtype);
                    if (temp != null) {employés = temp;}
                }
            }
        }catch (IOException | JsonSyntaxException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        for(int i=1;i<employés.size();i++){
            if(employés.get(i).getEmail().equals(email)&&employés.get(i).getMotdepasse().equals(motdepasse)){
                System.out.println("Vous etes connectés avec succès");
                userconnect=email;
            }else{
                System.out.println("Email ou mot de passe incorrecte");
            }
        }


    }

    public void sabonner() {

        Gson gson=new Gson();
        File file = new File(FICHIER_JSON);
        List<Employé>employés=new ArrayList<>();
        try {
            if (file.exists() && file.length() > 0) {
                try( FileReader read = new FileReader(file)){
                    Type listtype=new TypeToken<List<Employé>>() {}.getType();
                    List<Employé> temp = gson.fromJson(read, listtype);
                    if (temp != null) {employés = temp;lesemployés=temp;}
                }
            }
        }catch (IOException | JsonSyntaxException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
        for(int i=0;i<employés.size();i++){
            if(employés.get(i).getEmail().equals(userconnect)){
                if (employés.get(i).estabonné==false) {
                    employés.get(i).estabonné = true;

                } else {
                    System.out.println("Vous etes déjà abonné(e)s");
                }
            }
            }

        try(FileWriter write=new FileWriter(file)){
            gson.toJson(employés, write);

            System.out.println("Vous etes abonné(e)s avec succès");
        }catch (IOException m){
            System.err.println("Erreur lors de l'écriture dans le fichier : " + m.getMessage());
        }
        }


    public void désabonner(){

        Gson gson=new Gson();
        File file = new File(FICHIER_JSON);
        List<Employé>employés=new ArrayList<>();
        try {
            if (file.exists() && file.length() > 0) {
                try( FileReader read = new FileReader(file)){
                    Type listtype=new TypeToken<List<Employé>>() {}.getType();
                    List<Employé> temp = gson.fromJson(read, listtype);
                    if (temp != null) {employés = temp;}
                }
            }
        }catch (IOException | JsonSyntaxException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        for(int i=0;i<employés.size();i++){
            if(employés.get(i).getEmail().equals(userconnect)){
                if (employés.get(i).estabonné==true) {
                    employés.get(i).estabonné = false;

                } else {
                    System.out.println("Vous etes déjà désabonné(e)s");
                }
            }
        }

        try(FileWriter write=new FileWriter(file)){
            gson.toJson(employés, write);

            System.out.println("Vous avez été désabonné(e)s");
        }catch (IOException m){
            System.err.println("Erreur lors de l'écriture dans le fichier : " + m.getMessage());
        }


    }
    public void envoyerdesnotifications(){}

    public void Afficherlesnotifications(){}
    //interface


    @Override
    public void evoyernotification(String message) {
        for(Employé e:lesemployés){
            if(e.getEmail().equals(this.email)){
                if(e.estabonné==true){
                    System.out.println("Bonjour"+e.getPrenom()+e.getNom()+","+ "\n"+ message);
                }
            }
        }

    }

    @Override
    public void receptionnotification(String message, String nom, String prenom) {

    }
}
