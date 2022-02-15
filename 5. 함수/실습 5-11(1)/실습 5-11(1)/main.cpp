#include <iostream>
#include <cstring>
using namespace std;

class Book{
    string title;
    int price;
public:
    Book(string title, int price);
    void set(string title, int price);
    void show(){cout << title << ' ' << price << "won" << endl;}
};

Book::Book(string title, int price){
    this->price = price;
    this->title = title;
}

void Book::set(string title, int price){
    this->title = title;
    this->price = price;
}

int main(){
    Book cpp("Ele c++", 10000);
    Book java = cpp;
    java.set("Ele java", 12000);
    cpp.show();
    java.show();
    
}
