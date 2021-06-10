class CashRegister {
    private var productsBought: MutableMap<Product, Int> = mutableMapOf()
    private val cerisesReduc = 20

    fun addProduct(product: Product) {
        productsBought.computeIfPresent(product) { _, value -> value + 1 }
        productsBought.putIfAbsent(product, 1)
    }

    fun getTotalPrice(): Int {
        val totalBeforeReduc = productsBought
            .map { entry -> entry.value * entry.key.priceInCents }
            .reduce { acc, value -> acc + value }

        val reducCerises = getHalfTheQuantityOf(Product.CERISES).times(cerisesReduc)
        val reducBananes = forNBoughtOneFree(2, Product.BANANES)
        val reducMele = forNBoughtOneFree(2, Product.MELE)
        val reducApples = forNBoughtOneFree(3, Product.APPLES)
        return totalBeforeReduc - (reducCerises + reducBananes + reducMele + reducApples)
    }

    private fun getHalfTheQuantityOf(product: Product) = productsBought[product]?.div(2) ?: 0

    private fun forNBoughtOneFree(n: Int, product: Product) =
        (productsBought[product]?.div(n) ?: 0).times(product.priceInCents)
}