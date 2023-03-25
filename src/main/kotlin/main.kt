package ru.netology

fun main() {
    val time = 720
    val userName = "Alex"

    agoToText(time, userName)
}

fun agoToText(time: Int, userName: String) = when (time) {
    in 0..59 -> println("$userName был(а) в сети только что")
    in 60..3_599 -> println("$userName был(а) в сети ${minutes(time)} назад")
    in 3_600..86_399 -> println("$userName был(а) в сети ${hours(time)} назад")
    in 86_400..172_799 -> println("$userName был(а) в сети вчера")
    in 172_800..259_199 -> println("$userName был(а) в сети позавчера")
    else -> println("$userName был(а) в сети давно")
}

fun minutes(time: Int): String {
    val numberOfMinutes = time / 60

    var minutesEnding = numberOfMinutes % 100
    when (minutesEnding) {
        in 11..14 -> return "$numberOfMinutes минут"
    }

    minutesEnding = numberOfMinutes % 10
    when (minutesEnding) {
        1 -> return "$numberOfMinutes минуту"
        2, 3, 4 -> return "$numberOfMinutes минуты"
        else -> return "$numberOfMinutes минут"
    }
    return "error"
}

fun hours(time: Int): String {
    val numberOfHours = time / 3600

    var hoursEnding = numberOfHours % 100
    when (hoursEnding) {
        in 11..14 -> return "$numberOfHours часов"
    }

    hoursEnding = numberOfHours % 10
    when (hoursEnding) {
        1 -> return "$numberOfHours час"
        2, 3, 4 -> return "$numberOfHours часа"
        else -> return "$numberOfHours часов"
    }
    return "error"
}

