@file:Suppress("Since15")
import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress

fun main() {
    val server = HttpServer.create(InetSocketAddress(8080), 0)

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

    server.createContext("/") { exchange ->
        val path = exchange.requestURI.path

        val response = when (path) {
            "/" -> """
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

            "/about" -> """
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

            "/contact" -> """
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

            else -> """
                <!DOCTYPE html>
                <html>
                    <head>
                        <meta charset="UTF-8">
                        <title>404 - Page non trouvée</title>
                        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
                    </head>
                    <body>
                        ${navbar.render()}
                        <div class="container mt-5 text-center">
                            <h1 class="display-1 text-danger">404</h1>
                            <h2>Page non trouvée</h2>
                            <p class="text-muted">La page <strong>$path</strong> n'existe pas.</p>
                            <a href="/" class="btn btn-primary mt-3">Retour à l'accueil</a>
                        </div>
                        ${footer.render()}
                        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
                    </body>
                </html>
            """.trimIndent()
        }

        val statusCode = if (path == "/" || path == "/about" || path == "/contact") 200 else 404
        val bytes = response.toByteArray()
        exchange.sendResponseHeaders(statusCode, bytes.size.toLong())
        exchange.responseBody.use { it.write(bytes) }
    }

    server.start()
    println("Serveur démarré sur http://localhost:8080")
}