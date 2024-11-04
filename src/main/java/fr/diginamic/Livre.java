package fr.diginamic;

import jakarta.persistence.*;

@Entity
@Table(name = "LIVRE")
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "TITRE")
    private String titre;
    @Column(name = "AUTEUR")
    private String auteur;

    public Livre (int id, String titre, String auteur){
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
    }

    public Livre(){

    }


    @Override
    public String toString() {
        return "----------" +
                "\nId : " + this.id +
                "\nTitre : " + this.titre +
                "\nAuteur : " + this.auteur;
    }
}
