import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;


public class Admin extends Employé{
    private static final String FICHIER_JSON ="data.json";

    public Admin(String prenom,String nom,String email, int tel)
    {
        super(prenom,nom,email,tel);
    }
    public void ajouterunemployé(String prenom,String nom){}

    public void retirerunemployer() throws FileNotFoundException {
        BufferedReader read=new BufferedReader(new FileReader(FICHIER_JSON));

        Type listtype = new TypeToken<List<Employé>>() {}.getType();
    }


    public void vérifiersiunemployéestabonné(){}


    public void afficherlesnotifreçudunemployé(){}
}
