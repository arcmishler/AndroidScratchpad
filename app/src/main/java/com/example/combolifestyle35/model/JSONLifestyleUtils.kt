package com.example.combolifestyle35.model

import kotlin.Throws
import org.json.JSONException
import org.json.JSONObject


//Declare methods as static. We don't want to create objects of this class.
object JSONUserUtils {
    @Throws(JSONException::class)
    fun getUserData(data: String?): UserData {
        val userData = UserData()

        //Start parsing JSON data
        val jsonObject = JSONObject(data!!) //Must throw JSONException
        val user = userData.user
        val jsonMain = jsonObject.getJSONObject("main")
        user.id = jsonMain.getInt("id")
        user.name = jsonMain.getString("name").toString()
        user.loc = jsonMain.getString("location").toString()
        user.age = jsonMain.getInt("age")
        user.sex = jsonMain.getString("sex").toString()
        user.activityLvl = jsonMain.getString("activityLvl").toString()
        user.weight = jsonMain.getInt("weight")
        userData.user = user

        return userData
    }
}

//Declare methods as static. We don't want to create objects of this class.
//object JSONWeatherUtils {
//    @Throws(JSONException::class)
//    fun getWeatherData(data: String?): WeatherData {
//        val weatherData = WeatherData()
//
//        //Start parsing JSON data
//        val jsonObject = JSONObject(data!!) //Must throw JSONException
//        val currentCondition = weatherData.currentCondition
//        val jsonMain = jsonObject.getJSONObject("main")
//        currentCondition.humidity = jsonMain.getInt("humidity").toDouble()
//        currentCondition.pressure = jsonMain.getInt("pressure").toDouble()
//        weatherData.currentCondition = currentCondition
//
//        //Get the temperature, wind and cloud data.
//        val temperature = weatherData.temperature
//        val wind = weatherData.wind
//        val clouds = weatherData.clouds
//        temperature.maxTemp = jsonMain.getDouble("temp_max")
//        temperature.minTemp = jsonMain.getDouble("temp_min")
//        temperature.temp = jsonMain.getDouble("temp")
//        weatherData.temperature = temperature
//        return weatherData
//    }
//}