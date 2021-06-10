

fun main() {
    val cashRegister = CashRegister()
    val productParser = ProductParser()

    while(true) {
        val input = readLine()
        val products = productParser.fromString(input)

        for (product in products) {
            cashRegister.addProduct(product)
        }

        println(cashRegister.getTotalPrice())
    }

}