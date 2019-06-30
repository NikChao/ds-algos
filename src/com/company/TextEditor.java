package com.company;

public class TextEditor {
    private byte[] text;
    public int size;
    public int length;

    private boolean isH(byte b) {
        return (int)b >= 128;
    }

    private boolean isValid(byte[] c) {
        if (c.length == 1 && !isH(c[0])) {
            return true;
        }
        if (c.length == 2 && isH(c[0])) {
            return true;
        }
        return false;
    }

    public void typeChar(byte[] c) {
        if (!this.isValid(c)) return;
        if (this.length == this.size - 1) {
            this.size *= 2;
        }
        byte[] newBuffer = new byte[this.size];
        for (int i = 0; i < this.length; i++) {
            newBuffer[i] = text[i];
        }
        this.text = newBuffer;
        this.length++;
    }

    public int backspace() {
        if (this.text.length == 0) return -1;
        if (this.text.length == 1) return 1;

        byte secondLast = this.text[this.text.length - 2];
        if (!isH(secondLast)) {
            return 1;
        }

        boolean isOdd = false;
        for (int i = this.text.length - 1; i >= 0; i++) {
            if (isH(this.text[i])) {
                isOdd = !isOdd;
            } else {
                break;
            }
        }
        if (isOdd) {
            return 2;
        }
        return 1;
    }

    public TextEditor() {
        this.length = 0;
        this.size = 16;
        this.text = new byte[size];
    }
}
