

public class LoginSuccess {
    // lv0. 로그인 성공?
    class Solution {
        public String solution(String[] id_pw, String[][] db) {
            for(int index = 0; index < db.length; index++){
                if(db[index][0].equals(id_pw[0])) return checkPassword(id_pw[1], db[index][1]);
            }
            return "fail";
        }

        private String checkPassword(String password, String pwDB){
            if(password.equals(pwDB)) return "login";
            return "wrong pw";
        }
    }
}
