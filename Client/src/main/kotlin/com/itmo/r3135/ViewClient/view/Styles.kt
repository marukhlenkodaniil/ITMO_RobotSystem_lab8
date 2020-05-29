package com.itmo.r3135.ViewClient.view

import javafx.scene.Cursor
import javafx.scene.text.FontWeight
import tornadofx.*
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

        val comfortaa = loadFont("/Comfortaa-VariableFont_wght.ttf", 14)!!  //Font.font("Times New Roman")
    }

    init {
        println(comfortaa)
        label and heading {
            padding = box(100.px)
            fontSize = 100.px
            fontWeight = FontWeight.BOLD
            font = comfortaa
        }
        loginScreenButton{
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
        }
        tableView {
            font = comfortaa
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

            fontSize = 16.px
        }
        main {
            backgroundColor += backgroundcolor

        }
    }
}