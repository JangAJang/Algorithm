#include <iostream>

using namespace std;

class CoffeeMachine{
    int coffee, water, sugar;
public:
    CoffeeMachine(int c, int w, int s);
    void drinkEspresso();
    void drinkAmericano();
    void drinkSugarCoffee();
    void show();
    void fill();
};
CoffeeMachine::CoffeeMachine(int c, int w, int s){
    coffee = c;
    water = w;
    sugar = s;
}

void CoffeeMachine::drinkEspresso(){
    coffee -=1;
    water -=1;
}

void CoffeeMachine::drinkAmericano(){
    coffee -=1;
    water -=2;
}

void CoffeeMachine::drinkSugarCoffee(){
    coffee -=1;
    water -=2;
    sugar -=1;
}

void CoffeeMachine::show(){
    cout << "커피 머신 상태, 커피:" << coffee << " 물:" << water << " 설탕:" << sugar << endl;
}

void CoffeeMachine::fill(){
    coffee = 10;
    water = 10;
    sugar = 10;
}

int main(){
    CoffeeMachine java(5,10,3);
    java.drinkEspresso();
    java.show();
    java.drinkAmericano();
    java.show();
    java.drinkSugarCoffee();
    java.show();
    java.fill();
    java.show();
    return 0;
}
