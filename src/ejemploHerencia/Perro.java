package ejemploHerencia;

public class Perro extends Animal {

    public void ladrar() {
        System.out.println("guau");
    }
    public static void main(String[] args) {
        Animal a = new Perro();

    }
}
