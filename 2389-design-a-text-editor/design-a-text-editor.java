class TextEditor {

    //TC-O(K) for all and O(1) for getLast10 and SC-O(N) 
    Deque<Character> left;
    Deque<Character> right;

    public TextEditor() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    public void addText(String text) {
        for (char c : text.toCharArray()) {
            left.addLast(c);
        }
    }

    public int deleteText(int k) {
        int count = 0;
        while (k > 0 && !left.isEmpty()) {
            left.removeLast();
            count++;
            k--;
        }
        return count;
    }

    public String cursorLeft(int k) {
        while (k > 0 && !left.isEmpty()) {
            right.addFirst(left.removeLast());
            k--;
        }
        return getLast10();
    }

    public String cursorRight(int k) {
        while (k > 0 && !right.isEmpty()) {
            left.addLast(right.removeFirst());
            k--;
        }
        return getLast10();
    }

    public String getLast10() {
        StringBuilder sb = new StringBuilder();
        Iterator<Character> it = left.descendingIterator();
        int count = 0;
        while (it.hasNext() && count < 10) {
            sb.append(it.next());
            count++;
        }
        return sb.reverse().toString();
    }

    //TextEditor with Undo and Redo, SC-O(N) nd TC for insert/delete - O(K) and undo/redo - O(1)
    // private StringBuilder text;
    // private final Deque<String> undoStack;
    // private final Deque<String> redoStack;

    // public TextEditor() {
    //     sb = new StringBuilder();
    //     undoStack = new ArrayDeque<>();
    //     redoStack = new ArrayDeque<>();
    // }

    // public void saveState() {
    //     undoStack.push(text.toString());
    //     redoStack.clear();
    // }

    // public void addText(String str) {
    //     saveState();
    //     text.append(str);
    // }

    // public void deleteText(int k) {
    //     saveState();
    //     int start = Math.max(0, text.length() - k);
    //     text.delete(start, text.length());
    // }

    // public void undo() {
    //     if (!undoStack.isEmpty()) {
    //         redoStack.push(text.toString());
    //         text = new StringBuilder(undoStack.pop());
    //     }
    // }

    // public void redo() {
    //     if (!redoStack.isEmpty()) {
    //         undoStack.push(text.toString());
    //         text = new StringBuilder(redoStack.pop());
    //     }
    // }

    // public String getText() {
    //     return text.toString();
    // }

}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */