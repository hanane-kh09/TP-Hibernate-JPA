package ma.projet.beans;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "mariage")
public class Mariage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private int nbrEnfant;

    @ManyToOne
    @JoinColumn(name = "homme_id")
    private Homme homme;

    @ManyToOne
    @JoinColumn(name = "femme_id")
    private Femme femme;

    public Mariage() {}

    public Mariage(LocalDate dateDebut, LocalDate dateFin, int nbrEnfant, Homme homme, Femme femme) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbrEnfant = nbrEnfant;
        this.homme = homme;
        this.femme = femme;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }

    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }

    public int getNbrEnfant() { return nbrEnfant; }
    public void setNbrEnfant(int nbrEnfant) { this.nbrEnfant = nbrEnfant; }

    public Homme getHomme() { return homme; }
    public void setHomme(Homme homme) { this.homme = homme; }

    public Femme getFemme() { return femme; }
    public void setFemme(Femme femme) { this.femme = femme; }

    public boolean enCours() { return dateFin == null; }
}
