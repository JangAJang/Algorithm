#include <iostream>
using namespace std;

class Container{
    int size;
public:
    Container() { size = 10;}
    void fill();
    void consume();
    int getSize();
};

void Container::fill(){
    this->size = 10;
}

void Container::consume(){
    this->size--;
}

int Container::getSize(){
    return size;
}

class CoffeeVendingMachine{
    Container tong[3];
    void fill();
    void selectEspresso();
    void selectAmericano();
    void selectSugarCoffee();
    void show();
public:
    void run();
};

void CoffeeVendingMachine::fill(){
    for(int i=0; i<3; i++){
        tong[i].fill();
    }
}

void CoffeeVendingMachine::selectEspresso(){
    tong[0].consume();
    tong[1].consume();
}

void CoffeeVendingMachine::selectAmericano(){
    tong[0].consume();
    tong[1].consume();
    tong[1].consume();
}

void CoffeeVendingMachine::selectSugarCoffee(){
    tong[0].consume();
    tong[1].consume();
    tong[1].consume();
    tong[2].consume();
}

void CoffeeVendingMachine::show(){
    cout << "bean " << tong[0].getSize() << ", water " << tong[1].getSize() << ", sugar "<< tong[2].getSize() << endl;
}

void CoffeeVendingMachine::run(){
    int check;
    while(true){
        if(tong[0].getSize() ==0 || tong[1].getSize() == 0 || tong[2].getSize() == 0){
            cout << "Please Refill" << endl;
        }
        else{
            cout << "Choose the Menu(1: Espresso, 2: Americano, 3: Sugar Coffee, 4: Check the ingredient, 5: Fill)";
        cin >> check;
            if(check == 1){
                selectEspresso();
                cout << "Here goes Espresso" << endl;
            }
            if(check == 2){
                selectAmericano();
                cout << "Here goes Americano" << endl;
            }
            if(check == 3){
                selectSugarCoffee();
                cout << "Here goes Sugar Coffee" << endl;
            }
            if(check == 4){
                show();
            }
            if(check == 5){
                fill();
                show();
            }
        }
    }
}

int main(){
    CoffeeVendingMachine machine;
    machine.run();
    return 0;
}
