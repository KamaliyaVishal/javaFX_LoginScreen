package com.test.app.model

import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty

class ErrorHandler {
    var errorCode: StringProperty? = null
    var errorMessage: StringProperty? = null
    fun getErrorCode(): String {
        return errorCode!!.get()
    }

    fun setErrorCode(errorCode: String?) {
        this.errorCode = SimpleStringProperty(errorCode)
    }

    fun getErrorMessage(): String {
        return errorMessage!!.get()
    }

    fun setErrorMessage(errorMessage: String?) {
        this.errorMessage = SimpleStringProperty(errorMessage)
    }

    //if the API response is 0 return -> true
    //as API not working properly, can check the app with changing bellow getErrorCode() value to "01"
    fun validateErrorCode(): Boolean {
        return if (getErrorCode() == "00") {
            true
        } else {
            false
        }
    }
}