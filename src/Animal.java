public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void talk() {
        System.out.println("I don't know what to say!");
    }
}