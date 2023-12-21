public class Toy {
    private int toyId;
    private String name;
    private int quantity;
    private double weight; // Частота (вес)
    private double winProbability; // Вероятность выигрыша

    public Toy(int toyId, String name, int quantity, double weight, double winProbability) {
        this.toyId = toyId;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
        this.winProbability = (winProbability > 0.3) ? 0.3 : winProbability;
    }

    public int getToyId() {
        return toyId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWeight() {
        return weight;
    }

    public double getWinProbability() {
        return winProbability;
    }

    public void setWeight(double newWeight) {
        this.weight = newWeight;
    }

    public void setWinProbability(double newWinProbability) {
        this.winProbability = (newWinProbability > 0.3) ? 0.3 : newWinProbability;
    }

    public void reduceQuantity() {
        this.quantity--;
    }
}
