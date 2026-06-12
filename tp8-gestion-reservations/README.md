"C:\Program Files\Eclipse Adoptium\jdk-21.0.9.10-hotspot\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2026.1.1\lib\idea_rt.jar=49392" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\ytr\IdeaProjects\tp8-gestion-reservations\target\classes;C:\Users\ytr\.m2\repository\org\hibernate\hibernate-core\5.6.15.Final\hibernate-core-5.6.15.Final.jar;C:\Users\ytr\.m2\repository\org\jboss\logging\jboss-logging\3.4.3.Final\jboss-logging-3.4.3.Final.jar;C:\Users\ytr\.m2\repository\javax\persistence\javax.persistence-api\2.2\javax.persistence-api-2.2.jar;C:\Users\ytr\.m2\repository\net\bytebuddy\byte-buddy\1.12.18\byte-buddy-1.12.18.jar;C:\Users\ytr\.m2\repository\antlr\antlr\2.7.7\antlr-2.7.7.jar;C:\Users\ytr\.m2\repository\org\jboss\spec\javax\transaction\jboss-transaction-api_1.2_spec\1.1.1.Final\jboss-transaction-api_1.2_spec-1.1.1.Final.jar;C:\Users\ytr\.m2\repository\org\jboss\jandex\2.4.2.Final\jandex-2.4.2.Final.jar;C:\Users\ytr\.m2\repository\com\fasterxml\classmate\1.5.1\classmate-1.5.1.jar;C:\Users\ytr\.m2\repository\javax\activation\javax.activation-api\1.2.0\javax.activation-api-1.2.0.jar;C:\Users\ytr\.m2\repository\org\hibernate\common\hibernate-commons-annotations\5.1.2.Final\hibernate-commons-annotations-5.1.2.Final.jar;C:\Users\ytr\.m2\repository\javax\xml\bind\jaxb-api\2.3.1\jaxb-api-2.3.1.jar;C:\Users\ytr\.m2\repository\org\glassfish\jaxb\jaxb-runtime\2.3.1\jaxb-runtime-2.3.1.jar;C:\Users\ytr\.m2\repository\org\glassfish\jaxb\txw2\2.3.1\txw2-2.3.1.jar;C:\Users\ytr\.m2\repository\com\sun\istack\istack-commons-runtime\3.0.7\istack-commons-runtime-3.0.7.jar;C:\Users\ytr\.m2\repository\org\jvnet\staxex\stax-ex\1.8\stax-ex-1.8.jar;C:\Users\ytr\.m2\repository\com\sun\xml\fastinfoset\FastInfoset\1.2.15\FastInfoset-1.2.15.jar;C:\Users\ytr\.m2\repository\org\hibernate\hibernate-ehcache\5.6.15.Final\hibernate-ehcache-5.6.15.Final.jar;C:\Users\ytr\.m2\repository\net\sf\ehcache\ehcache\2.10.9.2\ehcache-2.10.9.2.jar;C:\Users\ytr\.m2\repository\org\slf4j\slf4j-api\1.7.25\slf4j-api-1.7.25.jar;C:\Users\ytr\.m2\repository\com\h2database\h2\2.1.214\h2-2.1.214.jar;C:\Users\ytr\.m2\repository\com\mysql\mysql-connector-j\8.0.33\mysql-connector-j-8.0.33.jar;C:\Users\ytr\.m2\repository\com\google\protobuf\protobuf-java\3.21.9\protobuf-java-3.21.9.jar;C:\Users\ytr\.m2\repository\javax\validation\validation-api\2.0.1.Final\validation-api-2.0.1.Final.jar;C:\Users\ytr\.m2\repository\org\hibernate\validator\hibernate-validator\6.2.5.Final\hibernate-validator-6.2.5.Final.jar;C:\Users\ytr\.m2\repository\jakarta\validation\jakarta.validation-api\2.0.2\jakarta.validation-api-2.0.2.jar;C:\Users\ytr\.m2\repository\org\glassfish\javax.el\3.0.0\javax.el-3.0.0.jar;C:\Users\ytr\.m2\repository\org\slf4j\slf4j-simple\1.7.36\slf4j-simple-1.7.36.jar com.example.App
=== APPLICATION DE RÉSERVATION DE SALLES ===

=== MENU PRINCIPAL ===
1. Initialiser les données de test
2. Exécuter les scénarios de test
3. Exécuter le script de migration
4. Générer un rapport de performance
5. Quitter
   Votre choix: 1
   Création des équipements...
   Création des utilisateurs...
   Création des salles...
   Création des réservations...
   Jeu de données initialisé avec succès !

=== MENU PRINCIPAL ===
1. Initialiser les données de test
2. Exécuter les scénarios de test
3. Exécuter le script de migration
4. Générer un rapport de performance
5. Quitter
   Votre choix: 
   2

=== EXÉCUTION DES SCÉNARIOS DE TEST ===


=== TEST 1: RECHERCHE DE DISPONIBILITÉ ===
Recherche de salles disponibles entre 2026-06-13T09:00:06.231685500 et 2026-06-13T12:00:06.231685500
Nombre de salles disponibles: 15
- Salle A1 (Capacité: 10, Bâtiment: Bâtiment A)
- Salle A2 (Capacité: 12, Bâtiment: Bâtiment A)
- Salle A3 (Capacité: 14, Bâtiment: Bâtiment A)
- Salle A4 (Capacité: 16, Bâtiment: Bâtiment A)
- Salle A5 (Capacité: 18, Bâtiment: Bâtiment A)
  ... et 10 autres salles

Recherche de salles disponibles pendant une réservation existante:
Créneau: 2026-08-07T08:00:00.397264 à 2026-08-07T11:00:00.397264
Salle déjà réservée: Salle C4
Nombre de salles disponibles: 14
La salle réservée est-elle exclue des résultats? true

=== TEST 2: RECHERCHE MULTI-CRITÈRES ===
Recherche de salles avec capacité >= 30 et équipées d'un écran interactif

Nombre de salles trouvées: 8
- Salle B3 (Capacité: 30)
  Équipements: 5 équipement(s)
- Salle B4 (Capacité: 35)
  Équipements: 6 équipement(s)
- Salle B5 (Capacité: 40)
  Équipements: 5 équipement(s)
- Salle C1 (Capacité: 50)
  Équipements: 7 équipement(s)
- Salle C2 (Capacité: 70)
  Équipements: 7 équipement(s)
- Salle C3 (Capacité: 90)
  Équipements: 7 équipement(s)
- Salle C4 (Capacité: 110)
  Équipements: 7 équipement(s)
- Salle C5 (Capacité: 130)
  Équipements: 7 équipement(s)

Recherche de salles dans le Bâtiment C à l'étage 2
Nombre de salles trouvées: 2
- Salle C1 (Étage: 2)
- Salle C4 (Étage: 2)

Recherche complexe: capacité entre 20 et 50, Bâtiment B, avec ordinateur fixe
Nombre de salles trouvées: 0

=== TEST 3: PAGINATION ===
Pagination des salles (5 par page):
Nombre total de pages: 3

Page 1:
- Salle A1 (Capacité: 10, Bâtiment: Bâtiment A)
- Salle A2 (Capacité: 12, Bâtiment: Bâtiment A)
- Salle A3 (Capacité: 14, Bâtiment: Bâtiment A)
- Salle A4 (Capacité: 16, Bâtiment: Bâtiment A)
- Salle A5 (Capacité: 18, Bâtiment: Bâtiment A)

Page 2:
- Salle B1 (Capacité: 20, Bâtiment: Bâtiment B)
- Salle B2 (Capacité: 25, Bâtiment: Bâtiment B)
- Salle B3 (Capacité: 30, Bâtiment: Bâtiment B)
- Salle B4 (Capacité: 35, Bâtiment: Bâtiment B)
- Salle B5 (Capacité: 40, Bâtiment: Bâtiment B)

Page 3:
- Salle C1 (Capacité: 50, Bâtiment: Bâtiment C)
- Salle C2 (Capacité: 70, Bâtiment: Bâtiment C)
- Salle C3 (Capacité: 90, Bâtiment: Bâtiment C)
- Salle C4 (Capacité: 110, Bâtiment: Bâtiment C)
- Salle C5 (Capacité: 130, Bâtiment: Bâtiment C)

Test avec PaginationResult:
Page courante: 1
Taille de la page: 5
Nombre total de pages: 3
Nombre total d'éléments: 15
Page suivante disponible: true
Page précédente disponible: false

=== TEST 4: OPTIMISTIC LOCKING ===
Réservation sélectionnée: ID=1, Salle=Salle C4, Date=2026-08-07T08:00:00.397264
Thread 1: Réservation récupérée, version = 0


Temps d'exécution des requêtes avec cache: 62ms

=== TOUS LES TESTS TERMINÉS ===


=== MENU PRINCIPAL ===
1. Initialiser les données de test
2. Exécuter les scénarios de test
3. Exécuter le script de migration
4. Générer un rapport de performance
5. Quitter
   Votre choix: 3
   Cette fonctionnalité nécessite une base de données externe.
   Voulez-vous continuer avec une simulation? (o/n): o
   Simulation de la migration...
   Dans un environnement réel, utilisez la classe DatabaseMigrationTool.
   Exemple: DatabaseMigrationTool.main(args);

=== MENU PRINCIPAL ===
1. Initialiser les données de test
2. Exécuter les scénarios de test
3. Exécuter le script de migration
4. Générer un rapport de performance
5. Quitter
   Votre choix: 4
   Exécution des tests de performance...
   Exécution du test: Recherche de salles disponibles
   Test terminé: Recherche de salles disponibles en 5ms
   Exécution du test: Recherche multi-critères
   Test terminé: Recherche multi-critères en 5ms
   Exécution du test: Pagination
   Test terminé: Pagination en 1ms
   Exécution du test: Accès répété avec cache


=== MENU PRINCIPAL ===
1. Initialiser les données de test
2. Exécuter les scénarios de test
3. Exécuter le script de migration
4. Générer un rapport de performance
5. Quitter
   Votre choix: 5
   Au revoir !

Process finished with exit code 0
