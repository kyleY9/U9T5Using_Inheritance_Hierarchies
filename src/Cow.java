public class Cow extends Animal {
    public Cow(String name) {
        super(name);
    }

    @Override
    public void talk() {
        System.out.println("Moooooove over butter");
    }

    public void milk() {
        System.out.println("My milk is rich in calcium");
    }
}
