class Animal {
    void makeSound() {
        System.out.println("Generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof!");
    }

    void bark() {
        System.out.println("Bark!");
    }
}

public class upcasting {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        Animal myAnimal = new Dog(); // Upcasting: Dog object is now referenced as an Animal
        Dog my_Dog = (Dog) myAnimal; // Explicit downcasting
        my_Dog.makeSound();
        my_Dog.bark(); 
        myAnimal.makeSound();
    }
}
