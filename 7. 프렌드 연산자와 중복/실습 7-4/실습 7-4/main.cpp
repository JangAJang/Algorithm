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
    friend bool operator<(string b, Book &a);
};

bool operator<(string b, Book &a){
    if((int)b[0] < (int)a.title[0]) return true;
    else return false;
}


int main(){
    Book a("youth", 20000, 300);
    string b;
    cout << "Type the title of the book" ;
    getline(cin, b);
    if (b < a) cout << a.getTitle() << "is later than" << b << endl;
}
