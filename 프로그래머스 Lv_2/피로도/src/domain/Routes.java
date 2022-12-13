package domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Routes {

    private final List<Route> routes = new ArrayList<>();

    public List<Integer> getBestRoute(){
        return routes.stream()
                .sorted(Comparator.comparing(Route::getLength).reversed())
                .collect(Collectors.toList()).get(0).getRoute();
    }

    public void addRoute(List<Integer> route){
        routes.add(new Route(route));
    }
}
