package com.test.app.view_model

import com.test.app.model.APIHandler
import com.test.app.model.ErrorHandler
import com.test.app.model.User
import com.test.app.view.home.HomeController
import com.test.app.view.login.LoginController
import javafx.fxml.FXMLLoader
import javafx.scene.layout.AnchorPane
import java.io.IOException

class UserViewModel {
    fun userValidate(user: User?) {
        val apiHandler = APIHandler()
        val errorHandler: ErrorHandler
        try {
            errorHandler = apiHandler.sendingPostRequest(user!!)
            if (errorHandler.validateErrorCode()) {
                LoginController.staticErrorHandler = errorHandler
                LoginController.staticUser = user
            } else {
                AlertPopUP.noRecordFound(errorHandler)
            }
        } catch (ex: Exception) {
            AlertPopUP.generalError(ex)
        }
    }

    fun loadHome(rootpane: AnchorPane, mode: String?) {
        try {
            val pane = FXMLLoader.load<AnchorPane>(javaClass.getResource("/com/test/app/view/home/home.fxml"))
            HomeController.mode = mode
            rootpane.children.setAll(pane)
        } catch (ex: IOException) {
            AlertPopUP.generalError(ex)
        }
    }
}