#include <iostream>
#include <string>

using namespace std;

class Account{
    string owner;
    int id, money;
public:
    Account(string o, int i, int m);
    string getOwner();
    int deposit(int in);
    int withdraw(int out);
    int inquiry();
};

Account::Account(string o, int i, int m){
    owner = o;
    id = i;
    money = m;
}

string Account::getOwner(){
    return owner;
}

int Account::deposit(int in){
    money += in;
    return money;
}

int Account::withdraw(int out){
    money -= out;
    return money;
}

int Account::inquiry(){
    return money;
}

int main(){
    Account a("kitae", 1, 5000);
    a.deposit(50000);
    cout << a.getOwner() << "의 잔액은 " << a.inquiry() << endl;
    int money = a.withdraw(20000);
    cout << a.getOwner() <<"의 잔액은 " << a.inquiry() << endl;
    return 0;
}
