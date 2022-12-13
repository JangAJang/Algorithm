package domain;
import java.util.List;

public class Route {

    private final List<Integer> route;

    public Route(List<Integer> route){
        this.route = route;
    }

    public List<Integer> getRoute(){
        return this.route;
    }

    public int getLength(){
        return route.size();
    }
}
