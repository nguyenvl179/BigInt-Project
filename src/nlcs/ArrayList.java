/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nlcs;
import java.util.*;

/**
 *
 * @author nguyen
 */
public class ArrayList {
    private int[] storage;
    private int size;
    
    public ArrayList() {
        this.size = 0;
        this.storage = new int[100];
    }
    
    public ArrayList(int n) {
        this.size = 0;
        this.storage = new int[n];
    }
    
    public void resize(int length) {
        if(this.size() > length) return;
        while(this.size() < length){
            this.push(0);
        }
    }
    
    public void print() {
        for(int i=this.size() - 1;i>=0;i--){
            System.out.print(String.valueOf(this.storage[i]));
        }
    }
    
    public void push(int value) {
        this.storage[this.size] = value;
        this.size++;
    }
    
    public void insert(int position, int value){
//        if(position > size-1) return;
        
        for(int i=size;i>position;i--){
            this.storage[i] = this.storage[i-1];
        }
        this.size++;
        this.storage[position] = value;
    }
    
    public void pop() {
        this.size--;
    }
    
    public int size() {
        return this.size;
    }
    
    public int first() {
        if(this.size > 0) return this.storage[0];
        else return -1;
    }
    
    public int last() {
        if(this.size > 0) return this.storage[this.size - 1];
        return -1;
    }
    
    public boolean isEmpty() {
        return this.size==0;
    }
    
    public void makeNull() {
        this.size = 0;
    }
    
    public int endList() {
        if(size>0) return size-1;
        return size;
    }
    
    public int locate(int value) {
        for(int i=0;i<this.size;i++){
            if(this.storage[i] == value) return i;
        }
        return -1;
    }
    
    public void reverse()
    {
        int[] b = new int[this.size];
        int j = this.size;
        for (int i = 0; i < this.size; i++) {
            b[j - 1] = this.storage[i];
            j = j - 1;
        }
        
        this.storage = b;
    }
    
    public int retrieve(int position) {
        if(position > size) return -100;
        return this.storage[position-1];
    }
    
    public void deleteItem(int position) {
        if(position >= 0 && position < size){
            for(int i=position;i<this.size - 1;i++){
                this.storage[i] = this.storage[i+1];
            }
            this.size--;
        }
    }
}
