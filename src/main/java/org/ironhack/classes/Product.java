package org.ironhack.classes;

import java.util.Objects;

public class Product {
    private String id;
    private String name;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    Es lo mismo que el otro método equals, solo que usando getClass en vez de instanceof
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Product product = (Product) o;
//        return Objects.equals(id, product.id) && Objects.equals(name, product.name);
//    }


    // PARA VERIFICAR EL FUNCIONAMIENTO DE EQUALS Y HASHCODE COMENTAR ESTE MÉTODO:
    // verifica si dos objetos son iguales
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name);
    }

    // PARA VERIFICAR EL FUNCIONAMIENTO DE EQUALS Y HASHCODE COMENTAR ESTE MÉTODO:
    // int que indica en qué cubo del HashMap se almacena una clave
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
