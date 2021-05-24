package subtask1

class HappyArray {

	fun convertToHappy(sadArray: IntArray): IntArray {
		val result: MutableList<Int> = sadArray.toMutableList()

		var k = 1
		while (k < result.size - 1) {
			if (result[k - 1] + result[k + 1] < result[k]) {
				result.removeAt(k)
				if (k > 1) k--
			} else k++
		}
		return result.toIntArray()
	}
}
