package com.example.newsapp.Common

import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Response

abstract class SafeApiCall {

//    This method is used make the api Call safely , fun can be any type , and it has a parametere with a
//    function , when we are using this safeAPIRequest we need to pass a function iside thss function which has
//    a return type of any. if succecfull we are paring the body if nt we are modifing the response
//


   suspend fun <T: Any> safeApiRequest(call: suspend()-> Response<T>): T {
   val response = call.invoke()
      if (response.isSuccessful){
         return response.body()!!
      }
      else{
          val errorbody = response.errorBody().toString()
          val message= StringBuilder()
          try {
              errorbody.let {
                  message.append(JSONObject(it).getString("error"))
              }

          }catch (e: Exception){
              e.message
          }
          throw Exception(message.toString())
      }

  }
}