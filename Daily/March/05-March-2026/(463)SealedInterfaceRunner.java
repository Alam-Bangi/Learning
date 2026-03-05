class SealedInterfaceRunner {
    sealed interface Flyable permits Helicopter, Plane, Bird {
    }

    final class Bird implements Flyable {
    }

    sealed class Plane implements Flyable permits JetPlane {
    }

    non-sealed class Helicopter implements Flyable {
    }

    final class JetPlane extends Plane {
    }

    public static void main(String[] args) {

    }
}
