import kotlin.streams.toList

class ProductParser {

    fun fromString(product: String?): List<Product> =
        (product?.split(',') ?: emptyList())
            .stream()
            .map { value -> value.trim() }
            .map { value -> mapOneProduct(value) }
            .toList()


    private fun mapOneProduct(product: String?): Product {
        return when (product) {
            "Pommes" -> Product.POMMES
            "Apples" -> Product.APPLES
            "Mele" -> Product.MELE
            "Cerises" -> Product.CERISES
            "Bananes" -> Product.BANANES
            else -> Product.INCONNU
        }
    }
}