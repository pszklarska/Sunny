package pl.droidsonroids.sunny.data

import pl.droidsonroids.sunny.model.Weather
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    companion object {
        fun create(): RestApi = Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build().create(RestApi::class.java)
    }

    @GET("weather")
    fun checkWeatherByCityName(@Query("q") city: String, @Query("APPID") appId: String,
                               @Query("units") units: String): Call<Weather>
}
