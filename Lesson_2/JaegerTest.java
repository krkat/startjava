public class JaegerTest {
    public static void main(String[] args) {
        Jaeger crimsonTyphoon = new Jaeger();
        crimsonTyphoon.setModelName("Crimson Typhoon");
        crimsonTyphoon.setMark("Mark-4");
        crimsonTyphoon.setOrigin("China");
        crimsonTyphoon.setHeight(76.2f);
        crimsonTyphoon.setWeight(38.9f);
        crimsonTyphoon.setStrength(8);
        crimsonTyphoon.setArmor(6);
        Jaeger strikerEureka = new Jaeger("Striker Eureka", "Mark-5", "Australia", 76.2f, 41.79f, 10, 9);
        System.out.println(crimsonTyphoon.getModelName() + " - это Jaeger ростом " + 
                crimsonTyphoon.getHeight() + "м и весом " + crimsonTyphoon.getWeight() + "т.");
        System.out.println(strikerEureka.getModelName() + " - это Jaeger ростом " + 
                strikerEureka.getHeight() + "м и весом " + strikerEureka.getWeight() + "т.");
        crimsonTyphoon.move();
        strikerEureka.move();
        crimsonTyphoon.fight();
        strikerEureka.fight();
    }
}