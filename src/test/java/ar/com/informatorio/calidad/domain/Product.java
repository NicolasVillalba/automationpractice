package ar.com.informatorio.calidad.domain;

public class Product {
    private Integer id;
    private String nombre;
    private Integer cant;

    public Product(Integer id, String nombre, Integer cant) {
        this.id = id;
        this.nombre = nombre;
        this.cant = cant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCant() {
        return cant;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }
}
