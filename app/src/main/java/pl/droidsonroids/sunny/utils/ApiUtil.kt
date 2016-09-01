package pl.droidsonroids.sunny.utils

import pl.droidsonroids.sunny.R
import pl.droidsonroids.sunny.model.Weather
import pl.droidsonroids.sunny.model.WeatherState
import java.text.SimpleDateFormat
import java.util.*

object ApiUtil {
    val TEMPERATURE_UNIT = "\u00B0C"
    val HUMIDITY_UNIT = "%"
    val PRESSURE_UNIT = "hPa"
    val VISIBILITY_UNIT = "m"

    val DATE_FORMAT_PATTERN = "HH:mm"

    fun copyWeatherToWeatherStateList(weather: Weather): List<WeatherState> {
        val weatherInfoList = ArrayList<WeatherState>()
        weatherInfoList.add(WeatherState(WeatherState.State.TEMPERATURE,
                R.string.temperature,
                weather.main.temp + TEMPERATURE_UNIT))
        weatherInfoList.add(WeatherState(WeatherState.State.HUMIDITY,
                R.string.humidity,
                weather.main.humidity + HUMIDITY_UNIT))
        weatherInfoList.add(WeatherState(WeatherState.State.PRESSURE,
                R.string.pressure,
                weather.main.pressure + PRESSURE_UNIT))
        weatherInfoList.add(WeatherState(WeatherState.State.VISIBILITY,
                R.string.visibility,
                weather.visibility + VISIBILITY_UNIT))
        weatherInfoList.add(WeatherState(WeatherState.State.SUNRISE,
                R.string.sunrise,
                getDateFromMillis(weather.sys.sunrise)))
        weatherInfoList.add(WeatherState(WeatherState.State.SUNSET,
                R.string.sunset,
                getDateFromMillis(weather.sys.sunset)))
        return weatherInfoList
    }

    private fun getDateFromMillis(millis: String): String {
        return SimpleDateFormat(DATE_FORMAT_PATTERN, Locale.getDefault()).format(millis.toLong() * 1000)
    }
}
