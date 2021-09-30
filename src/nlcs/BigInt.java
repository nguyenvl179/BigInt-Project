/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nlcs;

/**
 *
 * @author nguyen
 */
public class BigInt {
    private int sign = 1;
    private ArrayList list = new ArrayList();
    
    public BigInt() {
        this.list.push(0);
    }
    
    public BigInt(String str) {
        String[] item = str.split("");
        int index = 0;
        
        if(str.contains("-")) {
            this.sign = -1;
            index = 1;
        }
        
        for(int i=item.length - 1;i>=index;i--) {
            int temp = Integer.valueOf(item[i]);
            this.list.push(temp);
        }
        
        this.removeZero();
    }
    
    public BigInt(ArrayList list) {
        this.sign = 1;
        this.list = list;
    }
    
    public void removeZero() {
        if(this.list.isEmpty()) return;
        while(this.list.last() == 0 && this.list.size() > 1){
            this.list.pop();
        }
    }
    
    public String getText() {
        String str = "";
        if(sign < 0) str += "-";
        for(int i=list.size();i>0;i--){
            str += list.retrieve(i);
        }
        
        return str;
    }
    
    public void print() {
        if(sign < 0) System.out.print("-");
        list.print();
    }
    
    public int size() {
        return this.list.size();
    }
    
    public int compare(BigInt num){
        if(num.size() > this.size()) return -1;
        if(num.size() < this.size()) return 1;
        
        for(int i=this.size();i>0;i--){
            if(this.list.retrieve(i) > num.list.retrieve(i)) return 1;
            if(this.list.retrieve(i) < num.list.retrieve(i)) return -1;
        }
        
        return 0;
    }
    
    public void sub(BigInt num) {
        num.sign = -num.sign;
        this.add(num);
        num.sign = -num.sign;
    }
    
    public void add(BigInt num) {
        ArrayList list3 = new ArrayList();
        list3.makeNull();
        
        int length = (num.list.size() > list.size()) ? num.list.size() : list.size();
        num.list.resize(length);
        list.resize(length);
        
        int extra = 0;
        int temp;
        
        //Cộng cùng dấu
        if(this.sign > 0 && num.sign > 0 || this.sign < 0 && num.sign < 0){
            for(int i=0;i<length;i++){
                temp = num.list.retrieve(i+1) + list.retrieve(i+1) + extra;
                extra = temp/10;
                list3.push(temp%10);
            }

            if(extra > 0) list3.push(extra);

            this.sign = this.sign + num.sign;            
        }//Cộng khác dấu
        else{
            BigInt num1, num2;
            if(this.compare(num) == 1){
                num1 = this;
                num2 = num;
            }else{
                num1 = num;
                num2 = this;
            }

            for(int i=0;i<list.size();i++){
                if(num1.list.retrieve(i+1) < num2.list.retrieve(i+1) + extra){
                    list3.push(num1.list.retrieve(i+1) - num2.list.retrieve(i+1) - extra + 10);
                    extra = 1;
                }
                else{
                    list3.push(num1.list.retrieve(i+1) - num2.list.retrieve(i+1) - extra);
                    extra = 0;
                }
            }
        }

        if(this.compare(num) == -1) this.sign = num.sign;
        this.list = list3;
        this.removeZero();
        num.removeZero();
    }
    
    public void mul(BigInt num) {
        ArrayList list3 = new ArrayList();
        list3.makeNull();
        
        this.sign = this.sign * num.sign;
        
        BigInt numTemp = new BigInt("0");
        
        for(int i=0;i<this.size();i++){
            ArrayList list4 = new ArrayList();
            int extra = 0;
            int temp;
            
            for(int j=0;j<num.size();j++){
                temp = num.list.retrieve(j+1) * this.list.retrieve(i+1) + extra;
                extra = temp/10;
                list4.push(temp%10);
            }
            
            if(extra > 0) list4.push(extra);
            
            for(int j=0;j<i;j++){
                list4.insert(0,0);
            }
            numTemp.add(new BigInt(list4));
        }
        
        if(list3.size() == 1 && list3.retrieve(1) == 0) this.sign = 1;
        this.list = numTemp.list;
        this.sign = numTemp.sign * this.sign;
        this.removeZero();
    }
    
    public void div(BigInt num){
        BigInt numCarry = new BigInt("0");
        BigInt numTemp = new BigInt("0");
        if(num.list.last() == 0) return;
        
        while(this.size() > 0){
            int finish = this.size();
            int count = 0;
            
            
            while(numCarry.compare(num) == -1 && this.size() > 0) {
                numCarry.list.insert(0, this.list.retrieve(finish));
                this.list.pop();
                finish--;
                count++;
                if(count>1) numTemp.list.insert(0, 0);
            }
          
            
            if(numCarry.compare(num) == -1 && this.size() > 0){
                numCarry.list.insert(0, this.list.retrieve(finish));
                this.list.pop();
            }
            
            numCarry.removeZero(); 

            count = 0;
            while(numCarry.compare(num) >= 0){
                count++;
                numCarry.sub(num);
            }
            
            if(count >= 10){
                int x = count % 10;
                count = count / 10;
                int y = count % 10;
                count = count / 10;
                numTemp.list.insert(0, y);
                numTemp.list.insert(0, x);
            }else  numTemp.list.insert(0, count);
            
//            numTemp.print();
//            System.out.println("");
        }
        
        numTemp.removeZero();
        this.list = numTemp.list;
        this.sign = this.sign / num.sign;
    }
}
