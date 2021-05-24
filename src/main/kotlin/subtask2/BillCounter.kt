package subtask2

class BillCounter {

    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val result: MutableList<Int> = bill.toMutableList()

        result.removeAt(k)
        val cost = result.sum()/2
        if (b > cost)
            return (b - cost).toString()
        return ("Bon Appetit")
    }
}
