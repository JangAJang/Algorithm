#include <iostream>
#include <cstring>
using namespace std;

class Circle{
    int radius;
public:
    Circle(int radius = 0) {this->radius = radius; }
    int getRadius() { return radius; }
    void setRadius(int radius) { this->radius = radius; }
    double getArea() { return 3.14*radius*radius; }
};

class NamedCircle : public Circle{
    string name;
public:
    NamedCircle() {}
    void setName(string name) { this->name = name;}
    string getName() { return name; }
};

int main(){
    NamedCircle pizza[5], biggest;
    cout << "Type 5 radius and names" << endl;
    for(int i=0; i<5; i++){
        cout << i+1 << ">> ";
        int size;
        string name;
        cin >> size;
        getline(cin, name);
        pizza[i].setRadius(size);
        pizza[i].setName(name);
        if(i>0) {
            if(pizza[i].getRadius() > pizza[i-1].getRadius()) biggest = pizza[i];
        }
    }
    cout << "biggest pizza is " << biggest.getName() << endl;
}
