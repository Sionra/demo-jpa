package fr.diginamic.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "LIVRE")
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "TITRE", nullable = false)
    private String titre;
    @Column(name = "AUTEUR", length = 50, nullable = false)
    private String auteur;
    @ManyToMany
    @JoinTable(name = "COMPO",
    joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"),
    inverseJoinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"))
    private Set<Emprunt> emprunts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livre livre = (Livre) o;
        return id == livre.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Livre (int id, String titre, String auteur){
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
    }

    public Livre(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "----------" +
                "\nId : " + this.id +
                "\nTitre : " + this.titre +
                "\nAuteur : " + this.auteur;
    }
}
