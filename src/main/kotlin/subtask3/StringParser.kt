package subtask3

class StringParser {

    val openBrackets: Array<Char> = arrayOf('(', '[', '<')
    val closeBrackets: Array<Char> = arrayOf(')', ']', '>')
    val countBrackets: Array<Int> = arrayOf(0, 0, 0)

    fun getResult(inputString: String): Array<String> {
        val result: MutableList<String> = mutableListOf<String>()
        var start = 0
        var index = 0
        var lookPair: Pair<Boolean, Char> = false to '0'
        while (index < inputString.length) {
            val ch = inputString[index]
            val openId = openBrackets.indexOf(ch)
            val closeId = closeBrackets.indexOf(ch)
            if (openId != -1) {
                countBrackets[openId]++
                if (!lookPair.first) {
                    lookPair = true to closeBrackets[openBrackets.indexOf(ch)]
                    start = index + 1
                }
            }
            else if (closeId != -1) {
                if (lookPair == true to ch && --countBrackets[closeId] == 0) {
                    result.add(inputString.substring(start, index))
                    index = start - 1
                    lookPair = false to '0'
                    countBrackets.fill(0)
                }
            }
            index++
        }
        return result.toTypedArray()
    }
}
