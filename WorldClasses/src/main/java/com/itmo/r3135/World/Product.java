package com.itmo.r3135.World;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Класс Коллекции
 */
public class Product implements Comparable<Product>, Serializable {
    private final static String format = "%-30s%-20s%-20s%n";
    private static int idCounter;

    static {
        idCounter = 1;
    }

    private int id;
    private String name;
    private Coordinates coordinates;
    private LocalDateTime creationDate;
    private Double price;
    private String partNumber;
    private Float manufactureCost;
    private UnitOfMeasure unitOfMeasure;
    private Person owner;
    private String userName = "";

    {
        creationDate = LocalDateTime.now();
    }

    /**
     * Конструктор для класса com.itmo.com.itmo.r3135.World.Product
     *
     * @param name            - имя
     * @param coordinates     - класса координат
     * @param price           - цена
     * @param partNumber      - номер партии
     * @param manufactureCost - цена производства
     * @param unitOfMeasure   - единицы измерения продукта
     * @param owner           - владелец
     */
    public Product(String name, Coordinates coordinates, Double price, String partNumber, Float manufactureCost, UnitOfMeasure unitOfMeasure, Person owner) {
        this.id = idCounter;
        this.name = name;
        this.coordinates = coordinates;
        this.price = price;
        this.partNumber = partNumber;
        this.manufactureCost = manufactureCost;
        this.unitOfMeasure = unitOfMeasure;
        this.owner = owner;
        idCounter++;
    }

    public Product() {
    }

    public Product(int id, String name, Coordinates coordinates, LocalDateTime creationDate, Double price, String partNumber, Float manufactureCost, UnitOfMeasure unitOfMeasure, Person owner) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.price = price;
        this.partNumber = partNumber;
        this.manufactureCost = manufactureCost;
        this.unitOfMeasure = unitOfMeasure;
        this.owner = owner;
    }

    public static String printRequest() {
        return ("------------------------\n" +
                "Требования к элементу:\n" +
                "------------------------\n" +
                "Product: {\n" +
                "    String name --- Поле не может быть null, Строка не может быть пустой\n" +
                "    Coordinates coordinates; --- Поле не может быть null\n" +
                "    Long price --- Поле может быть null, Значение поля должно быть больше 0\n" +
                "    String partNumber --- Длина строки должна быть не меньше 21, Поле не может быть null\n" +
                "    manufactureCost --- Поле не может быть null;\n" +
                "    UnitOfMeasure unitOfMeasure --- Поле не может быть null\n" +
                "    Person owner --- Поле не может быть null\n" +
                "}\n" +
                "Coordinates: {\n" +
                "    Float x --- Максимальное значение поля: 82, Поле не может быть null\n" +
                "    Long y --- Значение поля должно быть больше -244, Поле не может быть null\n" +
                "}\n" +
                "Person : {\n" +
                "    String name --- Поле не может быть null, Строка не может быть пустой\n" +
                "    java.time.LocalDateTime birthday --- Поле не может быть null\n" +
                "    Color eyeColor --- Поле не может быть null\n" +
                "    Color hairColor --- Поле не может быть null\n" +
                "}\n" +
                "UnitOfMeasure: {\n" +
                "    PCS,\n" +
                "    LITERS,\n" +
                "    GRAMS,\n" +
                "    MILLIGRAMS;\n" +
                "}\n" +
                "Color: {\n" +
                "    GREEN,\n" +
                "    RED,\n" +
                "    BLACK,\n" +
                "    BLUE,\n" +
                "    YELLOW;\n}");
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void updateProduct(Product product) {
        this.name = product.getName();
        this.coordinates = product.coordinates;
        this.creationDate = product.getCreationDate();
        this.price = product.getPrice();
        this.partNumber = product.getPartNumber();
        this.manufactureCost = product.getManufactureCost();
        this.unitOfMeasure = product.getUnitOfMeasure();
        this.owner = product.getOwner();
    }

    /**
     * Проверяет элемент на сообтетвтвовение требованиям коллекции
     */
    public boolean checkNull() {
        try {
            if (this.creationDate == null) this.creationDate = LocalDateTime.now();
            return name == null || name.isEmpty() || coordinates == null ||
//                    coordinates.getX() >= 82 || coordinates.getY() <= -50 ||
                    creationDate == null || price == null || price <= 0 ||
                    partNumber == null || partNumber.length() < 21 ||
                    manufactureCost == null || unitOfMeasure == null || owner == null ||
                    owner.getName() == null || owner.getName().isEmpty() ||
                    owner.getBirthday() == null || owner.getEyeColor() == null || owner.getHairColor() == null;
        } catch (Exception ex) {
            System.out.println("В процессе проверки объекта произошла ошибка");
            return true;
        }
    }

    /**
     * Возвращает id элемента.
     *
     * @return id элемента коллекции.
     */
    public int getId() {
        return id;
    }

    /**
     * Устанавливает id орпеделенному элементу коллекции.
     *
     * @param id - id предмета
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Воозвращает поле name элемента коллекции.
     *
     * @return - имя
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает координаты в формате класса com.itmo.com.itmo.r3135.World.Coordinates.
     *
     * @return - класс com.itmo.com.itmo.r3135.World.Coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Возвращает поле price элемента коллекции.
     *
     * @return - цена.
     */
    public Double getPrice() {
        return price;
    }

    public String getUserName() {
        return userName;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Product o) {
        return (int) ((this.getPrice() - o.getPrice()) * 1000000);
    }

    public void printCheck() {
        if (this.creationDate == null) this.creationDate = LocalDateTime.now();
        System.out.println(this);
        String s = String.format(format, "Поле", "Значение", "Требование");
        if (this == null) s += String.format(format, "Product", "null", "Ты шо, дорашка?");
        else {
            if (name == null || name.isEmpty())
                s += String.format(format, "String name", name, "Поле не может быть null, Строка не может быть пустой");
            if (coordinates == null)
                s += String.format(format, "Coordinates coordinates", coordinates, "Поле не может быть null");
//            else {
//                if (coordinates.getY() <= -50) {
//                    s += String.format(format, "(coordinates)Long y ", coordinates.getY(), "Значение поля должно быть больше -244, Поле не может быть null");
//                }
//                if (coordinates.getX() >= 82) {
//                    s += String.format(format, "(coordinates)Long y ", coordinates.getY(), "Максимальное значение поля: 82, Поле не может быть null");
//                }
//            }
            if (price == null || price <= 0) {
                s += String.format(format, "Double price", price, "Поле может быть null, Значение поля должно быть больше 0");
            }
            if (partNumber == null || partNumber.length() < 21) {
                s += String.format(format, "String partNumber", partNumber, "Длина строки должна быть не меньше 21, Поле не может быть null");
            }
            if (manufactureCost == null) {
                s += String.format(format, "Float manufactureCost", manufactureCost, "Поле не может быть null");
            }
            if (unitOfMeasure == null) {
                s += String.format(format, "UnitOfMeasure unitOfMeasure", unitOfMeasure, "Поле не может быть null");
            }
            if (owner == null) {
                s += String.format(format, "Person owner", owner, "Поле не может быть null");
            } else {
                if (owner.getName() == null || owner.getName().isEmpty()) {
                    s += String.format(format, "(owner)String name", owner.getName(), "Длина строки должна быть не меньше 21, Поле не может быть null");
                }
                if (owner.getBirthday() == null) {
                    s += String.format(format, "(owner)LocalDateTime birthday", owner.getBirthday(), "Поле не может быть null");
                }
                if (owner.getEyeColor() == null) {
                    s += String.format(format, "(owner)Color eyeColor", owner.getEyeColor(), "Поле не может быть null");
                }
                if (owner.getHairColor() == null) {
                    s += String.format(format, "(owner)Color hairColor", owner.getEyeColor(), "Поле не может быть null");
                }
            }
        }
        System.out.println(s);
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Устанавливает дату создания.
     *
     * @param creationDate - дата создания.
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public Float getManufactureCost() {
        return manufactureCost;
    }

    public void setManufactureCost(Float manufactureCost) {
        this.manufactureCost = manufactureCost;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "------------------------------------------------------------------------\n" +
                "ID: " + id + "\n" +
                "Название: " + name + "\n" +
                "Координаты: " + "\n" +
                coordinates + "\n" +
                "Дата создания: " + creationDate + "\n" +
                "Цена: " + price + "\n" +
                "Номер партии: " + partNumber + "\n" +
                "Стоимость изготовления: " + manufactureCost + "\n" +
                "Единицы измерения: " + unitOfMeasure + "\n" +
                "Владелец: " + owner + "\n" +
                "Создатель: " + userName + "\n" +
                "------------------------------------------------------------------------\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Objects.equals(name, product.name) &&
                Objects.equals(coordinates, product.coordinates) &&
                Objects.equals(creationDate, product.creationDate) &&
                Objects.equals(price, product.price) &&
                Objects.equals(partNumber, product.partNumber) &&
                Objects.equals(manufactureCost, product.manufactureCost) &&
                unitOfMeasure == product.unitOfMeasure &&
                Objects.equals(owner, product.owner) &&
                Objects.equals(userName, product.userName);
    }

}

