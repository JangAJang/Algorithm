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
    friend bool operator==(Book& a, int price);
    friend bool operator==(Book& a, string title);
    friend bool operator==(Book& a, Book& b);
};

bool operator==(Book &a, int price){
    if(a.price == price) return true;
    else return false;
}

bool operator==(Book &a, string title){
    if(a.title == title) return true;
    else return false;
}

bool operator==(Book &a, Book &b){
    if(a.title == b.title && a.pages == b.pages&& a.price == b.price) return true;
    else return false;
}

int main(){
    Book a("명품 C++", 30000, 500), b("고품 C++", 30000, 500);
    if(a == 30000) cout << "정가 30000원 "<< endl;
    if(a== "명품 C++") cout << "명품 C++ 입니다" <<endl;
    if(a == b) cout << "They are same" << endl;
}
