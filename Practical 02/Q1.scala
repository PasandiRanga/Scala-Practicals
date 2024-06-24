object Variables {
  def main(args: Array[String]): Unit = {
    var i, j, k = 2
    var m, n = 5
    var f = 12.0f
    var g = 4.0f
    var c = 'X'

    println(s"i = $i, j = $j, k = $k")
    println(s"m = $m, n = $n")
    println(s"f = $f, g = $g")
    println(s"c = $c")

    val a = k + 12 * m
    val b = m / j
    val cResult = n % j
    val d = m / j * j
    val e = f + 10 * 5 + g
    i += 1 
    val fResult = i * n

    println(s"a) k + 12 * m = $a")
    println(s"b) m / j = $b")
    println(s"c) n % j = $cResult")
    println(s"d) m / j * j = $d")
    println(s"e) f + 10*5 + g = $e")
    println(s"f) ++i * n = $fResult")
  }
}
  