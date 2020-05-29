package view.WorkView

import com.itmo.r3135.System.Command
import com.itmo.r3135.System.CommandList
import com.itmo.r3135.World.Color
import com.itmo.r3135.World.UnitOfMeasure
import com.itmo.r3135.app.Styles
import com.itmo.r3135.app.Styles.Companion.addform
import com.itmo.r3135.app.Styles.Companion.xy
import controller.ConnectController
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon.USER
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView
import javafx.beans.binding.BooleanExpression
import tornadofx.*
import tornadofx.Stylesheet.Companion.fieldset
import tornadofx.Stylesheet.Companion.textField

class AddForm : View("Register Customer") {
    val connectController: ConnectController by inject()
    val model: ProductsModel by inject()

    override val root = form {
        addClass(addform)
        fieldset("Хозяина", FontAwesomeIconView(USER))
        {
            field("Owner name") {
                textfield(model.ownername).required()
            }
            field("Birthday") {
                datepicker(model.birthday).required()
            }
            field("Owner's eye color") {
                combobox<Color>(model.eyecolor, values = Color.values().toList()) {
                    required()
                }
            }
            field("Owner's hair color") {
                combobox<Color>(model.haircolor, values = Color.values().toList()) {
                    required()
                }
            }
        }

        fieldset("Products", FontAwesomeIconView(FontAwesomeIcon.APPLE))
        {
//            field("ID") {
//                textfield(model.id).required()
//            }
            field("Name") {
                textfield(model.name).required()
            }
            field("Price") {
                textfield(model.price) {
                    filterInput { it.controlNewText.isDouble() && it.controlNewText.toDouble() >= 0 }
                    required()
                }
            }
            field("X / Y") {
                textfield(model.xcoordinate) {
                    filterInput { it.controlNewText.isDouble() }
                    required()
                }
                textfield(model.ycoordinate) {
                    filterInput { it.controlNewText.isDouble() }
                    required()
                }
            }
            field("Partnumeber") {
                textfield(model.partnumeber) {
                    required()
                }
            }
            field("Manufacture cost") {
                textfield(model.manufacturecost) {
                    filterInput { it.controlNewText.isDouble() && it.controlNewText.toDouble() >= 0 }
                    required()
                }
            }
            field("Unit of measure") {
                combobox<UnitOfMeasure>(model.unitOfMeasure, values = UnitOfMeasure.values().toList()) {
                    required()
                }
            }
        }

        button("Add")
        {
            action {
                model.commit {
                    val product = model.item
                    connectController.sendReceiveManager.send(Command(CommandList.ADD, product.toProduct()))
                    close()
                }
            }
            enableWhen(model.valid)
        }
    }

    override val savable: BooleanExpression
        get() = super.savable

}



