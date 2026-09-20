# Mini proyecto 3.2: Analizador de notas

Analizamos las notas de cinco estudiantes en dos evaluaciones. Mostramos los aprobados, los suspensos y la mejor nota de cada evaluación. Después comparamos el número de aprobados para ver cómo evoluciona el grupo.

## Proyecto en IntelliJ

Creamos `analizador-notas` como proyecto Scala con sbt en IntelliJ IDEA. En `build.sbt` configuramos Scala 2.12.21 y el nombre del proyecto. El archivo `project/build.properties` indica sbt 1.10.3.

![Proyecto analizador-notas abierto y configuración de build.sbt](../../images/59-notas-proyecto.png)

En `Project Structure > Project` comprobamos que el SDK seleccionado es Zulu 17. Dejamos el nivel de lenguaje en `SDK default`.

![Zulu 17 seleccionado para analizador-notas](../../images/60-notas-jdk17.png)

En `Settings > Plugins > Installed` comprobamos que el complemento Scala 2024.3.35 está instalado y habilitado. Aparece con la casilla marcada y el botón `Disable`.

![Complemento Scala instalado y habilitado en IntelliJ](../../images/61-notas-plugin-scala.png)

## Organización y funciones

El código está en [src/main/scala/Main.scala](src/main/scala/Main.scala) dentro de `object Main extends App`. Guardamos los nombres en una `List` y las notas de cada evaluación en un `Array`. Usamos la misma posición para relacionar cada estudiante con su nota.

`aprobado` devuelve un Boolean que indica si la nota llega a 5. `estadoNota` usa esa función para devolver el texto del resultado. `maxNota` compara dos notas con `if` y devuelve la mayor. Si son iguales devuelve la primera.

![Datos y funciones del programa](../../images/70-notas-funciones.png)

## Primera evaluación

Recorremos los estudiantes y sus notas con un `while`. Usamos `estadoNota` para mostrar si aprueban o suspenden y contamos cuántos hay de cada grupo. En cada vuelta actualizamos la mejor nota con `maxNota`.

Al ejecutar el programa con sbt desde la terminal de IntelliJ obtenemos 5 estudiantes, 3 aprobados y 2 suspensos. La mejor nota es el 10 de Marta.

![Primera evaluación y resumen ejecutados desde la terminal](../../images/62-notas-primera-evaluacion.png)

## Clasificación de las notas

La función `clasificacion` comprueba las notas de mayor a menor con `if`, `else if` y `else`. Para notas de 0 a 10 devuelve `EXCELENTE` desde 9, `NOTABLE` desde 7, `APROBADO` desde 5 y `SUSPENSO` por debajo de 5.

Reiniciamos `i` y recorremos las notas para mostrar esta clasificación junto al nombre. Ana obtiene NOTABLE, Marta EXCELENTE y Pedro APROBADO. Luis y Sofia tienen SUSPENSO.

![Clasificación de los cinco estudiantes con ejecución correcta](../../images/63-notas-clasificacion.png)

![Recorrido de la primera evaluación y clasificación](../../images/71-notas-primera-clasificacion-codigo.png)

## Segunda evaluación

Guardamos los aprobados y la mejor nota de la primera evaluación antes de poner los contadores a cero. Recorremos `notasSegundaEvaluacion` con los mismos nombres y funciones.

En la segunda evaluación aprueban los cinco estudiantes y no hay suspensos. La mejor nota es el 9 de Ana.

![Resultados y resumen de la segunda evaluación](../../images/64-notas-segunda-evaluacion.png)

![Clasificación y recorrido de la segunda evaluación](../../images/72-notas-segunda-codigo.png)

## Comparación de evaluaciones

Comparamos el número de aprobados con `if`, `else if` y `else`. El grupo pasa de 3 a 5 aprobados, así que mostramos que ha mejorado. Aunque la mejor nota baja de 10 a 9, el criterio para decidir la mejora es el número de aprobados.

![Comparación de evaluaciones y mejora del grupo](../../images/65-notas-comparacion.png)

## Lista original y lista nueva

Con `"Carlos" :: estudiantes` creamos una lista nueva con Carlos al principio. La lista original sigue teniendo los mismos cinco nombres porque `List` es inmutable. Mostramos las dos listas para comprobar la diferencia.

![Lista original y lista nueva con Carlos al principio](../../images/66-notas-listas.png)

![Resumen, comparación y creación de la lista nueva](../../images/73-notas-comparacion-listas-codigo.png)

## Compilación

Ejecutamos `sbt compile` desde la terminal de IntelliJ. El comando termina con `[success]`.

![Compilación correcta del analizador de notas](../../images/67-notas-compilacion.png)

## Ejecución

Al ejecutar el programa obtenemos 3 aprobados en la primera evaluación y 5 en la segunda. Mostramos las clasificaciones, la comparación y las dos listas. La ejecución termina con `[success]`.

![Comando sbt run y comienzo de la ejecución](../../images/69-notas-ejecucion-inicio.png)

![Resultados finales del analizador de notas](../../images/68-notas-ejecucion-final.png)

## Problemas y soluciones

Al principio la mejor nota aparece como 0 porque falta actualizarla dentro del bucle. Añadimos `mejorNota = maxNota(mejorNota, notas(i))` antes de aumentar el contador. Al repetir la ejecución obtenemos 10.

Al arrancar sbt desde la terminal aparece un error de bloqueo y pregunta si queremos crear otro servidor. Detenemos la sbt shell de IntelliJ que está abierta para el mismo proyecto. Al ejecutar de nuevo `sbt compile` termina correctamente y ya no aparece esa pregunta.
