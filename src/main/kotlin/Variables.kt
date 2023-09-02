import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import java.util.stream.Stream
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class Variables {

    fun ejemplo1() {
        //Se pueden declarar variables con var y val
        // Los tipos de variables primitivos se infieren automaticamente
        val nombre: String = "DanDev" // val es para definir variables constantes
        var saludo =
            "Un saludo de parte de $nombre" // var es para definir variables que pueden cambiar en tiempo de ejecución
        println(saludo)
    }

    fun ejemplo2() {
        //Tipos de variables float, double, int, boolean, Byte, Long etc.
        //Los valores primitivos pueden no especificarse al declararse porque se detectan automáticamente
        val miInt: Int = 1 // entero de 32 bits
        val miInt2 = 1

        val miDouble: Double = 2.0 // 64 bits
        //Estas 2 variables pueden ser confusas, porque si no ponemos el indicativo f se tomara por defecto como double
        val miDouble2 = 3.0
        val miFloat: Float = 3.0f

        val miByte: Byte = 127 // Entero de 8 bits (-128 127)

        val miLong: Long = 1000 // Entero de 64 bits
        val miLong2 = 1000L

        val miBoolean: Boolean = true
        val miBoolean2 = false
    }

    fun ejemplo3() {
        // Sentencia when (Switch)
        var leer: Scanner = Scanner(System.`in`)
        println("Introduzca un número entero:")
        var numero: Int = leer.nextInt()
        when (numero) {
            1 -> println("Introdujo $numero")
            2 -> println("Introdujo $numero")
            3, 5, 6, 7, 8 -> println("Introdujo valores entre 3 y 8")
            in 9..100 -> println("Introdujo valores entre 9 y 100")
            in 101..Int.MAX_VALUE -> println("Introdujo valores entre 101 y ${Int.MAX_VALUE}")
            else -> println("No introdujo un número entero")
        }
    }

    fun ejemplo4() {
        // Creando arreglos
        //val myFun = fun (init: Int) : Int = init + 1, Segundo parametro del arreglo clasico itera la cantidad de veces del tamaño del arreglo bajo su indice
        var arrayClassic: IntArray = IntArray(5) {
            println(it * 100)
            it
        }
        arrayClassic[0] = 1
        arrayClassic[1] = 2
        arrayClassic[2] = 3
        arrayClassic[3] = 4
        arrayClassic[4] = 5
        println("Array clasico:")
        arrayClassic.forEach {
            println(it)
        }
        var arrayClassic2: DoubleArray = DoubleArray(5)
        var arrayClassic3: FloatArray = FloatArray(5)
        var arrayClassic4: ByteArray = ByteArray(5)
        // Los streams solo se ejecutan cuando es necesario ser ejecutado
        val myStream: Stream<String> = Stream.of("a", "e", "i", "o", "u")
        val myStream2: Stream<Int> = Stream.empty()
        val myArray: ArrayList<Int> = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val myArray2: ArrayList<Int> = ArrayList()
        val myArraySet: Set<Int> = setOf(1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4)
        println("Mostrando un set de numeros")
        println("Cantidad de elementos: ${myArraySet.size}")
        println(myArraySet)
        println(myArray)
    }

    fun ejemplo5() {
        // Creando diccionarios
        var myMap: MutableMap<String, kotlin.Any> =
            mutableMapOf() // Lo convertimos en mutable, para poder modificar el objeto
        // var mapMutable = myMap.toMutableMap() //En caso no convirtieramos a map mutable podemos obtener un map mutable a partir del map
        myMap["Nombre"] = "Daniel" // Esta forma de agregar es recomendable en kotlin
        myMap["Alias"] = "DanDev"
        myMap.put("Edad", 30)
        myMap["Novia"] = "Erika"
        println("Imprimiendo map:")
        println(myMap)
        println("Eliminando novia...")
        myMap.remove("Novia")
        println("Imprimiendo map:")
        println(myMap)
    }

    fun ejemplo6() {
        //Bucles
        var miRango: IntRange = (1..10)
        for (numero in miRango) {
            println(numero)
        }

        // for (numero in 3..6)
        // for (numero in 3 until 6) no toma en cuenta el ultimo numero (6)
        // for (numero in 3..6 step 2) itera de 2 en 2
        // for (numero in 10 downTo 0) iteramos de manera inversa

        for (numero in 1..5) {
            println(numero)
        }
    }

    fun ejemplo7() {
        // En kotlin no existen nulos y si los hay nos da un error para esto tiene algo llamado CallSafe
        // Es decir si queremos que una variable sea nulo tenemos que informarlo antes
        var miVariablePuedeSerNula: String? = "Mi nombre ajjaja"
        println(miVariablePuedeSerNula)
        miVariablePuedeSerNula = null
        println(miVariablePuedeSerNula)

        if (miVariablePuedeSerNula != null) {
            println("Mi variable no es nula: $miVariablePuedeSerNula!!") // Los 2 signos de admiracion es cuando le indicamos al compilador que estamos seguros que esa variable no sera nula
        } else {
            println("Mi variable es nula: $miVariablePuedeSerNula")
        }
        // Otra manera de deternos al intentar operar con una variable nula, en cuanto la detecta manda null y termian cualquier operacion siguiente en linea
        println(miVariablePuedeSerNula?.length)

        // Manera ALTERNATIVA de preguntar por una variable nula y tomar acciones en las distintas alternativas
        miVariablePuedeSerNula = "Variable bien hecha tio"
        miVariablePuedeSerNula?.let {
            println(it)
        } ?: run {
            println(miVariablePuedeSerNula)
        }
    }

    fun ejemplo8() {
        // Clases
        // El constructor puede estar en el encabezado directamente
        // valores nulos pueden ser tratados desde los parametros
        // Podemos encapsular las variables o objetos con public, private, etc
        class Persona(
            val nombre: String,
            private var sexo: String,
            val edad: Int,
            var pareja: String? = "No tiene pareja"
        ) {
            fun mostrar() {
                println(
                    """
                     NOMBRE: ${nombre.uppercase()},
                     SEXO: ${sexo.uppercase()},
                     EDAD: $edad,
                     PAREJA: ${pareja!!.uppercase()}
                 """.trimIndent()
                )
            }

            fun cambiarSexoXD(sexo: String) {
                this.sexo = sexo
            }

        }
        // Los parametro val no pueden modificarse al crear un objeto, los var si
        var sho: Persona = Persona("Daniel", "Masculino", 30)
        sho.mostrar()
        sho.pareja = "Una buena mujer ;)"
        sho.mostrar()
    }

    // Clase de Enumeracion
    enum class Direccion(var dir: Int, var tr: String) {
        ESTE(1, "EAST"), OESTE(2, "WEST"), NORTE(3, "NORTH"), SUR(4, "SOUTH");

        fun traduction(): String {
            return when (this) {
                ESTE -> "this is East"
                OESTE -> "this is West"
                NORTE -> "this is North"
                else -> "this is South"
            }
        }
    }

    fun ejemplo9() {
        var miDireccion = Direccion.ESTE
        print(
            """
            name: ${miDireccion.name},
            ordinal: ${miDireccion.ordinal},
            fun: ${miDireccion.traduction()}
            param-dir: ${miDireccion.dir},
            param-tr: ${miDireccion.tr}
        """.trimIndent()
        )
    }

    //Nested Class and Inner Class
    // Clases anidadas
    class NestedClass(var nested: String? = "Nested Class") {
        fun saludoNested() {
            println("Este es un saludo de la clase $nested")
        }
    }

    inner class InnerClass(var inner: String? = "Inner Class") {
        fun saludoInner() {
            println("Este es un saludo de la clase $inner")
            println("Ejecutando ejemplo1 de la clase superior (Variables)")
            ejemplo1()
        }
    }

    fun ejemplo10() {
        // Las Nested e Inner Class necesitan llamarse a traves de la clase superior (Variables)
        // en otros ámbitos
        var nestedClass = Variables.NestedClass().saludoNested()
        // Las Inner Class a diferencia de las Nested Class pueden acceder a las varibles y funciones
        // de su clase superior.
        var innerClass = InnerClass().saludoInner()
    }

    // Herencia de clases
    open class Persona(override var nombre: String, var edad: Int) : Work(nombre) {
        open fun nombreEdad() {
            println(
                """
                NOMBRE: $nombre,
                EDAD: $edad
            """.trimIndent()
            )
        }

        override fun state() {
            println("$nombre esta vivo")
        }
    }

    class Estudiante(name: String, age: Int, var instagram: String) : Persona(name, age), Actions {
        fun mostrarInstagram() {
            println(
                """
                Instagram: ${instagram}
            """.trimIndent()
            )
        }

        override fun dormir() {
            TODO("Not yet implemented")
        }

        override fun desayunar() {
            TODO("Not yet implemented")
        }

        override fun jugar() {
            TODO("Not yet implemented")
        }

        override fun cenar() {
            TODO("Not yet implemented")
        }
    }

    fun ejemplo11() {
        var student = Estudiante("Daniel", 30, "@dannqk")
        student.nombreEdad()
        student.mostrarInstagram()
    }

    // Clases abstractas e interfaces
    // Una clase abstracta no puede ser instanciada sin embargo guarda estados, a diferencia
    // de las interfaces esta puede tener un constructor, pero solo puede ser llamado una clase abstracta
    // como herencia en cambio las interfaces pueden ser herencia multiple
    abstract class Work(open var nombre: String) {
        open fun action() {
            println("${this.nombre} esta trabajando")
        }

        open fun state() {};
    }

    interface Actions {
        fun dormir()
        fun desayunar()
        fun jugar()
        fun cenar()
    }

    // Modificadores de visibilidad encapsulamiento:
    // public(default, a cualquier parte), private(clases), protected (private+sub-classes(+ Clases Herdadas)),
    // internal (A nivel de módulo o la propia aplicación)

    // Data clases, son clases que a diferencia de cualquier otra clase tiene
    // algunas caracteristicas y fucniones especiales para la manipulación de datos

    data class Dog(var name: String, var age: Int)

    fun ejemplo13() {
        var miMascota = Dog("Lila", 4)
        var otro = Dog("Roco", 12)

        // equals and hashcode
        if (miMascota.equals(otro)) println("Son iguales")
        else println("No son iguales")

        // toString
        println(otro.toString())

        // copy
        var aux = miMascota.copy(age = 5)
        println(aux)

        // componentN
        // La desestructuracion tambien sirven para los elementos de cada Map
        // otras formas de desestructurar
        var (var1, var2) = miMascota
        var (_, variable) = Dog("Orejon", 5)
        println("Destructuracion: ${otro.component1()} y ${otro.component2()}")
        println("Destructuracion: _ y ${otro.component2()}")
        println("Destructuracion: $var1 y $var2")
    }


    fun ejemplo14() {
        // Utilizando los typealias
        var nestedClass = nestedClassAlias()
        nestedClass.saludoNested()
    }

    // EXTENSIONES
    // Podemos aplicar Modificadores de visibilidad tambien
    fun Date?.customFormat(): String? {
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        if (this != null) return formatter.format(this)
        return null
    }
    // Si elegiriamos var en vez de val tendriamos que definir tambien el set
    val Date?.formatSize: Int
        get() = this.customFormat()?.length ?: 0

    fun ejemplo15() {
        println(Date().customFormat())
        println(Date().formatSize)

        var dateNullable: Date? = null
        println(dateNullable.customFormat())
        println(dateNullable.formatSize)
    }

    // LAMBDAS
    fun ejemplo16() {
        var mylist = listOf(1,2,4,6,98,435,7,9,34)
        var mylist2 = mylist.filter {

            if (it == 2) return@filter true // Si queremos incluir el 2
            // filter se basa en una respuesta booleana para admitir los elementos dentro del filtro
            it > 9
        }
        println(mylist2)
        // Los lambdas solo sirven con funciones de primer orden, el valor retornado siempre es la ultima linea
        val sumar = fun(x: Int, y: Int) = x + y
        val producto = fun(x: Int, y: Int) = x * y

        println("Operacion suma: " + operacion(2,2, sumar))
        println("Operacionn prosucto: " + operacion(2,2, producto))
    }
    // funAritmethic lo usamos del los alias (typealias), funcion lamba de primer orden
    fun operacion (x:Int, y:Int, funAritmethic: funAritmethic): Int {
        return funAritmethic(x, y)
    }
}
typealias funAritmethic = (Int, Int) -> Int
typealias creandoUnMap = Map<String, Int>
typealias nestedClassAlias = Variables.NestedClass