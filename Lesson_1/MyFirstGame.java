public class MyFirstGame {
    public static void main(String[] args) {
        int hiddenNumber = 23;
        int playerNumber = 50;
        while (playerNumber != hiddenNumber) {
            if (playerNumber > hiddenNumber) {
                System.out.printf("%d больше того, что загадал компьютер%n", playerNumber);
                playerNumber--;
            } else {
                System.out.printf("%d меньше того, что загадал компьютер%n", playerNumber);
                playerNumber++;
            }
        }
        System.out.println("Вы победили!");
    } 
}