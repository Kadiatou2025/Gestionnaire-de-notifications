import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;


public class Admin extends Employé {
    private static final String FICHIER_JSON = "data.json";

    public Admin(String prenom, String nom, String email, int tel, String motdepasse) {
        super(prenom, nom, email, tel, motdepasse);
    }

    public void ajouterunemployé(String prenom, String nom, String email, int tel, String motdepasse) {
        Gson gson = new Gson();
        File file = new File(FICHIER_JSON);
        List<Employé> employés = new ArrayList<>(); // initialisation ici pour éviter null

        try {
            if (file.exists() && file.length() > 0) {
                try (FileReader read = new FileReader(file)) {
                    Type listType = new TypeToken<List<Employé>>() {
                    }.getType();
                    List<Employé> temp = gson.fromJson(read, listType);
                    if (temp != null) {
                        employés = temp;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            // On continue avec employés vide
        }

        Employé e = new Employé(prenom, nom, email, tel, motdepasse);
        employés.add(e);

        try (Writer write = new FileWriter(file)) {
            gson.toJson(employés, write);

            System.out.println("Employé ajouté avec succès");
        } catch (IOException r) {
            System.err.println("Erreur lors de l'écriture dans le fichier : " + r.getMessage());
        }
    }

    public void retirerunemployé(String email) {
        Gson gson = new Gson();
        File file = new File(FICHIER_JSON);
        List<Employé> employés = new ArrayList<>();
        try {
            if (file.exists() && file.length() > 0) {
                try (FileReader read = new FileReader(file)) {
                    Type listtype = new TypeToken<List<Employé>>() {
                    }.getType();
                    List<Employé> temp = gson.fromJson(read, listtype);
                    if (temp != null) {
                        employés = temp;
                    }
                }
            }
        } catch (IOException | JsonSyntaxException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        for (int i = 0; i < employés.size(); i++) {
            if (employés.get(i).getEmail().equals(email)) {
                employés.remove(i);
            }
        }

        try (FileWriter write = new FileWriter(file)) {
            gson.toJson(employés, write);

            System.out.println("Employé retiré avec succès");
        } catch (IOException m) {
            System.err.println("Erreur lors de l'écriture dans le fichier : " + m.getMessage());
        }

    }


    public void seconnecter(String email, String motdepasse) {
        Gson gson = new Gson();
        File file = new File(FICHIER_JSON);
        Admin admin = null;
        try {
            if (file.exists() && file.length() > 0) {
                try (FileReader read = new FileReader(file)) {
                    Admin temp = gson.fromJson(read, Admin.class);
                    if (temp != null) {
                        admin = temp;
                    }

                    if (admin.getEmail().equals(email)&& admin.getMotdepasse().equals(motdepasse)){
                        System.out.println("Vous etes connecté(e)s avec succès");
                    }else {
                        System.out.println("Email ou mot de passe incorrecte");
                    }
                }
            }


        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());

        }


    }

    public void verifiersiunemployéestabonnéoupas(String email) {
        Gson gson = new Gson();
        File file = new File(FICHIER_JSON);
        List<Employé> employés = new ArrayList<>(); // initialisation ici pour éviter null

        try {
            if (file.exists() && file.length() > 0) {
                try (FileReader read = new FileReader(file)) {
                    Type listType = new TypeToken<List<Employé>>() {
                    }.getType();
                    List<Employé> temp = gson.fromJson(read, listType);
                    if (temp != null) {
                        employés = temp;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        for (Employé e : employés) {
            if (e.getEmail().equals(email) && e.estabonné == true) {
                System.out.println("Cet employé est abonné");
            } else {
                System.out.println("Cet employé n'est abonné");
            }
        }
    }


    }








