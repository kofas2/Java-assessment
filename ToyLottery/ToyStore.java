import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToyStore {
    private List<Toy> toys;

    public ToyStore() {
        this.toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateWeight(int toyId, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getToyId() == toyId) {
                toy.setWeight(newWeight);
                break;
            }
        }
    }

    public void updateWinProbability(int toyId, double newWinProbability) {
        for (Toy toy : toys) {
            if (toy.getToyId() == toyId) {
                toy.setWinProbability(newWinProbability);
                break;
            }
        }
    }

    public List<Toy> playLottery() {
        List<Toy> lotteryPrizes = new ArrayList<>();
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();

        while (totalWeight > 0) {
            double randomValue = Math.random() * totalWeight;
            double cumulativeWeight = 0;

            for (Toy toy : toys) {
                if (randomValue <= cumulativeWeight + toy.getWeight() && Math.random() <= toy.getWinProbability()) {
                    lotteryPrizes.add(toy);
                    totalWeight -= toy.getWeight();
                    toy.reduceQuantity();
                    break;
                }
                cumulativeWeight += toy.getWeight();
            }
        }

        return lotteryPrizes;
    }

    public Toy getPrize(List<Toy> lotteryPrize) {
        if (!lotteryPrize.isEmpty()) {
            Toy prize = lotteryPrize.get(0);
            try (FileWriter writer = new FileWriter("prize_list.txt", true)) {
                writer.write("ID: " + prize.getToyId() + ", Name: " + prize.getName() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return prize;
        } else {
            return null;
        }
    }
}

