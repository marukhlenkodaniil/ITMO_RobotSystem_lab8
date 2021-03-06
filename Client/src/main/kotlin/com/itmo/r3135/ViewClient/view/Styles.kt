package com.itmo.r3135.ViewClient.view

import javafx.scene.image.Image
import javafx.scene.text.FontWeight
import tornadofx.*
import tornadofx.FX.Companion.primaryStage
import tornadofx.WizardStyles.Companion.heading

class Styles : Stylesheet() {
    companion object {
        val main by cssclass()
        val loginScreen by cssclass()
        val productsSearch by cssclass()
        val addform by cssclass()
        val table by cssclass()

        val loginScreenButton by cssclass()
        val maingreedpane by cssclass()

        val red by cssclass()
        val green by cssclass()

        val backgroundcolor = c("#91ff91")
        val redcolor = c("#eb1919")
        val greencolor = c("#19eb19")

        val comfortaa = loadFont("/Comfortaa-VariableFont_wght.ttf", 12)!!  //Font.font("Times New Roman")
    }

    init {
        primaryStage.icons.add(Image(this.javaClass.classLoader.getResource("icon.png").toString()))
        label and heading {
            padding = box(100.px)
            fontSize = 40.px
            fontWeight = FontWeight.BOLD
            font = comfortaa
        }
        loginScreenButton {
            startMargin = 10.px
            endMargin = 10.px
            maxWidth = 200.px
            minWidth = maxWidth
        }
        red {
            backgroundColor += redcolor
        }
        green {
            backgroundColor += greencolor
        }
        addform {
            padding = box(25.px)
            prefWidth = 450.px
            backgroundColor += backgroundcolor
        }
        fieldset {
            font = comfortaa
        }
        field {
            font = comfortaa
        }
        textField {
            font = comfortaa
        }
        button {
            font = comfortaa
            fontSize = 14.px
        }
        tableView {
            font = comfortaa
            fontSize = 12.px
        }
        loginScreen {
            backgroundColor += backgroundcolor
            padding = box(15.px)
            vgap = 50.px
            hgap = 50.px
            font = comfortaa
        }
        productsSearch {
            padding = box(15.px)
            vgap = 10.px
            hgap = 10.px
            font = comfortaa

        }
        table {

            fontSize = 12.px
        }
        main {
            backgroundColor += backgroundcolor

        }
    }
}