public class WolfTest {
    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        wolf.isMale = true;
        wolf.name = "Ганс";
        wolf.weight = 50.4f;
        wolf.age = 5;
        wolf.color = "серый";
        System.out.println("isMale: " + wolf.isMale);
        System.out.println("name: " + wolf.name);
        System.out.println("weight: " + wolf.weight);
        System.out.println("age: " + wolf.age);
        System.out.println("color: " + wolf.color);
        wolf.go();
        wolf.sit();
        wolf.run();
        wolf.howl();
        wolf.hunt();
    }
}