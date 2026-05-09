@file:Suppress("Since15")
import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress

fun main() {
    val server = HttpServer.create(InetSocketAddress(8080), 0)

    // Création des composants
    val navbar = BootstrapNavbar(
        brand = "Hello World",
        links = listOf(
            Pair("Accueil", "/"),
            Pair("À propos", "/about"),
            Pair("Contact", "/contact")
        )
    )

    val footer = BootstrapFooter("© 2025 Hello World. Tous droits réservés.")

    val cards = listOf(
        BootstrapCard("Card 1", "Contenu de la première card"),
        BootstrapCard("Card 2", "Contenu de la deuxième card"),
        BootstrapCard("Card 3", "Contenu de la troisième card"),
        BootstrapCard("Card 4", "Contenu de la quatrième card"),
        BootstrapCard("Card 5", "Contenu de la cinquième card"),
        BootstrapCard("Card 6", "Contenu de la sixième card")
    )

    val container = BootstrapContainer(cards.map { it.render() })

    // Route "/"
    server.createContext("/") { exchange ->
        val response = """
            <!DOCTYPE html>
            <html>
                <head>
                    <meta charset="UTF-8">
                    <title>Hello World</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
                </head>
                <body>
                    ${navbar.render()}
                    <div class="container mt-4">
                        <h1 class="text-center text-primary">Hello World</h1>
                    </div>
                    ${container.render()}
                    ${footer.render()}
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
                </body>
            </html>
        """.trimIndent()

        val bytes = response.toByteArray()
        exchange.sendResponseHeaders(200, bytes.size.toLong())
        exchange.responseBody.use { it.write(bytes) }
    }

    // Route "/about"
    server.createContext("/about") { exchange ->
        val response = """
            <!DOCTYPE html>
            <html>
                <head>
                    <meta charset="UTF-8">
                    <title>À propos</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
                </head>
                <body>
                    ${navbar.render()}
                    <div class="container mt-4">
                        <h1 class="text-primary">À propos</h1>
                        <p>Ce site est un projet scolaire en Kotlin avec Bootstrap.</p>
                    </div>
                    ${footer.render()}
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
                </body>
            </html>
        """.trimIndent()

        val bytes = response.toByteArray()
        exchange.sendResponseHeaders(200, bytes.size.toLong())
        exchange.responseBody.use { it.write(bytes) }
    }

    // Route "/contact"
    server.createContext("/contact") { exchange ->
        val response = """
            <!DOCTYPE html>
            <html>
                <head>
                    <meta charset="UTF-8">
                    <title>Contact</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
                </head>
                <body>
                    ${navbar.render()}
                    <div class="container mt-4">
                        <h1 class="text-primary">Contact</h1>
                        <form>
                            <div class="mb-3">
                                <label class="form-label">Nom</label>
                                <input type="text" class="form-control" placeholder="Votre nom">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Email</label>
                                <input type="email" class="form-control" placeholder="Votre email">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Message</label>
                                <textarea class="form-control" rows="3" placeholder="Votre message"></textarea>
                            </div>
                            <button type="submit" class="btn btn-primary">Envoyer</button>
                        </form>
                    </div>
                    ${footer.render()}
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
                </body>
            </html>
        """.trimIndent()

        val bytes = response.toByteArray()
        exchange.sendResponseHeaders(200, bytes.size.toLong())
        exchange.responseBody.use { it.write(bytes) }
    }

    server.start()
    println("Serveur démarré sur http://localhost:8080")
}