const net = require("net");
const { URL } = require("url");

const server = net.createServer((socket) => {
  socket.on("data", (data) => {
    // 요청 데이터 확인
    socket.setEncoding("utf8");
    const [method, pathname, http] = getReqeustMethodAndPathname(data);
    const url =
      new URL(`http://localhost:3000/create?userId=javajigi&password=password&name=%EB%B0%95%EC%9E%AC%EC%84%B1&email=javajigi%40slipp.net
    `);
    console.log(parseRequestParamsToJson(url.searchParams));
    const responseType = url.pathname.split(".")[1];

    // 요청 처리를 해주는 부분
    // pathname으로 요청 받은거 처리해서 컨트롤러가 리스폰스를 준다. 라우터 => 컨트롤러 순서로 설계를 한다.
    // url의

    // 응답 처리
    if (method === "GET") {
      socket.write("HTTP/1.1 200 OK\r\n");
      socket.write("Content-Type: text/html; charset=utf-8\r\n"); // 응답해야할 content type에 맞게 수정, 확장자 확인 <- text/${responseType}의 방식으로 type 처리
      socket.write("\r\n");
      socket.write("Hello World");
      // 응답해야할 body에 맞게 수정 => html, css, js, 등의 로직 fs.readFile을 해준 문자열 <- get메서드에서는 요청받은 파일 readFile해서 문자열 넣어주기.
      // 컨트롤러 응답 넣어주기
      socket.end();
    }
  });
});

const getReqeustMethodAndPathname = (data) =>
  data.toString().split("\r\n")[0].split(" ");

const parseRequestParamsToJson = (searchParams) => {
  const queryObject = {};
  for (const [key, value] of searchParams) {
    queryObject[key] = value;
  }

  return queryObject;
};

server.listen(3000, () => {
  console.log("HTTP server running on port 3000");
});
