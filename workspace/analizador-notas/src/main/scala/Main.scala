object Main extends App{
  val estudiantes = List("Ana", "Luis", "Marta", "Pedro", "Sofia")
  val notas = Array(8, 4, 10, 6, 3)
  val notasSegundaEvaluacion = Array(9, 5, 8, 7, 6)


  def aprobado(nota: Int): Boolean = {
    if (nota >= 5){
      return true
    }
    else {
      return false
    }
  }
  def estadoNota (nota: Int): String = {
    if (aprobado(nota)){
      return "APROBADO"
    }
    else {
      return "SUSPENSO"
    }
  }

  def maxNota(a: Int, b: Int): Int = {
    if (a > b){
      return a
    }
    else if (a < b){
      return b
    }
    else {
      return a
    }
  }

  var i = 0
  var aprobados = 0
  var suspensos = 0
  var mejorNota = 0

  while (i < notas.length){
    println(estudiantes(i) + " -> " +notas(i) +" -> " +estadoNota(notas(i)))
    if (aprobado(notas(i))){
      aprobados += 1
    }
    else {
      suspensos += 1
    }
    mejorNota = maxNota(mejorNota, notas(i))
    i += 1
  }

  println("Resumen del grupo")
  println("Estudiantes: " + estudiantes.length)
  println("Aprobados: " + aprobados)
  println("Suspensos: " + suspensos)
  println("Mejor nota: " + mejorNota)

  def clasificacion(nota: Int): String = {
    if (nota >= 9) {
      return "EXCELENTE"
    }
    else if (nota >= 7) {
      return "NOTABLE"
    }
    else if (nota >= 5) {
      return "APROBADO"
    }
    else {
      return "SUSPENSO"
    }
  }

  println("\nClasificación de la primera evaluación")

  i = 0

  while (i < notas.length) {
    println(estudiantes(i) + " -> " + notas(i) + " -> " + clasificacion(notas(i)))
    i += 1
  }

  val aprobadosPrimera = aprobados
  val mejorNotaPrimera = mejorNota

  i = 0
  aprobados = 0
  suspensos = 0
  mejorNota = 0

  println("\nSegunda evaluación")

  while (i < notasSegundaEvaluacion.length) {
    println(estudiantes(i) + " -> " + notasSegundaEvaluacion(i) + " -> " + estadoNota(notasSegundaEvaluacion(i)))

    if (aprobado(notasSegundaEvaluacion(i))) {
      aprobados += 1
    }
    else {
      suspensos += 1
    }

    mejorNota = maxNota(mejorNota, notasSegundaEvaluacion(i))
    i += 1
  }

  println("Resumen de la segunda evaluación")
  println("Estudiantes: " + estudiantes.length)
  println("Aprobados: " + aprobados)
  println("Suspensos: " + suspensos)
  println("Mejor nota: " + mejorNota)

  println("\nComparación de evaluaciones")
  println("Mejor nota de la primera: " + mejorNotaPrimera)
  println("Mejor nota de la segunda: " + mejorNota)
  println("Aprobados en la primera: " + aprobadosPrimera)
  println("Aprobados en la segunda: " + aprobados)

  if (aprobados > aprobadosPrimera) {
    println("El grupo ha mejorado")
  }
  else if (aprobados < aprobadosPrimera) {
    println("El grupo ha empeorado")
  }
  else {
    println("El grupo se ha mantenido igual")
  }

  val nuevosEstudiantes = "Carlos" :: estudiantes

  println("\nLista original: " + estudiantes)
  println("Lista nueva: " + nuevosEstudiantes)
}