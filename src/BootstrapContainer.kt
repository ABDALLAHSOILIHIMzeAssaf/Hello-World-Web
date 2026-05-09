class BootstrapContainer(val elements: List<String>) {

    fun render(): String {
        val columns = elements.joinToString("\n") { element ->
            """
            <div class="col-12 col-sm-6 col-md-4 mb-4">
                $element
            </div>
            """.trimIndent()
        }

        return """
            <div class="container mt-4">
                <div class="row">
                    $columns
                </div>
            </div>
        """.trimIndent()
    }
}