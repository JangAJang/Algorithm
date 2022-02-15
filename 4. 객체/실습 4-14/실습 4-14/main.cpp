#include <iostream>
#include <string>
#include <cstdlib>
#include <ctime>
using namespace std;

class Player{
    string name;
    int num[3];
public:
    Player(){};
    string getName(){return this->name;}
    void setName(string name);
    void getNumber();
    int checkNum();
    void show();
};

void Player::setName(string name){
    this->name = name;
}

void Player::getNumber(){
    for(int i=0; i<3; i++){
        srand((unsigned)time(0));
        int n = rand();
        this->num[i] = n % 3;
    }
}

int Player::checkNum(){
    int c;
    if(num[0] == num[1] && num[1] == num[2]){
        c=1;
    }
    else c=0;
    return c;
}

void Player::show(){
    cout << "       ";
    for(int i=0; i<3; i++){
        cout << num[i] << "    ";
    }
}

class GamblingGame{
    Player *p;
public:
    GamblingGame();
    void Game();
};

GamblingGame::GamblingGame(){
    Player *p = new Player[2];
    this->p = p;
    string name;
    cout << "Type the First Player's name >> ";
    cin >> name;
    p[0].setName(name);
    cout << "Type the Second Player's name >> ";
    cin >> name;
    p[1].setName(name);
}

void GamblingGame::Game(){
    int i=0;
    char c;
    while(true){
        p[i%2].getNumber();
        cout << p[i%2].getName() << ":";
        cin >> c;
            p[i%2].show();
            if(p[i%2].checkNum() == 0) {
                cout << "Bad Luck" << endl;
            }
            else {
                cout << p[i%2].getName() << "wins!!!"<<endl;
                break;
            }
        
    }
}

int main(){
    cout << "***** Lets Starts to Gamble *****" << endl;
    GamblingGame gamble;
    gamble.Game();
    return 0;
}
