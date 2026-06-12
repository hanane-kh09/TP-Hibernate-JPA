"C:\Program Files\Eclipse Adoptium\jdk-21.0.9.10-hotspot\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2026.1.1\lib\idea_rt.jar=64940" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\ytr\IdeaProjects\gestion_projets\target\test-classes;C:\Users\ytr\IdeaProjects\gestion_projets\target\classes;C:\Users\ytr\.m2\repository\org\hibernate\orm\hibernate-core\6.4.4.Final\hibernate-core-6.4.4.Final.jar;C:\Users\ytr\.m2\repository\jakarta\persistence\jakarta.persistence-api\3.1.0\jakarta.persistence-api-3.1.0.jar;C:\Users\ytr\.m2\repository\jakarta\transaction\jakarta.transaction-api\2.0.1\jakarta.transaction-api-2.0.1.jar;C:\Users\ytr\.m2\repository\org\jboss\logging\jboss-logging\3.5.0.Final\jboss-logging-3.5.0.Final.jar;C:\Users\ytr\.m2\repository\org\hibernate\common\hibernate-commons-annotations\6.0.6.Final\hibernate-commons-annotations-6.0.6.Final.jar;C:\Users\ytr\.m2\repository\io\smallrye\jandex\3.1.2\jandex-3.1.2.jar;C:\Users\ytr\.m2\repository\com\fasterxml\classmate\1.5.1\classmate-1.5.1.jar;C:\Users\ytr\.m2\repository\net\bytebuddy\byte-buddy\1.14.11\byte-buddy-1.14.11.jar;C:\Users\ytr\.m2\repository\jakarta\xml\bind\jakarta.xml.bind-api\4.0.0\jakarta.xml.bind-api-4.0.0.jar;C:\Users\ytr\.m2\repository\jakarta\activation\jakarta.activation-api\2.1.0\jakarta.activation-api-2.1.0.jar;C:\Users\ytr\.m2\repository\org\glassfish\jaxb\jaxb-runtime\4.0.2\jaxb-runtime-4.0.2.jar;C:\Users\ytr\.m2\repository\org\glassfish\jaxb\jaxb-core\4.0.2\jaxb-core-4.0.2.jar;C:\Users\ytr\.m2\repository\org\eclipse\angus\angus-activation\2.0.0\angus-activation-2.0.0.jar;C:\Users\ytr\.m2\repository\org\glassfish\jaxb\txw2\4.0.2\txw2-4.0.2.jar;C:\Users\ytr\.m2\repository\com\sun\istack\istack-commons-runtime\4.1.1\istack-commons-runtime-4.1.1.jar;C:\Users\ytr\.m2\repository\jakarta\inject\jakarta.inject-api\2.0.1\jakarta.inject-api-2.0.1.jar;C:\Users\ytr\.m2\repository\org\antlr\antlr4-runtime\4.13.0\antlr4-runtime-4.13.0.jar;C:\Users\ytr\.m2\repository\com\mysql\mysql-connector-j\8.3.0\mysql-connector-j-8.3.0.jar;C:\Users\ytr\.m2\repository\com\google\protobuf\protobuf-java\3.25.1\protobuf-java-3.25.1.jar;C:\Users\ytr\.m2\repository\org\slf4j\slf4j-simple\2.0.12\slf4j-simple-2.0.12.jar;C:\Users\ytr\.m2\repository\org\slf4j\slf4j-api\2.0.12\slf4j-api-2.0.12.jar ma.projet.test.MainTest
TEST 1 : Insertion de données
Hibernate:
insert
into
employe
(nom, prenom, telephone)
values
(?, ?, ?)
Hibernate:
insert
into
employe
(nom, prenom, telephone)
values
(?, ?, ?)
Hibernate:
insert
into
projet
(chef_de_projet_id, dateDebut, dateFin, nom)
values
(?, ?, ?, ?)
Hibernate:
insert
into
projet
(chef_de_projet_id, dateDebut, dateFin, nom)
values
(?, ?, ?, ?)
Hibernate:
insert
into
tache
(dateDebut, dateFin, nom, prix, projet_id)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
tache
(dateDebut, dateFin, nom, prix, projet_id)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
tache
(dateDebut, dateFin, nom, prix, projet_id)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
tache
(dateDebut, dateFin, nom, prix, projet_id)
values
(?, ?, ?, ?, ?)
Hibernate:
insert
into
employe_tache
(dateDebutReelle, dateFinReelle, employe_id, tache_id)
values
(?, ?, ?, ?)
Hibernate:
insert
into
employe_tache
(dateDebutReelle, dateFinReelle, employe_id, tache_id)
values
(?, ?, ?, ?)
Hibernate:
insert
into
employe_tache
(dateDebutReelle, dateFinReelle, employe_id, tache_id)
values
(?, ?, ?, ?)
TEST 2 : Tâches par employé
Hibernate:
select
e1_0.id,
e1_0.nom,
e1_0.prenom,
e1_0.telephone
from
employe e1_0
where
e1_0.id=?
Tâches réalisées par : Martin Alice
Id    Nom                  Date Début   Date Fin     Prix      
Hibernate:
select
t1_0.id,
t1_0.dateDebut,
t1_0.dateFin,
t1_0.nom,
t1_0.prix,
t1_0.projet_id
from
employe_tache et1_0
join
tache t1_0
on t1_0.id=et1_0.tache_id
where
et1_0.employe_id=?
Hibernate:
select
p1_0.id,
cdp1_0.id,
cdp1_0.nom,
cdp1_0.prenom,
cdp1_0.telephone,
p1_0.dateDebut,
p1_0.dateFin,
p1_0.nom
from
projet p1_0
left join
employe cdp1_0
on cdp1_0.id=p1_0.chef_de_projet_id
where
p1_0.id=?
1     Analyse              2013-02-01   2013-02-28   1500,00   
2     Conception           2013-03-01   2013-03-31   2000,00   
TEST 3 : Projets gérés par employé
Hibernate:
select
e1_0.id,
e1_0.nom,
e1_0.prenom,
e1_0.telephone
from
employe e1_0
where
e1_0.id=?
Projets gérés par : Martin Alice
Id    Nom                       Date Début   Date Fin    
Hibernate:
select
p1_0.id,
p1_0.chef_de_projet_id,
p1_0.dateDebut,
p1_0.dateFin,
p1_0.nom
from
projet p1_0
where
p1_0.chef_de_projet_id=?
Hibernate:
select
e1_0.id,
e1_0.nom,
e1_0.prenom,
e1_0.telephone
from
employe e1_0
where
e1_0.id=?
1     Gestion de stock          2013-01-14   2013-06-30  
TEST 4 : Tâches planifiées par projet
Hibernate:
select
p1_0.id,
cdp1_0.id,
cdp1_0.nom,
cdp1_0.prenom,
cdp1_0.telephone,
p1_0.dateDebut,
p1_0.dateFin,
p1_0.nom
from
projet p1_0
left join
employe cdp1_0
on cdp1_0.id=p1_0.chef_de_projet_id
where
p1_0.id=?
Projet : 1      Nom : Gestion de stock     Date début : 2013-01-14
Liste des tâches planifiées :
Num   Nom                  Date Début   Date Fin     Prix      
Hibernate:
select
t1_0.id,
t1_0.dateDebut,
t1_0.dateFin,
t1_0.nom,
t1_0.prix,
t1_0.projet_id
from
tache t1_0
where
t1_0.projet_id=?
Hibernate:
select
p1_0.id,
cdp1_0.id,
cdp1_0.nom,
cdp1_0.prenom,
cdp1_0.telephone,
p1_0.dateDebut,
p1_0.dateFin,
p1_0.nom
from
projet p1_0
left join
employe cdp1_0
on cdp1_0.id=p1_0.chef_de_projet_id
where
p1_0.id=?
1     Analyse              2013-02-01   2013-02-28   1500,00   
2     Conception           2013-03-01   2013-03-31   2000,00   
3     Développement        2013-04-01   2013-05-31   5000,00   
TEST 5 : Tâches réalisées par projet
Hibernate:
select
p1_0.id,
cdp1_0.id,
cdp1_0.nom,
cdp1_0.prenom,
cdp1_0.telephone,
p1_0.dateDebut,
p1_0.dateFin,
p1_0.nom
from
projet p1_0
left join
employe cdp1_0
on cdp1_0.id=p1_0.chef_de_projet_id
where
p1_0.id=?
Projet : 1      Nom : Gestion de stock     Date début : 2013-01-14
Liste des tâches réalisées :
Num   Nom                  Date Début Réelle    Date Fin Réelle     
Hibernate:
select
et1_0.id,
et1_0.dateDebutReelle,
et1_0.dateFinReelle,
et1_0.employe_id,
et1_0.tache_id
from
employe_tache et1_0
join
tache t1_0
on t1_0.id=et1_0.tache_id
where
t1_0.projet_id=?
Hibernate:
select
e1_0.id,
e1_0.nom,
e1_0.prenom,
e1_0.telephone
from
employe e1_0
where
e1_0.id=?
Hibernate:
select
t1_0.id,
t1_0.dateDebut,
t1_0.dateFin,
t1_0.nom,
t1_0.prix,
p1_0.id,
cdp1_0.id,
cdp1_0.nom,
cdp1_0.prenom,
cdp1_0.telephone,
p1_0.dateDebut,
p1_0.dateFin,
p1_0.nom
from
tache t1_0
left join
projet p1_0
on p1_0.id=t1_0.projet_id
left join
employe cdp1_0
on cdp1_0.id=p1_0.chef_de_projet_id
where
t1_0.id=?
Hibernate:
select
t1_0.id,
t1_0.dateDebut,
t1_0.dateFin,
t1_0.nom,
t1_0.prix,
p1_0.id,
cdp1_0.id,
cdp1_0.nom,
cdp1_0.prenom,
cdp1_0.telephone,
p1_0.dateDebut,
p1_0.dateFin,
p1_0.nom
from
tache t1_0
left join
projet p1_0
on p1_0.id=t1_0.projet_id
left join
employe cdp1_0
on cdp1_0.id=p1_0.chef_de_projet_id
where
t1_0.id=?
Hibernate:
select
e1_0.id,
e1_0.nom,
e1_0.prenom,
e1_0.telephone
from
employe e1_0
where
e1_0.id=?
Hibernate:
select
t1_0.id,
t1_0.dateDebut,
t1_0.dateFin,
t1_0.nom,
t1_0.prix,
p1_0.id,
cdp1_0.id,
cdp1_0.nom,
cdp1_0.prenom,
cdp1_0.telephone,
p1_0.dateDebut,
p1_0.dateFin,
p1_0.nom
from
tache t1_0
left join
projet p1_0
on p1_0.id=t1_0.projet_id
left join
employe cdp1_0
on cdp1_0.id=p1_0.chef_de_projet_id
where
t1_0.id=?
1     Analyse              2013-02-10           2013-02-20          
2     Conception           2013-03-10           2013-03-15          
3     Développement        2013-04-10           2013-04-25          
TEST 6 : Tâches prix > 1000 DH
Tâches dont le prix est supérieur à 1000 DH :
Id    Nom                  Date Début   Date Fin     Prix      
Hibernate:
select
t1_0.id,
t1_0.dateDebut,
t1_0.dateFin,
t1_0.nom,
t1_0.prix,
t1_0.projet_id
from
tache t1_0
where
t1_0.prix>1000
Hibernate:
select
p1_0.id,
cdp1_0.id,
cdp1_0.nom,
cdp1_0.prenom,
cdp1_0.telephone,
p1_0.dateDebut,
p1_0.dateFin,
p1_0.nom
from
projet p1_0
left join
employe cdp1_0
on cdp1_0.id=p1_0.chef_de_projet_id
where
p1_0.id=?
Hibernate:
select
p1_0.id,
cdp1_0.id,
cdp1_0.nom,
cdp1_0.prenom,
cdp1_0.telephone,
p1_0.dateDebut,
p1_0.dateFin,
p1_0.nom
from
projet p1_0
left join
employe cdp1_0
on cdp1_0.id=p1_0.chef_de_projet_id
where
p1_0.id=?
Hibernate:
select
p1_0.id,
cdp1_0.id,
cdp1_0.nom,
cdp1_0.prenom,
cdp1_0.telephone,
p1_0.dateDebut,
p1_0.dateFin,
p1_0.nom
from
projet p1_0
left join
employe cdp1_0
on cdp1_0.id=p1_0.chef_de_projet_id
where
p1_0.id=?
Hibernate:
select
p1_0.id,
cdp1_0.id,
cdp1_0.nom,
cdp1_0.prenom,
cdp1_0.telephone,
p1_0.dateDebut,
p1_0.dateFin,
p1_0.nom
from
projet p1_0
left join
employe cdp1_0
on cdp1_0.id=p1_0.chef_de_projet_id
where
p1_0.id=?
1     Analyse              2013-02-01   2013-02-28   1500,00   
2     Conception           2013-03-01   2013-03-31   2000,00   
3     Développement        2013-04-01   2013-05-31   5000,00   
5     Analyse              2013-02-01   2013-02-28   1500,00   
6     Conception           2013-03-01   2013-03-31   2000,00   
7     Développement        2013-04-01   2013-05-31   5000,00   
9     Analyse              2013-02-01   2013-02-28   1500,00   
10    Conception           2013-03-01   2013-03-31   2000,00   
11    Développement        2013-04-01   2013-05-31   5000,00   
13    Analyse              2013-02-01   2013-02-28   1500,00   
14    Conception           2013-03-01   2013-03-31   2000,00   
15    Développement        2013-04-01   2013-05-31   5000,00   
TEST 7 : Tâches entre deux dates
Tâches réalisées entre 2013-01-01 et 2013-12-31 :
Id    Nom                  Date Début   Date Fin     Prix      
Hibernate:
select
t1_0.id,
t1_0.dateDebut,
t1_0.dateFin,
t1_0.nom,
t1_0.prix,
t1_0.projet_id
from
tache t1_0
where
t1_0.dateDebut>=?
and t1_0.dateFin<=?
Hibernate:
select
p1_0.id,
cdp1_0.id,
cdp1_0.nom,
cdp1_0.prenom,
cdp1_0.telephone,
p1_0.dateDebut,
p1_0.dateFin,
p1_0.nom
from
projet p1_0
left join
employe cdp1_0
on cdp1_0.id=p1_0.chef_de_projet_id
where
p1_0.id=?
Hibernate:
select
p1_0.id,
cdp1_0.id,
cdp1_0.nom,
cdp1_0.prenom,
cdp1_0.telephone,
p1_0.dateDebut,
p1_0.dateFin,
p1_0.nom
from
projet p1_0
left join
employe cdp1_0
on cdp1_0.id=p1_0.chef_de_projet_id
where
p1_0.id=?
Hibernate:
select
p1_0.id,
cdp1_0.id,
cdp1_0.nom,
cdp1_0.prenom,
cdp1_0.telephone,
p1_0.dateDebut,
p1_0.dateFin,
p1_0.nom
from
projet p1_0
left join
employe cdp1_0
on cdp1_0.id=p1_0.chef_de_projet_id
where
p1_0.id=?
Hibernate:
select
p1_0.id,
cdp1_0.id,
cdp1_0.nom,
cdp1_0.prenom,
cdp1_0.telephone,
p1_0.dateDebut,
p1_0.dateFin,
p1_0.nom
from
projet p1_0
left join
employe cdp1_0
on cdp1_0.id=p1_0.chef_de_projet_id
where
p1_0.id=?
Hibernate:
select
p1_0.id,
cdp1_0.id,
cdp1_0.nom,
cdp1_0.prenom,
cdp1_0.telephone,
p1_0.dateDebut,
p1_0.dateFin,
p1_0.nom
from
projet p1_0
left join
employe cdp1_0
on cdp1_0.id=p1_0.chef_de_projet_id
where
p1_0.id=?
Hibernate:
select
p1_0.id,
cdp1_0.id,
cdp1_0.nom,
cdp1_0.prenom,
cdp1_0.telephone,
p1_0.dateDebut,
p1_0.dateFin,
p1_0.nom
from
projet p1_0
left join
employe cdp1_0
on cdp1_0.id=p1_0.chef_de_projet_id
where
p1_0.id=?
Hibernate:
select
p1_0.id,
cdp1_0.id,
cdp1_0.nom,
cdp1_0.prenom,
cdp1_0.telephone,
p1_0.dateDebut,
p1_0.dateFin,
p1_0.nom
from
projet p1_0
left join
employe cdp1_0
on cdp1_0.id=p1_0.chef_de_projet_id
where
p1_0.id=?
Hibernate:
select
p1_0.id,
cdp1_0.id,
cdp1_0.nom,
cdp1_0.prenom,
cdp1_0.telephone,
p1_0.dateDebut,
p1_0.dateFin,
p1_0.nom
from
projet p1_0
left join
employe cdp1_0
on cdp1_0.id=p1_0.chef_de_projet_id
where
p1_0.id=?
1     Analyse              2013-02-01   2013-02-28   1500,00   
2     Conception           2013-03-01   2013-03-31   2000,00   
3     Développement        2013-04-01   2013-05-31   5000,00   
4     Tests                2013-04-01   2013-04-30   800,00    
5     Analyse              2013-02-01   2013-02-28   1500,00   
6     Conception           2013-03-01   2013-03-31   2000,00   
7     Développement        2013-04-01   2013-05-31   5000,00   
8     Tests                2013-04-01   2013-04-30   800,00    
9     Analyse              2013-02-01   2013-02-28   1500,00   
10    Conception           2013-03-01   2013-03-31   2000,00   
11    Développement        2013-04-01   2013-05-31   5000,00   
12    Tests                2013-04-01   2013-04-30   800,00    
13    Analyse              2013-02-01   2013-02-28   1500,00   
14    Conception           2013-03-01   2013-03-31   2000,00   
15    Développement        2013-04-01   2013-05-31   5000,00   
16    Tests                2013-04-01   2013-04-30   800,00

Process finished with exit code 0
