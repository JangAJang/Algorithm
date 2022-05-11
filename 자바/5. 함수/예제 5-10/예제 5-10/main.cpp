#include <iostream>
#include <cstring>
using namespace std;

class Person{
    char* name;
    int id;
public:
    Person(int id, const char* name);
    ~Person();
    void changeName(const char* name);
    void show() { cout << id << "," << name << endl; }
};

Person::Person(int id, const char* name){
    this->id = id;
    int len = strlen(name);
    this->name = new char [len +1];
    strcpy(this->name, name);
}

Person::~Person(){
    if(name) delete [] name;
}

void Person::changeName(const char *name){
    if(strlen(this->name) < strlen(name)) return;
    strcpy(this->name, name);
}

int main(){
    Person father(1, "Kitae");
    Person daughter(father);
    cout << "just made daughter" << endl;
    father.show();
    daughter.show();
    daughter.changeName("Grace");
    cout << "just changed daughter's name" << endl;
    father.show();
    daughter.show();
    return 0;
}
