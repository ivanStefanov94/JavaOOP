package WorkingWithAbstraction.exercise.TrafficLights;

public class Light {
    private Colors color;

    public Light(Colors color) {
        this.color = color;
    }

    //метод за смяна на цвета
    public void changeColor(){
        if(this.color.equals(Colors.RED)){
            this.color = Colors.GREEN;
        }else if(this.color.equals(Colors.YELLOW)){
            this.color = Colors.RED;
        }else if(this.color.equals(Colors.GREEN)){
            this.color = Colors.YELLOW;
        }
    }

    public Colors getColor() {
        return color;
    }
}
