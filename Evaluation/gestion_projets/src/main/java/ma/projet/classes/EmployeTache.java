package ma.projet.classes;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employe_tache")
public class EmployeTache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate dateDebutReelle;
    private LocalDate dateFinReelle;

    @ManyToOne
    @JoinColumn(name = "employe_id")
    private Employe employe;

    @ManyToOne
    @JoinColumn(name = "tache_id")
    private Tache tache;

    public EmployeTache() {}

    public EmployeTache(LocalDate dateDebutReelle, LocalDate dateFinReelle, Employe employe, Tache tache) {
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
        this.employe = employe;
        this.tache = tache;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getDateDebutReelle() { return dateDebutReelle; }
    public void setDateDebutReelle(LocalDate dateDebutReelle) { this.dateDebutReelle = dateDebutReelle; }

    public LocalDate getDateFinReelle() { return dateFinReelle; }
    public void setDateFinReelle(LocalDate dateFinReelle) { this.dateFinReelle = dateFinReelle; }

    public Employe getEmploye() { return employe; }
    public void setEmploye(Employe employe) { this.employe = employe; }

    public Tache getTache() { return tache; }
    public void setTache(Tache tache) { this.tache = tache; }

    @Override
    public String toString() {
        return "EmployeTache{id=" + id + ", employe=" + employe.getNom() + ", tache=" + tache.getNom()
                + ", dateDebutReelle=" + dateDebutReelle + ", dateFinReelle=" + dateFinReelle + "}";
    }
}
