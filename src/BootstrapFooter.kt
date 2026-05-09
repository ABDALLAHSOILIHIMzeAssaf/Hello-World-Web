class BootstrapFooter(val text: String) {

    fun render(): String {
        return """
            <footer class="bg-light text-center py-3 mt-4">
                <p class="mb-0">$text</p>
            </footer>
        """.trimIndent()
    }
}