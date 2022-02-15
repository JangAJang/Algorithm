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
    bool operator!();
};

bool Book::operator!(){
    if(this->price == 0) return true;
    else return false;
}

int main(){
    Book book("벼룩시장", 0, 50);
    if(!book) cout << "It's free" << endl;
}
