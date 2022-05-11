#include <iostream>
#include <string>
using namespace std;

class Person{
    string name;
public:
    Person(){ };
    Person(string name) {this->name = name;}
    string getName() { return name; }
    void setName(string name) { this->name = name;}
};

class Family{
    Person *p;
    int size;
    string name;
public:
    Family(string name, int size);
    void setName(int size, string name);
    void show();
    ~Family(){};
};

Family::Family(string name, int size){
    this->name = name;
    this->size = size;
    Person *f = new Person [size];
    this->p = f;
}

void Family::setName(int size, string name){
    p[size].setName(name);
}

void Family::show(){
    cout << this->name << " has " << this->size << "people" << endl;
    for(int i=0; i < (this->size);i++){
        cout << p[i].getName() << "   ";
    }
    cout << endl;
}

int main(){
    Family *simpson = new Family("Simpson", 3);
    simpson->setName(0, "Mr. Simpson");
    simpson->setName(1, "Mrs. Simpson");
    simpson->setName(2, "Bart Simpson");
    simpson->show();
    delete simpson;
    return 0;
}
