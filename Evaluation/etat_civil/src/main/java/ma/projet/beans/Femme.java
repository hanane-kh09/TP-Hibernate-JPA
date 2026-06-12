package ma.projet.beans;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "femme")
@NamedQueries({
    @NamedQuery(
        name = "Femme.marieeAuMoinsDeuXFois",
        query = "SELECT f FROM Femme f WHERE (SELECT COUNT(m) FROM Mariage m WHERE m.femme = f) >= 2"
    )
})
@NamedNativeQueries({
    @NamedNativeQuery(
        name = "Femme.nbrEnfantsEntreDates",
        query = "SELECT COALESCE(SUM(m.nbr_enfant), 0) FROM mariage m WHERE m.femme_id = :femmeId AND m.date_debut >= :debut AND (m.date_fin <= :fin OR m.date_fin IS NULL)"
    )
})
public class Femme extends Personne {

    @OneToMany(mappedBy = "femme", cascade = CascadeType.ALL)
    private List<Mariage> mariages;

    public Femme() {}

    public Femme(String nom, String prenom, String telephone, String adresse, LocalDate dateNaissance) {
        super(nom, prenom, telephone, adresse, dateNaissance);
    }

    public List<Mariage> getMariages() { return mariages; }
    public void setMariages(List<Mariage> mariages) { this.mariages = mariages; }
}
