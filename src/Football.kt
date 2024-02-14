import java.io.File
import kotlin.math.abs

fun main(){
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