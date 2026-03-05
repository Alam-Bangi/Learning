class SealedClassRunner {
    sealed class Vehicle permits Car, Truck, Bike {
    }

    final class Car extends Vehicle {
    }

    non-sealed class Truck extends Vehicle {
    }

    sealed class Bike extends Vehicle permits SuperBike {
    }

    final class SuperBike extends Bike {
    }

    public static void main(String[] args) {

    }
}
