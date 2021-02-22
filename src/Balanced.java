// balanced brackets by using the linked list

  public class Balanced {

    Node top;

    public char pop() {
      char result;

      if (top == null) {
        return 0;

      } else {
        result = top.getData();
        top = top.getNext();
        return result;
      }
    }

    public void push(char data) {
      Node n = new Node();
      n.setData(data);
      if (isempty()) {
        top = n;
      } else {
        n.setNext(top);
        top = n;
      }
    }

    public void display() {
      Node temp;
      temp = top;
      while (temp != null) {
        System.out.println(temp.getData());
        temp = temp.getNext();
      }
    }

    public boolean matchingpair(char a, char b) {
      if (a == '(' && b == ')') {
        return true;
      } else if (a == '{' && b == '}') {
        return true;
      } else if (a == '[' && b == ']') {
        return true;
      } else {
        return false;
      }

    }
    public boolean isempty() {
      return top == null;
    }

    public static void main(String[] args) {
      Balanced obj = new Balanced();
      String s = "(){}{{}}[]";
      char ch[] = s.toCharArray();

      for (int i = 0; i <= ch.length - 1; i++) {
        if ((ch[i] == '(') || (ch[i] == '{') || (ch[i] == '[')) {
          obj.push(ch[i]);
        }
        if ((ch[i] == '}') || (ch[i] == ')') || (ch[i] == ']')) {
          if (obj.isempty()) {
            System.out.println("Not a matching pair");
            return;
          } else if (!obj.matchingpair(obj.top.data, ch[i])) {
            System.out.println("Not a matching pair");
          } else {
            obj.pop();
          }

        }
      }
      if (obj.isempty()) {
        System.out.println("Brackets are balanced and matched");
      }
    }
  }



