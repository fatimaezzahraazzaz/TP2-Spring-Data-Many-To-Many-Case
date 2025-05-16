# Rapport du Projet : TP1-Spring-Data-Many-To-Many-Case

---

## 1. Introduction

Ce projet a pour but de mettre en œuvre une relation **Many-To-Many** entre les entités `User` et `Role` en utilisant **Spring Boot** et **Spring Data JPA**. 

Dans une application réelle, un utilisateur peut posséder plusieurs rôles ( ADMIN, USER,STUDENT ), et un rôle peut être attribué à plusieurs utilisateurs. Cette relation complexe est modélisée par une table de jointure dans la base de données.

Nous avons d'abord utilisé une base de données embarquée **H2** pour faciliter le développement et les tests rapides. Ensuite, nous avons migré vers une base **MySQL**, plus adaptée à un usage en production.

---

## 2. Objectifs du projet

- Comprendre et implémenter une relation Many-To-Many avec JPA
- Utiliser Spring Data JPA pour gérer les entités, avec un minimum de code
- Configurer et switcher entre une base H2 et une base MySQL
- Appliquer les bonnes pratiques Spring Boot et Hibernate

---

## 3. Technologies utilisées

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA** pour la gestion des entités
- **Hibernate** comme implémentation JPA
- **Base de données H2** (en mémoire) pour le développement initial
- **Base de données MySQL** pour la phase finale
- **Maven** comme outil de gestion de projet
- **Lombok** pour réduire le code boilerplate


---
# 4 Exécution du projet
Lancer MySQL localement et s’assurer que l’utilisateur root a un mot de passe vide .
pour h2 ma bd est "users_db"avec le port 8083
Voici une capture de l'exécution MYSQL :

Table Role :

![image](https://github.com/user-attachments/assets/e027f2ba-f082-47ce-95e0-9090d0924492)
Table User :

![image](https://github.com/user-attachments/assets/39a7cf01-df5e-4aff-a237-c05013dd529a)
TableRole_users:

![image](https://github.com/user-attachments/assets/b3530b65-307e-40a6-90e6-6db0d9afc2de)

---
## 5. Exemple de test d’authentification et récupération des rôles

Pour valider la relation Many-To-Many entre `User` et `Role`, nous avons implémenté une méthode d’authentification dans le service utilisateur, permettant de récupérer un utilisateur par son nom et mot de passe, puis d’afficher ses rôles associés.

### Extrait de code :

```java
try {
    User user = userService.authenticate("user1", "12345");
    System.out.println(user.getUserId());
    System.out.println(user.getUserName());
    System.out.println("Roles =>");
    user.getRoles().forEach(r -> {
        System.out.println("Role = " + r);
    });
} catch (Exception e) {
    e.printStackTrace();
}
```
Resultat:
![Capture d'écran 2025-05-16 233648](https://github.com/user-attachments/assets/027c6fc5-053d-4159-b155-44bff40550b6)

--- 
## 6.Conclusion
Ce projet a permis de mettre en pratique les concepts fondamentaux de la gestion des bases de données relationnelles avec Spring Data JPA, en particulier la gestion des relations complexes Many-To-Many entre entités.

Nous avons d'abord utilisé une base de données H2 en mémoire pour un développement rapide et des tests simples, avant de passer à une base MySQL pour un environnement plus réaliste et persistant. Cette transition a démontré la flexibilité de Spring Boot et JPA pour s’adapter à différents systèmes de gestion de bases de données sans modification majeure du code.

L’implémentation des entités User et Role, ainsi que la création des repositories, services et contrôleurs associés, ont permis de structurer proprement l’application selon les bonnes pratiques. Le test d’authentification avec affichage des rôles a validé la cohérence et la bonne mise en œuvre de la relation Many-To-Many.

En somme, ce TP a renforcé la compréhension de l’intégration entre Spring Boot, JPA/Hibernate et les bases de données relationnelles, tout en offrant une base solide pour développer des applications métiers complexes nécessitant une gestion fine des droits et des rôles utilisateurs.

---
## 📎 Auteur
Nom : Fatima Ezzahra Azzaz Master SDIA -FS meknès

