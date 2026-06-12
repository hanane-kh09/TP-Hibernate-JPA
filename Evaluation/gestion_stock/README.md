"C:\Program Files\Eclipse Adoptium\jdk-21.0.9.10-hotspot\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2026.1.1\lib\idea_rt.jar=64930" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\ytr\IdeaProjects\gestion_stock\target\test-classes;C:\Users\ytr\IdeaProjects\gestion_stock\target\classes;C:\Users\ytr\.m2\repository\org\hibernate\orm\hibernate-core\6.4.4.Final\hibernate-core-6.4.4.Final.jar;C:\Users\ytr\.m2\repository\jakarta\persistence\jakarta.persistence-api\3.1.0\jakarta.persistence-api-3.1.0.jar;C:\Users\ytr\.m2\repository\jakarta\transaction\jakarta.transaction-api\2.0.1\jakarta.transaction-api-2.0.1.jar;C:\Users\ytr\.m2\repository\org\jboss\logging\jboss-logging\3.5.0.Final\jboss-logging-3.5.0.Final.jar;C:\Users\ytr\.m2\repository\org\hibernate\common\hibernate-commons-annotations\6.0.6.Final\hibernate-commons-annotations-6.0.6.Final.jar;C:\Users\ytr\.m2\repository\io\smallrye\jandex\3.1.2\jandex-3.1.2.jar;C:\Users\ytr\.m2\repository\com\fasterxml\classmate\1.5.1\classmate-1.5.1.jar;C:\Users\ytr\.m2\repository\net\bytebuddy\byte-buddy\1.14.11\byte-buddy-1.14.11.jar;C:\Users\ytr\.m2\repository\jakarta\xml\bind\jakarta.xml.bind-api\4.0.0\jakarta.xml.bind-api-4.0.0.jar;C:\Users\ytr\.m2\repository\jakarta\activation\jakarta.activation-api\2.1.0\jakarta.activation-api-2.1.0.jar;C:\Users\ytr\.m2\repository\org\glassfish\jaxb\jaxb-runtime\4.0.2\jaxb-runtime-4.0.2.jar;C:\Users\ytr\.m2\repository\org\glassfish\jaxb\jaxb-core\4.0.2\jaxb-core-4.0.2.jar;C:\Users\ytr\.m2\repository\org\eclipse\angus\angus-activation\2.0.0\angus-activation-2.0.0.jar;C:\Users\ytr\.m2\repository\org\glassfish\jaxb\txw2\4.0.2\txw2-4.0.2.jar;C:\Users\ytr\.m2\repository\com\sun\istack\istack-commons-runtime\4.1.1\istack-commons-runtime-4.1.1.jar;C:\Users\ytr\.m2\repository\jakarta\inject\jakarta.inject-api\2.0.1\jakarta.inject-api-2.0.1.jar;C:\Users\ytr\.m2\repository\org\antlr\antlr4-runtime\4.13.0\antlr4-runtime-4.13.0.jar;C:\Users\ytr\.m2\repository\com\mysql\mysql-connector-j\8.3.0\mysql-connector-j-8.3.0.jar;C:\Users\ytr\.m2\repository\com\google\protobuf\protobuf-java\3.25.1\protobuf-java-3.25.1.jar;C:\Users\ytr\.m2\repository\org\slf4j\slf4j-simple\2.0.12\slf4j-simple-2.0.12.jar;C:\Users\ytr\.m2\repository\org\slf4j\slf4j-api\2.0.12\slf4j-api-2.0.12.jar ma.projet.test.MainTest
TEST 1 : Insertion de données
Hibernate:
insert
into
categorie
(code, libelle)
values
(?, ?)
Hibernate:
insert
into
categorie
(code, libelle)
values
(?, ?)
Catégories créées : Categorie{id=5, code='INFO', libelle='Informatique'} | Categorie{id=6, code='RES', libelle='Réseau'}
Hibernate:
insert
into
produit
(categorie_id, prix, reference)
values
(?, ?, ?)
Hibernate:
insert
into
produit
(categorie_id, prix, reference)
values
(?, ?, ?)
Hibernate:
insert
into
produit
(categorie_id, prix, reference)
values
(?, ?, ?)
Hibernate:
insert
into
produit
(categorie_id, prix, reference)
values
(?, ?, ?)
Produits créés.
Hibernate:
insert
into
commande
(date)
values
(?)
Hibernate:
insert
into
commande
(date)
values
(?)
Commandes créées : Commande{id=5, date=Thu Mar 14 00:00:00 WET 2013} | Commande{id=6, date=Wed Jan 10 00:00:00 WEST 2024}
Hibernate:
insert
into
ligne_commande_produit
(commande_id, produit_id, quantite)
values
(?, ?, ?)
Hibernate:
insert
into
ligne_commande_produit
(commande_id, produit_id, quantite)
values
(?, ?, ?)
Hibernate:
insert
into
ligne_commande_produit
(commande_id, produit_id, quantite)
values
(?, ?, ?)
Hibernate:
insert
into
ligne_commande_produit
(commande_id, produit_id, quantite)
values
(?, ?, ?)
Lignes de commande créées.
TEST 2 : Produits par catégorie
Hibernate:
select
c1_0.id,
c1_0.code,
c1_0.libelle
from
categorie c1_0

Catégorie : Informatique
Hibernate:
select
p1_0.id,
p1_0.categorie_id,
p1_0.prix,
p1_0.reference
from
produit p1_0
where
p1_0.categorie_id=?
-> ES12 | 120.0 DH
-> ZR85 | 100.0 DH

Catégorie : Réseau
Hibernate:
select
p1_0.id,
p1_0.categorie_id,
p1_0.prix,
p1_0.reference
from
produit p1_0
where
p1_0.categorie_id=?
-> EE85 | 200.0 DH
-> SW01 | 80.0 DH

Catégorie : Informatique
Hibernate:
select
p1_0.id,
p1_0.categorie_id,
p1_0.prix,
p1_0.reference
from
produit p1_0
where
p1_0.categorie_id=?
-> ES12 | 120.0 DH
-> ZR85 | 100.0 DH

Catégorie : Réseau
Hibernate:
select
p1_0.id,
p1_0.categorie_id,
p1_0.prix,
p1_0.reference
from
produit p1_0
where
p1_0.categorie_id=?
-> EE85 | 200.0 DH
-> SW01 | 80.0 DH

Catégorie : Informatique
Hibernate:
select
p1_0.id,
p1_0.categorie_id,
p1_0.prix,
p1_0.reference
from
produit p1_0
where
p1_0.categorie_id=?
-> ES12 | 120.0 DH
-> ZR85 | 100.0 DH

Catégorie : Réseau
Hibernate:
select
p1_0.id,
p1_0.categorie_id,
p1_0.prix,
p1_0.reference
from
produit p1_0
where
p1_0.categorie_id=?
-> EE85 | 200.0 DH
-> SW01 | 80.0 DH
TEST 3 : Produits commandés entre dates
Hibernate:
select
distinct p1_0.id,
p1_0.categorie_id,
p1_0.prix,
p1_0.reference
from
ligne_commande_produit lcp1_0
join
produit p1_0
on p1_0.id=lcp1_0.produit_id
join
commande c2_0
on c2_0.id=lcp1_0.commande_id
where
c2_0.date between ? and ?
Produits commandés en 2013 :
-> ES12
-> ZR85
-> EE85
-> ES12
-> ZR85
-> EE85
-> ES12
-> ZR85
-> EE85
TEST 4 : Produits d'une commande
Hibernate:
select
c1_0.id,
c1_0.date
from
commande c1_0
where
c1_0.id=?
Hibernate:
select
lcp1_0.id,
lcp1_0.commande_id,
p1_0.id,
p1_0.categorie_id,
p1_0.prix,
p1_0.reference,
lcp1_0.quantite
from
ligne_commande_produit lcp1_0
join
produit p1_0
on p1_0.id=lcp1_0.produit_id
where
lcp1_0.commande_id=?
Commande : 5     Date : 2013-03-14
Liste des produits :
Référence    Prix       Quantité
ES12         120 DH     7
ZR85         100 DH     14
EE85         200 DH     5
TEST 5 : Produits prix > 100 DH (NamedQuery)
Hibernate:
select
p1_0.id,
p1_0.categorie_id,
p1_0.prix,
p1_0.reference
from
produit p1_0
where
p1_0.prix>100
order by
p1_0.prix desc
Produits avec prix > 100 DH :
-> EE85 | 200.0 DH
-> EE85 | 200.0 DH
-> EE85 | 200.0 DH
-> ES12 | 120.0 DH
-> ES12 | 120.0 DH
-> ES12 | 120.0 DH

Process finished with exit code 0
