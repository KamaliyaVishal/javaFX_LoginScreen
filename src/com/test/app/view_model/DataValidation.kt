package com.test.app.view_model

import javafx.scene.control.Label
import javafx.scene.control.PasswordField

object DataValidation {
    @JvmStatic
    fun TextFieldNotEmpty(stringField: String?): Boolean {
        //returning string fields empty as default value
        var returnVal = false
        if (stringField != null && !stringField.isEmpty()) {
            returnVal = true
        }
        return returnVal
    }

    @JvmStatic
    fun TextFieldNotEmpty(stringField: String?, label: Label, validationText: String?) {
        if (!TextFieldNotEmpty(stringField)) {
            label.text = validationText
        }
    }
    @JvmStatic
    fun PasswordFieldNotEmpty(passwordField: PasswordField): Boolean {
        //returning integer fields empty as default value
        var returnVal = false
        if (passwordField.text != null && !passwordField.text.isEmpty()) {
            returnVal = true
        }
        return returnVal
    }
    @JvmStatic
    fun PasswordFieldNotEmpty(passwordField: PasswordField, label: Label, validationText: String?) {
        if (!PasswordFieldNotEmpty(passwordField)) {
            label.text = validationText
        }
    }

    //checking for maximum length
    @JvmStatic
    fun isValidMaximumLength(data: String, maxLength: Int): Boolean {
        var returnVal = true
        if (data.length > maxLength) {
            returnVal = false
        }
        return returnVal
    }

    @JvmStatic
    fun isValidMaximumLength(data: String, maxLength: Int, label: Label, validationText: String?) {
        if (!isValidMaximumLength(data, maxLength)) {
            label.text = validationText
        }
    }
}