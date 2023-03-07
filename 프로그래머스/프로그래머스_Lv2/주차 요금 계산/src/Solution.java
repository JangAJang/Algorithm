import java.util.*;

class Solution {
    private final Cars cars = new Cars();

    public int[] solution(int[] fees, String[] records) {
        for(String recordEach : records){
            cars.putDataOfCar(recordEach);
        }
        return cars.getCarsFees(fees);
    }

    private class Cars{
        private final List<Car> cars = new ArrayList<>();

        private Car findCar(String carName){
            for(Car car : cars){
                if(car.isRightCar(carName)) return car;
            }
            Car car = new Car(carName);
            cars.add(car);
            return car;
        }

        public void putDataOfCar(String record){
            String[] records = record.split(" ");
            Car car = findCar(records[1]);
            car.addData(records[0], records[2]);
        }

        public int[] getCarsFees(int[] fees){
            return cars.stream().sorted(Comparator.comparing(Car::getCarNumber)).mapToInt(car-> car.getTotalFee(fees)).toArray();
        }
    }

    private class Car{
        private final String carNumber;

        private final InData inData = new InData();
        private final OutData outData = new OutData();

        public Car(String carNumber){
            this.carNumber = carNumber;
        }

        public String getCarNumber(){
            return this.carNumber;
        }

        public boolean isRightCar(String carNumber){
            return this.carNumber.equals(carNumber);
        }

        public void addData(String time, String dataType){
            if(dataType.equals("IN")){
                inData.putCar(time);
                return;
            }
            outData.outCar(time);
        }

        public int getTotalFee(int[] fees){
            int result = 0;
            while(!inData.isInDataEmpty()){
                result+= outData.pollOutCar() - inData.pollCar();
            }
            return countFee(fees, result);
        }

        private int countFee(int[] fees, int stayingTime){
            int fee = 0;
            if(stayingTime < fees[0]){
                return fees[1];
            }
            fee += fees[1];
            stayingTime -= fees[0];
            if(stayingTime % fees[2] != 0){
                return fee + (stayingTime/fees[2]+1)*fees[3];
            }
            return fee + (stayingTime / fees[2])*fees[3];
        }
    }

    private class InData{
        private final Queue<Integer> inTime = new ArrayDeque<>();

        public void putCar(String in){
            String[] time = in.split(":");
            int result = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            inTime.add(result);
        }

        public boolean isInDataEmpty(){
            return inTime.isEmpty();
        }

        public int pollCar(){
            return inTime.poll();
        }
    }

    private class OutData{
        private final Queue<Integer> outTime = new ArrayDeque<>();

        public void outCar(String out){
            String[] time = out.split(":");
            int result = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            outTime.add(result);
        }

        public int pollOutCar(){
            if(!outTime.isEmpty()) return outTime.poll();
            return 23*60 + 59;
        }
    }
}