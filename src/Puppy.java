public class Puppy extends Dog {
    public Puppy(String name) {
        super(name);
    }

    @Override
    public void fetch() {
        System.out.println("It's time to play!");
    }
}