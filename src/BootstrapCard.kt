class BootstrapCard(val title: String, val content: String) {

    fun render(): String {
        return """
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">$title</h5>
                    <p class="card-text">$content</p>
                </div>
            </div>
        """.trimIndent()
    }
}