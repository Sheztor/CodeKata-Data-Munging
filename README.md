# Kata04: Data Munging :cat2:

### Language used
`Kotlin`

### IDE used
`IntelliJ IDEA Community Edition`

### Source of the problem
[Kata04: Data Munging](http://codekata.com/kata/kata04-data-munging/)

### Link to the video of my solution
:movie_camera: [YouTube](https://youtu.be/6lMhFVaxHK4)

## Objective :round_pushpin: 
The goal is to read data from `.dat` files in order to perform some actions based on the obtained information.

### Kotlin code to read a file :book:
``` Kotlin
// File is a class in Java.
import java.io.File

val file = File("./src/weather.dat") // The same for the file football.dat.

val listOfLines = file.readLines() // File has many functions, not just this.
```

## After downloading this repository :arrow_down:

#### Run from the IDE (Recommended)
Use the IDE of your preference. I used `IntelliJ IDEA Community Edition`. You can download it from the official website [here.](https://www.jetbrains.com/idea/download/)

#### You can run it with the following command. 
```
kotlinc Main.kt
```
But for this, you need to have the Kotlin command-line compiler installed. You can find the official tutorial [here.](https://kotlinlang.org/docs/command-line.html)

Similarly, you can also check out the[`Get started with Kotlin`](https://kotlinlang.org/docs/getting-started.html)guide.