package view

import tornadofx.*

class Interface : View("My View") {
    override val root = stackpane {
        prefHeight = 800.0
        prefWidth = 80.0
        gridpane {
            row {
                button("+") {
                    tooltip("add new object")
                    prefHeight = 50.0
                    prefWidth = 80.0
                    gridpaneConstraints {
                        marginTop = 10.0
                        marginLeft = 10.0
                    }
                    action {
                        //action
                    }
                }
            }
            row {
                button("-") {
                    tooltip("remove object")
                    prefHeight = 50.0
                    prefWidth = 80.0
                    gridpaneConstraints {
                        marginTop = 2.0
                        marginLeft = 10.0
                    }
                    action {
                        //action
                    }
                }
            }
            row {
                button("button") {
                    tooltip("remove object")
                    prefHeight = 50.0
                    prefWidth = 80.0
                    gridpaneConstraints {
                        marginTop = 2.0
                        marginLeft = 10.0
                    }
                    action {
                        //action
                    }
                }
            }
        }
    }
}