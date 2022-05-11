#include <iostream>
#include <cstring>
using namespace std;

class Person{
    char *name;
    int id;
public:
    Person();
    Person(int id, const char* name);
    void changeName(const char* name);
    string show() {return name;}
};

Person::Person(){
    cout << "복사 생성자 실행 name = " << name;
}

Person::Person(int id, const char* name){
    this->id = id;
    int len = strlen(name);
    this->name = new char [len+1];
    strcpy(this->name, name);
}

void Person::changeName(const char *name){
    strcpy(this->name, name);
}

void f(Person person){
    cout << "복사 생성자 실행 name = " << person.show()<<endl;
    person.changeName("dummy");
}

Person g(){
    Person mother(2, "Jane");
    cout << "복사생성자 실행 name = " << mother.show()<<endl;
    return mother;
}

int main(){
    Person father(1, "Kitae");
    Person son = father;
    f(father);
    g();
    return 0;
}
