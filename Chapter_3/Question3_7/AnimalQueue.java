/* 
 * Author: Hao Tan <ihntee@gmail.com>
 * Time: 2014/07/19
 * Problem Description: Implement a queue, which can be inserted with cats and dogs,
 *                      and can dequeue them seperately or according to the whole order 
 */

import java.util.LinkedList;

abstract class Animal {
    private int order;
    private String name;
    public Animal(String name) {
        this.name = name;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    public boolean isOlderThan(Animal that) {
        return this.getOrder() < that.getOrder();
    }
    public int getOrder() {
        return order;
    }
    public void talk() {
        System.out.println("My name is " + name);
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

public class AnimalQueue {
    private LinkedList<Cat> cats = new LinkedList<Cat>();
    private LinkedList<Dog> dogs = new LinkedList<Dog>();
    private int order = 0;

    public void enqueue (Animal animal) {
        if (animal instanceof Cat) {
            animal.setOrder(order++);
            cats.addLast((Cat) animal);
        }
        else if (animal instanceof Dog) {
            animal.setOrder(order++);
            dogs.addLast((Dog) animal);
        }
    }

    public Animal dequeueAny() {
        if (cats.isEmpty()) return dequeueDog();
        if (dogs.isEmpty()) return dequeueCat();
        Cat cat = cats.getFirst();
        Dog dog = dogs.getFirst();
        if (cat.isOlderThan(dog)) {
            return dequeueCat();
        } else {
            return dequeueDog();
        }
    }

    public Cat dequeueCat() {
        return cats.pollFirst();
    }

    public Dog dequeueDog() {
        return dogs.pollFirst();
    }

    public static void main(String[] args) {
        Cat[] cats = new Cat[5];
        for (int i = 0; i < 5; i++) {
            cats[i] = new Cat("cat" + i);
        }
        Dog[] dogs = new Dog[5];
        for (int i = 0; i < 5; i++) {
            dogs[i] = new Dog("dog" + i);
        }
        AnimalQueue aq = new AnimalQueue();

        aq.enqueue(cats[0]);
        aq.enqueue(dogs[0]);
        aq.enqueue(dogs[1]);
        aq.enqueue(cats[1]);
        aq.enqueue(cats[2]);
        aq.enqueue(cats[3]);
        aq.enqueue(dogs[2]);
        aq.enqueue(dogs[3]);

        aq.dequeueDog().talk();
        aq.dequeueAny().talk();
        aq.dequeueCat().talk();
        aq.dequeueAny().talk();
    }
}