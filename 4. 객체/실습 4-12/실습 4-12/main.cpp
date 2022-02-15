#include <iostream>
#include <string>
using namespace std;

class Circle{
    int radius;
    string name;
public:
    void setCircle(string name, int radius);
    double getArea(){return 3.14*radius*radius;}
    string getName(){return name;}
};

void Circle::setCircle(string name, int radius){
    this->radius = radius;
    this->name = name;
}

class CircleManager{
    Circle *p;
    int size;
public:
    CircleManager(){}
    CircleManager(int size);
    ~CircleManager(){};
    void setCircle(string name, int size, int number);
    void SearchByName();
    void SearchByArea();
};

CircleManager::CircleManager(int size){
    this->size = size;
    Circle *p = new Circle [size];
    this->p = p;
}

void CircleManager::setCircle(string name, int size, int number){
    p[number].setCircle(name, size);
}

void CircleManager::SearchByName(){
    string name;
    cout << "Type down the name you wanna search >> ";
    cin >> name;
    for(int i=0; i< this->size; i++){
        if(p[i].getName() == name){
            cout << name << "has Area of " << p[i].getArea()<< endl;
        }
    }
}

void CircleManager::SearchByArea(){
    int size;
    cout << "Type the least amount of area you wanna find >> ";
    cin >> size;
    cout<< "Searching for the circles bigger than " << size << endl;
    for(int i=0; i<this->size; i++){
        if(p[i].getArea() > size) {
            cout << p[i].getName() << "is" << p[i].getArea() << ", ";
        }
    }
    cout << endl;
}

int main(){
    int count, radius;
    string name;
    cout << " number of Circles >> ";
    cin >> count;
    CircleManager circles(count);
    for(int i=0; i<count; i++){
        cout << "The name and the radius of Circle " << i+1 << "is? >> ";
        cin >> name >> radius;
        circles.setCircle(name, radius, i);
    }
    circles.SearchByName();
    circles.SearchByArea();
    return 0;
}
