package pro.sky;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private String[] stringList;
    private int size;

    public StringListImpl() {
        this.stringList = new String[10];
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (size < stringList.length) {
            stringList[size] = item;
        } else {
            String[] oldStringArray = stringList;
            String[] stringList = new String[oldStringArray.length + 10];
            for (int j = 0; j < oldStringArray.length; j++) {
                    stringList[j] = oldStringArray[j];
                }
            stringList[size] = item;
        }
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (index >= size) {
            stringList[size+1] = item;
        }
        if (index < size) {
            String[] oldStringArrayEnd = Arrays.copyOfRange(stringList, index, stringList.length);
            String[] oldStringArrayStart = Arrays.copyOfRange(stringList, 0, index - 1);
            String[] stringList = new String[oldStringArrayEnd.length + 10];
            for (int i = 0; i < oldStringArrayStart.length; i++) {
                stringList[i] = oldStringArrayStart[i];
            }
            stringList[index] = item;
            for (int i = 0; i < oldStringArrayEnd.length; i++) {
                stringList[index + 1 + i] = oldStringArrayEnd[i];
            }
        }
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index < 0 || index > size) {
            throw new NoSuchItemException();
        }
        if (stringList[index] == null) {
            throw new NoElementAtSuchIndexException();
        }
        stringList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new NullPointerException();
        }
        int itemIndex = indexOf(item);
        if (itemIndex == -1) {
            throw new NoSuchItemException();
        }
        String[] endArray = Arrays.copyOfRange(stringList, itemIndex + 1, stringList.length);
        for (int i = 0; i < endArray.length; i++) {
            stringList[itemIndex + i] = endArray[i];
        }
        size--;
        return item;
        }

    @Override
    public String remove(int index) {
        if (index < 0 || index > size) {
            throw new NoElementAtSuchIndexException();
        }
        String item = stringList[index];
        String[] endArray = Arrays.copyOfRange(stringList, index + 1, stringList.length);
        for (int i = 0; i < endArray.length; i++) {
            stringList[index + i] = endArray[i];
        }
        size--;
        return item;

    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < size; i++) {
            if (stringList[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size -1; i >= 0; i--) {
            if (stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index > size) {
            throw new NoSuchItemException();
        }
        return stringList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new NullPointerException();
        }
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return stringList[0] == null;
    }

    @Override
    public void clear() {
        size = 0;
        Arrays.fill(stringList, null);
    }

    @Override
    public String[] toArray() {
        return stringList = Arrays.copyOfRange(stringList, 0, size);
    }

    @Override
    public String toString() {
        return "StringList=" + Arrays.toString(stringList);
    }
}
