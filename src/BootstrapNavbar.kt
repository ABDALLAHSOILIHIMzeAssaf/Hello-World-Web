class BootstrapNavbar(val brand: String, val links: List<Pair<String, String>>) {

    fun render(): String {
        val linkItems = links.joinToString("\n") { (label, url) ->
            """<li class="nav-item"><a class="nav-link" href="$url">$label</a></li>"""
        }

        return """
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="/">$brand</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            $linkItems
                        </ul>
                    </div>
                </div>
            </nav>
        """.trimIndent()
    }
}