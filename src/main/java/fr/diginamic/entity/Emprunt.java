package fr.diginamic.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "DATE_DEBUT")
    private LocalDateTime date_debut;
    @Column(name = "DELAI")
    private String delai;
    @Column
    private LocalDateTime date_fin;
    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;
    @ManyToMany(mappedBy = "emprunts")
    private Set<Livre> livres;


    public Emprunt(){}

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Emprunt{");
        sb.append("id=").append(id);
        sb.append(", date_debut=").append(date_debut);
        sb.append(", delai='").append(delai).append('\'');
        sb.append(", date_fin=").append(date_fin);
        sb.append(", id_c=").append(client);
        sb.append('}');
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDelai(String delai) {
        this.delai = delai;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDateTime date_debut) {
        this.date_debut = date_debut;
    }

    public String getDelai() {
        return delai;
    }

    public LocalDateTime getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDateTime date_fin) {
        this.date_fin = date_fin;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }
}
