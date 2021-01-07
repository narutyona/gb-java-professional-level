import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;
    private float weight;

    public Box() {
        fruits = new ArrayList<>();
        weight = 0;
    }

    public void put(T fruit) {
        fruits.add(fruit);
        weight += fruit.getWeight();
    }

    public float getWeight() {
        return weight;
    }

    public String getWeightAsString(){
        return String.format("%.2f", getWeight());
    }

    public boolean compare(Box<?> other){
        return Math.abs(other.getWeight() - getWeight()) < 0.001;
    }

    public void pourOut(Box<T> target){
        for (var fruit:fruits){
            target.put(fruit);
        }

        fruits.clear();
        weight = 0;
    }
}
