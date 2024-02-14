import java.io.File

fun main() {
    val file = File("./src/weather.dat")

    val listOfLines = file.readLines()

    for(line in listOfLines){
        val lineTrim = line.trim()

        if(lineTrim.startsWith("Dy") || lineTrim == "") continue

        val valuesLine = lineTrim.split("\\s+".toRegex())
        
        if(valuesLine[0].toIntOrNull() == null) continue

        val day = valuesLine[0]
        val maxTemp = valuesLine[1].filter { it.isDigit() }.toInt()
        val minTemp = valuesLine[2].filter { it.isDigit() }.toInt()

        println("Day: $day \nMax: $maxTemp \nMin: $minTemp \n")

        spread(maxTemp, minTemp)
    }
}

fun spread(maxTemp: Int, minTemp: Int){

}