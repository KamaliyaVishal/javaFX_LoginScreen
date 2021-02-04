package com.test.app.model

import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class APIHandler {
    private val USER_AGENT = "Mozilla/5.0"
    @Throws(Exception::class)
    fun sendingPostRequest(user: User): ErrorHandler {
        val url = "http://private-222d3-homework5.apiary-mock.com/api/login"
        val obj = URL(url)
        val con = obj.openConnection() as HttpURLConnection

        // Setting basic post request
        con.requestMethod = "POST"
        con.setRequestProperty("User-Agent", USER_AGENT)
        con.setRequestProperty("Content-Type", "application/json")
        con.setRequestProperty("IMSI", "357175048449937")
        con.setRequestProperty("IMEI", "510110406068589")
        val postJsonData = """
            {
            "username": ${user.getuName()}, "password": ${user.getuPassword()}
            }
            
            """.trimIndent()
        // Send post request
        con.doOutput = true
        val wr = DataOutputStream(con.outputStream)
        wr.writeBytes(postJsonData)
        wr.flush()
        wr.close()
        val `in` = BufferedReader(InputStreamReader(con.inputStream))
        var output: String?
        val response = StringBuffer()
        while (`in`.readLine().also { output = it } != null) {
            response.append(output)
        }
        `in`.close()
        val parse = JSONParser()
        val responseObj = parse.parse(response.toString()) as JSONObject
        val errorCode = responseObj["errorCode"].toString()
        val errorMessage = responseObj["errorMessage"].toString()
        val errorHandler = ErrorHandler()
        errorHandler.setErrorCode(errorCode)
        errorHandler.setErrorMessage(errorMessage)
        return errorHandler
    }
}