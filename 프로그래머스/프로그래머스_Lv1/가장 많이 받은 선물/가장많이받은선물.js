function solution(friends, gifts) {
  const giftLogbox = {};
  const nextReceiveBox = {};

  function initGiftLogbox() {
    // {이름 : {받은갯수: 0, 준 갯수: 0, sendLog: { 이름 : 0 } }}
    friends.forEach((name) => {
      giftLogbox[name] = { allReceiveCount: 0, allSendCount: 0, sendLog: {} };
      nextReceiveBox[name] = 0;
      friends.forEach((name2) => (giftLogbox[name].sendLog[name2] = 0));
    });
  }

  function updateGiftLog() {
    gifts.forEach((el) => {
      const [sender, receiver] = el.split(" ");
      giftLogbox[sender].allSendCount++;
      giftLogbox[receiver].allReceiveCount++;
      giftLogbox[sender].sendLog[receiver]++;
    });
  }

  function getGiftPoint(name) {
    return giftLogbox[name].allSendCount - giftLogbox[name].allReceiveCount;
  }

  function initNextReceiveBox() {
    for (let i = 0; i < friends.length; i++) {
      for (let j = i + 1; j < friends.length; j++) {
        const person1 = friends[i];
        const person2 = friends[j];

        const person1SendCount = giftLogbox[person1].sendLog[person2];
        const person2SendCount = giftLogbox[person2].sendLog[person1];

        let receivePerson;
        if (person1SendCount > person2SendCount) receivePerson = person1;
        else if (person1SendCount < person2SendCount) receivePerson = person2;
        else {
          const person1GiftPoint = getGiftPoint(person1);
          const person2GiftPoint = getGiftPoint(person2);

          if (person1GiftPoint === person2GiftPoint) continue;
          else if (person1GiftPoint > person2GiftPoint) receivePerson = person1;
          else receivePerson = person2;
        }

        if (receivePerson) nextReceiveBox[receivePerson]++;
      }
    }
  }

  function getAnswer() {
    initGiftLogbox();
    updateGiftLog();
    initNextReceiveBox();

    return Math.max(...Object.values(nextReceiveBox));
  }

  return getAnswer();
}
