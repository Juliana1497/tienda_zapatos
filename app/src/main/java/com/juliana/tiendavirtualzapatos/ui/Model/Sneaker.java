package com.juliana.tiendavirtualzapatos.ui.Model;
import com.juliana.tiendavirtualzapatos.R;

public class Sneaker {
    private int id;

    private String name;

    private String description;

    private int idDrawable;

    public Sneaker(int id, String name,  String description, int idDrawable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.idDrawable = idDrawable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public void setIdDrawable(int idDrawable) {
        this.idDrawable = idDrawable;
    }

    public static Sneaker[] ITEMS ={
            new Sneaker(1,"Zapato hombre Velez","Zapato 100% en cuero, tallas de la 37 a la 43", R.drawable.hombre1),
            new Sneaker(2,"Zapato hombre Velez","Zapato 90% en cuero, 10% cuerina, tallas de la 37 a la 43", R.drawable.hombre2),
            new Sneaker(4,"Zapato hombre Bossi","Zapato 100% en cuero, tallas de la 37 a la 43", R.drawable.hombre6),
            new Sneaker(5,"Zapato hombre Bossi","Zapato 80% en cuero, 10% cuerina, 10% badana, tallas de la 37 a la 43", R.drawable.hombre7),
            new Sneaker(6,"Zapato mujer Velez","Zapato 100% en cuero, tallas de la 34 a la 40", R.drawable.mujer1),
            new Sneaker(7,"Zapato mujer Velez", "Zapato 95% en cuero, 5% badana, tallas de la 34 a la 40", R.drawable.mujer2),
            new Sneaker(9,"Zapato mujer Bossi","Zapato 100% en cuero, tallas de la 34 a la 40", R.drawable.mujer4),
            new Sneaker(10,"Zapato mujer Bossi","Zapato 90% en cuero, 10% en cuerina, tallas de la 34 a la 40", R.drawable.mujer5),
    };

    public static Sneaker getItem(int id){
        for(Sneaker sneakerActual: ITEMS){
            if(sneakerActual.getId()==id){
                return sneakerActual;
            }
        }
        return null;
    }
}