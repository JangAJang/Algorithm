#include <iostream>
#include <string>
using namespace std;

class Person{
    string name;
    string tel;
public:
    Person();
    string getName(){ return name;}
    string getTel(){return tel;}
    void set(string name, string tel);
};

Person::Person(){}

void Person::set(string n, string t){
    name = n;
    tel = t;
}

int main(){
    Person people[3];
    string n, t;
    cout << "이름과 전화번호를 입력하시오. " << endl;
    for(int i =0 ; i<3; i++){
        cout << "사람 " << i+1 << ">> ";
        cin >> n >> t;
        people[i].set(n, t);
    }
    cout << "모든 사람의 이름은 " << people[0].getName() << " " << people[1].getName() << " " << people[2].getName() << endl;
    cout << "전화번호를 입력합니다. 이름을 입력하세요. " ;
    string name;
    cin >> name;
    for(int i = 0; i<3; i++){
        if(people[i].getName() == name){
            cout << "전화번호는 " <<people[i].getTel();
        }
    }
    return 0;
}
