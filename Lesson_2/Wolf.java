public class Wolf {
    private boolean isMale;
    private String name;
    private float weight;
    private int age;
    private String color;

    public void go() {
        System.out.println("Идет.");
    }

    public void sit() {
        System.out.println("Сидит.");
    }

    public void run() {
        System.out.println("Бежит.");
    }

    public void howl() {
        System.out.println("Воет.");
    }

    public void hunt() {
        System.out.println("Охотится.");
    }

    public boolean isMale() {
        return isMale;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setAge(int age) {
        if (age > 8) {
            System.out.println("Некорректный возраст");
        } else {
            this.age = age;
        }
    }

    public void setColor(String color) {
        this.color = color;
    }
}