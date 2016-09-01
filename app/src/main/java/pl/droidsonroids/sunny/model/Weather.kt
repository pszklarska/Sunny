package pl.droidsonroids.sunny.model

data class Weather(
        val main: Main,
        val name: String,
        val sys: Sys,
        val weather: List<WeatherModel>,
        val visibility: String) {

    data class Main(
            val temp: String,
            val humidity: String,
            val pressure: String
    )

    data class Sys(
            val sunrise: String,
            val sunset: String
    )

    data class WeatherModel(
            val main: String
    )
}

