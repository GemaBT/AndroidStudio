package com.example.mynuevoproyecto;

import java.io.Serializable;

public class Item implements Serializable {

    /* lista de items es "serializable", significa que se puede convertir esa lista en una secuencia
     * de bytes o en un formato que pueda ser almacenado o transmitido de una manera que
     * posteriormente se pueda reconstruir la lista original.
     * La serialización es el proceso de convertir objetos, datos o estructuras de datos en un
     * formato que se puede guardar en disco o enviar a través de una red, y luego deserializarlos
     *  para restaurar la estructura original.
     */

    String name;
    int image;

    public Item(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

