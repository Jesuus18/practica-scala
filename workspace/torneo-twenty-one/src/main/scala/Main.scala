object Main extends App {
    val jugadores = List("Alex", "Chen", "Marta", "Sindhu", "Luis")
    val puntuaciones = Array(18, 24, 21, 20, 26)
    val puntuacionesRonda2 = Array(22, 19, 20, 21, 17)

    def bust(puntuacion: Int): Boolean = {
        if (puntuacion > 21) {
            return true
        }
            
        else {
            return false
        }
    }

    def estadoMano(puntuacion: Int): String = {
        if (bust(puntuacion)) {
            "BUST"
        } 
        else {
            "VALIDA"
        }
    }

    def mejorMano(handA: Int, handB: Int): Int ={
        if (bust(handA) && !bust(handB)){
            return handB
        }
        else if (!bust(handA) && bust(handB)) {
            return handA
        }
        else {
            if(bust(handA) && bust(handB)){
                return 0
            }
            else if (handA > handB){
                return handA
            }
            else {
                return handB
            }
        }
    }

    var i = 0
    var manosValidas = 0
    var manosBust = 0
    var mejorPuntuacion = 0

    while(i < puntuaciones.length) {
        println(jugadores(i)+" -> "+puntuaciones(i)+" -> " +
        estadoMano(puntuaciones(i)))
        if(bust(puntuaciones(i))){
            manosBust+=1
        }
        else{
            manosValidas+=1
        }

        mejorPuntuacion = mejorMano(mejorPuntuacion, puntuaciones(i))
        i+=1
    }

    
    println("Resumen de la primera ronda")
    println("Jugadores: " + jugadores.length)
    println("Manos válidas: " + manosValidas)
    println("Bust: " + manosBust)
    println("Mejor puntuación válida: " + mejorPuntuacion +"\n")

    val mejorRonda1 = mejorPuntuacion

    i = 0
    manosValidas = 0
    manosBust = 0
    mejorPuntuacion = 0

    while(i < puntuacionesRonda2.length) {
        println(jugadores(i)+" -> "+puntuacionesRonda2(i)+" -> " +
        estadoMano(puntuacionesRonda2(i)))
        if(bust(puntuacionesRonda2(i))){
            manosBust+=1
        }
        else{
            manosValidas+=1
        }

        mejorPuntuacion = mejorMano(mejorPuntuacion, puntuacionesRonda2(i))
        i+=1
    }

    println("Resumen de la segunda ronda")
    println("Jugadores: " + jugadores.length)
    println("Manos válidas: " + manosValidas)
    println("Bust: " + manosBust)
    println("Mejor puntuación válida: " + mejorPuntuacion)

    val mejorRonda2 = mejorPuntuacion

    println("\nComparación de rondas")
    println("Mejor puntuación de la primera ronda: " + mejorRonda1)
    println("Mejor puntuación de la segunda ronda: " + mejorRonda2)

    if (mejorRonda1 > mejorRonda2) {
        println("La primera ronda tiene la mejor puntuación")
    }
    else if (mejorRonda2 > mejorRonda1) {
        println("La segunda ronda tiene la mejor puntuación")
    }
    else {
        println("Las dos rondas tienen la misma mejor puntuación")
    }

      println("\nPrimera ronda con foreach")

    puntuaciones.foreach { puntuacion =>
        println(puntuacion + " -> " + estadoMano(puntuacion))
    }

}