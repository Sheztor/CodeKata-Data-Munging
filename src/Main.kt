import java.io.File

fun main() {
    val file = File("./src/weather.dat")

    val listOfLines = file.readLines()

    for(line in listOfLines){
        val lineTrim = line.trim()

        if(lineTrim.startsWith("Dy") || lineTrim == "") continue

        val valuesLine = lineTrim.split("\\s+".toRegex())

        val day = valuesLine[0]
        val maxTemp = valuesLine[1]
        val minTemp = valuesLine[2]

        println("Day: $day \nMax: $maxTemp \nMin: $minTemp")
    }
}