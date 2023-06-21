package de.eberln.algodat.stack;

public class LinkedStack<T> implements Stack<T> {

    private StackElement<T> topElement;

    private class StackElement<T> {

        private T value;
        private StackElement<T> nextElement;

        protected StackElement(T value) {
            this.value = value;
        }

        public void setNextElement(StackElement<T> next) {
            this.nextElement = next;
        }

        public StackElement<T> getNextElement() {
            return nextElement;
        }
    }

    @Override
    public T push(T content) {

        if(topElement == null) {

            this.topElement = new StackElement<T>(content);

        }else{

            StackElement<T> newTop = new StackElement<>(content);
            newTop.setNextElement(topElement);
            topElement = newTop;

        }

        return topElement.value;

    }

    @Override
    public T pop() {

        if(topElement == null) {
            return null;
        }else{

            T toReturn = topElement.value;
            topElement = topElement.getNextElement();

            return toReturn;
        }

    }

    @Override
    public T peek() {
        
        if(topElement == null) {
            return null;
        }else{
            return topElement.value;
        }
    }

    @Override
    public boolean isEmpty() {
        return topElement == null;    
    }

    @Override
    public String toString() {

        String resultStr = "[ ";
        StackElement<T> currentElement = topElement;

        while(currentElement != null) {
            resultStr += currentElement.value.toString() + " ";
            currentElement = currentElement.getNextElement();
        }

        return resultStr + "]";

    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }
    
}
