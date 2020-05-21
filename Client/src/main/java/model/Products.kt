package model

import com.itmo.r3135.World.Color
import com.itmo.r3135.World.Product
import javafx.beans.property.ObjectProperty
import javafx.beans.property.Property
import javafx.beans.property.StringProperty
import tornadofx.*
import java.time.LocalDate
import java.time.LocalDateTime

class Products {
    var ownername by property<String>()
    fun ownernameProperty() = getProperty(Products::ownername)

    var birthday by property<LocalDate>()
    fun birthdayProperty() = getProperty(Products::birthday)

    var eyecolor by property<Color>()
    fun eyecolorProperty() = getProperty(Products::eyecolor)

    var haircolor by property<Color>()
    fun haircolorProperty() = getProperty(Products::haircolor)

    var price by property<Number>()
    fun priceProperty() = getProperty(Products::price)

    var ycoordinate by property<Number>()
    fun ycoordinatePropetry() = getProperty(Products::ycoordinate)

    var xcoordinate by property<Number>()
    fun xcoordinatePropetry() = getProperty(Products::xcoordinate)

    var partnumeber by property<String>()
    fun partnumeberProperty() = getProperty(Products::partnumeber)

    var manufacturecost by property<Number>()
    fun manufacturecostProperty() = getProperty(Products::manufacturecost)

    var name by property<String>()
    fun nameProperty() = getProperty(Products::name)

    var id by property<Number>()
    fun idProperty() = getProperty(Products::id)

    constructor()

    constructor(product: Product){
        this.id = product.id
        this.name = product.name
        this.price = product.price
        this.ycoordinate = product.coordinates.y
        this.xcoordinate = product.coordinates.x
        this.partnumeber = product.partNumber
        this.manufacturecost = product.manufactureCost
        this.ownername = product.owner.name
        this.birthday = product.owner.birthday.toLocalDate()
        this.eyecolor = product.owner.eyeColor
        this.haircolor = product.owner.hairColor
    }

//    constructor(ownername: String, birthday: LocalDate, eyecolor: Color, haircolor: Color, price: Number, ycoordinate: Number, xcoordinate: Number, partnumeber: String, manufacturecost: Number, name: String, id: Number) {
//        this.ownername = ownername
//        this.birthday = birthday
//        this.eyecolor = eyecolor
//        this.haircolor = haircolor
//        this.price = price
//        this.ycoordinate = ycoordinate
//        this.xcoordinate = xcoordinate
//        this.partnumeber = partnumeber
//        this.manufacturecost = manufacturecost
//        this.name = name
//        this.id = id
//    }
}

class ProductsModel : ItemViewModel<Products>(Products()) {
    val ownername: StringProperty = bind { item?.ownernameProperty() }
    val birthday: Property<LocalDate> = bind { item?.birthdayProperty() }
    val eyecolor: Property<Color> = bind { item?.eyecolorProperty() }
    val haircolor: Property<Color> = bind { item?.haircolorProperty() }
    val price: ObjectProperty<Number> = bind { item?.priceProperty() }
    val ycoordinate : ObjectProperty<Number> = bind { item?.ycoordinatePropetry() }
    val xcoordinate : ObjectProperty<Number> = bind { item?.xcoordinatePropetry() }
    val partnumeber: StringProperty = bind { item?.partnumeberProperty() }
    val manufacturecost: ObjectProperty<Number> = bind { item?.manufacturecostProperty() }
    val name: StringProperty = bind { item?.nameProperty() }
    val id : ObjectProperty<Number> = bind { item?.idProperty() }
}


