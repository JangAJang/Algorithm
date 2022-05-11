#include <iostream>
#include <string>

using namespace std;

class Date{
    int year, month, day;
public:
    Date(int y, int m, int d);
    Date(string s);
    void show();
    int getYear();
    int getMonth();
    int getDay();
};

Date::Date(int y, int m, int d){
    year = y;
    month = m;
    day = d;
}

Date::Date(string s){
    int a, b, c;
    string sY, sM, sD;
    for(a=0; a<20; a++){
        if(s[a] != '/') sY[a] = s[a];
        else break;
    }
    year = stoi(sY);
    for(b=1; b<20; b++){
        if(s[a+b] != '/') sM[b] = s[a+b];
        else break;
    }
    for(c=1; c<20; c++){
        if(s[a+b+c] != '/') sD[c] = s[a+b+c];
        else break;
    }
    day = stoi(sD);
}

int Date::getYear(){
    return year;
}

int Date::getMonth(){
    return month;
}

int Date::getDay(){
    return day;
}

void Date::show(){
    cout << year << "년" << month << "월" << day <<"일" <<endl;
}

int main(){
    Date birth(2014, 3, 20);
    Date independenceDay("1945/8/15");
    independenceDay.show();
    cout << birth.getYear() << ',' << birth.getMonth() << '/' << birth.getDay() << endl;
    return 0;
}
