import java.util.*;
public class Vet {
    private String vetName;
    private ArrayList<Animal> clients;

    public Vet(String vetName) {
        this.vetName = vetName;
        clients = new ArrayList<Animal>();
    }

    public boolean addClient(Animal animal) {
        if (clients.indexOf(animal) < 0) {
            clients.add(animal);
            System.out.println("Welcome to " + vetName + "'s office, " + animal.getName());
            return true;
        } else {
            System.out.println(animal.getName() + " is already a client of " + vetName);
            return false;
        }
    }

    public void printClientList() {
        for (Animal animal : clients) {
            System.out.println(animal.getName() + ": " + animal.getClass());
        }
    }
}
