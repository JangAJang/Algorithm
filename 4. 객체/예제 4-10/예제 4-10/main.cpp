#include <iostream>

using namespace std;

class Circle{
    int radius;
public:
    Circle();
    ~Circle();
    void setRadius(int r){ radius = r;}
    double getArea() { return 3.14 * radius * radius;}
};

Circle::Circle(){
    radius = 1;
    cout << "생성자 실행 radius = " << radius << endl;
}

Circle::~Circle(){
    cout << "소멸자 실행 radius = " << radius << endl;
}

int main(){
    cout << "생성하고자 하는 원의 개수는 ? ";
    int n, radius;
    cin >> n;
    if(n <= 0) return 0;
    Circle *pArray = new Circle [n];
    for(int i = 0; i < n; i++){
        cout << i+1 << "번째 반지름을 입력하시오.";
        cin >> radius;
        pArray[i].setRadius(radius);
    }
    int count = 0;
    Circle *p = pArray;
    for(int i=0; i<n; i++){
        cout << p->getArea() << ' ';
        if(p->getArea() >= 100 && p->getArea() <= 200) count++;
        p++;
    }
    cout << endl <<"면적이 100 이상 200 이하인 원의 개수는 " << count << "개 입니다. " << endl;
    return 0;
}
