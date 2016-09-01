package pl.droidsonroids.sunny.data

import pl.droidsonroids.sunny.model.Weather
import pl.droidsonroids.sunny.utils.Constants
import retrofit2.Call

object ApiManager {

    var apiAdapter: RestApi = RestApi.create()

    fun checkWeatherByCity(cityName: String): Call<Weather> {
        return apiAdapter.checkWeatherByCityName(cityName, Constants.APP_ID, Constants.UNITS)
    }

}