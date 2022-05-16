import tester.*;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

class Point {
  int x, y;
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  double distance(Point other) {
    return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
  }
}

class PointCompare implements Comparator<Point> {
  public int compare(Point pt1, Point other) {
    if(pt1.y < other.y) {
      return -1;
    }
    else if(pt1.y > other.y) {
      return 1;
    }
    else if(pt1.x < other.x) {
      return -1;
    }
    else if(pt1.x > other.x) {
      return 1;
    }
    else { //same coordinates
      return 0;
    }
  }
}

class PointDistanceCompare implements Comparator<Point> {
  public int compare(Point pt1, Point other) {
    Point pt = new Point(0, 0);

    if(pt.distance(pt1) < pt.distance(other)) {
      return -1;
    }
    else if(pt.distance(pt1) > pt.distance(other)) {
      return 1;
    }
    else { //equal distances
      return 0;
    }
  }
}

class StringCompare implements Comparator<String> {
  public int compare(String str1, String str2) {
    if(str1.compareTo(str2) < 0) {
      return -1;
    }
    else if(str1.compareTo(str2) > 0) {
      return 1;
    }
    else { //they're equal
      return 0;
    }
  }
}

class StringLengthCompare implements Comparator<String> {
  public int compare(String str1, String str2) {
    if(str1.length() < str2.length()) {
      return -1;
    }
    else if(str1.length() > str2.length()) {
      return 1;
    }
    else { //equal lengths
      return 0;
    }
  }
}

class BooleanCompare implements Comparator<Boolean> { //true > false
  public int compare(Boolean bool1, Boolean bool2) {
    if(bool1 == false && bool2 == true) {
      return -1;
    }
    else if(bool1 == true && bool2 == false) {
      return 1;
    }
    else { //equal bools
      return 0;
    }
  }
}

class TestCompare {
  //at least 4 tests each
  void testPointCompare(Tester t) {
    PointCompare ptCom = new PointCompare();

    Point ex1pt1 = new Point(3, 4);
    Point ex1other = new Point(1, 10);
    Point ex2pt1 = new Point(-3, 8);
    Point ex2other = new Point(1, -5);
    Point ex3pt1 = new Point(-2, 2);
    Point ex3other = new Point(9, 2);
    Point ex4pt1 = new Point(4, 6);
    Point ex4other = new Point(4, 6);

    t.checkExpect(ptCom.compare(ex1pt1, ex1other), -1);
    t.checkExpect(ptCom.compare(ex2pt1, ex2other), 1);
    t.checkExpect(ptCom.compare(ex3pt1, ex3other), -1);
    t.checkExpect(ptCom.compare(ex4pt1, ex4other), 0);
  }
  void testPointDistanceCompare(Tester t) {
    PointDistanceCompare ptDisCom = new PointDistanceCompare();

    Point ex1pt1 = new Point(3, 4);
    Point ex1other = new Point(1, 10);
    Point ex2pt1 = new Point(-3, 8);
    Point ex2other = new Point(1, -5);
    Point ex3pt1 = new Point(-2, 2);
    Point ex3other = new Point(9, 2);
    Point ex4pt1 = new Point(4, 6);
    Point ex4other = new Point(4, 6);

    t.checkExpect(ptDisCom.compare(ex1pt1, ex1other), -1);
    t.checkExpect(ptDisCom.compare(ex2pt1, ex2other), 1);
    t.checkExpect(ptDisCom.compare(ex3pt1, ex3other), -1);
    t.checkExpect(ptDisCom.compare(ex4pt1, ex4other), 0);
  }
  void testStringCompare(Tester t) {
    StringCompare strCom = new StringCompare();

    String ex1str1 = "I";
    String ex1str2 = "believe";
    String ex2str1 = "the";
    String ex2str2 = "children";
    String ex3str1 = "are";
    String ex3str2 = "our";
    String ex4str1 = "future";
    String ex4str2 = "future";

    t.checkExpect(strCom.compare(ex1str1, ex1str2), -1);
    t.checkExpect(strCom.compare(ex2str1, ex2str2), 1);
    t.checkExpect(strCom.compare(ex3str1, ex3str2), -1);
    t.checkExpect(strCom.compare(ex4str1, ex4str2), 0);
  }
  void testStringLengthCompare(Tester t) {
    StringLengthCompare strLenCom = new StringLengthCompare();

    String ex1str1 = "I believe the children";
    String ex1str2 = "are our futue";
    String ex2str1 = "Teach them well";
    String ex2str2 = "and let them lead the way";
    String ex3str1 = "Show them all the beauty";
    String ex3str2 = "they possess inside";
    String ex4str1 = "give them";
    String ex4str2 = "give them";

    t.checkExpect(strLenCom.compare(ex1str1, ex1str2), 1);
    t.checkExpect(strLenCom.compare(ex2str1, ex2str2), -1);
    t.checkExpect(strLenCom.compare(ex3str1, ex3str2), 1);
    t.checkExpect(strLenCom.compare(ex4str1, ex4str2), 0);
  }
  void testBooleanCompare(Tester t) {
    BooleanCompare boolCom = new BooleanCompare();

    Boolean ex1bool1 = true;
    Boolean ex1bool2 = true;
    Boolean ex2bool1 = true;
    Boolean ex2bool2 = false;
    Boolean ex3bool1 = false;
    Boolean ex3bool2 = true;
    Boolean ex4bool1 = false;
    Boolean ex4bool2 = false;

    t.checkExpect(boolCom.compare(ex1bool1, ex1bool2), 0);
    t.checkExpect(boolCom.compare(ex2bool1, ex2bool2), 1);
    t.checkExpect(boolCom.compare(ex3bool1, ex3bool2), -1);
    t.checkExpect(boolCom.compare(ex4bool1, ex4bool2), 0);
  }
}

class CompareLists {
  static <E> E minimum(List<E> someList, Comparator<E> comparator) {
    if(someList.size() == 0) {
      return null;
    }
    Collections.sort(someList, comparator);
    return someList.get(0);
  }

  static <E> E minimum(E[] arrE, Comparator<E> comparator) {
    if(arrE.length == 0) {
      return null;
    }
    else {
      E smallest = arrE[0];
      for(E element : arrE) {
        if(comparator.compare(element, smallest) == -1) {
          smallest = element;
        }
      }
      return smallest;
    }
  }

  static <E> List<E> greaterThan(List<E> someList, Comparator<E> comparator, E element) {
    if(someList.size() == 0) {
      return null;
    }
    else {
      List<E> list = new ArrayList<>();
      for(E thing : someList) {
        if(comparator.compare(thing, element) == 1) {
          list.add(thing);
        }
      }
      return list;
    }
  }

  static <E> boolean inOrder(List<E> someList, Comparator<E> comparator) {
    List<E> list = new ArrayList<>();
    for(E element : someList) {
      if(element == null) {
        throw new IllegalArgumentException("null value in list");
      }
      list.add(element);
    }
    Collections.sort(list, comparator);
    return list.equals(someList);
  }

  static <E> boolean inOrder(E[] arrE, Comparator<E> comparator) {
    List<E> list = new ArrayList<>();
    for(E element : arrE) {
      if(element == null) {
        throw new IllegalArgumentException("null value in array");
      }
      list.add(element);
    }
    Collections.sort(list, comparator);
    List<E> arrElist = Arrays.asList(arrE);
    return list.equals(arrElist);
  }

  static <E> List<E> merge(Comparator<E> comparator, List<E> list1, List<E> list2) {
    List<E> mergeList = new ArrayList<>();
    for(E element : list1) {
      if(element == null) {
        throw new IllegalArgumentException("null value in first list");
      }
      mergeList.add(element);
    }
    for(E element : list2) {
      if(element == null) {
        throw new IllegalArgumentException("null value in second list");
      }
      mergeList.add(element);
    }
    Collections.sort(mergeList, comparator);
    return mergeList;
  }
}

class TestCompareLists {
  CompareLists CL = new CompareLists();
  void testMinimum(Tester t) {
    List<Point> l1 = Arrays.asList(new Point(3, 7), new Point(-1, 5));
    List<Point> l2 = Arrays.asList(new Point(-20, 7), new Point(-15, 4));
    List<Point> l3 = Arrays.asList(new Point(1, 1), new Point(1, 1));
    //get(0) because the method sorts the list
    t.checkExpect(CompareLists.minimum(l1, new PointCompare()), l1.get(0));
    t.checkExpect(CompareLists.minimum(l2, new PointCompare()), l2.get(0));
    t.checkExpect(CompareLists.minimum(l3, new PointCompare()), l3.get(0));
  }
  void testMinimumOL(Tester t) {
    Point[] arr1 = {new Point(3, 7), new Point(-1, 5)};
    Point[] arr2 = {new Point(-20, 7), new Point(-15, 4)};
    Point[] arr3 = {new Point(1, 1), new Point(1, 1)};
    t.checkExpect(CompareLists.minimum(arr1, new PointDistanceCompare()), arr1[1]);
    t.checkExpect(CompareLists.minimum(arr2, new PointDistanceCompare()), arr2[1]);
    t.checkExpect(CompareLists.minimum(arr3, new PointDistanceCompare()), arr3[0]);
  }
  void testGreaterThan(Tester t) {
    List<String> l1 = Arrays.asList("hi", "there", "person");
    List<String> l2 = Arrays.asList("how", "are", "you");
    List<String> l3 = Arrays.asList("bye", "bye", "bye");

    List<String> result2 = Arrays.asList(l2.get(0), l2.get(2));

    t.checkExpect(CompareLists.greaterThan(l1, new StringCompare(), "boo"), l1);
    t.checkExpect(CompareLists.greaterThan(l2, new StringCompare(), "boo"), result2);
    t.checkExpect(CompareLists.greaterThan(l3, new StringCompare(), "boo"), l3);
  }
  //resubmit: finishing tests
  void testInOrder(Tester t) {
    List<String> l1 = Arrays.asList("hi", "there", "person");
    List<String> l2 = Arrays.asList("how", "are", "you");
    List<String> l3 = Arrays.asList("bye", "bye", "bye");
    List<String> l4 = Arrays.asList("hi", null, "person");
    t.checkExpect(CompareLists.inOrder(l1, new StringLengthCompare()), true);
    t.checkExpect(CompareLists.inOrder(l2, new StringLengthCompare()), true);
    t.checkExpect(CompareLists.inOrder(l3, new StringLengthCompare()), true);
    t.checkException(new IllegalArgumentException("null value in list"), CL, "inOrder", l4, new StringLengthCompare());
  }
  void testInOrderOL(Tester t) {
    String[] arr1 = {"hi", "there", "person"};
    String[] arr2 = {"how", "are", "you"};
    String[] arr3 = {"bye", "bye", "bye"};
    String[] arr4 = {"hi", null, "person"};
    t.checkExpect(CompareLists.inOrder(arr1, new StringLengthCompare()), true);
    t.checkExpect(CompareLists.inOrder(arr2, new StringLengthCompare()), true);
    t.checkExpect(CompareLists.inOrder(arr3, new StringLengthCompare()), true);
    t.checkException(new IllegalArgumentException("null value in array"), CL, "inOrder", arr4, new StringLengthCompare());
  }
  void testMerge(Tester t) {
    List<Boolean> l1 = Arrays.asList(true, false, true);
    List<Boolean> l2 = Arrays.asList(true, true, true);
    List<Boolean> l3 = Arrays.asList(false, true, false);
    List<Boolean> l4 = Arrays.asList(false, false, false);
    List<Boolean> l5 = Arrays.asList(false, false, true);
    List<Boolean> l6 = Arrays.asList(true, true, false);
    List<Boolean> l7 = Arrays.asList(true, null, true);
    List<Boolean> l8 = Arrays.asList(true, true, true);

    List<Boolean> result1 = Arrays.asList(false, true, true, true, true, true);
    List<Boolean> result2 = Arrays.asList(false, false, false, false, false, true);
    List<Boolean> result3 = Arrays.asList(false, false, false, true, true, true);

    t.checkExpect(CompareLists.merge(new BooleanCompare(), l1, l2), result1);
    t.checkExpect(CompareLists.merge(new BooleanCompare(), l3, l4), result2);
    t.checkExpect(CompareLists.merge(new BooleanCompare(), l5, l6), result3);
    t.checkException(new IllegalArgumentException("null value in first list"), CL, "merge", new BooleanCompare(), l7, l8);

    //method call with exception for stack trace
    List<Boolean> exception = CompareLists.merge(new BooleanCompare(), l7, l8);
  }
}