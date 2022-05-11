#include <iostream>
#include <cstring>
using namespace std;

class Book{
    char *title;
    int price;
public:
    Book(const char *title, int price);
    ~Book();
    void set(char *title, int price);
    void show() { cout << title << ' ' << price << "won" << endl;}
};

Book::Book(const char *title, int price){
    this->price = price;
    int size = strlen(title) +1;
    this->title = new char [size];
    strcpy(this->title, title);
}

Book::~Book(){
    delete [] title;
}

void Book::set(char *title, int price){
    this->price = price;
    delete [] this->title;
    int size = strlen(title)+1;
    title = new char [size];
    strcpy(this->title, title);
}

int main(){
    Book cpp("Ele C++", 10000);
    Book java = cpp;
    java.set("Ele Java", 12000);
    cpp.show();
    java.show();
    
}
