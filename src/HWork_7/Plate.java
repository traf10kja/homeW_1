package HWork_7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decrease(Cat cat) {
        if (food > cat.getAppetite()) {
            System.out.println(cat.checkHungry(this) + " не голодна");
            food = food - cat.getAppetite();
            return;
        } else {
            System.out.println(cat.checkHungry(this) + " остался голоден");
        }
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }

    public int getFood() {
        return food;
    }
}
