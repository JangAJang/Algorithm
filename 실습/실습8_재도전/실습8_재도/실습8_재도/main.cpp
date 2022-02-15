#include <iostream>
#include <cstring>

using namespace std;

int main(){
    cout<<"5명의 이름을 ';'로 구분하여 입력하시오. "<<endl<<">>";
    char names[100], max_name[100];
    for(int a=1; a<6; a++){
        cin.getline(names, 100, ';');
        cout<<a<<" : "<<names<<endl;
        if(strlen(names)>strlen(max_name)) strcpy(max_name, names);
    }
    cout<<"가장 긴 이름은 "<< max_name<< endl;
    return 0;
}
