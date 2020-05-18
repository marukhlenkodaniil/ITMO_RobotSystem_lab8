package com.itmo.r3135.view


import tornadofx.*
import view.Interface
import view.ProductsMap
import view.ProductsTable
import view.Toolbar

class MainView : View("DataBase") {

    override val root = borderpane() {
        prefHeight = 900.0
        prefWidth = 1600.0
        top(Toolbar::class)
        left(Interface::class)

//        add<ProductsMap>()
        center(gridpane {
            row { add<ProductsMap>() }
            row { add<ProductsTable>() }

        })

        //left(BottomView::class)
        //addClass(Styles.main)
    }

}