#include <iostream>
#include <cmath>
#include <cstdlib>

using namespace std;

class Pointer{
public:
    int x, y;
    Pointer();
    Pointer(int x, int y);
};

Pointer::Pointer():Pointer(0,0){ }

Pointer::Pointer(int x, int y) : x(x), y(y) {}

int main(){
    Pointer origin;
    cout << "가로로 이동하고 싶은 만큼을 입력하시오. >> ";
    Pointer destination;
    cin >> destination.x;
    cout << "세로로 이동하고 싶은 만큼을 입력하시오. >> ";
    cin >> destination.y;
    double length;
    int g, s;
    s = abs(destination.y - origin.y);
    g = abs(destination.x - origin.x);
    length = sqrt(g*g + s*s);
    cout << "목적 좌표까지의 가로 거리는 " << g <<"이며 세로 거리는 " << s << "이다. " <<endl;
    cout << "최종 거리는 " << length << "입니다. " << endl;
    return 0;
}
