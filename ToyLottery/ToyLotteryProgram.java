import java.util.List;

public class ToyLotteryProgram {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        toyStore.addToy(new Toy(1, "Doll", 10, 20, 0.2));
        toyStore.addToy(new Toy(2, "Car", 15, 30, 0.3));
        toyStore.addToy(new Toy(3, "Teddy Bear", 8, 15, 0.1));

        toyStore.updateWeight(1, 25);
        toyStore.updateWinProbability(2, 0.25);

        List<Toy> lotteryPrizes = toyStore.playLottery();

        for (Toy prize : lotteryPrizes) {
            Toy winner = toyStore.getPrize(List.of(prize));
            System.out.println("Congratulations! You won a " + winner.getName());
        }
    }
}
