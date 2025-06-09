public class Employé {
    private String prenom;
    private String nom;
    private String email;
    private int tel;
    boolean estabonné=false;
    //constructeur
    public Employé(String prenom,String nom,String email,int tel){
        this.prenom=prenom;
        this.nom=nom;
        this.email=email;
        this.tel=tel;
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

    public void sabonner() {
        if (estabonné) {
            this.estabonné = true;
            System.out.println("Vous etes abonné(e)s avec succès");
        } else {
            System.out.println("Vous etes déjà abonné(e)s");
        }
    }

    public void désabonner(){
        if (estabonné==true){
            this.estabonné=false;
            System.out.println("Vous avez été désabonné(e)s");
        }else {
            System.out.println("Vous etes déjà désabonné(e)s");
        }
    }
    public void envoyerdesnotifications(){}

    public void Afficherlesnotifications(){}

}
