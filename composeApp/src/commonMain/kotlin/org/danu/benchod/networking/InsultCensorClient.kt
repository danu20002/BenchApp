package org.danu.benchod.networking

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.statement.bodyAsText
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import org.danu.benchod.utils.NetworkError

class InsultCensorClient(private val httpClient: HttpClient) {
    suspend fun censorWords(uncensored:String):Result<String,NetworkError>{
       val response= try {
           httpClient.get(
               urlString = "https://www.purgomalum.com/service/json"
           ){
               parameter("text",uncensored)
           }

       }catch (e: UnresolvedAddressException){
           return org.danu.benchod.utils.Result.Error(NetworkError.NO_INTERNET)
       }catch (e:SerializationException){
           return org.danu.benchod.utils.Result.Error(NetworkError.SERIALIZATION)
       }
        return when(response.status.value){
            in 200..299 -> {
                val censoredText=response.body<CensoredText>)
                Result.success(censoredText.censoredText)
            }
            else -> org.danu.benchod.utils.Result.Error(NetworkError.UNKNOWN)
        })
    }
}