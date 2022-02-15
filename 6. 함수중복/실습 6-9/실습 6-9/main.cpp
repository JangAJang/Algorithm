#include <iostream>
#include <cstring>
using namespace std;

class Board{
public:
    static string announce[100];
    static int counter;
    static void add(string words);
    static void print();
};

string Board::announce[100];
int Board::counter = 0;

void Board::add(string words){
    announce[counter] = words;
    counter++;
}

void Board::print(){
    cout << "-----DashBoard-----" << endl;
    for(int i=0; i< counter; i++){
        cout << i << " : " << announce[i] << endl;
    }
}

int main(){
    Board::add("Mid Term test is freely done without managers");
    Board::add("Please enjoy your coding lounge");
    Board::print();
    Board::add("Please congratulate our Ms.Jin. She won the competition");
    Board::print();
}
