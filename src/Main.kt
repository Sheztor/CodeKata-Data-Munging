import java.io.File
import kotlin.math.abs

fun main() {

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

        val valueDifference = maxTemp - minTemp

        listTempDifferences.add(Pair(day.toInt(), valueDifference))

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

        val valueDifference = abs(goalsAgainst - goalsScored)
        listGoalsDifferences.add(Pair(teamName, valueDifference))
    }

    val result = listGoalsDifferences.minBy { it.second }

    println("Team Name: ${result.first} \nMinor Difference: ${result.second}")
}