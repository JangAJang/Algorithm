#include <iostream>
#include <cstring>
using namespace std;

int main(){
    char name[100], address[100], age[3];
    cout<<"이름은? ";
    cin.getline(name, 100, '\n');
    cout<<"주소는? ";
    cin.getline(address, 100, '\n');
    cout<<"나이는? ";
    cin.getline(age, 100, '\n');
    cout<< name <<", "<<address<< ", " << age<<"세"<<"\n";
    return 0;
}
