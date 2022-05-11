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
    bool operator==(int price);
    bool operator==(string title);
    bool operator==(Book b);
};

bool Book::operator==(int price){
    if (this->price == price) return true;
    else return false;
}

bool Book::operator==(string title){
    if(this->title == title) return true;
    else return false;
}

bool Book::operator==(Book b){
    if( this->title == b.title && this->pages == b.pages && this->price == b.price ) return true;
    else return false;
}

int main(){
    Book a("명품 C++", 30000, 500), b("고품 C++", 30000, 500);
    if(a == 30000) cout << "정가입니다. "<<endl;
    if(a == "명품 C++") cout << "명품 C++입니다" << endl;
    if (a == b) cout << "they are same" << endl;
}
