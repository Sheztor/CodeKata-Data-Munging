import java.io.File
import kotlin.math.abs

fun main() {

}

fun process(file: File, nameProgram: String): Pair<String, Int> {
    val listOfLines = file.readLines()
    val listTempDifferences = mutableListOf<Pair <String, Int>>()

    val value1 = if (nameProgram == "weather") 0 else 1
    val value2 = if (nameProgram == "weather") 1 else 6
    val value3 = if (nameProgram == "weather") 2 else 7

    for(line in listOfLines){
        var lineTrim = line.trim()
        lineTrim = lineTrim.replace("-", "")

        if(lineTrim.startsWith("Dy") || lineTrim.startsWith("Team") || lineTrim == "") continue
        val valuesLine = lineTrim.split("\\s+".toRegex())

        if (nameProgram == "weather") {
            if(valuesLine[0].toIntOrNull() == null) continue
        }

        val day = valuesLine[value1]
        val maxTemp = valuesLine[value2].filter { it.isDigit() }.toInt()
        val minTemp = valuesLine[value3].filter { it.isDigit() }.toInt()

        listTempDifferences.add(Pair(day, Differences(maxTemp, minTemp)))
    }

    val result = listTempDifferences.minBy { it.second }
    return result
}

fun Differences(value1: Int, value2: Int): Int{

    return abs(value1 - value2)
}

fun weather(){
    val file = File("./src/weather.dat")

    val listOfLines = file.readLines()
    val listTempDifferences = mutableListOf<Pair <Int, Int>>()

    for(line in listOfLines){
        val lineTrim = line.trim()

        if(lineTrim.startsWith("Dy") || lineTrim == "") continue

        val valuesLine = lineTrim.split("\\s+".toRegex())

        if(valuesLine[0].toIntOrNull() == null) continue

        val day = valuesLine[0]
        val maxTemp = valuesLine[1].filter { it.isDigit() }.toInt()
        val minTemp = valuesLine[2].filter { it.isDigit() }.toInt()

        listTempDifferences.add(Pair(day.toInt(), Differences(maxTemp, minTemp)))

    }

    val result = listTempDifferences.minBy { it.second }

    println("Number Day: ${result.first} \nMinor Difference : ${result.second}")
}

fun football(){
    val file = File("./src/football.dat")

    val listOfLines = file.readLines()
    val listGoalsDifferences = mutableListOf<Pair <String, Int>>()

    for(line in listOfLines) {
        var lineTrim = line.trim()

        lineTrim = lineTrim.replace("-", "")
        if(lineTrim.startsWith("Team") || lineTrim == "") continue

        val valuesLine = lineTrim.split("\\s+".toRegex())

        val teamName = valuesLine[1]
        val goalsAgainst = valuesLine[6].filter { it.isDigit() }.toInt()
        val goalsScored = valuesLine[7].filter { it.isDigit() }.toInt()

        listGoalsDifferences.add(Pair(teamName, Differences(goalsAgainst, goalsScored)))
    }

    val result = listGoalsDifferences.minBy { it.second }

    println("Team Name: ${result.first} \nMinor Difference: ${result.second}")
}