package com.test.app.model

import javafx.beans.property.StringProperty
import javafx.beans.property.SimpleStringProperty

class User {
    private var uID: StringProperty? = null
    private var uName: StringProperty? = null
    private var uPassword: StringProperty? = null

    constructor(uID: String?, uName: String?, uPassword: String?) {
        this.uID = SimpleStringProperty(uID)
        this.uName = SimpleStringProperty(uName)
        this.uPassword = SimpleStringProperty(uPassword)
    }

    constructor(uName: String?, uPassword: String?) {
        this.uName = SimpleStringProperty(uName)
        this.uPassword = SimpleStringProperty(uPassword)
    }

    constructor() {}

    fun getuName(): String {
        return uName!!.get()
    }

    fun setuName(uName: String?) {
        this.uName = SimpleStringProperty(uName)
    }

    fun getuPassword(): String {
        return uPassword!!.get()
    }

    fun setuPassword(uPassword: String?) {
        this.uPassword = SimpleStringProperty(uPassword)
    }
}