@file:Suppress("Since15")
import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress

fun main() {
    val server = HttpServer.create(InetSocketAddress(8080), 0)

    // Création des 6 cartes
    val cards = listOf(
        BootstrapCard("Card 1", "Contenu de la première card"),
        BootstrapCard("Card 2", "Contenu de la deuxième card"),
        BootstrapCard("Card 3", "Contenu de la troisième card"),
        BootstrapCard("Card 4", "Contenu de la quatrième card"),
        BootstrapCard("Card 5", "Contenu de la cinquième card"),
        BootstrapCard("Card 6", "Contenu de la sixième card")
    )

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
                    <div class="container mt-4">
                        <h1 class="text-center text-primary">Hello World</h1>
                        <div class="row mt-4">
                            ${cards.joinToString("\n") { card ->
            """<div class="col-12 col-sm-6 col-md-4 mb-4">${card.render()}</div>"""
        }}
                        </div>
                    </div>
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