package pro.sky;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private Integer[] integerList;
    private int size;

    public IntegerListImpl() {
        this.integerList = new Integer[10];
    }

    @Override
    public Integer add(Integer item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (size < integerList.length) {
            integerList[size] = item;
        } else {
            grow();
            integerList[size] = item;
        }
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (index >= size) {
            integerList[size+1] = item;
        }
        if (index < size) {
            Integer[] oldIntegerArrayEnd = Arrays.copyOfRange(integerList, index, integerList.length);
            Integer[] oldIntegerArrayStart = Arrays.copyOfRange(integerList, 0, index - 1);
            Integer[] integerList = new Integer[oldIntegerArrayEnd.length + 10];
            for (int i = 0; i < oldIntegerArrayStart.length; i++) {
                integerList[i] = oldIntegerArrayStart[i];
            }
            integerList[index] = item;
            for (int i = 0; i < oldIntegerArrayEnd.length; i++) {
                integerList[index + 1 + i] = oldIntegerArrayEnd[i];
            }
        }
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index < 0 || index > size) {
            throw new NoSuchItemException();
        }
        if (integerList[index] == null) {
            throw new NoElementAtSuchIndexException();
        }
        integerList[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        if (item == null) {
            throw new NullPointerException();
        }
        int itemIndex = indexOf(item);
        if (itemIndex == -1) {
            throw new NoSuchItemException();
        }
        Integer[] endArray = Arrays.copyOfRange(integerList, itemIndex + 1, integerList.length);
        for (int i = 0; i < endArray.length; i++) {
            integerList[itemIndex + i] = endArray[i];
        }
        size--;
        return item;
        }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index > size) {
            throw new NoElementAtSuchIndexException();
        }
        Integer item = integerList[index];
        Integer[] endArray = Arrays.copyOfRange(integerList, index + 1, integerList.length);
        for (int i = 0; i < endArray.length; i++) {
            integerList[index + i] = endArray[i];
        }
        size--;
        return item;

    }

    @Override
    public boolean contains(Integer item) {
            Integer[] integerListCopy = this.toArray();
            return binarySearch(mergeSort(integerListCopy), item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size -1; i >= 0; i--) {
            if (integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index > size) {
            throw new NoSuchItemException();
        }
        return integerList[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
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
        return integerList[0] == null;
    }

    @Override
    public void clear() {
        size = 0;
        Arrays.fill(integerList, null);
    }

    @Override
    public Integer[] toArray() {
        return integerList = Arrays.copyOfRange(integerList, 0, size);
    }
    private static boolean binarySearch(Integer[] arr, Integer element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
    private static Integer[] mergeSort(Integer[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        Integer mid = arr.length / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[arr.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
        return arr;
    }
    public static void merge(Integer[] arr, Integer[] left, Integer[] right) {

        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                arr[mainP++] = left[leftP++];
            } else {
                arr[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            arr[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            arr[mainP++] = right[rightP++];
        }
    }
    private void grow () {
        Integer[] oldIntegerArray = integerList;
        Integer[] integerList = new Integer[(oldIntegerArray.length * 2)/2];
        for (int j = 0; j < oldIntegerArray.length; j++) {
            integerList[j] = oldIntegerArray[j];
        }
    }

    @Override
    public String toString() {
        return "StringList=" + Arrays.toString(integerList);
    }
}
