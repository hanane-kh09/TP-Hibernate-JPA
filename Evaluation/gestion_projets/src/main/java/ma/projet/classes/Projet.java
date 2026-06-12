package ma.projet.classes;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "projet")
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    @ManyToOne
    @JoinColumn(name = "chef_de_projet_id")
    private Employe chefDeProjet;

    @OneToMany(mappedBy = "projet")
    private List<Tache> taches;

    public Projet() {}

    public Projet(String nom, LocalDate dateDebut, LocalDate dateFin, Employe chefDeProjet) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.chefDeProjet = chefDeProjet;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }

    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }

    public Employe getChefDeProjet() { return chefDeProjet; }
    public void setChefDeProjet(Employe chefDeProjet) { this.chefDeProjet = chefDeProjet; }

    public List<Tache> getTaches() { return taches; }
    public void setTaches(List<Tache> taches) { this.taches = taches; }

    @Override
    public String toString() {
        return "Projet{id=" + id + ", nom='" + nom + "', dateDebut=" + dateDebut + ", dateFin=" + dateFin + "}";
    }
}
