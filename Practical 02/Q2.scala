object VariableDeclarations {
  def main(args: Array[String]): Unit = {
    var a = 2
    var b = 3
    var c = 4
    var d = 5
    var k = 4.3f
    var g = 0.0f
    
    b -= 1
    d -= 1
    val Aresult = b * a + c * d
    println(s"a) $Aresult")
    
    println(s"b) $a")
    a += 1
    
    val Cresult = -2 * (g - k) + c
    println(s"c) $Cresult")
    
    val Dresult = c
    println(s"d) $Dresult")
    c += 1
    
    c += 1
    val temp = c * a
    a += 1
    println(s"e) $temp")
    
    println(s"Final values: a = $a, b = $b, c = $c, d = $d, k = $k, g = $g")
  }
}
