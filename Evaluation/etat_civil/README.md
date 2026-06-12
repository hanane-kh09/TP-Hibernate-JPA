"C:\Program Files\Eclipse Adoptium\jdk-21.0.9.10-hotspot\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2026.1.1\lib\idea_rt.jar=64969" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\ytr\IdeaProjects\etat_civil\target\test-classes;C:\Users\ytr\IdeaProjects\etat_civil\target\classes;C:\Users\ytr\.m2\repository\org\hibernate\orm\hibernate-core\6.4.4.Final\hibernate-core-6.4.4.Final.jar;C:\Users\ytr\.m2\repository\jakarta\persistence\jakarta.persistence-api\3.1.0\jakarta.persistence-api-3.1.0.jar;C:\Users\ytr\.m2\repository\jakarta\transaction\jakarta.transaction-api\2.0.1\jakarta.transaction-api-2.0.1.jar;C:\Users\ytr\.m2\repository\org\jboss\logging\jboss-logging\3.5.0.Final\jboss-logging-3.5.0.Final.jar;C:\Users\ytr\.m2\repository\org\hibernate\common\hibernate-commons-annotations\6.0.6.Final\hibernate-commons-annotations-6.0.6.Final.jar;C:\Users\ytr\.m2\repository\io\smallrye\jandex\3.1.2\jandex-3.1.2.jar;C:\Users\ytr\.m2\repository\com\fasterxml\classmate\1.5.1\classmate-1.5.1.jar;C:\Users\ytr\.m2\repository\net\bytebuddy\byte-buddy\1.14.11\byte-buddy-1.14.11.jar;C:\Users\ytr\.m2\repository\jakarta\xml\bind\jakarta.xml.bind-api\4.0.0\jakarta.xml.bind-api-4.0.0.jar;C:\Users\ytr\.m2\repository\jakarta\activation\jakarta.activation-api\2.1.0\jakarta.activation-api-2.1.0.jar;C:\Users\ytr\.m2\repository\org\glassfish\jaxb\jaxb-runtime\4.0.2\jaxb-runtime-4.0.2.jar;C:\Users\ytr\.m2\repository\org\glassfish\jaxb\jaxb-core\4.0.2\jaxb-core-4.0.2.jar;C:\Users\ytr\.m2\repository\org\eclipse\angus\angus-activation\2.0.0\angus-activation-2.0.0.jar;C:\Users\ytr\.m2\repository\org\glassfish\jaxb\txw2\4.0.2\txw2-4.0.2.jar;C:\Users\ytr\.m2\repository\com\sun\istack\istack-commons-runtime\4.1.1\istack-commons-runtime-4.1.1.jar;C:\Users\ytr\.m2\repository\jakarta\inject\jakarta.inject-api\2.0.1\jakarta.inject-api-2.0.1.jar;C:\Users\ytr\.m2\repository\org\antlr\antlr4-runtime\4.13.0\antlr4-runtime-4.13.0.jar;C:\Users\ytr\.m2\repository\com\mysql\mysql-connector-j\8.3.0\mysql-connector-j-8.3.0.jar;C:\Users\ytr\.m2\repository\com\google\protobuf\protobuf-java\3.25.1\protobuf-java-3.25.1.jar;C:\Users\ytr\.m2\repository\org\slf4j\slf4j-simple\2.0.12\slf4j-simple-2.0.12.jar;C:\Users\ytr\.m2\repository\org\slf4j\slf4j-api\2.0.12\slf4j-api-2.0.12.jar ma.projet.test.MainTest
TEST 1 : Insertion de données
Hibernate:
create table femme (
id integer not null,
primary key (id)
) engine=InnoDB
Hibernate:
create table homme (
id integer not null,
primary key (id)
) engine=InnoDB
Hibernate:
create table mariage (
id integer not null auto_increment,
dateDebut date,
dateFin date,
nbrEnfant integer not null,
femme_id integer,
homme_id integer,
primary key (id)
) engine=InnoDB
Hibernate:
create table personne (
id integer not null auto_increment,
adresse varchar(255),
dateNaissance date,
nom varchar(255),
prenom varchar(255),
telephone varchar(255),
primary key (id)
) engine=InnoDB
Hibernate:
alter table femme
add constraint FKjkh7dheci5btwgkov7bjpjw4i
foreign key (id)
references personne (id)
Hibernate:
alter table homme
add constraint FKpghll7h1uqbasoavv1nk6dgml
foreign key (id)
references personne (id)
Hibernate:
alter table mariage
add constraint FKrd6bpu1y9od29915187hmfse2
foreign key (femme_id)
references femme (id)
Hibernate:
alter table mariage
add constraint FK4xwli0137al3tvsqjlbgh6qgw
foreign key (homme_id)
references homme (id)
Hibernate:
insert
into
personne
(adresse, dateNaissance, nom, prenom, telephone)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
femme
(id)
values
(?)
Hibernate:
insert
into
personne
(adresse, dateNaissance, nom, prenom, telephone)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
femme
(id)
values
(?)
Hibernate:
insert
into
personne
(adresse, dateNaissance, nom, prenom, telephone)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
femme
(id)
values
(?)
Hibernate:
insert
into
personne
(adresse, dateNaissance, nom, prenom, telephone)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
femme
(id)
values
(?)
Hibernate:
insert
into
personne
(adresse, dateNaissance, nom, prenom, telephone)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
femme
(id)
values
(?)
Hibernate:
insert
into
personne
(adresse, dateNaissance, nom, prenom, telephone)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
femme
(id)
values
(?)
Hibernate:
insert
into
personne
(adresse, dateNaissance, nom, prenom, telephone)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
femme
(id)
values
(?)
Hibernate:
insert
into
personne
(adresse, dateNaissance, nom, prenom, telephone)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
femme
(id)
values
(?)
Hibernate:
insert
into
personne
(adresse, dateNaissance, nom, prenom, telephone)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
femme
(id)
values
(?)
Hibernate:
insert
into
personne
(adresse, dateNaissance, nom, prenom, telephone)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
femme
(id)
values
(?)
Hibernate:
insert
into
personne
(adresse, dateNaissance, nom, prenom, telephone)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
homme
(id)
values
(?)
Hibernate:
insert
into
personne
(adresse, dateNaissance, nom, prenom, telephone)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
homme
(id)
values
(?)
Hibernate:
insert
into
personne
(adresse, dateNaissance, nom, prenom, telephone)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
homme
(id)
values
(?)
Hibernate:
insert
into
personne
(adresse, dateNaissance, nom, prenom, telephone)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
homme
(id)
values
(?)
Hibernate:
insert
into
personne
(adresse, dateNaissance, nom, prenom, telephone)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
homme
(id)
values
(?)
Hibernate:
insert
into
mariage
(dateDebut, dateFin, femme_id, homme_id, nbrEnfant)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
mariage
(dateDebut, dateFin, femme_id, homme_id, nbrEnfant)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
mariage
(dateDebut, dateFin, femme_id, homme_id, nbrEnfant)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
mariage
(dateDebut, dateFin, femme_id, homme_id, nbrEnfant)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
mariage
(dateDebut, dateFin, femme_id, homme_id, nbrEnfant)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
mariage
(dateDebut, dateFin, femme_id, homme_id, nbrEnfant)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
mariage
(dateDebut, dateFin, femme_id, homme_id, nbrEnfant)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
mariage
(dateDebut, dateFin, femme_id, homme_id, nbrEnfant)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
mariage
(dateDebut, dateFin, femme_id, homme_id, nbrEnfant)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
mariage
(dateDebut, dateFin, femme_id, homme_id, nbrEnfant)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
mariage
(dateDebut, dateFin, femme_id, homme_id, nbrEnfant)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
mariage
(dateDebut, dateFin, femme_id, homme_id, nbrEnfant)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
mariage
(dateDebut, dateFin, femme_id, homme_id, nbrEnfant)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
mariage
(dateDebut, dateFin, femme_id, homme_id, nbrEnfant)
values
(?, ?, ?, ?, ?)
TEST 2 : Liste de toutes les femmes
Liste de toutes les femmes :
Id    Nom Complet               Téléphone       Adresse                        Date Naissance
Hibernate:
select
f1_0.id,
f1_1.adresse,
f1_1.dateNaissance,
f1_1.nom,
f1_1.prenom,
f1_1.telephone
from
femme f1_0
join
personne f1_1
on f1_0.id=f1_1.id
1     RAMI Salima               0611000001      Casablanca                     1970-03-15     
2     ALI Amal                  0611000002      Rabat                          1975-07-20     
3     ALAOUI Wafa               0611000003      Fès                            1978-11-04     
4     ALAMI Karima              0611000004      Marrakech                      1968-09-03     
5     BENALI Nadia              0611000005      Agadir                         1980-01-10     
6     CHAOUI Houda              0611000006      Tanger                         1982-05-22     
7     MANSOURI Loubna           0611000007      Oujda                          1985-08-17     
8     TAHIRI Zineb              0611000008      Meknes                         1990-02-28     
9     IDRISSI Sara              0611000009      Safi                           1992-06-05     
10    ZIANI Fatima              0611000010      Kenitra                        1965-12-30     
TEST 3 : Femme la plus âgée
Hibernate:
select
f1_0.id,
f1_1.adresse,
f1_1.dateNaissance,
f1_1.nom,
f1_1.prenom,
f1_1.telephone
from
femme f1_0
join
personne f1_1
on f1_0.id=f1_1.id
order by
f1_1.dateNaissance
limit
?
Femme la plus âgée : ZIANI Fatima — née le 1965-12-30
TEST 4 : Épouses d'un homme entre deux dates
Hibernate:
select
h1_0.id,
h1_1.adresse,
h1_1.dateNaissance,
h1_1.nom,
h1_1.prenom,
h1_1.telephone
from
homme h1_0
join
personne h1_1
on h1_0.id=h1_1.id
where
h1_0.id=?
Homme introuvable.
TEST 5 : Nbr enfants d'une femme entre deux dates
Hibernate:
select
f1_0.id,
f1_1.adresse,
f1_1.dateNaissance,
f1_1.nom,
f1_1.prenom,
f1_1.telephone
from
femme f1_0
join
personne f1_1
on f1_0.id=f1_1.id
where
f1_0.id=?
Hibernate:
SELECT
COALESCE(SUM(m.nbr_enfant), 0)
FROM
mariage m
WHERE
m.femme_id = ?
AND m.date_debut >= ?
AND (
m.date_fin <= ?
OR m.date_fin IS NULL
)


Process finished with exit code 1
