# 🌍 Hello World Web - Serveur HTTP en Kotlin avec Bootstrap

## 📋 Description

Projet scolaire consistant à créer un serveur web local en **Kotlin** qui affiche plusieurs pages HTML stylisées avec **Bootstrap 5**. Le serveur tourne en local sur `http://localhost:8080`.

---

## 🛠️ Technologies utilisées

| Technologie | Version | Utilisation |
|-------------|---------|-------------|
| Kotlin | - | Langage principal |
| JDK | Temurin 17 | Environnement d'exécution |
| Bootstrap | 5.3.0 | Mise en forme HTML/CSS |
| HttpServer | Java built-in | Serveur HTTP local |
| Git | - | Gestion de version |
| GitHub | - | Hébergement du code |

---

## 📁 Structure du projet

```
Hello-World-Web/
│
├── src/
│   ├── Main.kt               → Point d'entrée, serveur HTTP et routes
│   ├── BootstrapCard.kt      → Classe pour les cartes Bootstrap
│   ├── BootstrapNavbar.kt    → Classe pour la barre de navigation
│   ├── BootstrapFooter.kt    → Classe pour le footer
│   └── BootstrapContainer.kt → Classe pour le conteneur principal
│
├── .idea/                    → Configuration IntelliJ IDEA
├── README.md                 → Ce fichier
└── Hello-World-Web.iml       → Fichier de module IntelliJ
```

---

## 🚀 Installation et lancement

### Prérequis
- IntelliJ IDEA installé
- JDK Temurin 17 installé
- Git installé

### Étapes

1. **Cloner le projet**
```bash
git clone https://github.com/ABDALLAHSOILIHIMzeAssaf/Hello-World-Web.git
```

2. **Ouvrir dans IntelliJ IDEA**
   - File → Open → sélectionner le dossier `Hello-World-Web`

3. **Configurer le JDK**
   - File → Project Structure → SDK → Temurin 17

4. **Lancer le serveur**
   - Ouvrir `Main.kt`
   - Cliquer sur le bouton ▶️

5. **Ouvrir dans le navigateur**
```
http://localhost:8080
```

---

## 🌐 Pages disponibles

| Route | Description | Code HTTP |
|-------|-------------|-----------|
| `/` | Page d'accueil avec 6 cartes | 200 |
| `/about` | Page À propos | 200 |
| `/contact` | Page Contact avec formulaire | 200 |
| `/*` | Page d'erreur 404 | 404 |

---

## 📦 Classes Bootstrap

### 1️⃣ BootstrapCard
Représente une carte Bootstrap avec un titre et un contenu.

```kotlin
class BootstrapCard(val title: String, val content: String) {
    fun render(): String { ... }
}
```

**Utilisation :**
```kotlin
val card = BootstrapCard("Mon titre", "Mon contenu")
card.render() // retourne le HTML de la carte
```

---

### 2️⃣ BootstrapNavbar
Représente la barre de navigation avec un brand et des liens.

```kotlin
class BootstrapNavbar(val brand: String, val links: List<Pair<String, String>>) {
    fun render(): String { ... }
}
```

**Utilisation :**
```kotlin
val navbar = BootstrapNavbar(
    brand = "Hello World",
    links = listOf(
        Pair("Accueil", "/"),
        Pair("À propos", "/about"),
        Pair("Contact", "/contact")
    )
)
navbar.render() // retourne le HTML de la navbar
```

---

### 3️⃣ BootstrapFooter
Représente le footer avec un texte de copyright.

```kotlin
class BootstrapFooter(val text: String) {
    fun render(): String { ... }
}
```

**Utilisation :**
```kotlin
val footer = BootstrapFooter("© 2025 Hello World. Tous droits réservés.")
footer.render() // retourne le HTML du footer
```

---

### 4️⃣ BootstrapContainer
Représente le conteneur principal avec une grille responsive.

```kotlin
class BootstrapContainer(val elements: List<String>) {
    fun render(): String { ... }
}
```

**Utilisation :**
```kotlin
val container = BootstrapContainer(cards.map { it.render() })
container.render() // retourne le HTML du conteneur avec grille
```

---

## 🎨 Responsive Design

Le projet utilise la grille Bootstrap pour s'adapter à tous les écrans :

| Écran | Classe Bootstrap | Colonnes par ligne |
|-------|-----------------|-------------------|
| 📱 Mobile | `col-12` | 1 carte |
| 📟 Tablette | `col-sm-6` | 2 cartes |
| 🖥️ Desktop | `col-md-4` | 3 cartes |

---

## 🧠 Concepts Kotlin appris

| Concept | Exemple | Explication |
|---------|---------|-------------|
| String Templates | `"Bonjour $name"` | Insérer une variable dans une chaîne |
| trimIndent() | `""" ... """.trimIndent()` | Supprimer les indentations inutiles |
| joinToString() | `list.joinToString("\n")` | Transformer une liste en chaîne |
| listOf() | `listOf("a", "b")` | Créer une liste immuable |
| when | `when (path) { "/" -> ... }` | Équivalent du switch/case |
| Pair | `Pair("label", "/url")` | Paire de deux valeurs |
| Lambda | `cards.map { it.render() }` | Fonction anonyme |

---

## 🔧 Concepts Git appris

| Commande | Description |
|----------|-------------|
| `git init` | Initialiser un repo Git |
| `git add .` | Ajouter tous les fichiers |
| `git commit -m "message"` | Sauvegarder avec un message |
| `git push` | Envoyer sur GitHub |
| `git status` | Voir l'état du repo |
| `git stash` | Mettre en pause les modifications |
| `git stash pop` | Récupérer les modifications mises en pause |
| `git pull` | Récupérer les modifications distantes |
| `git branch` | Gérer les branches |

---

## 📅 Phases de développement

### ✅ Phase 1 - Structure de base
- Création du repository GitHub
- Création du projet IntelliJ
- Configuration du JDK Temurin 17
- Premier push vers GitHub

### ✅ Phase 2 - Serveur HTTP
- Mise en place du serveur HTTP sur le port 8080
- Route `/` qui affiche "Hello World"

### ✅ Phase 3 - Classes Bootstrap
- Création de `BootstrapCard`
- Création de `BootstrapNavbar`
- Création de `BootstrapFooter`
- Création de `BootstrapContainer`

### ✅ Phase 4 - Pages et routing
- Route `/` avec 6 cartes responsive
- Route `/about` avec description
- Route `/contact` avec formulaire

### ✅ Phase 5 - Fonctionnalités avancées
- Page d'erreur 404 personnalisée
- Logging des requêtes *(en cours)*

---

## 👨‍💻 Auteur

**ABDALLAHSOILIHIMzeAssaf**
Projet réalisé dans le cadre d'un cours de développement Kotlin.

---

*Dernière mise à jour : Mai 2025*
