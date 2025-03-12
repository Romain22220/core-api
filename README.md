# Core API

## Description

La Core API est une API centrale qui route les requêtes vers les autres APIs. Elle permet de gérer les étudiants, les managers, les formations, les messages, et les utilisateurs. Elle offre également des services de scraping pour récupérer les formations disponibles pour une année spécifique.

## Services

### Étudiants

- **GET /students** : Liste tous les étudiants enregistrés.
- **POST /students** : Ajoute un nouvel étudiant.
- **GET /students/{id}** : Trouve un étudiant par son ID.
- **PUT /students/{id}** : Met à jour un étudiant.
- **DELETE /students/{id}** : Supprime un étudiant.

### Managers

- **GET /managers** : Liste tous les managers enregistrés.
- **POST /managers** : Ajoute un nouveau manager.
- **GET /managers/{id}** : Trouve un manager par son ID.
- **PUT /managers/{id}** : Met à jour un manager.
- **DELETE /managers/{id}** : Supprime un manager.
- **POST /managers** : Ajoute un nouveau manager.

### Formations

- **GET /formations** : Liste toutes les formations disponibles.
- **POST /formations** : Ajoute une nouvelle formation.
- **GET /formations/{id}** : Trouve une formation par son ID.
- **DELETE /formations/{id}** : Supprime une formation.

### Messages

- **POST /messages** : Crée un nouveau message pour un étudiant.
- **GET /messages/{id}** : Récupère un message spécifique par son ID.
- **PUT /messages/{id}** : Met à jour un message existant.
- **DELETE /messages/{id}** : Supprime un message spécifique.
- **GET /messages/etudiants/{id}** : Récupère tous les messages d'un étudiant.

### Utilisateurs

- **POST /register** : Inscription d'un utilisateur.
- **POST /login** : Connexion d'un utilisateur et obtention d'un token JWT.
- **POST /logout** : Déconnexion de l'utilisateur.
- **POST /token** : Rafraîchir le token JWT.
- **GET /users/{id}** : Récupérer les informations de l'utilisateur connecté.
- **PUT /account/{id}** : Met à jour un compte utilisateur.
- **DELETE /account/{id}** : Supprime un compte utilisateur.

### Scraping

- **GET /scraping** : Scraper les formations pour une année donnée.

## Sécurité

L'API utilise des tokens JWT pour authentifier les requêtes. Utilisez le token JWT pour authentifier les requêtes en ajoutant un header `Authorization` avec la valeur `Bearer <token>`.

## Tests

Des tests ont été effectués pour les services `students` et `managers`. 

## Documentation

Pour plus de détails sur les endpoints et les schémas de données, veuillez consulter la documentation OpenAPI disponible dans le fichier `core-api.yaml`.