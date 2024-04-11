public class Toy {
    private static int idGlobal = 0;
    int id;
    String name;
    int quantity = 0;
    int chance;
    
    public Toy(String name, int quantity, int chance) {
        this.name = name;
        idGlobal +=1;
        this.id = idGlobal;
        this.quantity = quantity;
        this.chance = chance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getChance() {
        return chance;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }


    
}
