public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void talk() {
        System.out.println("Woof!");
    }

    public void fetch() {
        System.out.println("I'll get the stick!");
    }
}