package pl.droidsonroids.sunny.model

class WeatherState(var state: State,
                   var title: Int,
                   var value: String) {

    enum class State {
        TEMPERATURE, HUMIDITY, WIND, PRESSURE, VISIBILITY, SUNRISE, SUNSET
    }
}

