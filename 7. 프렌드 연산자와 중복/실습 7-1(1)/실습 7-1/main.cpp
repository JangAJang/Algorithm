#include <iostream>
#include <cstring>
using namespace std;

class Book{
    string title;
    int price, pages;
public:
    Book(string title = "", int price = 0, int pages = 0){
        this->title = title; this->price = price; this->pages = pages;
    }
    void show(){
        cout << title << ' ' << price << "$ " << pages << "pages" << endl;
    }
    string getTitle(){return title;}
    Book operator+=(int n);
    Book operator-=(int n);
};

Book Book::operator+=(int n){
    price += 500;
    return *this;
}

Book Book::operator-=(int n){
    price -= 500;
    return *this;
}

int main(){
    Book a("youth", 20000, 300), b("future", 30000, 500);
    a += 500;
    b -= 500;
    a.show();
    b.show();
}
