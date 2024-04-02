import java.util.*;
public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Thing");
        Puppy puppy = new Puppy("Spot");
        Cow cow = new Cow("Marge");
        Dog dog = new Dog("Penny");
        ArrayList<Animal> animalList = new ArrayList<Animal>();
        animalList.add(animal);
        animalList.add(puppy);
        animalList.add(cow);
        animalList.add(dog);

        for (Animal temp : animalList) {
            System.out.println(temp.getName());
        }

        Animal[] animalArr = {animal, puppy, cow, dog};
        for (int i = 0; i < animalArr.length; i++) {
            if (animalArr[i] instanceof Cow) {
                ((Cow) animalArr[i]).milk();
            }
        }

        System.out.println("\n--- Adding Each Client Successfully ---");
        Vet vet = new Vet("Petco");
        System.out.println(vet.addClient(animal));
        System.out.println(vet.addClient(puppy));
        System.out.println(vet.addClient(cow));
        System.out.println(vet.addClient(dog));

        System.out.println("\n--- Adding Each Client Again Unsuccessfully ---");
        System.out.println(vet.addClient(animal));
        System.out.println(vet.addClient(puppy));
        System.out.println(vet.addClient(cow));
        System.out.println(vet.addClient(dog));

        System.out.println("\n----------> PRINTING CLIENT LIST <----------");
        vet.printClientList();


    }
}