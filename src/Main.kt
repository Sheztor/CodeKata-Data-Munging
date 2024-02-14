import java.io.File
import kotlin.math.abs

fun main() {
    weather()
    football()
}

fun process(file: File, nameProgram: String): Pair<String, Int> {
    val listOfLines = file.readLines()
    val listTempDifferences = mutableListOf<Pair <String, Int>>()

    val indexList1 = if (nameProgram == "weather") 0 else 1
    val indexList2 = if (nameProgram == "weather") 1 else 6
    val indexList3 = if (nameProgram == "weather") 2 else 7

    for(line in listOfLines){
        var lineTrim = line.trim()
        lineTrim = lineTrim.replace("-", "")

        if(lineTrim.startsWith("Dy") || lineTrim.startsWith("Team") || lineTrim == "") continue
        val valuesLine = lineTrim.split("\\s+".toRegex())

        if (nameProgram == "weather") {
            if(valuesLine[0].toIntOrNull() == null) continue
        }

        val element = valuesLine[indexList1]
        val value1 = valuesLine[indexList2].filter { it.isDigit() }.toInt()
        val value2 = valuesLine[indexList3].filter { it.isDigit() }.toInt()

        listTempDifferences.add(Pair(element, abs(value1 - value2)))
    }

    val result = listTempDifferences.minBy { it.second }
    return result
}

fun weather(){
    val file = File("./src/weather.dat")
    val result = process(file, "weather")

    println("Number Day: ${result.first} \nMinor Difference : ${result.second}")
}

fun football(){
    val file = File("./src/football.dat")
    val result = process(file, "football")

    println("Team Name: ${result.first} \nMinor Difference: ${result.second}")
}